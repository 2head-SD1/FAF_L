package fafl.Absyn; // Java Package generated by the BNF Converter.

public class DictLength extends Expr {
  public final Expr expr_;
  public DictLength(Expr p1) { expr_ = p1; }

  public <R,A> R accept(fafl.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof fafl.Absyn.DictLength) {
      fafl.Absyn.DictLength x = (fafl.Absyn.DictLength)o;
      return this.expr_.equals(x.expr_);
    }
    return false;
  }

  public int hashCode() {
    return this.expr_.hashCode();
  }


}
