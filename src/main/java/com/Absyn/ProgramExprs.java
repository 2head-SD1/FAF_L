package com.Absyn; // Java Package generated by the BNF Converter.

public abstract class ProgramExprs implements java.io.Serializable {
  public abstract <R,A> R accept(ProgramExprs.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(com.Absyn.Program p, A arg);

  }

}
