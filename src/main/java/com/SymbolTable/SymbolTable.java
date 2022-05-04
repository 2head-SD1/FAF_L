package com.SymbolTable;

import java.util.HashMap;

public class SymbolTable {
    private static HashMap<String, Object> table;
    public SymbolTable()
    {
        table = new HashMap<>();
    }

    public static void addSymbol(String ident, Object value)
    {
        if(table.containsKey(ident))
        {
            throw new IllegalArgumentException(String.format("Identifier %s exist", ident));
        }
        else
        {
            table.put(ident, value);
        }
    }

    public static Object getSymbol(String ident) {
        if(table.containsKey(ident))
        {
            return table.get(ident);
        }
        else
        {
            throw new IllegalArgumentException(String.format("Identifier %s does not exist", ident));
        }
    }
}
