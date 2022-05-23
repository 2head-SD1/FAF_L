package fafl.Absyn; // Java Package generated by the BNF Converter.

public class ArrayType extends Type {
  public final Type type_;
  public ArrayType(Type p1) { type_ = p1; }

  public <R,A> R accept(fafl.Absyn.Type.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof fafl.Absyn.ArrayType) {
      fafl.Absyn.ArrayType x = (fafl.Absyn.ArrayType)o;
      return this.type_.equals(x.type_);
    }
    return false;
  }

  public int hashCode() {
    return this.type_.hashCode();
  }


}