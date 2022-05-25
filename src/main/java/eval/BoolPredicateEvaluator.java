package eval;

import fafl.Absyn.*;

public class BoolPredicateEvaluator
{
    public static boolean isExprBoolPredicate(Expr expr)
    {
        return expr instanceof Equals ||
                expr instanceof IsLess ||
                expr instanceof IsGreater ||
                expr instanceof And ||
                expr instanceof Or
                ;
    }

    public static Expr doBoolPredicateExpr(Expr expr) throws Exception
    {
        if (expr instanceof Equals)
        {
            Equals eq = (Equals) expr;
            return doEqualsPredicate(eq);
        }
        if (expr instanceof IsLess)
        {
            IsLess isLess = (IsLess) expr;
            return doIsLess(isLess);
        }
        if (expr instanceof IsGreater)
        {
            IsGreater isGreater = (IsGreater) expr;
            return doIsGreater(isGreater);
        }
        if (expr instanceof And)
        {
            And and = (And) expr;
            return doAndPredicate(and);
        }
        if (expr instanceof Or)
        {
            Or or = (Or) expr;
            return doOrPredicate(or);
        }

        throw new Exception("No such expression");
    }

    private static Expr doEqualsPredicate(Equals eq) throws Exception
    {
        Expr expr1 = Evaluator.evalStep(eq.expr_1);
        Expr expr2 = Evaluator.evalStep(eq.expr_2);
        if (expr1 instanceof IntConst && expr2 instanceof IntConst)
        {
            IntConst int1 = (IntConst) expr1;
            IntConst int2 = (IntConst) expr2;
            if (int1.integer_.equals(int2.integer_))
            {
                return new BoolConst(new BoolTrue());
            }
            else
            {
                return new BoolConst(new BoolFalse());
            }
        }
        if (expr1 instanceof DoubleConst && expr2 instanceof DoubleConst)
        {
            DoubleConst d1 = (DoubleConst) expr1;
            DoubleConst d2 = (DoubleConst) expr2;
            if (d1.double_.equals(d2.double_))
            {
                return new BoolConst(new BoolTrue());
            }
            else
            {
                return new BoolConst(new BoolFalse());
            }
        }
        if (expr1 instanceof BoolConst && expr2 instanceof BoolConst)
        {
            BoolConst b1 = (BoolConst) expr1;
            BoolConst b2 = (BoolConst) expr2;
            if (b1.bool_.getClass() == b2.bool_.getClass())
            {
                return new BoolConst(new BoolTrue());
            }
            else
            {
                return new BoolConst(new BoolFalse());
            }
        }
        if (expr1 instanceof StringConst && expr2 instanceof StringConst)
        {
            StringConst s1 = (StringConst) expr1;
            StringConst s2 = (StringConst) expr2;
            if (s1.string_.equals(s1.string_))
            {
                return new BoolConst(new BoolTrue());
            }
            else
            {
                return new BoolConst(new BoolFalse());
            }
        }

        throw new Exception("Cannot do equals with such arguments");
    }

    private static Expr doIsLess(IsLess isLess) throws Exception
    {
        Expr expr1 = Evaluator.evalStep(isLess.expr_1);
        Expr expr2 = Evaluator.evalStep(isLess.expr_2);
        if (expr1 instanceof IntConst && expr2 instanceof IntConst)
        {
            IntConst int1 = (IntConst) expr1;
            IntConst int2 = (IntConst) expr2;
            if (int1.integer_ < int2.integer_)
            {
                return new BoolConst(new BoolTrue());
            }
            else
            {
                return new BoolConst(new BoolFalse());
            }
        }
        if (expr1 instanceof DoubleConst && expr2 instanceof DoubleConst)
        {
            DoubleConst d1 = (DoubleConst) expr1;
            DoubleConst d2 = (DoubleConst) expr2;
            if (d1.double_ < d2.double_)
            {
                return new BoolConst(new BoolTrue());
            }
            else
            {
                return new BoolConst(new BoolFalse());
            }
        }

        throw new Exception("Cannot do isLess with such arguments");
    }

    private static Expr doIsGreater(IsGreater isGreater) throws Exception
    {
        Expr expr1 = Evaluator.evalStep(isGreater.expr_1);
        Expr expr2 = Evaluator.evalStep(isGreater.expr_2);
        if (expr1 instanceof IntConst && expr2 instanceof IntConst)
        {
            IntConst int1 = (IntConst) expr1;
            IntConst int2 = (IntConst) expr2;
            if (int1.integer_ > int2.integer_)
            {
                return new BoolConst(new BoolTrue());
            }
            else
            {
                return new BoolConst(new BoolFalse());
            }
        }
        if (expr1 instanceof DoubleConst && expr2 instanceof DoubleConst)
        {
            DoubleConst d1 = (DoubleConst) expr1;
            DoubleConst d2 = (DoubleConst) expr2;
            if (d1.double_ > d2.double_)
            {
                return new BoolConst(new BoolTrue());
            }
            else
            {
                return new BoolConst(new BoolFalse());
            }
        }

        throw new Exception("Cannot do isGreater with such arguments");
    }

    private static Expr doAndPredicate(And and) throws Exception
    {
        Expr expr1 = Evaluator.evalStep(and.expr_1);
        Expr expr2 = Evaluator.evalStep(and.expr_2);
        if (expr1 instanceof BoolConst && expr2 instanceof BoolConst)
        {
            BoolConst b1 = (BoolConst) expr1;
            BoolConst b2 = (BoolConst) expr2;
            if (b1.bool_ instanceof BoolFalse || b2.bool_ instanceof BoolFalse)
            {
                return new BoolConst(new BoolFalse());
            }
            else
            {
                return new BoolConst(new BoolTrue());
            }
        }

        throw new Exception("Cannot do and with such arguments");
    }

    private static Expr doOrPredicate(Or or) throws Exception
    {
        Expr expr1 = Evaluator.evalStep(or.expr_1);
        Expr expr2 = Evaluator.evalStep(or.expr_2);
        if (expr1 instanceof BoolConst && expr2 instanceof BoolConst)
        {
            BoolConst b1 = (BoolConst) expr1;
            BoolConst b2 = (BoolConst) expr2;
            if (b1.bool_ instanceof BoolTrue || b2.bool_ instanceof BoolTrue)
            {
                return new BoolConst(new BoolTrue());
            }
            else
            {
                return new BoolConst(new BoolFalse());
            }
        }

        throw new Exception("Cannot do or with such arguments");
    }
}
