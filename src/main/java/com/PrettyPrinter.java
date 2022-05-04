package com;
import com.Absyn.*;

public class PrettyPrinter
{
  //For certain applications increasing the initial size of the buffer may improve performance.
  private static final int INITIAL_BUFFER_SIZE = 128;
  private static final int INDENT_WIDTH = 2;
  //You may wish to change the parentheses used in precedence.
  private static final String _L_PAREN = new String("(");
  private static final String _R_PAREN = new String(")");
  //You may wish to change render
  private static void render(String s)
  {
    if (s.equals("{"))
    {
       buf_.append("\n");
       indent();
       buf_.append(s);
       _n_ = _n_ + INDENT_WIDTH;
       buf_.append("\n");
       indent();
    }
    else if (s.equals("(") || s.equals("["))
       buf_.append(s);
    else if (s.equals(")") || s.equals("]"))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals("}"))
    {
       int t;
       _n_ = _n_ - INDENT_WIDTH;
       for(t=0; t<INDENT_WIDTH; t++) {
         backup();
       }
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals(","))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals(";"))
    {
       backup();
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals("")) return;
    else
    {
       buf_.append(s);
       buf_.append(" ");
    }
  }


  //  print and show methods are defined for each category.
  public static String print(com.Absyn.ProgramExprs foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.Absyn.ProgramExprs foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.Absyn.ListExpr foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.Absyn.ListExpr foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.Absyn.Expr foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.Absyn.Expr foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.Absyn.Params foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.Absyn.Params foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.Absyn.ListParams foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.Absyn.ListParams foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.Absyn.ListInteger foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.Absyn.ListInteger foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.Absyn.Type foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.Absyn.Type foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  /***   You shouldn't need to change anything beyond this point.   ***/

  private static void pp(com.Absyn.ProgramExprs foo, int _i_)
  {
    if (foo instanceof com.Absyn.Program)
    {
       com.Absyn.Program _program = (com.Absyn.Program) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_program.listexpr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.Absyn.ListExpr foo, int _i_)
  {
     for (java.util.Iterator<Expr> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(";");
       } else {
         render("");
       }
     }  }

  private static void pp(com.Absyn.Expr foo, int _i_)
  {
    if (foo instanceof com.Absyn.Plus)
    {
       com.Absyn.Plus _plus = (com.Absyn.Plus) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("plus");
       render("(");
       pp(_plus.listparams_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.Absyn.Minus)
    {
       com.Absyn.Minus _minus = (com.Absyn.Minus) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("minus");
       render("(");
       pp(_minus.listparams_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.Absyn.Assign)
    {
       com.Absyn.Assign _assign = (com.Absyn.Assign) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("setq");
       render("(");
       pp(_assign.ident_, 0);
       render("->");
       pp(_assign.type_, 0);
       render(")");
       pp(_assign.expr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.Absyn.Params foo, int _i_)
  {
    if (foo instanceof com.Absyn.ParametersInteger)
    {
       com.Absyn.ParametersInteger _parametersinteger = (com.Absyn.ParametersInteger) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_parametersinteger.integer_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.Absyn.ParametersFunctions)
    {
       com.Absyn.ParametersFunctions _parametersfunctions = (com.Absyn.ParametersFunctions) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_parametersfunctions.expr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.Absyn.ParametersIdents)
    {
       com.Absyn.ParametersIdents _parametersidents = (com.Absyn.ParametersIdents) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_parametersidents.ident_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.Absyn.ListParams foo, int _i_)
  {
     for (java.util.Iterator<Params> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }  }

  private static void pp(com.Absyn.ListInteger foo, int _i_)
  {
     for (java.util.Iterator<Integer> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }  }

  private static void pp(com.Absyn.Type foo, int _i_)
  {
    if (foo instanceof com.Absyn.BoolType)
    {
       com.Absyn.BoolType _booltype = (com.Absyn.BoolType) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("Bool");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.Absyn.IntType)
    {
       com.Absyn.IntType _inttype = (com.Absyn.IntType) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("Int");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.Absyn.StringType)
    {
       com.Absyn.StringType _stringtype = (com.Absyn.StringType) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("String");
       if (_i_ > 0) render(_R_PAREN);
    }
  }


  private static void sh(com.Absyn.ProgramExprs foo)
  {
    if (foo instanceof com.Absyn.Program)
    {
       com.Absyn.Program _program = (com.Absyn.Program) foo;
       render("(");
       render("Program");
       render("[");
       sh(_program.listexpr_);
       render("]");
       render(")");
    }
  }

  private static void sh(com.Absyn.ListExpr foo)
  {
     for (java.util.Iterator<Expr> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.Absyn.Expr foo)
  {
    if (foo instanceof com.Absyn.Plus)
    {
       com.Absyn.Plus _plus = (com.Absyn.Plus) foo;
       render("(");
       render("Plus");
       render("[");
       sh(_plus.listparams_);
       render("]");
       render(")");
    }
    if (foo instanceof com.Absyn.Minus)
    {
       com.Absyn.Minus _minus = (com.Absyn.Minus) foo;
       render("(");
       render("Minus");
       render("[");
       sh(_minus.listparams_);
       render("]");
       render(")");
    }
    if (foo instanceof com.Absyn.Assign)
    {
       com.Absyn.Assign _assign = (com.Absyn.Assign) foo;
       render("(");
       render("Assign");
       sh(_assign.ident_);
       sh(_assign.type_);
       sh(_assign.expr_);
       render(")");
    }
  }

  private static void sh(com.Absyn.Params foo)
  {
    if (foo instanceof com.Absyn.ParametersInteger)
    {
       com.Absyn.ParametersInteger _parametersinteger = (com.Absyn.ParametersInteger) foo;
       render("(");
       render("ParametersInteger");
       sh(_parametersinteger.integer_);
       render(")");
    }
    if (foo instanceof com.Absyn.ParametersFunctions)
    {
       com.Absyn.ParametersFunctions _parametersfunctions = (com.Absyn.ParametersFunctions) foo;
       render("(");
       render("ParametersFunctions");
       sh(_parametersfunctions.expr_);
       render(")");
    }
    if (foo instanceof com.Absyn.ParametersIdents)
    {
       com.Absyn.ParametersIdents _parametersidents = (com.Absyn.ParametersIdents) foo;
       render("(");
       render("ParametersIdents");
       sh(_parametersidents.ident_);
       render(")");
    }
  }

  private static void sh(com.Absyn.ListParams foo)
  {
     for (java.util.Iterator<Params> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.Absyn.ListInteger foo)
  {
     for (java.util.Iterator<Integer> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.Absyn.Type foo)
  {
    if (foo instanceof com.Absyn.BoolType)
    {
       com.Absyn.BoolType _booltype = (com.Absyn.BoolType) foo;
       render("BoolType");
    }
    if (foo instanceof com.Absyn.IntType)
    {
       com.Absyn.IntType _inttype = (com.Absyn.IntType) foo;
       render("IntType");
    }
    if (foo instanceof com.Absyn.StringType)
    {
       com.Absyn.StringType _stringtype = (com.Absyn.StringType) foo;
       render("StringType");
    }
  }


  private static void pp(Integer n, int _i_) { buf_.append(n); buf_.append(" "); }
  private static void pp(Double d, int _i_) { buf_.append(d); buf_.append(" "); }
  private static void pp(String s, int _i_) { buf_.append(s); buf_.append(" "); }
  private static void pp(Character c, int _i_) { buf_.append("'" + c.toString() + "'"); buf_.append(" "); }
  private static void sh(Integer n) { render(n.toString()); }
  private static void sh(Double d) { render(d.toString()); }
  private static void sh(Character c) { render(c.toString()); }
  private static void sh(String s) { printQuoted(s); }
  private static void printQuoted(String s) { render("\"" + s + "\""); }
  private static void indent()
  {
    int n = _n_;
    while (n > 0)
    {
      buf_.append(" ");
      n--;
    }
  }
  private static void backup()
  {
     if (buf_.charAt(buf_.length() - 1) == ' ') {
      buf_.setLength(buf_.length() - 1);
    }
  }
  private static void trim()
  {
     while (buf_.length() > 0 && buf_.charAt(0) == ' ')
        buf_.deleteCharAt(0); 
    while (buf_.length() > 0 && buf_.charAt(buf_.length()-1) == ' ')
        buf_.deleteCharAt(buf_.length()-1);
  }
  private static int _n_ = 0;
  private static StringBuilder buf_ = new StringBuilder(INITIAL_BUFFER_SIZE);
}

