package fafl.Absyn; // Java Package generated by the BNF Converter.

public class IntConst extends Expr {
  public final Integer integer_;
  public IntConst(Integer p1) { integer_ = p1; }

  public <R,A> R accept(fafl.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof fafl.Absyn.IntConst) {
      fafl.Absyn.IntConst x = (fafl.Absyn.IntConst)o;
      return this.integer_.equals(x.integer_);
    }
    return false;
  }

  public int hashCode() {
    return this.integer_.hashCode();
  }


}
