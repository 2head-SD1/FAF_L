package fafl.Absyn; // Java Package generated by the BNF Converter.

public class DoubleConst extends Expr {
  public final Double double_;
  public DoubleConst(Double p1) { double_ = p1; }

  public <R,A> R accept(fafl.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof fafl.Absyn.DoubleConst) {
      fafl.Absyn.DoubleConst x = (fafl.Absyn.DoubleConst)o;
      return this.double_.equals(x.double_);
    }
    return false;
  }

  public int hashCode() {
    return this.double_.hashCode();
  }


}
