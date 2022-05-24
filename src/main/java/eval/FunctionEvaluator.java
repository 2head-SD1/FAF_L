package eval;

import com.SymbolTable.SymbolNode;
import com.SymbolTable.SymbolTable;
import fafl.Absyn.*;

public class FunctionEvaluator
{
    public static boolean isFunctionExpr(Expr expr)
    {
        return expr instanceof Define ||
                expr instanceof FuncCall;
    }

    public static Expr doFunctionExpr(Expr expr) throws Exception
    {
        if (expr instanceof Define)
        {
            Define define = (Define) expr;
            return doDefine(define);
        }
        if (expr instanceof FuncCall)
        {
            FuncCall call = (FuncCall) expr;
            return doCall(call);
        }

        throw new Exception("Cannot handle such action with functions");
    }

    private static Expr doDefine(Define define) throws Exception
    {
        SymbolNode node = new SymbolNode(TypeChecker.typeOf(new Context().context, define), define);
        SymbolTable.addSymbol(define.ident_, node);
        return define;
    }

    private static Expr doCall(FuncCall call) throws Exception
    {
        SymbolTable.increaseScopeLevel();
        Define define = (Define) SymbolTable.getSymbol(call.ident_).value;
        addSymbols(define, call);
        Expr toReturn = Evaluator.evalStep(define.expr_);
        SymbolTable.decreaseScopeLevel();
        return toReturn;
    }

    private static void addSymbols(Define define, FuncCall call) throws Exception
    {
        for (int i = 0; i < define.listatypedarg_.size(); i++)
        {
            TypedArg arg = (TypedArg) define.listatypedarg_.get(i);
            Expr toArgExpr = Evaluator.evalStep(call.listexpr_.get(i));
            SymbolNode node = new SymbolNode(arg.type_, toArgExpr);
            SymbolTable.addSymbol(arg.ident_, node);
        }
    }
}
