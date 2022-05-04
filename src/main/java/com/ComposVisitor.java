package com;
import com.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  com.Absyn.ProgramExprs.Visitor<com.Absyn.ProgramExprs,A>,
  com.Absyn.Expr.Visitor<com.Absyn.Expr,A>,
  com.Absyn.Params.Visitor<com.Absyn.Params,A>,
  com.Absyn.Type.Visitor<com.Absyn.Type,A>
{
/* ProgramExprs */
    public ProgramExprs visit(com.Absyn.Program p, A arg)
    {
      ListExpr listexpr_ = new ListExpr();
      for (Expr x : p.listexpr_)
      {
        listexpr_.add(x.accept(this,arg));
      }
      return new com.Absyn.Program(listexpr_);
    }
/* Expr */
    public Expr visit(com.Absyn.Plus p, A arg)
    {
      ListParams listparams_ = new ListParams();
      for (Params x : p.listparams_)
      {
        listparams_.add(x.accept(this,arg));
      }
      return new com.Absyn.Plus(listparams_);
    }    public Expr visit(com.Absyn.Minus p, A arg)
    {
      ListParams listparams_ = new ListParams();
      for (Params x : p.listparams_)
      {
        listparams_.add(x.accept(this,arg));
      }
      return new com.Absyn.Minus(listparams_);
    }    public Expr visit(com.Absyn.Assign p, A arg)
    {
      String ident_ = p.ident_;
      Type type_ = p.type_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new com.Absyn.Assign(ident_, type_, expr_);
    }
/* Params */
    public Params visit(com.Absyn.ParametersInteger p, A arg)
    {
      Integer integer_ = p.integer_;
      return new com.Absyn.ParametersInteger(integer_);
    }    public Params visit(com.Absyn.ParametersFunctions p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new com.Absyn.ParametersFunctions(expr_);
    }    public Params visit(com.Absyn.ParametersIdents p, A arg)
    {
      String ident_ = p.ident_;
      return new com.Absyn.ParametersIdents(ident_);
    }
/* Type */
    public Type visit(com.Absyn.BoolType p, A arg)
    {
      return new com.Absyn.BoolType();
    }    public Type visit(com.Absyn.IntType p, A arg)
    {
      return new com.Absyn.IntType();
    }    public Type visit(com.Absyn.StringType p, A arg)
    {
      return new com.Absyn.StringType();
    }
}