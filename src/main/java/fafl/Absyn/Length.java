package fafl.Absyn; // Java Package generated by the BNF Converter.

public class Length extends Expr {
  public final String ident_;
  public Length(String p1) { ident_ = p1; }

  public <R,A> R accept(fafl.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof fafl.Absyn.Length) {
      fafl.Absyn.Length x = (fafl.Absyn.Length)o;
      return this.ident_.equals(x.ident_);
    }
    return false;
  }

  public int hashCode() {
    return this.ident_.hashCode();
  }


}
