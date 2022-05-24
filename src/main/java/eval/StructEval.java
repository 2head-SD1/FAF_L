package eval;

import com.SymbolTable.SymbolNode;
import com.SymbolTable.SymbolTable;
import fafl.Absyn.*;
import fafl.PrettyPrinter;
import java_cup.runtime.Symbol;

import java.sql.Struct;

public class StructEval {
    public static Expr doStructExpr(Expr expr) throws Exception
    {
        if (expr instanceof StructInit){
            StructInit structInit = (StructInit) expr;
            return doStructInit(structInit);
        }
        if (expr instanceof StructConstructor)
        {
            StructConstructor structConstructor = (StructConstructor) expr;
            return doStructConstructor(structConstructor);
        }
        if (expr instanceof StructField)
        {
            StructField structField = (StructField) expr;
            return doStructField(structField);
        }
        throw new Exception("No such expression");
    }

    private static Expr doStructInit(StructInit expr) throws Exception {
        SymbolNode structNode = new SymbolNode(
                new StructType(
                        expr.ident_
                ),
                expr
        );
        SymbolTable.addSymbol(expr.ident_, structNode);

        return expr;
    }

    private static Expr doStructConstructor(StructConstructor expr) throws Exception {
        return expr;
    }

    private static Expr doStructField(StructField expr) throws Exception {
//        System.out.println(expr.ident_);
//
//        if (expr.expr_ instanceof Id){
//            Id id = (Id) expr.expr_;
//
//            return SymbolTable.getSymbol(
//                    id.ident_ +"." + expr.ident_
//            ).value;
//        } else {
//            Expr evaluatedExpr = expr.expr_;
//            if (evaluatedExpr instanceof StructField){
//                return SymbolTable.getSymbol(
//                        ((StructField) evaluatedExpr).ident_ + "." + expr.ident_
//                ).value;
//            } else {
//
//            }
//
//            while (! (evaluatedExpr instanceof  StructField)){
//                evaluatedExpr = Evaluator.evalStep(expr.)
//            }
//        }
        return expr;
    }


    public static boolean isStructExpr(Expr expr)
    {
        return
                expr instanceof StructInit ||
                expr instanceof StructConstructor ||
                expr instanceof StructField;
    }
}
