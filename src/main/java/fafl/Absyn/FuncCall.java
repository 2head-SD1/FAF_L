package fafl.Absyn; // Java Package generated by the BNF Converter.

public class FuncCall extends Expr {
  public final String ident_;
  public final ListExpr listexpr_;
  public FuncCall(String p1, ListExpr p2) { ident_ = p1; listexpr_ = p2; }

  public <R,A> R accept(fafl.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof fafl.Absyn.FuncCall) {
      fafl.Absyn.FuncCall x = (fafl.Absyn.FuncCall)o;
      return this.ident_.equals(x.ident_) && this.listexpr_.equals(x.listexpr_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.ident_.hashCode())+this.listexpr_.hashCode();
  }


}