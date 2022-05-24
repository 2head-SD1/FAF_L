package fafl.Absyn; // Java Package generated by the BNF Converter.

public class DictRemove extends Expr {
  public final Expr expr_1, expr_2;
  public DictRemove(Expr p1, Expr p2) { expr_1 = p1; expr_2 = p2; }

  public <R,A> R accept(fafl.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof fafl.Absyn.DictRemove) {
      fafl.Absyn.DictRemove x = (fafl.Absyn.DictRemove)o;
      return this.expr_1.equals(x.expr_1) && this.expr_2.equals(x.expr_2);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.expr_1.hashCode())+this.expr_2.hashCode();
  }


}
