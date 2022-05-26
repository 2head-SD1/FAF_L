package eval;

import com.SymbolTable.SymbolNode;
import com.SymbolTable.SymbolTable;
import fafl.Absyn.*;

public class FunctionEvaluator
{
    public static boolean isFunctionExpr(Expr expr)
    {
        return expr instanceof Define ||
                expr instanceof FuncCall ||
                expr instanceof Lambda ||
                expr instanceof DefineWithExc;
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
        if (expr instanceof Lambda)
        {
            Lambda lambda = (Lambda) expr;
            return doLambda(lambda);
        }
        if (expr instanceof DefineWithExc)
        {
            DefineWithExc defineWithExc = (DefineWithExc) expr;
            return doDefineWithExc(defineWithExc);
        }

        throw new Exception("Cannot handle such action with functions");
    }

    private static Expr doDefine(Define define) throws Exception
    {
        SymbolNode node = new SymbolNode(new FuncType(TypeChecker.getFuncArgsFromTypedArgs(define.listatypedarg_), ((FuncReturnType) define.afuncreturntype_).type_), define);
        SymbolTable.addSymbol(define.ident_, node);
        return define;
    }

    private static Expr doDefineWithExc(DefineWithExc defineWithExc)
    {
        SymbolNode node = new SymbolNode(new FuncType(TypeChecker.getFuncArgsFromTypedArgs(defineWithExc.listatypedarg_), ((FuncReturnType) defineWithExc.afuncreturntype_).type_), defineWithExc);
        SymbolTable.addSymbol(defineWithExc.ident_, node);
        return defineWithExc;
    }

    private static Expr doLambda(Lambda lambda) throws Exception
    {
        return lambda;
    }

    private static Expr doCall(FuncCall call) throws Exception
    {
        SymbolTable.increaseScopeLevel();
        Expr exprFromTable = SymbolTable.getSymbol(call.ident_).value;
        Expr toReturn;
        if (exprFromTable instanceof Define)
        {
            Define define = (Define) exprFromTable;
            addSymbols(define, call);
            toReturn = Evaluator.evalStep(define.expr_);
        }
        else if (exprFromTable instanceof Lambda)
        {
            Lambda lambda = (Lambda) exprFromTable;
            addSymbols(lambda, call);
            toReturn = Evaluator.evalStep(lambda.expr_);
        }
        else if (exprFromTable instanceof DefineWithExc)
        {
            DefineWithExc defineWithExc = (DefineWithExc) exprFromTable;
            addSymbols(defineWithExc, call);
            toReturn = Evaluator.evalStep(defineWithExc.expr_);
        }
        else
        {
            throw new Exception("Cannot call such type");
        }
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

    private static void addSymbols(Lambda lambda, FuncCall call) throws Exception
    {
        for (int i = 0; i < lambda.listatypedarg_.size(); i++)
        {
            TypedArg arg = (TypedArg) lambda.listatypedarg_.get(i);
            Expr toArgExpr = Evaluator.evalStep(call.listexpr_.get(i));
            SymbolNode node = new SymbolNode(arg.type_, toArgExpr);
            SymbolTable.addSymbol(arg.ident_, node);
        }
    }

    private static void addSymbols(DefineWithExc defineWithExc, FuncCall call) throws Exception
    {
        for (int i = 0; i < defineWithExc.listatypedarg_.size(); i++)
        {
            TypedArg arg = (TypedArg) defineWithExc.listatypedarg_.get(i);
            Expr toArgExpr = Evaluator.evalStep(call.listexpr_.get(i));
            SymbolNode node = new SymbolNode(arg.type_, toArgExpr);
            SymbolTable.addSymbol(arg.ident_, node);
        }
    }
}
