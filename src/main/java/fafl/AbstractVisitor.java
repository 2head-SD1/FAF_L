package fafl;
import fafl.Absyn.*;
/** BNFC-Generated Abstract Visitor */
public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
/* ProgramExprs */
    public R visit(fafl.Absyn.Program p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(fafl.Absyn.ProgramExprs p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Expr */
    public R visit(fafl.Absyn.SetqSimple p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.SetqStruct p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.IntConst p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.DoubleConst p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.BoolConst p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.StringConst p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.Id p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.Define p, A arg) { return visitDefault(p, arg); }

    public R visit(fafl.Absyn.StructInit p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.StructConstructor p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.StructField p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.If p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.Lambda p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.Plus p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.Minus p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.Mul p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.Div p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.IsLess p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.IsGreater p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.And p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.Or p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.ReadLine p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.PrintLine p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(fafl.Absyn.Expr p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Bool */
    public R visit(fafl.Absyn.BoolTrue p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.BoolFalse p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(fafl.Absyn.Bool p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* AFuncReturnType */
    public R visit(fafl.Absyn.FuncReturnType p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(fafl.Absyn.AFuncReturnType p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Raise */
    public R visit(fafl.Absyn.RaiseEx p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(fafl.Absyn.Raise p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* ATryCatch */
    public R visit(fafl.Absyn.TryCatch p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(fafl.Absyn.ATryCatch p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* ATypedArg */
    public R visit(fafl.Absyn.TypedArg p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(fafl.Absyn.ATypedArg p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Args */
    public R visit(fafl.Absyn.Arguments p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(fafl.Absyn.Args p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Arg */
    public R visit(fafl.Absyn.NameArg p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.ExprArg p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(fafl.Absyn.Arg p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Type */
    public R visit(fafl.Absyn.BoolType p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.IntType p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.DoubleType p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.StringType p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.ArrayType p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.StructType p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.StructFieldType p, A arg) { return visitDefault(p, arg); }
    public R visit(fafl.Absyn.FuncType p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(fafl.Absyn.Type p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
