package eval;

import fafl.Absyn.Expr;
import fafl.Absyn.Type;

import java.util.ArrayList;

public class Context {
    public static class ContextNode {
        public String ident;
        public Type type;
        public Expr additionalInfo;
        public ContextNode(String ident, Type type)
        {
            this.ident = ident;
            this.type = type;
        }
        public ContextNode(String ident, Type type, Expr additionalInfo)
        {
            this.ident = ident;
            this.type = type;
            this.additionalInfo = additionalInfo;
        }
    }

    public ArrayList<ContextNode> context = new ArrayList<>();
}
