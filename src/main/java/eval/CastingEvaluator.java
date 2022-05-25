package eval;

import fafl.Absyn.*;

public class CastingEvaluator
{
    public static boolean isCastingExpr(Expr expr)
    {
        return expr instanceof ToDouble ||
                expr instanceof ToInt ||
                expr instanceof ToString;
    }

    public static Expr doCastingExpr(Expr expr) throws Exception
    {
        if (expr instanceof ToDouble)
        {
            ToDouble toDouble = (ToDouble) expr;
            return doToDouble(toDouble);
        }
        if (expr instanceof ToInt)
        {
            ToInt toInt = (ToInt) expr;
            return doToInt(toInt);
        }
        if (expr instanceof ToString)
        {
            ToString toString = (ToString) expr;
            return doToString(toString);
        }
        throw new Exception("Cannot do casting with such expression");
    }

    private static Expr doToDouble(ToDouble toDouble) throws Exception
    {
        Expr expr = Evaluator.evalStep(toDouble.expr_);
        if (expr instanceof DoubleConst)
        {
            return expr;
        }
        if (expr instanceof IntConst)
        {
            IntConst intConst = (IntConst) expr;
            return new DoubleConst(
                    intConst.integer_.doubleValue()
            );
        }
        if (expr instanceof StringConst)
        {
            StringConst stringConst = (StringConst) expr;
            return new DoubleConst(
                    Double.parseDouble(stringConst.string_)
            );
        }

        throw new Exception("Cannot cast to double such expression");
    }

    private static Expr doToInt(ToInt toInt) throws Exception
    {
        Expr expr = Evaluator.evalStep(toInt.expr_);
        if (expr instanceof DoubleConst)
        {
            DoubleConst doubleConst = (DoubleConst) expr;
            return new IntConst(
                    doubleConst.double_.intValue()
            );
        }
        if (expr instanceof IntConst)
        {
            return expr;
        }
        if (expr instanceof StringConst)
        {
            StringConst stringConst = (StringConst) expr;
            return new IntConst(
                    Integer.parseInt(stringConst.string_)
            );
        }
        throw new Exception("Cannot cast to int such expression");
    }

    private static Expr doToString(ToString toString) throws Exception
    {
        Expr expr = Evaluator.evalStep(toString.expr_);
        if (expr instanceof DoubleConst)
        {
            DoubleConst doubleConst = (DoubleConst) expr;
            return new StringConst(
                    doubleConst.double_.toString()
            );
        }
        if (expr instanceof IntConst)
        {
            IntConst intConst = (IntConst) expr;
            return new StringConst(
                    intConst.integer_.toString()
            );
        }
        if (expr instanceof StringConst)
        {
            return expr;
        }
        throw new Exception("Cannot cast to string such expression");
    }
}
