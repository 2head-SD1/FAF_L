package fafl;
import fafl.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  fafl.Absyn.ProgramExprs.Visitor<fafl.Absyn.ProgramExprs,A>,
  fafl.Absyn.Expr.Visitor<fafl.Absyn.Expr,A>,
  fafl.Absyn.Bool.Visitor<fafl.Absyn.Bool,A>,
  fafl.Absyn.AFuncReturnType.Visitor<fafl.Absyn.AFuncReturnType,A>,
  fafl.Absyn.Pair.Visitor<fafl.Absyn.Pair,A>,
  fafl.Absyn.ATypedArg.Visitor<fafl.Absyn.ATypedArg,A>,
  fafl.Absyn.Args.Visitor<fafl.Absyn.Args,A>,
  fafl.Absyn.Arg.Visitor<fafl.Absyn.Arg,A>,
  fafl.Absyn.Type.Visitor<fafl.Absyn.Type,A>
{
/* ProgramExprs */
    public ProgramExprs visit(fafl.Absyn.Program p, A arg)
    {
      ListExpr listexpr_ = new ListExpr();
      for (Expr x : p.listexpr_)
      {
        listexpr_.add(x.accept(this,arg));
      }
      return new fafl.Absyn.Program(listexpr_);
    }
/* Expr */
    public Expr visit(fafl.Absyn.SetqSimple p, A arg)
    {
      String ident_ = p.ident_;
      Type type_ = p.type_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new fafl.Absyn.SetqSimple(ident_, type_, expr_);
    }    public Expr visit(fafl.Absyn.SetqStruct p, A arg)
    {
      String ident_1 = p.ident_1;
      String ident_2 = p.ident_2;
      Args args_ = p.args_.accept(this, arg);
      return new fafl.Absyn.SetqStruct(ident_1, ident_2, args_);
    }    public Expr visit(fafl.Absyn.IntConst p, A arg)
    {
      Integer integer_ = p.integer_;
      return new fafl.Absyn.IntConst(integer_);
    }    public Expr visit(fafl.Absyn.DoubleConst p, A arg)
    {
      Double double_ = p.double_;
      return new fafl.Absyn.DoubleConst(double_);
    }    public Expr visit(fafl.Absyn.BoolConst p, A arg)
    {
      Bool bool_ = p.bool_.accept(this, arg);
      return new fafl.Absyn.BoolConst(bool_);
    }    public Expr visit(fafl.Absyn.StringConst p, A arg)
    {
      String string_ = p.string_;
      return new fafl.Absyn.StringConst(string_);
    }    public Expr visit(fafl.Absyn.Id p, A arg)
    {
      String ident_ = p.ident_;
      return new fafl.Absyn.Id(ident_);
    }    public Expr visit(fafl.Absyn.FuncCall p, A arg)
    {
      String ident_ = p.ident_;
      ListExpr listexpr_ = new ListExpr();
      for (Expr x : p.listexpr_)
      {
        listexpr_.add(x.accept(this,arg));
      }
      return new fafl.Absyn.FuncCall(ident_, listexpr_);
    }    public Expr visit(fafl.Absyn.Define p, A arg)
    {
      String ident_ = p.ident_;
      ListATypedArg listatypedarg_ = new ListATypedArg();
      for (ATypedArg x : p.listatypedarg_)
      {
        listatypedarg_.add(x.accept(this,arg));
      }
      AFuncReturnType afuncreturntype_ = p.afuncreturntype_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new fafl.Absyn.Define(ident_, listatypedarg_, afuncreturntype_, expr_);
    }    public Expr visit(fafl.Absyn.DefineWithExc p, A arg)
    {
      String ident_ = p.ident_;
      ListATypedArg listatypedarg_ = new ListATypedArg();
      for (ATypedArg x : p.listatypedarg_)
      {
        listatypedarg_.add(x.accept(this,arg));
      }
      AFuncReturnType afuncreturntype_ = p.afuncreturntype_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new fafl.Absyn.DefineWithExc(ident_, listatypedarg_, afuncreturntype_, expr_);
    }    public Expr visit(fafl.Absyn.StructInit p, A arg)
    {
      String ident_ = p.ident_;
      ListATypedArg listatypedarg_ = new ListATypedArg();
      for (ATypedArg x : p.listatypedarg_)
      {
        listatypedarg_.add(x.accept(this,arg));
      }
      return new fafl.Absyn.StructInit(ident_, listatypedarg_);
    }    public Expr visit(fafl.Absyn.StructConstructor p, A arg)
    {
      String ident_ = p.ident_;
      ListExpr listexpr_ = new ListExpr();
      for (Expr x : p.listexpr_)
      {
        listexpr_.add(x.accept(this,arg));
      }
      return new fafl.Absyn.StructConstructor(ident_, listexpr_);
    }    public Expr visit(fafl.Absyn.StructField p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      String ident_ = p.ident_;
      return new fafl.Absyn.StructField(expr_, ident_);
    }    public Expr visit(fafl.Absyn.If p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      Expr expr_3 = p.expr_3.accept(this, arg);
      return new fafl.Absyn.If(expr_1, expr_2, expr_3);
    }    public Expr visit(fafl.Absyn.Lambda p, A arg)
    {
      ListATypedArg listatypedarg_ = new ListATypedArg();
      for (ATypedArg x : p.listatypedarg_)
      {
        listatypedarg_.add(x.accept(this,arg));
      }
      AFuncReturnType afuncreturntype_ = p.afuncreturntype_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new fafl.Absyn.Lambda(listatypedarg_, afuncreturntype_, expr_);
    }    public Expr visit(fafl.Absyn.DictConstructor p, A arg)
    {
      String ident_ = p.ident_;
      Type type_1 = p.type_1.accept(this, arg);
      Type type_2 = p.type_2.accept(this, arg);
      ListPair listpair_ = new ListPair();
      for (Pair x : p.listpair_)
      {
        listpair_.add(x.accept(this,arg));
      }
      return new fafl.Absyn.DictConstructor(ident_, type_1, type_2, listpair_);
    }    public Expr visit(fafl.Absyn.DictSet p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      Pair pair_ = p.pair_.accept(this, arg);
      return new fafl.Absyn.DictSet(expr_, pair_);
    }    public Expr visit(fafl.Absyn.DictGet p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new fafl.Absyn.DictGet(expr_1, expr_2);
    }    public Expr visit(fafl.Absyn.DictRemove p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new fafl.Absyn.DictRemove(expr_1, expr_2);
    }    public Expr visit(fafl.Absyn.DictKeys p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new fafl.Absyn.DictKeys(expr_);
    }    public Expr visit(fafl.Absyn.DictValues p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new fafl.Absyn.DictValues(expr_);
    }    public Expr visit(fafl.Absyn.DictLength p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new fafl.Absyn.DictLength(expr_);
    }    public Expr visit(fafl.Absyn.ArrayConstructor p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      ListExpr listexpr_ = new ListExpr();
      for (Expr x : p.listexpr_)
      {
        listexpr_.add(x.accept(this,arg));
      }
      return new fafl.Absyn.ArrayConstructor(type_, expr_, listexpr_);
    }    public Expr visit(fafl.Absyn.First p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new fafl.Absyn.First(expr_);
    }    public Expr visit(fafl.Absyn.Last p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new fafl.Absyn.Last(expr_);
    }    public Expr visit(fafl.Absyn.ArrayGet p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new fafl.Absyn.ArrayGet(expr_1, expr_2);
    }    public Expr visit(fafl.Absyn.ArraySet p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      Expr expr_3 = p.expr_3.accept(this, arg);
      return new fafl.Absyn.ArraySet(expr_1, expr_2, expr_3);
    }    public Expr visit(fafl.Absyn.ArrayLength p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new fafl.Absyn.ArrayLength(expr_);
    }    public Expr visit(fafl.Absyn.TupleConstructor p, A arg)
    {
      ListExpr listexpr_ = new ListExpr();
      for (Expr x : p.listexpr_)
      {
        listexpr_.add(x.accept(this,arg));
      }
      return new fafl.Absyn.TupleConstructor(listexpr_);
    }    public Expr visit(fafl.Absyn.TupleGet p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new fafl.Absyn.TupleGet(expr_1, expr_2);
    }    public Expr visit(fafl.Absyn.TupleLength p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new fafl.Absyn.TupleLength(expr_);
    }    public Expr visit(fafl.Absyn.RaiseEx p, A arg)
    {
      String string_ = p.string_;
      return new fafl.Absyn.RaiseEx(string_);
    }    public Expr visit(fafl.Absyn.TryCatch p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new fafl.Absyn.TryCatch(expr_1, expr_2);
    }    public Expr visit(fafl.Absyn.Plus p, A arg)
    {
      ListExpr listexpr_ = new ListExpr();
      for (Expr x : p.listexpr_)
      {
        listexpr_.add(x.accept(this,arg));
      }
      return new fafl.Absyn.Plus(listexpr_);
    }    public Expr visit(fafl.Absyn.Minus p, A arg)
    {
      ListExpr listexpr_ = new ListExpr();
      for (Expr x : p.listexpr_)
      {
        listexpr_.add(x.accept(this,arg));
      }
      return new fafl.Absyn.Minus(listexpr_);
    }    public Expr visit(fafl.Absyn.Mul p, A arg)
    {
      ListExpr listexpr_ = new ListExpr();
      for (Expr x : p.listexpr_)
      {
        listexpr_.add(x.accept(this,arg));
      }
      return new fafl.Absyn.Mul(listexpr_);
    }    public Expr visit(fafl.Absyn.Div p, A arg)
    {
      ListExpr listexpr_ = new ListExpr();
      for (Expr x : p.listexpr_)
      {
        listexpr_.add(x.accept(this,arg));
      }
      return new fafl.Absyn.Div(listexpr_);
    }    public Expr visit(fafl.Absyn.ToDouble p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new fafl.Absyn.ToDouble(expr_);
    }    public Expr visit(fafl.Absyn.Equals p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new fafl.Absyn.Equals(expr_1, expr_2);
    }    public Expr visit(fafl.Absyn.IsLess p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new fafl.Absyn.IsLess(expr_1, expr_2);
    }    public Expr visit(fafl.Absyn.IsGreater p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new fafl.Absyn.IsGreater(expr_1, expr_2);
    }    public Expr visit(fafl.Absyn.And p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new fafl.Absyn.And(expr_1, expr_2);
    }    public Expr visit(fafl.Absyn.Or p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new fafl.Absyn.Or(expr_1, expr_2);
    }    public Expr visit(fafl.Absyn.ReadLine p, A arg)
    {
      return new fafl.Absyn.ReadLine();
    }    public Expr visit(fafl.Absyn.PrintLine p, A arg)
    {
      String string_ = p.string_;
      return new fafl.Absyn.PrintLine(string_);
    }
/* Bool */
    public Bool visit(fafl.Absyn.BoolTrue p, A arg)
    {
      return new fafl.Absyn.BoolTrue();
    }    public Bool visit(fafl.Absyn.BoolFalse p, A arg)
    {
      return new fafl.Absyn.BoolFalse();
    }
/* AFuncReturnType */
    public AFuncReturnType visit(fafl.Absyn.FuncReturnType p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      return new fafl.Absyn.FuncReturnType(type_);
    }
/* Pair */
    public Pair visit(fafl.Absyn.DictPair p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new fafl.Absyn.DictPair(expr_1, expr_2);
    }
/* ATypedArg */
    public ATypedArg visit(fafl.Absyn.TypedArg p, A arg)
    {
      String ident_ = p.ident_;
      Type type_ = p.type_.accept(this, arg);
      return new fafl.Absyn.TypedArg(ident_, type_);
    }
/* Args */
    public Args visit(fafl.Absyn.Arguments p, A arg)
    {
      ListArg listarg_ = new ListArg();
      for (Arg x : p.listarg_)
      {
        listarg_.add(x.accept(this,arg));
      }
      return new fafl.Absyn.Arguments(listarg_);
    }
/* Arg */
    public Arg visit(fafl.Absyn.NameArg p, A arg)
    {
      String ident_ = p.ident_;
      return new fafl.Absyn.NameArg(ident_);
    }    public Arg visit(fafl.Absyn.ExprArg p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new fafl.Absyn.ExprArg(expr_);
    }
/* Type */
    public Type visit(fafl.Absyn.ExceptionType p, A arg)
    {
      return new fafl.Absyn.ExceptionType();
    }    public Type visit(fafl.Absyn.TupleType p, A arg)
    {
      return new fafl.Absyn.TupleType();
    }    public Type visit(fafl.Absyn.BoolType p, A arg)
    {
      return new fafl.Absyn.BoolType();
    }    public Type visit(fafl.Absyn.IntType p, A arg)
    {
      return new fafl.Absyn.IntType();
    }    public Type visit(fafl.Absyn.DoubleType p, A arg)
    {
      return new fafl.Absyn.DoubleType();
    }    public Type visit(fafl.Absyn.StringType p, A arg)
    {
      return new fafl.Absyn.StringType();
    }    public Type visit(fafl.Absyn.ArrayType p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      return new fafl.Absyn.ArrayType(type_);
    }    public Type visit(fafl.Absyn.StructType p, A arg)
    {
      String ident_ = p.ident_;
      return new fafl.Absyn.StructType(ident_);
    }    public Type visit(fafl.Absyn.DictType p, A arg)
    {
      Type type_1 = p.type_1.accept(this, arg);
      Type type_2 = p.type_2.accept(this, arg);
      return new fafl.Absyn.DictType(type_1, type_2);
    }    public Type visit(fafl.Absyn.StructFieldType p, A arg)
    {
      Type type_ = p.type_.accept(this, arg);
      return new fafl.Absyn.StructFieldType(type_);
    }    public Type visit(fafl.Absyn.FuncType p, A arg)
    {
      Type type_1 = p.type_1.accept(this, arg);
      Type type_2 = p.type_2.accept(this, arg);
      return new fafl.Absyn.FuncType(type_1, type_2);
    }
}