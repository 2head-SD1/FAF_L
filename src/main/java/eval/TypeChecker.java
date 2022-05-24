package eval;

import fafl.Absyn.*;
import fafl.PrettyPrinter;

import java.util.List;

public class TypeChecker {
    public static Type typecheck(List<Context.ContextNode> context, Expr expr, Type expectedType) throws TypeCheckError
    {
        var actualType = typeOf(context, expr);
        if(expectedType.equals(actualType))
            return actualType;
        else
            throw new UnexpectedTypeError(getUnexpectedTypeError(expectedType, actualType, expr));
    }
    public static Type typeOf(List<Context.ContextNode> context, Expr expr) throws TypeCheckError
    {
        if(expr instanceof If)
        {
            typecheck(context, ((If) expr).expr_1, new BoolType());
            var typeOfResult = typeOf(context, ((If) expr).expr_2);
            return typecheck(context, ((If) expr).expr_3, typeOfResult);
        }
        //Constants
        if(expr instanceof IntConst)
            return new IntType();
        if(expr instanceof DoubleConst)
            return new DoubleType();
        if(expr instanceof StringConst)
            return new StringType();
        if(expr instanceof BoolConst)
            return new BoolType();
        if(expr instanceof Id)
        {
            for(var t : context)
            {
                if(t.ident.equals(((Id)expr).ident_))
                    return t.type;
            }
            throw new UndefinedVariableError(String.format("Variable %s undefined", ((Id)expr).ident_));
        }
        if(expr instanceof SetqSimple)
        {
            SetqSimple curExpr = (SetqSimple) expr;
            Type exprType = typecheck(context, curExpr.expr_, curExpr.type_);
            context.add(new Context.ContextNode(curExpr.ident_, exprType));
        }
        //Dict typechecking
        if(expr instanceof DictConstructor)
        {
        }
        if(expr instanceof DictGet)
        {
        }
        if(expr instanceof DictKeys)
        {
        }
        if(expr instanceof DictLength)
        {
        }
        if(expr instanceof DictRemove)
        {
        }
        if(expr instanceof DictValues)
        {
        }
        if(expr instanceof DictSet)
        {
        }
        //Array typechecking
        if(expr instanceof ArrayConstructor)
        {
            ArrayConstructor curExpr = (ArrayConstructor)expr;
            typecheck(context, curExpr.expr_, new IntType());
            for(var arrayExpr : curExpr.listexpr_)
            {
                typecheck(context, arrayExpr, curExpr.type_);
            }
            return new ArrayType(curExpr.type_);
        }
        if(expr instanceof ArrayGet)
        {
            ArrayGet curExpr = (ArrayGet)expr;

            Type arrayContentType = getArrayContentType(context, curExpr);
            typecheck(context, curExpr.expr_2, new IntType());
            return arrayContentType;
        }
        if(expr instanceof ArrayLength)
            return new IntType();
        if(expr instanceof ArraySet)
        {
            ArraySet curExpr = (ArraySet) expr;
            typecheck(context, curExpr.expr_2, new IntType());
            Type arrayContentType = getArrayContentType(context, curExpr.expr_1);
            typecheck(context, curExpr.expr_3, arrayContentType);
            return new ArrayType(arrayContentType);
        }
        if(expr instanceof First)
        {
            First curExpr = (First)expr;
            return getArrayContentType(context, curExpr.expr_);
        }
        if(expr instanceof Last)
        {
            Last curExpr = (Last) expr;
            return getArrayContentType(context, curExpr.expr_);
        }
        //Func typechecking
        if(expr instanceof Define)
        {
            Define curDef = (Define)expr;
            typecheck(context, curDef.expr_, ((FuncReturnType)curDef.afuncreturntype_).type_);
            return new FuncType(getFuncArgsType(curDef.listatypedarg_), ((FuncReturnType) curDef.afuncreturntype_).type_);
        }
        //Base Bool predicates
        if(expr instanceof Equals)
        {
            Equals curExpr = (Equals) expr;
            typeCheckBaseBoolPredicate(context, curExpr, curExpr.expr_1, curExpr.expr_2);
            return new BoolType();
        }
        if(expr instanceof IsGreater)
        {
            IsGreater curExpr = (IsGreater) expr;
            typeCheckNumericBoolPredicate(context, curExpr, curExpr.expr_1, curExpr.expr_2);
            return new BoolType();
        }
        if(expr instanceof IsLess)
        {
            IsLess curExpr = (IsLess) expr;
            typeCheckNumericBoolPredicate(context, curExpr, curExpr.expr_1, curExpr.expr_2);
            return new BoolType();
        }
        if(expr instanceof And)
        {
            And curExpr = (And) expr;
            typeCheckBoolPredicate(context, curExpr, curExpr.expr_1, curExpr.expr_2);
            return new BoolType();
        }
        if(expr instanceof Or)
        {
            Or curExpr = (Or) expr;
            typeCheckBoolPredicate(context, curExpr, curExpr.expr_1, curExpr.expr_2);
            return new BoolType();
        }
        //Base Arithmetic predicates
        if(expr instanceof Plus)
        {
            Plus curExpr = (Plus)expr;
            return typeCheckArithmetic(context, curExpr.listexpr_, expr);
        }
        if(expr instanceof Minus)
        {
            Minus curExpr = (Minus)expr;
            return typeCheckArithmetic(context, curExpr.listexpr_, expr);
        }
        if(expr instanceof Mul)
        {
            Mul curExpr = (Mul)expr;
            return typeCheckArithmetic(context, curExpr.listexpr_, expr);
        }
        if(expr instanceof Div)
        {
            Div curExpr = (Div) expr;
            return typeCheckArithmetic(context, curExpr.listexpr_, expr);
        }
        return null;
    }

    private static Type getArrayContentType(List<Context.ContextNode> context, Expr curExpr) throws TypeCheckError
    {
        Type arrayType = typeOf(context, curExpr);
        Type arrayContentType;
        try
        {
            ArrayType castedArrayType = (ArrayType) arrayType;
            arrayContentType = castedArrayType.type_;
        }
        catch(ClassCastException e)
        {
            throw new UnexpectedTypeError(getUnexpectedTypeError(new ArrayType(null), arrayType, curExpr));
        }
        return arrayContentType;
    }

    private static Type getFuncArgsType(List<ATypedArg> args)
    {
        if(args.stream().count() == 1)
            return ((TypedArg)args.get(0)).type_;
        return new FuncType(((TypedArg)args.get(0)).type_, getFuncArgsType(args.subList(1, ((int)args.stream().count()))));
    }

    private static Type typeCheckNumericBoolPredicate(List<Context.ContextNode> context, Expr mainExpr, Expr expr1, Expr expr2) throws TypeCheckError
    {
        Type expr1Type = typeOf(context, expr1);
        if(!(expr1Type instanceof DoubleType || expr1Type instanceof IntType))
            throw new UnexpectedTypeError(getExpectedNumericalTypeError(expr1Type, mainExpr));
        typecheck(context, expr2, expr1Type);
        return expr1Type;
    }
    private static Type typeCheckBaseBoolPredicate(List<Context.ContextNode> context, Expr mainExpr, Expr expr1, Expr expr2) throws TypeCheckError
    {
        Type expr1Type = typeOf(context, expr1);
        if(expr1Type instanceof DoubleType || expr1Type instanceof IntType || expr1Type instanceof StringType || expr1Type instanceof BoolType)
        {
            return typecheck(context, expr2, expr1Type);
        }
        throw new UnexpectedTypeError(getExpectedBaseTypeError(expr1Type, mainExpr));
    }

    private static Type typeCheckBoolPredicate(List<Context.ContextNode> context, Expr mainExpr, Expr expr1, Expr expr2) throws TypeCheckError
    {
        Type expr1Type = typeOf(context, expr1);
        if(expr1Type instanceof BoolType)
            return typecheck(context, expr2, expr1Type);
        throw new UnexpectedTypeError(getUnexpectedTypeError(new BoolType(), expr1Type, mainExpr));
    }

    private static Type typeCheckArithmetic(List<Context.ContextNode> context, ListExpr curExpr, Expr expr) throws TypeCheckError
    {
        Type firstExprType = typeOf(context, curExpr.getFirst());
        if(!(firstExprType instanceof IntType || firstExprType instanceof DoubleType))
            throw new UnexpectedTypeError(getExpectedNumericalTypeError(firstExprType, expr));
        for(int i = 1; i < curExpr.stream().count(); i++)
        {
            typecheck(context, curExpr.get(i), firstExprType);
        }
        return firstExprType;
    }

    private Type lookup(String ident_, List<Context.ContextNode> context) throws TypeCheckError {
        for(var x : context)
        {
            if(ident_.equals(x.ident))
                return x.type;
        }
        throw new UndefinedVariableError(getUndefinedVariableError(ident_));
    }

    private String getUnexpectedFunTypeError(Type funType, Expr expr)
    {
        return String.format(
                "Type Error: expected function type but actual type is %s for expression %s",
                PrettyPrinter.print(funType),
                PrettyPrinter.print(expr));
    }

    private static String getUnexpectedTypeError(Type expectedType, Type actualType, Expr expr) {
        return String.format(
                "Type Error: expected %s type but actual type is %s for expression %s",
                PrettyPrinter.print(expectedType),
                PrettyPrinter.print(actualType),
                PrettyPrinter.print(expr));
    }

    private static String getExpectedNumericalTypeError(Type actualType, Expr expr)
    {
        return String.format(
                "Type Error: expected %s type but actual type is %s for expression %s",
                "Numeric Type(DoubleType or IntType)",
                PrettyPrinter.print(actualType),
                PrettyPrinter.print(expr));
    }
    private static String getExpectedBaseTypeError(Type actualType, Expr expr)
    {
        return String.format("Type Error: expected %s type but actual type is %s for expression %s",
                "Base Type(DoubleType, IntType, StringType, BoolType)",
                PrettyPrinter.print(actualType),
                PrettyPrinter.print(expr));
    }
    private String getUndefinedVariableError(String varName)
    {
        return String.format("Undefined Variable Error: variable %s is not defined", varName);
    }

    public static class UnexpectedFunTypeError extends TypeCheckError
    {
        public UnexpectedFunTypeError(String message)
        {
            super(message);
        }
    }
    public static class UnexpectedTypeError extends TypeCheckError
    {
        public UnexpectedTypeError(String message)
        {
            super(message);
        }
    }
    public static class UndefinedVariableError extends TypeCheckError
    {
        public UndefinedVariableError(String message)
        {
            super(message);
        }
    }
    public static class TypeCheckError extends Exception
    {
        public TypeCheckError(String message)
        {
            super(message);
        }
    }
}
