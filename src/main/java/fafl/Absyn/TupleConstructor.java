package fafl.Absyn; // Java Package generated by the BNF Converter.

public class TupleConstructor extends Expr {
  public final ListExpr listexpr_;
  public TupleConstructor(ListExpr p1) { listexpr_ = p1; }

  public <R,A> R accept(fafl.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof fafl.Absyn.TupleConstructor) {
      fafl.Absyn.TupleConstructor x = (fafl.Absyn.TupleConstructor)o;
      return this.listexpr_.equals(x.listexpr_);
    }
    return false;
  }

  public int hashCode() {
    return this.listexpr_.hashCode();
  }


}