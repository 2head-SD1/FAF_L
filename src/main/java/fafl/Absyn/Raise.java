package fafl.Absyn; // Java Package generated by the BNF Converter.

public abstract class Raise implements java.io.Serializable {
  public abstract <R,A> R accept(Raise.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(fafl.Absyn.RaiseEx p, A arg);

  }

}
