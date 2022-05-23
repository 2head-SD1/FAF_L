package fafl.Absyn; // Java Package generated by the BNF Converter.

public class First extends Expr {
  public final Expr expr_;
  public First(Expr p1) { expr_ = p1; }

  public <R,A> R accept(fafl.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof fafl.Absyn.First) {
      fafl.Absyn.First x = (fafl.Absyn.First)o;
      return this.expr_.equals(x.expr_);
    }
    return false;
  }

  public int hashCode() {
    return this.expr_.hashCode();
  }


}
