package eval;

import com.SymbolTable.SymbolNode;
import com.SymbolTable.SymbolTable;
import fafl.Absyn.*;

public class ArrayEval
{
    public static Expr doArrayExpr(Expr expr) throws Exception
    {
        if (expr instanceof First)
        {
            First first = (First) expr;
            return doFirst(first);
        }
        if (expr instanceof Last)
        {
            Last last = (Last) expr;
            return doLast(last);
        }
        if (expr instanceof ArrayAdd)
        {
            ArrayAdd add = (ArrayAdd) expr;
            return doAdd(add);
        }
        if (expr instanceof ArraySet)
        {
            ArraySet arraySet = (ArraySet) expr;
            return doSet(arraySet);
        }
        if (expr instanceof ArrayGet)
        {
            ArrayGet arrayGet = (ArrayGet) expr;
            return doGet(arrayGet);
        }
        if (expr instanceof ArrayLength)
        {
            ArrayLength length = (ArrayLength) expr;
            return doLength(length);
        }
        throw new Exception("No such expression");
    }

    public static boolean isArrayExpr(Expr expr)
    {
        return expr instanceof First ||
                expr instanceof Last ||
                expr instanceof ArrayGet ||
                expr instanceof ArraySet ||
                expr instanceof ArrayLength ||
                expr instanceof ArrayAdd
                ;
    }

    private static Expr doFirst(First expr) throws Exception {
        ListExpr listExpr = getArray(expr.expr_);

        if(listExpr.isEmpty()){
            throw new Exception("empty array");
        } else {
            return listExpr.getFirst();
        }
    }

    private static Expr doLast(Last expr) throws Exception {
        ListExpr listExpr = getArray(expr.expr_);

        if(listExpr.isEmpty()){
            throw new Exception("empty array");
        } else {
            return listExpr.getLast();
        }
    }

    private static Expr doGet(ArrayGet expr) throws Exception {
        ListExpr listExpr = getArray(expr.expr_1);
        Expr indexExpr = Evaluator.evalStep(expr.expr_2);

        int index = ((IntConst) indexExpr).integer_;
        if (index >= 0) {
            return Evaluator.evalStep(listExpr.get(index));
        } else {
            throw new Exception("negative array index");
        }
    }

    private static Expr doSet(ArraySet expr) throws Exception {
        ArrayConstructor arrayConstructor = getArrayConstructor(expr.expr_1);
        ListExpr listExpr = getArray(expr.expr_1);
        Expr indexExpr = Evaluator.evalStep(expr.expr_2);
        Expr toSet = Evaluator.evalStep(expr.expr_3);

        int index = ((IntConst) indexExpr).integer_;
        if (index >= 0) {
            listExpr.set(index, toSet);

            ArrayConstructor newArrayConstructor = new ArrayConstructor(
                    arrayConstructor.type_,
                    arrayConstructor.expr_,
                    listExpr
            );

            if (arrayConstructor.expr_ instanceof Id){
                Id id = (Id) arrayConstructor.expr_;
                SymbolTable.removeSymbol(id.ident_);

                SymbolNode arrayNode = new SymbolNode(
                        new ArrayType(newArrayConstructor.type_),
                        newArrayConstructor
                );

                SymbolTable.addSymbol(id.ident_, arrayNode);
            }

            return newArrayConstructor;
        } else {
            throw new Exception("negative array index");
        }
    }

    private static Expr doAdd(ArrayAdd expr) throws Exception {
        ArrayConstructor arrayConstructor = getArrayConstructor(expr.expr_1);
        ListExpr listExpr = getArray(expr.expr_1);
        Expr indexExpr = Evaluator.evalStep(expr.expr_2);
        Expr toAdd = Evaluator.evalStep(expr.expr_3);

        int index = ((IntConst) indexExpr).integer_;
        if (index >= 0) {
            listExpr.add(index, toAdd);
            IntConst numOfElements = (IntConst) Evaluator.evalStep(arrayConstructor.expr_);
            IntConst newNumOfElements = new IntConst(numOfElements.integer_ + 1);

            ArrayConstructor newArrayConstructor = new ArrayConstructor(
                    arrayConstructor.type_,
                    newNumOfElements,
                    listExpr
            );

            if (arrayConstructor.expr_ instanceof Id){
                Id id = (Id) arrayConstructor.expr_;
                SymbolTable.removeSymbol(id.ident_);

                SymbolNode arrayNode = new SymbolNode(
                        new ArrayType(newArrayConstructor.type_),
                        newArrayConstructor
                );

                SymbolTable.addSymbol(id.ident_, arrayNode);
            }

            return newArrayConstructor;
        } else {
            throw new Exception("negative array index");
        }
    }

    private static IntConst doLength(ArrayLength expr) throws Exception {
        ListExpr listExpr = getArray(expr.expr_);

        return new IntConst(listExpr.size());
    }

    private static ArrayConstructor getArrayConstructor(Expr expr) throws Exception {
        ArrayConstructor arrayConstructorExpr;

        if (expr instanceof Id){
            Id id = (Id) expr;
            arrayConstructorExpr = (ArrayConstructor) SymbolTable.getSymbol(id.ident_).value;
        } else {
            arrayConstructorExpr = (ArrayConstructor) Evaluator.evalStep(expr);
        }

        return arrayConstructorExpr;
    }

    private static ListExpr getArray(Expr expr) throws Exception {
        ArrayConstructor arrayConstructorExpr = getArrayConstructor(expr);
        ListExpr listExpr = arrayConstructorExpr.listexpr_;

        return listExpr;
    }
}
