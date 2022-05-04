package com.Absyn; // Java Package generated by the BNF Converter.

public class ParametersFunctions extends Params {
  public final Expr expr_;
  public ParametersFunctions(Expr p1) { expr_ = p1; }

  public <R,A> R accept(com.Absyn.Params.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof com.Absyn.ParametersFunctions) {
      com.Absyn.ParametersFunctions x = (com.Absyn.ParametersFunctions)o;
      return this.expr_.equals(x.expr_);
    }
    return false;
  }

  public int hashCode() {
    return this.expr_.hashCode();
  }


}
