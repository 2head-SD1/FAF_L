package fafl.Absyn; // Java Package generated by the BNF Converter.

public abstract class Arg implements java.io.Serializable {
  public abstract <R,A> R accept(Arg.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(fafl.Absyn.NameArg p, A arg);
    public R visit(fafl.Absyn.ExprArg p, A arg);

  }

}
