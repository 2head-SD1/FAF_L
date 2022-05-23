package eval;

import fafl.Absyn.*;

import java.util.ArrayList;

public class ArithmeticEvaluator
{
    public static boolean isExprArithmetic(Expr expr)
    {
        return expr instanceof Plus ||
                expr instanceof Minus ||
                expr instanceof Div ||
                expr instanceof Mul
                ;
    }

    public static Expr doArithmeticExpr(Expr expr) throws Exception
    {
        if (expr instanceof Plus plus)
        {
            return doPlusExpr(plus);
        }
        if (expr instanceof Minus minus)
        {
            return doMinusExpr(minus);
        }
        if (expr instanceof Mul mul)
        {
            return doMulExpr(mul);
        }
        if (expr instanceof Div div)
        {
            return doDivExrp(div);
        }
        throw new Exception("No such expression");
    }

    private static Expr doPlusExpr(Plus plus) throws Exception
    {
        ArrayList<Expr> inPlusExprList = new ArrayList<>();
        for (Expr inPlusExpr : plus.listexpr_)
        {
            inPlusExprList.add(Evaluator.evalStep(inPlusExpr));
        }

        if (inPlusExprList.get(0) instanceof IntConst)
        {
            Integer ans = 0;
            for (Expr inPlusExpr : inPlusExprList)
            {
                ans += ((IntConst) inPlusExpr).integer_;
            }
            return new IntConst(ans);
        }
        else if (inPlusExprList.get(0) instanceof DoubleConst)
        {
            Double ans = 0.0;
            for (Expr inPlusExpr : inPlusExprList)
            {
                ans += ((DoubleConst) inPlusExpr).double_;
            }
            return new DoubleConst(ans);
        }
        throw new Exception("Cannot plus such expressions");
    }

    private static Expr doMinusExpr(Minus minus) throws Exception
    {
        ArrayList<Expr> inMinusExprList = new ArrayList<>();
        for (Expr inMinusExpr : minus.listexpr_)
        {
            inMinusExprList.add(Evaluator.evalStep(inMinusExpr));
        }

        if (inMinusExprList.get(0) instanceof IntConst)
        {
            Integer ans = 0;
            for (Expr inMinusExpr : inMinusExprList)
            {
                ans -= ((IntConst) inMinusExpr).integer_;
            }
            return new IntConst(ans);
        }
        else if (inMinusExprList.get(0) instanceof DoubleConst)
        {
            Double ans = 0.0;
            for (Expr inMinusExpr : inMinusExprList)
            {
                ans -= ((DoubleConst) inMinusExpr).double_;
            }
            return new DoubleConst(ans);
        }
        throw new Exception("Cannot minus such expression");
    }

    private static Expr doMulExpr(Mul mul) throws Exception
    {
        ArrayList<Expr> inMulExprList = new ArrayList<>();
        for (Expr inMulExpr : mul.listexpr_)
        {
            inMulExprList.add(Evaluator.evalStep(inMulExpr));
        }

        if (inMulExprList.get(0) instanceof IntConst)
        {
            Integer ans = 0;
            for (Expr inMulExpr : inMulExprList)
            {
                ans *= ((IntConst) inMulExpr).integer_;
            }
            return new IntConst(ans);
        }
        else if (inMulExprList.get(0) instanceof DoubleConst)
        {
            Double ans = 0.0;
            for (Expr inMulExpr : inMulExprList)
            {
                ans *= ((DoubleConst) inMulExpr).double_;
            }
            return new DoubleConst(ans);
        }
        throw new Exception("Cannot multiply such expression");
    }

    private static Expr doDivExrp(Div div) throws Exception
    {
        ArrayList<Expr> inDivExprList = new ArrayList<>();
        for (Expr inDivExpr : div.listexpr_)
        {
            inDivExprList.add(Evaluator.evalStep(inDivExpr));
        }

        if (inDivExprList.get(0) instanceof IntConst)
        {
            Integer ans = 0;
            for (Expr inDivExpr : inDivExprList)
            {
                ans /= ((IntConst) inDivExpr).integer_;
            }
            return new IntConst(ans);
        }
        else if (inDivExprList.get(0) instanceof DoubleConst)
        {
            Double ans = 0.0;
            for (Expr inDivExpr : inDivExprList)
            {
                ans /= ((DoubleConst) inDivExpr).double_;
            }
            return new DoubleConst(ans);
        }
        throw new Exception("Cannot divide such expression");
    }
}
