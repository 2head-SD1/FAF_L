package fafl.Absyn; // Java Package generated by the BNF Converter.

public class TupleType extends Type {
  public TupleType() { }

  public <R,A> R accept(fafl.Absyn.Type.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof fafl.Absyn.TupleType) {
      return true;
    }
    return false;
  }

  public int hashCode() {
    return 37;
  }


}