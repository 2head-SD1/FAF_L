package eval;

import fafl.Absyn.*;
import fafl.PrettyPrinter;

import java.util.List;

public class TypeChecker {
    public Type typecheck(List<Context.ContextNode> context, Expr expr, Type expectedType) throws TypeCheckError
    {
        var actualType = typeOf(context, expr);
        if(expectedType.equals(actualType))
            return actualType;
        else
            throw new UnexpectedTypeError(getUnexpectedTypeError(expectedType, actualType, expr));
    }
    public Type typeOf(List<Context.ContextNode> context, Expr expr) throws TypeCheckError
    {
        if(expr instanceof If)
        {
            typecheck(context, ((If) expr).expr_1, new BoolType());
            var typeOfResult = typeOf(context, ((If) expr).expr_2);
            return typecheck(context, ((If) expr).expr_3, typeOfResult);
        }
        if(expr instanceof IntConst)
            return new IntType();
        if(expr instanceof DoubleConst)
            return new DoubleType();
        if(expr instanceof StringConst)
            return new StringType();
        if(expr instanceof BoolConst)
            return new BoolType();
        if(expr instanceof Define)
        {
            Define curDef = (Define)expr;
            typecheck(context, curDef.expr_, ((FuncReturnType)curDef.afuncreturntype_).type_);
        }
        //Base Bool predicates
        //Base Arithmetic predicates
        if(expr instanceof Plus)
        {
            Plus curExpr = (Plus)expr;
            Type firstExprType = typeOf(context, curExpr.listexpr_.getFirst());
            if(!(firstExprType instanceof IntType || firstExprType instanceof DoubleType))
                throw new UnexpectedTypeError(String.format(
                        "Type Error: expected %s type but actual type is %s for expression %s",
                        "Numeric Type(DoubleType or IntType)",
                        PrettyPrinter.print(firstExprType),
                        PrettyPrinter.print(expr)));
            for(int i = 0; i < curExpr.listexpr_.stream().count(); i++)
            {
                if(i == 0)
                    continue;
                typecheck(context, curExpr.listexpr_.get(i), firstExprType);
            }
        }
        if(expr instanceof Minus)
        {
            Minus curExpr = (Minus)expr;
            Type firstExprType = typeOf(context, curExpr.listexpr_.getFirst());
            if(!(firstExprType instanceof IntType || firstExprType instanceof DoubleType))
                throw new UnexpectedTypeError(String.format(
                        "Type Error: expected %s type but actual type is %s for expression %s",
                        "Numeric Type(DoubleType or IntType)",
                        PrettyPrinter.print(firstExprType),
                        PrettyPrinter.print(expr)));
            for(int i = 0; i < curExpr.listexpr_.stream().count(); i++)
            {
                if(i == 0)
                    continue;
                typecheck(context, curExpr.listexpr_.get(i), firstExprType);
            }
        }
        if(expr instanceof Mul)
        {
            Mul curExpr = (Mul)expr;
            Type firstExprType = typeOf(context, curExpr.listexpr_.getFirst());
            if(!(firstExprType instanceof IntType || firstExprType instanceof DoubleType))
                throw new UnexpectedTypeError(String.format(
                        "Type Error: expected %s type but actual type is %s for expression %s",
                        "Numeric Type(DoubleType or IntType)",
                        PrettyPrinter.print(firstExprType),
                        PrettyPrinter.print(expr)));
            for(int i = 0; i < curExpr.listexpr_.stream().count(); i++)
            {
                if(i == 0)
                    continue;
                typecheck(context, curExpr.listexpr_.get(i), firstExprType);
            }
        }
        if(expr instanceof Div)
        {
            Div curExpr = (Div) expr;
            Type firstExprType = typeOf(context, curExpr.listexpr_.getFirst());
            if(!(firstExprType instanceof IntType || firstExprType instanceof DoubleType))
                throw new UnexpectedTypeError(String.format(
                        "Type Error: expected %s type but actual type is %s for expression %s",
                        "Numeric Type(DoubleType or IntType)",
                        PrettyPrinter.print(firstExprType),
                        PrettyPrinter.print(expr)));
            for(int i = 0; i < curExpr.listexpr_.stream().count(); i++)
            {
                if(i == 0)
                    continue;
                typecheck(context, curExpr.listexpr_.get(i), firstExprType);
            }
        }
        return null;
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

    private String getUnexpectedTypeError(Type expectedType, Type actualType, Expr expr) {
        return String.format(
                "Type Error: expected %s type but actual type is %s for expression %s",
                PrettyPrinter.print(expectedType),
                PrettyPrinter.print(actualType),
                PrettyPrinter.print(expr));
    }

    private String getUndefinedVariableError(String varName)
    {
        return String.format("Undefined Variable Error: variable %s is not defined", varName);
    }

    public class UnexpectedFunTypeError extends TypeCheckError
    {
        public UnexpectedFunTypeError(String message)
        {
            super(message);
        }
    }
    public class UnexpectedTypeError extends TypeCheckError
    {
        public UnexpectedTypeError(String message)
        {
            super(message);
        }
    }
    public class UndefinedVariableError extends TypeCheckError
    {
        public UndefinedVariableError(String message)
        {
            super(message);
        }
    }
    public class TypeCheckError extends Exception
    {
        public TypeCheckError(String message)
        {
            super(message);
        }
    }
}
