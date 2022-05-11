package fafl.Absyn; // Java Package generated by the BNF Converter.

public abstract class Type implements java.io.Serializable {
  public abstract <R,A> R accept(Type.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(fafl.Absyn.BoolType p, A arg);
    public R visit(fafl.Absyn.IntType p, A arg);
    public R visit(fafl.Absyn.DoubleType p, A arg);
    public R visit(fafl.Absyn.StringType p, A arg);
    public R visit(fafl.Absyn.ArrayType p, A arg);
    public R visit(fafl.Absyn.StructType p, A arg);
    public R visit(fafl.Absyn.StructFieldType p, A arg);
    public R visit(fafl.Absyn.FuncType p, A arg);

  }

}
