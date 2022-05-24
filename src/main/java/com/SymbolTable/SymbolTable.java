package com.SymbolTable;

import java.util.HashMap;

public class SymbolTable
{
    private static int currentScopeLevel = 0;
    private static HashMap<SymbolTableKey, SymbolNode> table = new HashMap<>();

    public static void increaseScopeLevel()
    {
        currentScopeLevel++;
    }

    public static void decreaseScopeLevel()
    {
        currentScopeLevel--;
        deleteSymbolsWithBadScopes();
    }

    public static void addSymbol(String ident, SymbolNode value)
    {
        SymbolTableKey key = new SymbolTableKey(ident, currentScopeLevel);
        if (table.containsKey(key))
        {
            throw new IllegalArgumentException(String.format("Identifier %s exist", ident));
        }
        else
        {
            table.put(key, value);
        }
    }

    public static SymbolNode getSymbol(String ident)
    {
        for (int i = currentScopeLevel; i >= 0; i--)
        {
            SymbolTableKey key = new SymbolTableKey(ident, i);
            if (table.containsKey(key))
            {
                return table.get(key);
            }
        }
        throw new IllegalArgumentException(String.format("Identifier %s does not exist", ident));
    }

    public static SymbolNode removeSymbol(String ident)
    {
        for (int i = currentScopeLevel; i >= 0; i--)
        {
            SymbolTableKey key = new SymbolTableKey(ident, i);
            if (table.containsKey(key))
            {
                return table.remove(key);
            }
        }
        throw new IllegalArgumentException(String.format("Identifier %s does not exist", ident));
    }

    private static void deleteSymbolsWithBadScopes()
    {
        for (SymbolTableKey key : table.keySet())
        {
            if (key.scopeLevel > currentScopeLevel)
            {
                table.remove(key);
            }
        }
    }

    private static class SymbolTableKey
    {
        public String symbolIdent;
        public int scopeLevel;

        public SymbolTableKey(String symbolIdent, int scopeLevel)
        {
            this.symbolIdent = symbolIdent;
            this.scopeLevel = scopeLevel;
        }

        @Override
        public boolean equals(Object obj)
        {
            SymbolTableKey other = (SymbolTableKey) obj;
            return other.scopeLevel == this.scopeLevel &&
                    other.symbolIdent.equals(this.symbolIdent);
        }

        @Override
        public int hashCode()
        {
            return this.symbolIdent.hashCode() + scopeLevel;
        }
    }
}
