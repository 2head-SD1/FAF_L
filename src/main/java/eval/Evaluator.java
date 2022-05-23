package eval;

import com.SymbolTable.*;
import fafl.Absyn.*;


public class Evaluator
{
    public static Expr evalStep(Expr expr) throws Exception
    {
        //Implemented: setq rules(without setqstruct), if rules, arithmetic rules, bool predicates
        if (isExprConst(expr))
        {
            return expr;
        }

        if (expr instanceof ArrayConstructor){
            return expr;
        }

        if (expr instanceof SetqSimple)
        {
            SetqSimple setq = (SetqSimple) expr;
            Expr value = evalStep(setq.expr_);
            SymbolNode node = new SymbolNode(setq.type_, value);
            SymbolTable.addSymbol(setq.ident_, node);
            return value;
        }

        //TODO: SetqStruct

        if (expr instanceof Id)
        {
            Id id = (Id) expr;
            SymbolNode symbolNode = SymbolTable.getSymbol(id.ident_);
            return symbolNode.value;
        }

        if (expr instanceof If)
        {
            If ifexpr = (If) expr;
            BoolConst expr1 = (BoolConst) evalStep(ifexpr.expr_1);
            if (expr1.bool_ instanceof BoolTrue)
            {
                return evalStep(ifexpr.expr_2);
            } else
            {
                return evalStep(ifexpr.expr_3);
            }
        }

        if (ArithmeticEvaluator.isExprArithmetic(expr))
        {
            return ArithmeticEvaluator.doArithmeticExpr(expr);
        }

        if (ArrayEval.isArrayExpr(expr))
        {
            return ArrayEval.doArrayExpr(expr);
        }

        if (BoolPredicateEvaluator.isExprBoolPredicate(expr))
        {
            return BoolPredicateEvaluator.doBoolPredicateExpr(expr);
        }

        throw new Exception("No such expression");
    }

    public static boolean isExprConst(Expr expr)
    {
        return expr instanceof IntConst ||
                expr instanceof DoubleConst ||
                expr instanceof BoolConst ||
                expr instanceof StringConst
                ;
    }
}
