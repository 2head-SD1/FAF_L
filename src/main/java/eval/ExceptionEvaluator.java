package eval;

import fafl.Absyn.*;

public class ExceptionEvaluator
{
    public static boolean isExprException(Expr expr)
    {
        return expr instanceof TryCatch ||
                expr instanceof RaiseEx;
    }

    public static Expr doExceptionExpr(Expr expr) throws Exception
    {
        if (expr instanceof TryCatch)
        {
            TryCatch tryCatch = (TryCatch) expr;
            return doTryCatch(tryCatch);
        }
        if (expr instanceof RaiseEx)
        {
            RaiseEx raiseEx = (RaiseEx) expr;
            return doRaiseEx(raiseEx);
        }
        throw new Exception("Cannot handle such exception expression");
    }

    private static Expr doTryCatch(TryCatch tryCatch) throws Exception
    {
        try
        {
            return Evaluator.evalStep(tryCatch.expr_1);
        } catch (Exception e)
        {
            return Evaluator.evalStep(tryCatch.expr_2);
        }
    }

    private static Expr doRaiseEx(RaiseEx raiseEx) throws Exception
    {
        throw new Exception(raiseEx.string_);
    }
}
