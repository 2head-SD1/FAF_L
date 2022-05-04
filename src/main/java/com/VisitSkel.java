package com;
import com.Absyn.*;
import com.SymbolTable.SymbolTable;

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
    public R visit(com.Absyn.Program p, A arg)
    { /* Code For Program Goes Here */
      ListInteger integers = new ListInteger();
      for (Expr x: p.listexpr_)
      {
        integers.add(x.accept(new ExprVisitor<Integer, Object>(), arg));
      }
      return (R)integers;
    }
  }
  public class ExprVisitor<R,A> implements Expr.Visitor<R,A>
  {
    public R visit(com.Absyn.Plus p, A arg)
    { /* Code For Plus Goes Here */
      Integer result = 0;
      for (Params x: p.listparams_)
      {
        result += x.accept(new ParamsVisitor<Integer, Object>(), arg);
      }
      return (R)result;
    }
    public R visit(com.Absyn.Minus p, A arg)
    { /* Code For Minus Goes Here */
      Integer result = 0;
      for (int i = 0; i < p.listparams_.stream().count(); i++)
      {
        if(i == 0)
        {
          result = p.listparams_.get(i).accept(new ParamsVisitor<Integer, Object>(), arg);
          continue;
        }
        result -= p.listparams_.get(i).accept(new ParamsVisitor<Integer, Object>(), arg);
      }
      return (R)result;
    }
    public R visit(com.Absyn.Assign p, A arg)
    { /* Code For Assign Goes Here */
      //p.ident_;
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      R value = p.expr_.accept(new ExprVisitor<R,A>(), arg);
      SymbolTable.addSymbol(p.ident_, value);
      return null;
    }
  }
  public class ParamsVisitor<R,A> implements Params.Visitor<R,A>
  {
    public R visit(com.Absyn.ParametersInteger p, A arg)
    { /* Code For ParametersInteger Goes Here */
      return (R)p.integer_;
    }
    public R visit(com.Absyn.ParametersFunctions p, A arg)
    { /* Code For ParametersFunctions Goes Here */
      R result = p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return result;
    }
    public R visit(com.Absyn.ParametersIdents p, A arg)
    { /* Code For ParametersIdents Goes Here */
      return (R)SymbolTable.getSymbol(p.ident_);
    }
  }
  public class TypeVisitor<R,A> implements Type.Visitor<R,A>
  {
    public R visit(com.Absyn.BoolType p, A arg)
    { /* Code For BoolType Goes Here */
      return (R)new BoolType();
    }
    public R visit(com.Absyn.IntType p, A arg)
    { /* Code For IntType Goes Here */
      return (R)new IntType();
    }
    public R visit(com.Absyn.StringType p, A arg)
    { /* Code For StringType Goes Here */
      return (R)new StringType();
    }
  }
}