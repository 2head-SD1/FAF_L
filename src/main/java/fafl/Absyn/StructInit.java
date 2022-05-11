package fafl.Absyn; // Java Package generated by the BNF Converter.

public class StructInit extends Expr {
  public final String ident_;
  public final ListATypedArg listatypedarg_;
  public StructInit(String p1, ListATypedArg p2) { ident_ = p1; listatypedarg_ = p2; }

  public <R,A> R accept(fafl.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof fafl.Absyn.StructInit) {
      fafl.Absyn.StructInit x = (fafl.Absyn.StructInit)o;
      return this.ident_.equals(x.ident_) && this.listatypedarg_.equals(x.listatypedarg_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.ident_.hashCode())+this.listatypedarg_.hashCode();
  }


}
