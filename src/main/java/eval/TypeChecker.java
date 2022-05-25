package eval;

import com.SymbolTable.SymbolTable;
import fafl.Absyn.*;
import fafl.PrettyPrinter;

import java.util.ArrayList;
import java.util.List;

public class TypeChecker {
    public static Type typecheck(List<Context.ContextNode> context, Expr expr, Type expectedType, boolean useSymbolTable) throws TypeCheckError
    {
        var actualType = typeOf(context, expr, useSymbolTable);
        if(expectedType.equals(actualType))
            return actualType;
        else
            throw new UnexpectedTypeError(getUnexpectedTypeError(expectedType, actualType, expr));
    }
    public static Type typeOf(List<Context.ContextNode> context, Expr expr, boolean useSymbolTable) throws TypeCheckError
    {
        if(expr instanceof If)
        {
            typecheck(context, ((If) expr).expr_1, new BoolType(), useSymbolTable);
            var typeOfResult = typeOf(context, ((If) expr).expr_2, useSymbolTable);
            return typecheck(context, ((If) expr).expr_3, typeOfResult, useSymbolTable);
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
            Id curExpr = (Id)expr;
            if(useSymbolTable)
                return SymbolTable.getSymbol(curExpr.ident_).GetType();
            else
                return lookup(curExpr.ident_, context);
        }
        if(expr instanceof SetqSimple)
        {
            SetqSimple curExpr = (SetqSimple) expr;
            Type exprType = typecheck(context, curExpr.expr_, curExpr.type_, useSymbolTable);
            if(!useSymbolTable)
                context.add(0, new Context.ContextNode(curExpr.ident_, exprType));
        }
        //Tuple typechecking
        if(expr instanceof TupleConstructor)
        {
        }
        //Struct typechecking
        if(expr instanceof StructInit)
        {
            StructInit curExpr = (StructInit) expr;

        }
        if(expr instanceof StructConstructor)
        {
            StructConstructor curExpr = (StructConstructor) expr;
            StructInit init;
            if(useSymbolTable)
                init = (StructInit)SymbolTable.getSymbol(curExpr.ident_).value;
            else
                throw new TypeCheckError("Not implemented");
            for(int i = 0; i < init.listatypedarg_.stream().count(); i++)
            {
                typecheck(context, curExpr.listexpr_.get(i), ((TypedArg)init.listatypedarg_.get(i)).type_, useSymbolTable);
            }
            return new StructType(curExpr.ident_);
        }
        if(expr instanceof StructField)
        {
            StructField curExpr = (StructField) expr;
            StructInit init;
            if(useSymbolTable)
                init = (StructInit)SymbolTable.getSymbol(curExpr.ident_).value;
            else
                throw new TypeCheckError("Not implemented");
            for(var arg : init.listatypedarg_)
            {
                TypedArg typedArg = (TypedArg) arg;
                if(typedArg.ident_.equals(curExpr.ident_))
                    return typedArg.type_;
            }
        }
        //Dict typechecking
        //FIXME: add using of symbol table
        if(expr instanceof DictConstructor)
        {
            DictConstructor curExpr = (DictConstructor) expr;
            context.add(new Context.ContextNode(curExpr.ident_, new DictType(curExpr.type_1, curExpr.type_2)));
            Type keyType = curExpr.type_1;
            Type valueType = curExpr.type_2;
            for(Pair pair : curExpr.listpair_)
            {
                DictPair dictPair = (DictPair)pair;
                typecheck(context, dictPair.expr_1, keyType, useSymbolTable);
                typecheck(context, dictPair.expr_2, valueType, useSymbolTable);
            }
            return new DictType(keyType, valueType);
        }
        if(expr instanceof DictGet)
        {
            DictGet curExpr = (DictGet) expr;
            return getDictType(context, useSymbolTable, curExpr.expr_1).type_2;
        }
        if(expr instanceof DictKeys)
        {
            DictKeys curExpr = (DictKeys) expr;
            return new ArrayType(getDictType(context, useSymbolTable, curExpr.expr_).type_1);
        }
        if(expr instanceof DictLength)
        {
            DictLength dictLength = (DictLength)expr;
            getDictType(context, useSymbolTable, dictLength.expr_);
            return new IntType();
        }
        if(expr instanceof DictRemove)
        {
            DictRemove curExpr = (DictRemove) expr;
            DictType dictType = getDictType(context, useSymbolTable, curExpr.expr_1);
            typecheck(context, curExpr.expr_2, dictType.type_1, useSymbolTable);
            return dictType;
        }
        if(expr instanceof DictValues)
        {
            DictValues dictLength = (DictValues)expr;
            getDictType(context, useSymbolTable, dictLength.expr_);
            return new ArrayType(getDictType(context, useSymbolTable, dictLength.expr_).type_2);
        }
        if(expr instanceof DictSet)
        {
            DictSet curExpr = (DictSet) expr;
            DictType dictType = getDictType(context, useSymbolTable, curExpr.expr_);
            DictPair dictPair = (DictPair) curExpr.pair_;
            typecheck(context, dictPair.expr_1, dictType.type_1, useSymbolTable);
            typecheck(context, dictPair.expr_2, dictType.type_2, useSymbolTable);
            return dictType;
        }
        //Array typechecking
        if(expr instanceof ArrayConstructor)
        {
            ArrayConstructor curExpr = (ArrayConstructor)expr;
            typecheck(context, curExpr.expr_, new IntType(), useSymbolTable);
            for(var arrayExpr : curExpr.listexpr_)
            {
                typecheck(context, arrayExpr, curExpr.type_, useSymbolTable);
            }
            return new ArrayType(curExpr.type_);
        }
        if(expr instanceof ArrayGet)
        {
            ArrayGet curExpr = (ArrayGet)expr;

            Type arrayContentType = getArrayType(context, curExpr.expr_1, useSymbolTable).type_;
            typecheck(context, curExpr.expr_2, new IntType(), useSymbolTable);
            return arrayContentType;
        }
        if(expr instanceof ArrayLength)
            return new IntType();
        if(expr instanceof ArraySet)
        {
            ArraySet curExpr = (ArraySet) expr;
            typecheck(context, curExpr.expr_2, new IntType(), useSymbolTable);
            Type arrayContentType = getArrayType(context, curExpr.expr_1, useSymbolTable).type_;
            typecheck(context, curExpr.expr_3, arrayContentType, useSymbolTable);
            return new ArrayType(arrayContentType);
        }
        if(expr instanceof First)
        {
            First curExpr = (First)expr;
            return getArrayType(context, curExpr.expr_, useSymbolTable).type_;
        }
        if(expr instanceof Last)
        {
            Last curExpr = (Last) expr;
            return getArrayType(context, curExpr.expr_, useSymbolTable).type_;
        }
        //Func typechecking
        if(expr instanceof Define)
        {
            Define curDef = (Define)expr;
            FuncType funcType = new FuncType(getFuncArgsFromTypedArgs(curDef.listatypedarg_), ((FuncReturnType) curDef.afuncreturntype_).type_);
            context.add(0, new Context.ContextNode(curDef.ident_, funcType));
            if(!useSymbolTable)
            {
                for(var aTypedArg : curDef.listatypedarg_)
                {
                    TypedArg typedArg = (TypedArg) aTypedArg;
                    context.add(0, new Context.ContextNode(typedArg.ident_, typedArg.type_));
                }
            }

            typecheck(context, curDef.expr_, ((FuncReturnType)curDef.afuncreturntype_).type_, useSymbolTable);
            if(!useSymbolTable)
            {
                for(var ignored : curDef.listatypedarg_)
                {
                    context.remove(0);
                }
            }
            return funcType;
        }
        if(expr instanceof FuncCall)
        {
            FuncCall curDef = (FuncCall) expr;
            for(var node : context)
            {
                if (node.ident.equals(curDef.ident_))
                {
                    FuncType funcType = (FuncType) node.type;
                    var listType = new ArrayList<Type>();
                    for(var arg : curDef.listexpr_)
                    {
                        listType.add(typeOf(context, arg, useSymbolTable));
                    }
                    Type argType = getFuncTypeArgs(listType);
                    if(argType.equals(funcType.type_1))
                        return funcType.type_2;
                }
            }
        }
        //TODO: Make normal realization
        if(expr instanceof Lambda)
        {
            Lambda curExpr = (Lambda) expr;
            return typeOf(context, new Define("l", curExpr.listatypedarg_, curExpr.afuncreturntype_, curExpr.expr_), useSymbolTable);
        }
        //Base Bool predicates
        if(expr instanceof Equals)
        {
            Equals curExpr = (Equals) expr;
            typeCheckBaseBoolPredicate(context, curExpr, curExpr.expr_1, curExpr.expr_2, useSymbolTable);
            return new BoolType();
        }
        if(expr instanceof IsGreater)
        {
            IsGreater curExpr = (IsGreater) expr;
            typeCheckNumericBoolPredicate(context, curExpr, curExpr.expr_1, curExpr.expr_2, useSymbolTable);
            return new BoolType();
        }
        if(expr instanceof IsLess)
        {
            IsLess curExpr = (IsLess) expr;
            typeCheckNumericBoolPredicate(context, curExpr, curExpr.expr_1, curExpr.expr_2, useSymbolTable);
            return new BoolType();
        }
        if(expr instanceof And)
        {
            And curExpr = (And) expr;
            typeCheckBoolPredicate(context, curExpr, curExpr.expr_1, curExpr.expr_2, useSymbolTable);
            return new BoolType();
        }
        if(expr instanceof Or)
        {
            Or curExpr = (Or) expr;
            typeCheckBoolPredicate(context, curExpr, curExpr.expr_1, curExpr.expr_2, useSymbolTable);
            return new BoolType();
        }
        //Base Arithmetic predicates
        if(expr instanceof Plus)
        {
            Plus curExpr = (Plus)expr;
            return typeCheckArithmetic(context, curExpr.listexpr_, expr, useSymbolTable);
        }
        if(expr instanceof Minus)
        {
            Minus curExpr = (Minus)expr;
            return typeCheckArithmetic(context, curExpr.listexpr_, expr, useSymbolTable);
        }
        if(expr instanceof Mul)
        {
            Mul curExpr = (Mul)expr;
            return typeCheckArithmetic(context, curExpr.listexpr_, expr, useSymbolTable);
        }
        if(expr instanceof Div)
        {
            Div curExpr = (Div) expr;
            return typeCheckArithmetic(context, curExpr.listexpr_, expr, useSymbolTable);
        }
        throw new TypeCheckError(String.format("TypeCheckError: Undefined type for expression %s", PrettyPrinter.print(expr)));
    }

    private static DictType getDictType(List<Context.ContextNode> context, boolean useSymbolTable, Expr curExpr) throws TypeCheckError
    {
        Type curType = typeOf(context, curExpr, useSymbolTable);
        try
        {
            DictType dictType = (DictType) curType;
            return dictType;
        }
        catch(ClassCastException e)
        {
            throw new UnexpectedTypeError(getUnexpectedTypeError(new DictType(null, null), curType, curExpr));
        }
    }

    private static ArrayType getArrayType(List<Context.ContextNode> context, Expr curExpr, boolean useSymbolTable) throws TypeCheckError
    {
        Type curType = typeOf(context, curExpr, useSymbolTable);
        try
        {
            return (ArrayType) curType;
        }
        catch(ClassCastException e)
        {
            throw new UnexpectedTypeError(getUnexpectedTypeError(new ArrayType(null), curType, curExpr));
        }
    }

    private static Type getFuncArgsFromTypedArgs(List<ATypedArg> args)
    {
        if(args.stream().count() == 1)
            return ((TypedArg)args.get(0)).type_;
        return new FuncType(((TypedArg)args.get(0)).type_, getFuncArgsFromTypedArgs(args.subList(1, ((int)args.stream().count()))));
    }

    private static Type getFuncTypeArgs(List<Type> args)
    {
        if(args.stream().count() == 1)
            return args.get(0);
        return new FuncType(args.get(0), getFuncTypeArgs(args.subList(1, ((int)args.stream().count()))));
    }

    private static Type typeCheckNumericBoolPredicate(List<Context.ContextNode> context, Expr mainExpr, Expr expr1, Expr expr2, boolean useSymbolTable) throws TypeCheckError
    {
        Type expr1Type = typeOf(context, expr1, useSymbolTable);
        if(!(expr1Type instanceof DoubleType || expr1Type instanceof IntType))
            throw new UnexpectedTypeError(getExpectedNumericalTypeError(expr1Type, mainExpr));
        typecheck(context, expr2, expr1Type, useSymbolTable);
        return expr1Type;
    }
    private static Type typeCheckBaseBoolPredicate(List<Context.ContextNode> context, Expr mainExpr, Expr expr1, Expr expr2, boolean useSymbolTable) throws TypeCheckError
    {
        Type expr1Type = typeOf(context, expr1,useSymbolTable);
        if(expr1Type instanceof DoubleType || expr1Type instanceof IntType || expr1Type instanceof StringType || expr1Type instanceof BoolType)
        {
            return typecheck(context, expr2, expr1Type, useSymbolTable);
        }
        throw new UnexpectedTypeError(getExpectedBaseTypeError(expr1Type, mainExpr));
    }

    private static Type typeCheckBoolPredicate(List<Context.ContextNode> context, Expr mainExpr, Expr expr1, Expr expr2, boolean useSymbolTable) throws TypeCheckError
    {
        Type expr1Type = typeOf(context, expr1, useSymbolTable);
        if(expr1Type instanceof BoolType)
            return typecheck(context, expr2, expr1Type, useSymbolTable);
        throw new UnexpectedTypeError(getUnexpectedTypeError(new BoolType(), expr1Type, mainExpr));
    }

    private static Type typeCheckArithmetic(List<Context.ContextNode> context, ListExpr curExpr, Expr expr, boolean useSymbolTable) throws TypeCheckError
    {
        Type firstExprType = typeOf(context, curExpr.getFirst(), useSymbolTable);
        if(!(firstExprType instanceof IntType || firstExprType instanceof DoubleType))
            throw new UnexpectedTypeError(getExpectedNumericalTypeError(firstExprType, expr));
        for(int i = 1; i < curExpr.stream().count(); i++)
        {
            typecheck(context, curExpr.get(i), firstExprType, useSymbolTable);
        }
        return firstExprType;
    }

    private static Type lookup(String ident_, List<Context.ContextNode> context) throws TypeCheckError {
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
    private static String getUndefinedVariableError(String varName)
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
