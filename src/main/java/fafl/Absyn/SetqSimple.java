package fafl.Absyn; // Java Package generated by the BNF Converter.

public class SetqSimple extends Expr {
  public final String ident_;
  public final Type type_;
  public final Expr expr_;
  public SetqSimple(String p1, Type p2, Expr p3) { ident_ = p1; type_ = p2; expr_ = p3; }

  public <R,A> R accept(fafl.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof fafl.Absyn.SetqSimple) {
      fafl.Absyn.SetqSimple x = (fafl.Absyn.SetqSimple)o;
      return this.ident_.equals(x.ident_) && this.type_.equals(x.type_) && this.expr_.equals(x.expr_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(37*(this.ident_.hashCode())+this.type_.hashCode())+this.expr_.hashCode();
  }


}