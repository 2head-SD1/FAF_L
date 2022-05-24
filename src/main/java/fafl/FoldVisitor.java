package fafl;

import fafl.Absyn.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/** BNFC-Generated Fold Visitor */
public abstract class FoldVisitor<R,A> implements AllVisitor<R,A> {
    public abstract R leaf(A arg);
    public abstract R combine(R x, R y, A arg);

/* ProgramExprs */
    public R visit(fafl.Absyn.Program p, A arg) {
      R r = leaf(arg);
      for (Expr x : p.listexpr_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* Expr */
    public R visit(fafl.Absyn.SetqSimple p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.SetqStruct p, A arg) {
      R r = leaf(arg);
      r = combine(p.args_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.IntConst p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(fafl.Absyn.DoubleConst p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(fafl.Absyn.BoolConst p, A arg) {
      R r = leaf(arg);
      r = combine(p.bool_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.StringConst p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(fafl.Absyn.Id p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(fafl.Absyn.Define p, A arg) {
      R r = leaf(arg);
      for (ATypedArg x : p.listatypedarg_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      r = combine(p.afuncreturntype_.accept(this, arg), r, arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.StructInit p, A arg) {
      R r = leaf(arg);
      for (ATypedArg x : p.listatypedarg_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }
    public R visit(fafl.Absyn.StructConstructor p, A arg) {
      R r = leaf(arg);
      for (Expr x : p.listexpr_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }
    public R visit(fafl.Absyn.StructField p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.If p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      r = combine(p.expr_3.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.Lambda p, A arg) {
      R r = leaf(arg);
      for (ATypedArg x : p.listatypedarg_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      r = combine(p.afuncreturntype_.accept(this, arg), r, arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.DictConstructor p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_1.accept(this, arg), r, arg);
      r = combine(p.type_2.accept(this, arg), r, arg);
      for (Pair x : p.listpair_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }
    public R visit(fafl.Absyn.DictSet p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      r = combine(p.pair_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.DictGet p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.DictRemove p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.DictKeys p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.DictValues p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.DictLength p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.ArrayConstructor p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      for (Expr x : p.listexpr_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }
    public R visit(fafl.Absyn.First p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.Last p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.ArrayGet p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.ArraySet p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      r = combine(p.expr_3.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.ArrayLength p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.RaiseEx p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(fafl.Absyn.TryCatch p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.Plus p, A arg) {
      R r = leaf(arg);
      for (Expr x : p.listexpr_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }
    public R visit(fafl.Absyn.Minus p, A arg) {
      R r = leaf(arg);
      for (Expr x : p.listexpr_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }
    public R visit(fafl.Absyn.Mul p, A arg) {
      R r = leaf(arg);
      for (Expr x : p.listexpr_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }
    public R visit(fafl.Absyn.Div p, A arg) {
      R r = leaf(arg);
      for (Expr x : p.listexpr_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }
    public R visit(fafl.Absyn.Equals p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.IsLess p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.IsGreater p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.And p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.Or p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.ReadLine p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(fafl.Absyn.PrintLine p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* Bool */
    public R visit(fafl.Absyn.BoolTrue p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(fafl.Absyn.BoolFalse p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* AFuncReturnType */
    public R visit(fafl.Absyn.FuncReturnType p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      return r;
    }

/* Pair */
    public R visit(fafl.Absyn.DictPair p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }

/* ATypedArg */
    public R visit(fafl.Absyn.TypedArg p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      return r;
    }

/* Args */
    public R visit(fafl.Absyn.Arguments p, A arg) {
      R r = leaf(arg);
      for (Arg x : p.listarg_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* Arg */
    public R visit(fafl.Absyn.NameArg p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(fafl.Absyn.ExprArg p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }

/* Type */
    public R visit(fafl.Absyn.BoolType p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(fafl.Absyn.IntType p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(fafl.Absyn.DoubleType p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(fafl.Absyn.StringType p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(fafl.Absyn.ArrayType p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.StructType p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(fafl.Absyn.DictType p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_1.accept(this, arg), r, arg);
      r = combine(p.type_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.StructFieldType p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(fafl.Absyn.FuncType p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_1.accept(this, arg), r, arg);
      r = combine(p.type_2.accept(this, arg), r, arg);
      return r;
    }


}
