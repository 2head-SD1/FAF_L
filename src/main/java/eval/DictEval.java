package eval;

import com.SymbolTable.SymbolNode;
import com.SymbolTable.SymbolTable;
import fafl.Absyn.*;

public class DictEval
{
    public static Expr doDictExpr(Expr expr) throws Exception
    {
        if (expr instanceof DictConstructor){
            DictConstructor dictConstructor = (DictConstructor) expr;
            return doDictInit(dictConstructor);
        }
        if (expr instanceof DictSet)
        {
            DictSet dictSet = (DictSet) expr;
            return doDictSet(dictSet);
        }
        if (expr instanceof DictGet)
        {
            DictGet dictGet = (DictGet) expr;
            return doDictGet(dictGet);
        }
        if (expr instanceof DictKeys)
        {
            DictKeys dictKeys = (DictKeys) expr;
            return doDictKeys(dictKeys);
        }
        if (expr instanceof DictValues)
        {
            DictValues dictValues = (DictValues) expr;
            return doDictValues(dictValues);
        }
        if (expr instanceof DictRemove)
        {
            DictRemove dictRemove = (DictRemove) expr;
            return doDictRemove(dictRemove);
        }
        if (expr instanceof DictLength)
        {
            DictLength dictLength = (DictLength) expr;
            return doDictLength(dictLength);
        }
        throw new Exception("No such expression");
    }

    public static boolean isDictExpr(Expr expr)
    {
        return
                expr instanceof DictLength ||
                expr instanceof DictRemove ||
                expr instanceof DictConstructor ||
                expr instanceof DictSet ||
                expr instanceof DictGet ||
                expr instanceof DictKeys ||
                expr instanceof DictValues
                ;
    }

    private static Expr doDictInit(DictConstructor expr) throws Exception {
        SymbolNode dictNode = new SymbolNode(
                new DictType(
                        expr.type_1,
                        expr.type_2
                ),
                expr
        );
        SymbolTable.addSymbol(expr.ident_, dictNode);

        return expr;
    }

    private static Expr doDictGet(DictGet expr) throws Exception {
        DictConstructor dictConstructor = getDictConstructor(expr.expr_1);
        Expr keyExpr = Evaluator.evalStep(expr.expr_2);
        ListPair pairs = getPairs(dictConstructor);

        ListExpr keys = getKeys(pairs);
        ListExpr values = getValues(pairs);

        if (keys.contains(keyExpr)){
            int index = keys.indexOf(keyExpr);

            return values.get(index);
        }

        throw new Exception("no such key");
    }

    private static Expr doDictKeys(DictKeys expr) throws Exception {
        DictConstructor dictConstructor = getDictConstructor(expr.expr_);
        ListPair pairs = getPairs(dictConstructor);

        ListExpr keys = getKeys(pairs);
        return new ArrayConstructor(
                dictConstructor.type_1,
                new IntConst(keys.size()),
                keys
        );
    }

    private static Expr doDictValues(DictValues expr) throws Exception {
        DictConstructor dictConstructor = getDictConstructor(expr.expr_);
        ListPair pairs = getPairs(dictConstructor);

        ListExpr values = getValues(pairs);
        return new ArrayConstructor(
                dictConstructor.type_2,
                new IntConst(values.size()),
                values
        );
    }

    private static Expr doDictSet(DictSet expr) throws Exception {
        DictConstructor dictConstructor = getDictConstructor(expr.expr_);
        ListPair pairs = getPairs(dictConstructor);
        ListExpr keys = getKeys(pairs);
        ListExpr values = getValues(pairs);

        DictPair dictPair = (DictPair) expr.pair_;
        Expr key = dictPair.expr_1;
        Expr value = dictPair.expr_2;

        if (keys.contains(key)) {
            int keyIndex = keys.indexOf(key);
            values.set(keyIndex, value);
        } else {
            keys.add(key);
            values.add(value);
        }

        ListPair newPairs = new ListPair();

        for(int i = 0; i < keys.size(); i++){
            newPairs.add(new DictPair(
                    keys.get(i),
                    values.get(i)
            ));
        }

        DictConstructor newDictConstructor = new DictConstructor(
                dictConstructor.ident_,
                dictConstructor.type_1,
                dictConstructor.type_2,
                newPairs
        );

        SymbolTable.removeSymbol(dictConstructor.ident_);
        SymbolNode dictNode = new SymbolNode(
                new DictType(
                        newDictConstructor.type_1,
                        newDictConstructor.type_2
                ),
                newDictConstructor
        );
        SymbolTable.addSymbol(newDictConstructor.ident_, dictNode);

        return newDictConstructor;
    }

    private static Expr doDictRemove(DictRemove expr) throws Exception {
        DictConstructor dictConstructor = getDictConstructor(expr.expr_1);
        ListPair pairs = getPairs(dictConstructor);
        ListExpr keys = getKeys(pairs);
        ListExpr values = getValues(pairs);

        Expr key = expr.expr_2;

        if (keys.contains(key)) {
            int keyIndex = keys.indexOf(key);
            keys.remove(keyIndex);
            values.remove(keyIndex);

            ListPair newPairs = new ListPair();

            for(int i = 0; i < keys.size(); i++){
                newPairs.add(new DictPair(
                        keys.get(i),
                        values.get(i)
                ));
            }

            DictConstructor newDictConstructor = new DictConstructor(
                    dictConstructor.ident_,
                    dictConstructor.type_1,
                    dictConstructor.type_2,
                    newPairs
            );

            SymbolTable.removeSymbol(dictConstructor.ident_);
            SymbolNode dictNode = new SymbolNode(
                    new DictType(
                            newDictConstructor.type_1,
                            newDictConstructor.type_2
                    ),
                    newDictConstructor
            );
            SymbolTable.addSymbol(newDictConstructor.ident_, dictNode);

            return newDictConstructor;

        } else {
            return dictConstructor;
        }
    }

    private static IntConst doDictLength(DictLength expr) throws Exception {
        DictConstructor dictConstructor = getDictConstructor(expr.expr_);
        ListPair pairs = getPairs(dictConstructor);

        return new IntConst(pairs.size());
    }

    private static DictConstructor getDictConstructor(Expr expr) throws Exception {
        DictConstructor dictConstructorExpr;

        if (expr instanceof Id){
            Id id = (Id) expr;
            dictConstructorExpr = (DictConstructor) SymbolTable.getSymbol(id.ident_).value;
        } else {
            dictConstructorExpr = (DictConstructor) Evaluator.evalStep(expr);
        }

        return dictConstructorExpr;
    }

    private static ListPair getPairs(DictConstructor dictConstructor) throws Exception {
        ListPair listPair = dictConstructor.listpair_;

        return listPair;
    }

    private static ListExpr getKeys(ListPair pairs) throws Exception{
        ListExpr exprs = new ListExpr();

        for (Pair pair: pairs){
            DictPair dictPair = (DictPair) pair;

            exprs.add(dictPair.expr_1);
        }

        return exprs;
    }

    private static ListExpr getValues(ListPair pairs) throws Exception{
        ListExpr exprs = new ListExpr();

        for (Pair pair: pairs){
            DictPair dictPair = (DictPair) pair;

            exprs.add(dictPair.expr_2);
        }

        return exprs;
    }
}
