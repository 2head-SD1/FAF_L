package fafl.Absyn; // Java Package generated by the BNF Converter.

public class StructType extends Type {
  public final String ident_;
  public StructType(String p1) { ident_ = p1; }

  public <R,A> R accept(fafl.Absyn.Type.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof fafl.Absyn.StructType) {
      fafl.Absyn.StructType x = (fafl.Absyn.StructType)o;
      return this.ident_.equals(x.ident_);
    }
    return false;
  }

  public int hashCode() {
    return this.ident_.hashCode();
  }


}
