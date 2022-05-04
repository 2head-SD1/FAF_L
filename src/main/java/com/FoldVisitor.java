package com;

import com.Absyn.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/** BNFC-Generated Fold Visitor */
public abstract class FoldVisitor<R,A> implements AllVisitor<R,A> {
    public abstract R leaf(A arg);
    public abstract R combine(R x, R y, A arg);

/* ProgramExprs */
    public R visit(com.Absyn.Program p, A arg) {
      R r = leaf(arg);
      for (Expr x : p.listexpr_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* Expr */
    public R visit(com.Absyn.Plus p, A arg) {
      R r = leaf(arg);
      for (Params x : p.listparams_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }
    public R visit(com.Absyn.Minus p, A arg) {
      R r = leaf(arg);
      for (Params x : p.listparams_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }
    public R visit(com.Absyn.Assign p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }

/* Params */
    public R visit(com.Absyn.ParametersInteger p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.Absyn.ParametersFunctions p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.Absyn.ParametersIdents p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* Type */
    public R visit(com.Absyn.BoolType p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.Absyn.IntType p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.Absyn.StringType p, A arg) {
      R r = leaf(arg);
      return r;
    }


}
