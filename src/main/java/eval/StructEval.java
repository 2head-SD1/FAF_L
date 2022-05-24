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
        StructConstructor structConstructor = getStructConstructor(expr.expr_);
        ListExpr arguments = structConstructor.listexpr_;

        SymbolNode structNode = SymbolTable.getSymbol(structConstructor.ident_);
        StructInit structInit = (StructInit) structNode.value;

        ListATypedArg fields = structInit.listatypedarg_;

        for(int i = 0; i < arguments.size(); i++){
            TypedArg typedArg = (TypedArg) fields.get(i);

            if (typedArg.ident_.equalsIgnoreCase(expr.ident_)){
                return arguments.get(i);
            }
        }

        throw new Exception("no such field");
    }

    public static boolean isStructExpr(Expr expr) {
        return
            expr instanceof StructInit ||
            expr instanceof StructConstructor ||
            expr instanceof StructField;
    }

    private static StructConstructor getStructConstructor(Expr expr) throws Exception {
        StructConstructor structConstructor;

        if (expr instanceof Id){
            Id id = (Id) expr;
            structConstructor = (StructConstructor) SymbolTable.getSymbol(id.ident_).value;
        } else {
            structConstructor = (StructConstructor) Evaluator.evalStep(expr);
        }

        return structConstructor;
    }
}
