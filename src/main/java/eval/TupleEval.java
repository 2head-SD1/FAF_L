package eval;

import com.SymbolTable.SymbolNode;
import com.SymbolTable.SymbolTable;
import fafl.Absyn.*;

public class TupleEval
{
    public static Expr doTupleExpr(Expr expr) throws Exception
    {
        if (expr instanceof TupleGet)
        {
            TupleGet tupleGet = (TupleGet) expr;
            return doTupleGet(tupleGet);
        }
        if (expr instanceof TupleLength)
        {
            TupleLength length = (TupleLength) expr;
            return doLength(length);
        }
        throw new Exception("No such expression");
    }

    public static boolean isTupleExpr(Expr expr)
    {
        return expr instanceof TupleConstructor ||
                expr instanceof TupleGet ||
                expr instanceof TupleLength
                ;
    }

    private static Expr doTupleGet(TupleGet expr) throws Exception {
        ListExpr listExpr = getTuple(expr.expr_1);
        Expr indexExpr = Evaluator.evalStep(expr.expr_2);

        int index = ((IntConst) indexExpr).integer_;
        if (index >= 0) {
            if (index < listExpr.size()) {
                return listExpr.get(index);
            } else
            {
                throw new Exception("overflow");
            }
        } else {
            throw new Exception("negative array index");
        }
    }


    private static IntConst doLength(TupleLength expr) throws Exception {
        ListExpr listExpr = getTuple(expr.expr_);

        return new IntConst(listExpr.size());
    }

    private static TupleConstructor getTupleConstructor(Expr expr) throws Exception {
        TupleConstructor tupleConstructor;

        if (expr instanceof Id){
            Id id = (Id) expr;
            tupleConstructor = (TupleConstructor) SymbolTable.getSymbol(id.ident_).value;
        } else {
            tupleConstructor = (TupleConstructor) Evaluator.evalStep(expr);
        }

        return tupleConstructor;
    }

    private static ListExpr getTuple(Expr expr) throws Exception {
        TupleConstructor tupleConstructor = getTupleConstructor(expr);
        ListExpr listExpr = tupleConstructor.listexpr_;

        return listExpr;
    }
}
