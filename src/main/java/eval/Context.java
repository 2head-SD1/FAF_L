package eval;

import fafl.Absyn.Type;

import java.util.ArrayList;

public class Context {
    public static class ContextNode {
        public String ident;
        public Type type;
        public ContextNode(String ident, Type type)
        {
            this.ident = ident;
            this.type = type;
        }
    }

    public ArrayList<ContextNode> context = new ArrayList<>();
}
