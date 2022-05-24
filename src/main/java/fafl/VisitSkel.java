package fafl;
import fafl.Absyn.*;
/*** BNFC-Generated Visitor Design Pattern Skeleton. ***/
/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use. 
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitSkel
{
  public class ProgramExprsVisitor<R,A> implements ProgramExprs.Visitor<R,A>
  {
    public R visit(fafl.Absyn.Program p, A arg)
    { /* Code For Program Goes Here */
      for (Expr x: p.listexpr_)
      { /* ... */ }
      return null;
    }
  }
  public class ExprVisitor<R,A> implements Expr.Visitor<R,A>
  {
    public R visit(fafl.Absyn.SetqSimple p, A arg)
    { /* Code For SetqSimple Goes Here */
      //p.ident_;
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.SetqStruct p, A arg)
    { /* Code For SetqStruct Goes Here */
      //p.ident_1;
      //p.ident_2;
      p.args_.accept(new ArgsVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.IntConst p, A arg)
    { /* Code For IntConst Goes Here */
      //p.integer_;
      return null;
    }    public R visit(fafl.Absyn.DoubleConst p, A arg)
    { /* Code For DoubleConst Goes Here */
      //p.double_;
      return null;
    }    public R visit(fafl.Absyn.BoolConst p, A arg)
    { /* Code For BoolConst Goes Here */
      p.bool_.accept(new BoolVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.StringConst p, A arg)
    { /* Code For StringConst Goes Here */
      //p.string_;
      return null;
    }    public R visit(fafl.Absyn.Id p, A arg)
    { /* Code For Id Goes Here */
      //p.ident_;
      return null;
    }    public R visit(fafl.Absyn.Define p, A arg)
    { /* Code For Define Goes Here */
      //p.ident_;
      for (ATypedArg x: p.listatypedarg_)
      { /* ... */ }
      p.afuncreturntype_.accept(new AFuncReturnTypeVisitor<R,A>(), arg);
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }        public R visit(fafl.Absyn.StructInit p, A arg)
    { /* Code For StructInit Goes Here */
      //p.ident_;
      for (ATypedArg x: p.listatypedarg_)
      { /* ... */ }
      return null;
    }    public R visit(fafl.Absyn.StructConstructor p, A arg)
    { /* Code For StructConstructor Goes Here */
      //p.ident_;
      p.args_.accept(new ArgsVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.StructField p, A arg)
    { /* Code For StructField Goes Here */
      //p.ident_1;
      //p.ident_2;
      return null;
    }    public R visit(fafl.Absyn.If p, A arg)
    { /* Code For If Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      p.expr_3.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.Lambda p, A arg)
    { /* Code For Lambda Goes Here */
      for (ATypedArg x: p.listatypedarg_)
      { /* ... */ }
      p.afuncreturntype_.accept(new AFuncReturnTypeVisitor<R,A>(), arg);
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.DictConstructor p, A arg)
    { /* Code For DictConstructor Goes Here */
      //p.ident_;
      p.type_1.accept(new TypeVisitor<R,A>(), arg);
      p.type_2.accept(new TypeVisitor<R,A>(), arg);
      for (Pair x: p.listpair_)
      { /* ... */ }
      return null;
    }    public R visit(fafl.Absyn.DictSet p, A arg)
    { /* Code For DictSet Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      p.pair_.accept(new PairVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.DictGet p, A arg)
    { /* Code For DictGet Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.DictRemove p, A arg)
    { /* Code For DictRemove Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.DictKeys p, A arg)
    { /* Code For DictKeys Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.DictValues p, A arg)
    { /* Code For DictValues Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.DictLength p, A arg)
    { /* Code For DictLength Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.ArrayConstructor p, A arg)
    { /* Code For ArrayConstructor Goes Here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      for (Expr x: p.listexpr_)
      { /* ... */ }
      return null;
    }    public R visit(fafl.Absyn.First p, A arg)
    { /* Code For First Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.Last p, A arg)
    { /* Code For Last Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.ArrayGet p, A arg)
    { /* Code For ArrayGet Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.ArraySet p, A arg)
    { /* Code For ArraySet Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      p.expr_3.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.ArrayLength p, A arg)
    { /* Code For ArrayLength Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.RaiseEx p, A arg)
    { /* Code For RaiseEx Goes Here */
      //p.string_;
      return null;
    }    public R visit(fafl.Absyn.TryCatch p, A arg)
    { /* Code For TryCatch Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.Plus p, A arg)
    { /* Code For Plus Goes Here */
      for (Expr x: p.listexpr_)
      { /* ... */ }
      return null;
    }    public R visit(fafl.Absyn.Minus p, A arg)
    { /* Code For Minus Goes Here */
      for (Expr x: p.listexpr_)
      { /* ... */ }
      return null;
    }    public R visit(fafl.Absyn.Mul p, A arg)
    { /* Code For Mul Goes Here */
      for (Expr x: p.listexpr_)
      { /* ... */ }
      return null;
    }    public R visit(fafl.Absyn.Div p, A arg)
    { /* Code For Div Goes Here */
      for (Expr x: p.listexpr_)
      { /* ... */ }
      return null;
    }    public R visit(fafl.Absyn.Equals p, A arg)
    { /* Code For Equals Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.IsLess p, A arg)
    { /* Code For IsLess Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.IsGreater p, A arg)
    { /* Code For IsGreater Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.And p, A arg)
    { /* Code For And Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.Or p, A arg)
    { /* Code For Or Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.ReadLine p, A arg)
    { /* Code For ReadLine Goes Here */
      return null;
    }    public R visit(fafl.Absyn.PrintLine p, A arg)
    { /* Code For PrintLine Goes Here */
      //p.string_;
      return null;
    }
  }
  public class BoolVisitor<R,A> implements Bool.Visitor<R,A>
  {
    public R visit(fafl.Absyn.BoolTrue p, A arg)
    { /* Code For BoolTrue Goes Here */
      return null;
    }    public R visit(fafl.Absyn.BoolFalse p, A arg)
    { /* Code For BoolFalse Goes Here */
      return null;
    }
  }
  public class AFuncReturnTypeVisitor<R,A> implements AFuncReturnType.Visitor<R,A>
  {
    public R visit(fafl.Absyn.FuncReturnType p, A arg)
    { /* Code For FuncReturnType Goes Here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }
  }
  public class PairVisitor<R,A> implements Pair.Visitor<R,A>
  {
    public R visit(fafl.Absyn.DictPair p, A arg)
    { /* Code For DictPair Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
  }
  public class ATypedArgVisitor<R,A> implements ATypedArg.Visitor<R,A>
  {
    public R visit(fafl.Absyn.TypedArg p, A arg)
    { /* Code For TypedArg Goes Here */
      //p.ident_;
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }
  }
  public class ArgsVisitor<R,A> implements Args.Visitor<R,A>
  {
    public R visit(fafl.Absyn.Arguments p, A arg)
    { /* Code For Arguments Goes Here */
      for (Arg x: p.listarg_)
      { /* ... */ }
      return null;
    }
  }
  public class ArgVisitor<R,A> implements Arg.Visitor<R,A>
  {
    public R visit(fafl.Absyn.NameArg p, A arg)
    { /* Code For NameArg Goes Here */
      //p.ident_;
      return null;
    }    public R visit(fafl.Absyn.ExprArg p, A arg)
    { /* Code For ExprArg Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
  }
  public class TypeVisitor<R,A> implements Type.Visitor<R,A>
  {
    public R visit(fafl.Absyn.BoolType p, A arg)
    { /* Code For BoolType Goes Here */
      return null;
    }    public R visit(fafl.Absyn.IntType p, A arg)
    { /* Code For IntType Goes Here */
      return null;
    }    public R visit(fafl.Absyn.DoubleType p, A arg)
    { /* Code For DoubleType Goes Here */
      return null;
    }    public R visit(fafl.Absyn.StringType p, A arg)
    { /* Code For StringType Goes Here */
      return null;
    }    public R visit(fafl.Absyn.ArrayType p, A arg)
    { /* Code For ArrayType Goes Here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.StructType p, A arg)
    { /* Code For StructType Goes Here */
      //p.ident_;
      return null;
    }    public R visit(fafl.Absyn.DictType p, A arg)
    { /* Code For DictType Goes Here */
      p.type_1.accept(new TypeVisitor<R,A>(), arg);
      p.type_2.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }        public R visit(fafl.Absyn.StructFieldType p, A arg)
    { /* Code For StructFieldType Goes Here */
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }    public R visit(fafl.Absyn.FuncType p, A arg)
    { /* Code For FuncType Goes Here */
      p.type_1.accept(new TypeVisitor<R,A>(), arg);
      p.type_2.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }    
  }
}