package com;
import com.Absyn.*;
/** BNFC-Generated Abstract Visitor */
public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
/* ProgramExprs */
    public R visit(com.Absyn.Program p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.Absyn.ProgramExprs p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Expr */
    public R visit(com.Absyn.Plus p, A arg) { return visitDefault(p, arg); }
    public R visit(com.Absyn.Minus p, A arg) { return visitDefault(p, arg); }
    public R visit(com.Absyn.Assign p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.Absyn.Expr p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Params */
    public R visit(com.Absyn.ParametersInteger p, A arg) { return visitDefault(p, arg); }
    public R visit(com.Absyn.ParametersFunctions p, A arg) { return visitDefault(p, arg); }
    public R visit(com.Absyn.ParametersIdents p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.Absyn.Params p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Type */
    public R visit(com.Absyn.BoolType p, A arg) { return visitDefault(p, arg); }
    public R visit(com.Absyn.IntType p, A arg) { return visitDefault(p, arg); }
    public R visit(com.Absyn.StringType p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.Absyn.Type p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
