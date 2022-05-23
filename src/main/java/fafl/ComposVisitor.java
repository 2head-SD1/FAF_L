package fafl;
import fafl.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  fafl.Absyn.ProgramExprs.Visitor<fafl.Absyn.ProgramExprs,A>,
  fafl.Absyn.Expr.Visitor<fafl.Absyn.Expr,A>,
  fafl.Absyn.Bool.Visitor<fafl.Absyn.Bool,A>,
  fafl.Absyn.AFuncReturnType.Visitor<fafl.Absyn.AFuncReturnType,A>,
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
      Args args_ = p.args_.accept(this, arg);
      return new fafl.Absyn.StructConstructor(ident_, args_);
    }    public Expr visit(fafl.Absyn.StructField p, A arg)
    {
      String ident_1 = p.ident_1;
      String ident_2 = p.ident_2;
      return new fafl.Absyn.StructField(ident_1, ident_2);
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
      String ident_ = p.ident_;
      return new fafl.Absyn.First(ident_);
    }    public Expr visit(fafl.Absyn.Get p, A arg)
    {
      String ident_ = p.ident_;
      Expr expr_ = p.expr_.accept(this, arg);
      return new fafl.Absyn.Get(ident_, expr_);
    }    public Expr visit(fafl.Absyn.Length p, A arg)
    {
      String ident_ = p.ident_;
      return new fafl.Absyn.Length(ident_);
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
    public Type visit(fafl.Absyn.BoolType p, A arg)
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