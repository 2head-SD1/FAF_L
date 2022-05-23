package com.SymbolTable;

import fafl.Absyn.Expr;
import fafl.Absyn.Type;

public class SymbolNode {
    private Type type;
    public Expr value;

    public SymbolNode(Type type, Expr value)
    {
        this.type = type;
        this.value = value;
    }

    public Type GetType()
    {
        return type;
    }
}
