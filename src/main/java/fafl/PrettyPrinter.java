package fafl;
import fafl.Absyn.*;

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
  public static String print(fafl.Absyn.ProgramExprs foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(fafl.Absyn.ProgramExprs foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(fafl.Absyn.ListExpr foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(fafl.Absyn.ListExpr foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(fafl.Absyn.Expr foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(fafl.Absyn.Expr foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(fafl.Absyn.Bool foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(fafl.Absyn.Bool foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(fafl.Absyn.ListATypedArg foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(fafl.Absyn.ListATypedArg foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(fafl.Absyn.AFuncReturnType foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(fafl.Absyn.AFuncReturnType foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(fafl.Absyn.Pair foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(fafl.Absyn.Pair foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(fafl.Absyn.ListPair foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(fafl.Absyn.ListPair foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(fafl.Absyn.ATypedArg foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(fafl.Absyn.ATypedArg foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(fafl.Absyn.Args foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(fafl.Absyn.Args foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(fafl.Absyn.ListArg foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(fafl.Absyn.ListArg foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(fafl.Absyn.Arg foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(fafl.Absyn.Arg foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(fafl.Absyn.Type foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(fafl.Absyn.Type foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  /***   You shouldn't need to change anything beyond this point.   ***/

  private static void pp(fafl.Absyn.ProgramExprs foo, int _i_)
  {
    if (foo instanceof fafl.Absyn.Program)
    {
       fafl.Absyn.Program _program = (fafl.Absyn.Program) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_program.listexpr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(fafl.Absyn.ListExpr foo, int _i_)
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

  private static void pp(fafl.Absyn.Expr foo, int _i_)
  {
    if (foo instanceof fafl.Absyn.SetqSimple)
    {
       fafl.Absyn.SetqSimple _setqsimple = (fafl.Absyn.SetqSimple) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("setq");
       pp(_setqsimple.ident_, 0);
       render(":");
       pp(_setqsimple.type_, 0);
       pp(_setqsimple.expr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.SetqStruct)
    {
       fafl.Absyn.SetqStruct _setqstruct = (fafl.Absyn.SetqStruct) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("setq");
       pp(_setqstruct.ident_1, 0);
       render(":");
       pp(_setqstruct.ident_2, 0);
       pp(_setqstruct.args_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.IntConst)
    {
       fafl.Absyn.IntConst _intconst = (fafl.Absyn.IntConst) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_intconst.integer_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.DoubleConst)
    {
       fafl.Absyn.DoubleConst _doubleconst = (fafl.Absyn.DoubleConst) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_doubleconst.double_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.BoolConst)
    {
       fafl.Absyn.BoolConst _boolconst = (fafl.Absyn.BoolConst) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_boolconst.bool_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.StringConst)
    {
       fafl.Absyn.StringConst _stringconst = (fafl.Absyn.StringConst) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_stringconst.string_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.Id)
    {
       fafl.Absyn.Id _id = (fafl.Absyn.Id) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_id.ident_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.FuncCall)
    {
       fafl.Absyn.FuncCall _funccall = (fafl.Absyn.FuncCall) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("call");
       pp(_funccall.ident_, 0);
       render("(");
       pp(_funccall.listexpr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.Define)
    {
       fafl.Absyn.Define _define = (fafl.Absyn.Define) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("define");
       pp(_define.ident_, 0);
       render("(");
       pp(_define.listatypedarg_, 0);
       render(")");
       render("->");
       pp(_define.afuncreturntype_, 0);
       render("{");
       pp(_define.expr_, 0);
       render("}");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.StructInit)
    {
       fafl.Absyn.StructInit _structinit = (fafl.Absyn.StructInit) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("struct");
       pp(_structinit.ident_, 0);
       render("(");
       pp(_structinit.listatypedarg_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.StructConstructor)
    {
       fafl.Absyn.StructConstructor _structconstructor = (fafl.Absyn.StructConstructor) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_structconstructor.ident_, 0);
       render("(");
       pp(_structconstructor.listexpr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.StructField)
    {
       fafl.Absyn.StructField _structfield = (fafl.Absyn.StructField) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_structfield.expr_, 0);
       render(".");
       pp(_structfield.ident_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.If)
    {
       fafl.Absyn.If _if = (fafl.Absyn.If) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("if");
       pp(_if.expr_1, 0);
       render("then");
       pp(_if.expr_2, 0);
       render("else");
       pp(_if.expr_3, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.Lambda)
    {
       fafl.Absyn.Lambda _lambda = (fafl.Absyn.Lambda) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("lambda");
       render("(");
       pp(_lambda.listatypedarg_, 0);
       render(")");
       render("->");
       pp(_lambda.afuncreturntype_, 0);
       render("{");
       pp(_lambda.expr_, 0);
       render("}");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.DictConstructor)
    {
       fafl.Absyn.DictConstructor _dictconstructor = (fafl.Absyn.DictConstructor) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("dict");
       pp(_dictconstructor.ident_, 0);
       render("<");
       pp(_dictconstructor.type_1, 0);
       render(",");
       pp(_dictconstructor.type_2, 0);
       render(">");
       render("(");
       pp(_dictconstructor.listpair_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.DictSet)
    {
       fafl.Absyn.DictSet _dictset = (fafl.Absyn.DictSet) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("dict-set");
       render("(");
       pp(_dictset.expr_, 0);
       render(",");
       pp(_dictset.pair_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.DictGet)
    {
       fafl.Absyn.DictGet _dictget = (fafl.Absyn.DictGet) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("dict-get");
       render("(");
       pp(_dictget.expr_1, 0);
       render(",");
       pp(_dictget.expr_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.DictRemove)
    {
       fafl.Absyn.DictRemove _dictremove = (fafl.Absyn.DictRemove) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("dict-remove");
       render("(");
       pp(_dictremove.expr_1, 0);
       render(",");
       pp(_dictremove.expr_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.DictKeys)
    {
       fafl.Absyn.DictKeys _dictkeys = (fafl.Absyn.DictKeys) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("dict-keys");
       render("(");
       pp(_dictkeys.expr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.DictValues)
    {
       fafl.Absyn.DictValues _dictvalues = (fafl.Absyn.DictValues) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("dict-values");
       render("(");
       pp(_dictvalues.expr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.DictLength)
    {
       fafl.Absyn.DictLength _dictlength = (fafl.Absyn.DictLength) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("dict-length");
       render("(");
       pp(_dictlength.expr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.ArrayConstructor)
    {
       fafl.Absyn.ArrayConstructor _arrayconstructor = (fafl.Absyn.ArrayConstructor) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_arrayconstructor.type_, 0);
       render("[");
       pp(_arrayconstructor.expr_, 0);
       render("]");
       render("{");
       pp(_arrayconstructor.listexpr_, 0);
       render("}");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.First)
    {
       fafl.Absyn.First _first = (fafl.Absyn.First) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("first");
       render("(");
       pp(_first.expr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.Last)
    {
       fafl.Absyn.Last _last = (fafl.Absyn.Last) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("last");
       render("(");
       pp(_last.expr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.ArrayGet)
    {
       fafl.Absyn.ArrayGet _arrayget = (fafl.Absyn.ArrayGet) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("array-get");
       render("(");
       pp(_arrayget.expr_1, 0);
       render(",");
       pp(_arrayget.expr_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.ArraySet)
    {
       fafl.Absyn.ArraySet _arrayset = (fafl.Absyn.ArraySet) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("array-set");
       render("(");
       pp(_arrayset.expr_1, 0);
       render(",");
       pp(_arrayset.expr_2, 0);
       render(",");
       pp(_arrayset.expr_3, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.ArrayLength)
    {
       fafl.Absyn.ArrayLength _arraylength = (fafl.Absyn.ArrayLength) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("array-length");
       render("(");
       pp(_arraylength.expr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.TupleConstructor)
    {
       fafl.Absyn.TupleConstructor _tupleconstructor = (fafl.Absyn.TupleConstructor) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("(");
       pp(_tupleconstructor.listexpr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.TupleGet)
    {
       fafl.Absyn.TupleGet _tupleget = (fafl.Absyn.TupleGet) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("tuple-get");
       render("(");
       pp(_tupleget.expr_1, 0);
       render(",");
       pp(_tupleget.expr_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.TupleLength)
    {
       fafl.Absyn.TupleLength _tuplelength = (fafl.Absyn.TupleLength) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("tuple-length");
       render("(");
       pp(_tuplelength.expr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.RaiseEx)
    {
       fafl.Absyn.RaiseEx _raiseex = (fafl.Absyn.RaiseEx) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("raise");
       render("Exception");
       render("(");
       pp(_raiseex.string_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.TryCatch)
    {
       fafl.Absyn.TryCatch _trycatch = (fafl.Absyn.TryCatch) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("try");
       pp(_trycatch.expr_1, 0);
       render("catch");
       render("(");
       pp(_trycatch.expr_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.Plus)
    {
       fafl.Absyn.Plus _plus = (fafl.Absyn.Plus) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("plus");
       render("(");
       pp(_plus.listexpr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.Minus)
    {
       fafl.Absyn.Minus _minus = (fafl.Absyn.Minus) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("minus");
       render("(");
       pp(_minus.listexpr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.Mul)
    {
       fafl.Absyn.Mul _mul = (fafl.Absyn.Mul) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("mul");
       render("(");
       pp(_mul.listexpr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.Div)
    {
       fafl.Absyn.Div _div = (fafl.Absyn.Div) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("div");
       render("(");
       pp(_div.listexpr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.Equals)
    {
       fafl.Absyn.Equals _equals = (fafl.Absyn.Equals) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("equals");
       render("(");
       pp(_equals.expr_1, 0);
       render(",");
       pp(_equals.expr_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.IsLess)
    {
       fafl.Absyn.IsLess _isless = (fafl.Absyn.IsLess) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("isless");
       render("(");
       pp(_isless.expr_1, 0);
       render(",");
       pp(_isless.expr_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.IsGreater)
    {
       fafl.Absyn.IsGreater _isgreater = (fafl.Absyn.IsGreater) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("isgreater");
       render("(");
       pp(_isgreater.expr_1, 0);
       render(",");
       pp(_isgreater.expr_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.And)
    {
       fafl.Absyn.And _and = (fafl.Absyn.And) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("and");
       render("(");
       pp(_and.expr_1, 0);
       render(",");
       pp(_and.expr_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.Or)
    {
       fafl.Absyn.Or _or = (fafl.Absyn.Or) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("or");
       render("(");
       pp(_or.expr_1, 0);
       render(",");
       pp(_or.expr_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.ReadLine)
    {
       fafl.Absyn.ReadLine _readline = (fafl.Absyn.ReadLine) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("readline");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.PrintLine)
    {
       fafl.Absyn.PrintLine _printline = (fafl.Absyn.PrintLine) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("printline");
       pp(_printline.string_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(fafl.Absyn.Bool foo, int _i_)
  {
    if (foo instanceof fafl.Absyn.BoolTrue)
    {
       fafl.Absyn.BoolTrue _booltrue = (fafl.Absyn.BoolTrue) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("true");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.BoolFalse)
    {
       fafl.Absyn.BoolFalse _boolfalse = (fafl.Absyn.BoolFalse) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("false");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(fafl.Absyn.ListATypedArg foo, int _i_)
  {
     for (java.util.Iterator<ATypedArg> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }  }

  private static void pp(fafl.Absyn.AFuncReturnType foo, int _i_)
  {
    if (foo instanceof fafl.Absyn.FuncReturnType)
    {
       fafl.Absyn.FuncReturnType _funcreturntype = (fafl.Absyn.FuncReturnType) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_funcreturntype.type_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(fafl.Absyn.Pair foo, int _i_)
  {
    if (foo instanceof fafl.Absyn.DictPair)
    {
       fafl.Absyn.DictPair _dictpair = (fafl.Absyn.DictPair) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("(");
       pp(_dictpair.expr_1, 0);
       render(".");
       pp(_dictpair.expr_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(fafl.Absyn.ListPair foo, int _i_)
  {
     for (java.util.Iterator<Pair> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }  }

  private static void pp(fafl.Absyn.ATypedArg foo, int _i_)
  {
    if (foo instanceof fafl.Absyn.TypedArg)
    {
       fafl.Absyn.TypedArg _typedarg = (fafl.Absyn.TypedArg) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_typedarg.ident_, 0);
       render(":");
       pp(_typedarg.type_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(fafl.Absyn.Args foo, int _i_)
  {
    if (foo instanceof fafl.Absyn.Arguments)
    {
       fafl.Absyn.Arguments _arguments = (fafl.Absyn.Arguments) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_arguments.listarg_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(fafl.Absyn.ListArg foo, int _i_)
  {
     for (java.util.Iterator<Arg> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }  }

  private static void pp(fafl.Absyn.Arg foo, int _i_)
  {
    if (foo instanceof fafl.Absyn.NameArg)
    {
       fafl.Absyn.NameArg _namearg = (fafl.Absyn.NameArg) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_namearg.ident_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.ExprArg)
    {
       fafl.Absyn.ExprArg _exprarg = (fafl.Absyn.ExprArg) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_exprarg.expr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(fafl.Absyn.Type foo, int _i_)
  {
    if (foo instanceof fafl.Absyn.TupleType)
    {
       fafl.Absyn.TupleType _tupletype = (fafl.Absyn.TupleType) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("Tuple");
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.BoolType)
    {
       fafl.Absyn.BoolType _booltype = (fafl.Absyn.BoolType) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("Bool");
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.IntType)
    {
       fafl.Absyn.IntType _inttype = (fafl.Absyn.IntType) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("Int");
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.DoubleType)
    {
       fafl.Absyn.DoubleType _doubletype = (fafl.Absyn.DoubleType) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("Double");
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.StringType)
    {
       fafl.Absyn.StringType _stringtype = (fafl.Absyn.StringType) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("String");
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.ArrayType)
    {
       fafl.Absyn.ArrayType _arraytype = (fafl.Absyn.ArrayType) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("[");
       pp(_arraytype.type_, 0);
       render("]");
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.StructType)
    {
       fafl.Absyn.StructType _structtype = (fafl.Absyn.StructType) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("<");
       pp(_structtype.ident_, 0);
       render(">");
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.DictType)
    {
       fafl.Absyn.DictType _dicttype = (fafl.Absyn.DictType) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("<");
       pp(_dicttype.type_1, 0);
       render(",");
       pp(_dicttype.type_2, 0);
       render(">");
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.StructFieldType)
    {
       fafl.Absyn.StructFieldType _structfieldtype = (fafl.Absyn.StructFieldType) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("{");
       pp(_structfieldtype.type_, 0);
       render("}");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof fafl.Absyn.FuncType)
    {
       fafl.Absyn.FuncType _functype = (fafl.Absyn.FuncType) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_functype.type_1, 1);
       render("->");
       pp(_functype.type_2, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }


  private static void sh(fafl.Absyn.ProgramExprs foo)
  {
    if (foo instanceof fafl.Absyn.Program)
    {
       fafl.Absyn.Program _program = (fafl.Absyn.Program) foo;
       render("(");
       render("Program");
       render("[");
       sh(_program.listexpr_);
       render("]");
       render(")");
    }
  }

  private static void sh(fafl.Absyn.ListExpr foo)
  {
     for (java.util.Iterator<Expr> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(fafl.Absyn.Expr foo)
  {
    if (foo instanceof fafl.Absyn.SetqSimple)
    {
       fafl.Absyn.SetqSimple _setqsimple = (fafl.Absyn.SetqSimple) foo;
       render("(");
       render("SetqSimple");
       sh(_setqsimple.ident_);
       sh(_setqsimple.type_);
       sh(_setqsimple.expr_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.SetqStruct)
    {
       fafl.Absyn.SetqStruct _setqstruct = (fafl.Absyn.SetqStruct) foo;
       render("(");
       render("SetqStruct");
       sh(_setqstruct.ident_1);
       sh(_setqstruct.ident_2);
       sh(_setqstruct.args_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.IntConst)
    {
       fafl.Absyn.IntConst _intconst = (fafl.Absyn.IntConst) foo;
       render("(");
       render("IntConst");
       sh(_intconst.integer_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.DoubleConst)
    {
       fafl.Absyn.DoubleConst _doubleconst = (fafl.Absyn.DoubleConst) foo;
       render("(");
       render("DoubleConst");
       sh(_doubleconst.double_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.BoolConst)
    {
       fafl.Absyn.BoolConst _boolconst = (fafl.Absyn.BoolConst) foo;
       render("(");
       render("BoolConst");
       sh(_boolconst.bool_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.StringConst)
    {
       fafl.Absyn.StringConst _stringconst = (fafl.Absyn.StringConst) foo;
       render("(");
       render("StringConst");
       sh(_stringconst.string_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.Id)
    {
       fafl.Absyn.Id _id = (fafl.Absyn.Id) foo;
       render("(");
       render("Id");
       sh(_id.ident_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.FuncCall)
    {
       fafl.Absyn.FuncCall _funccall = (fafl.Absyn.FuncCall) foo;
       render("(");
       render("FuncCall");
       sh(_funccall.ident_);
       render("[");
       sh(_funccall.listexpr_);
       render("]");
       render(")");
    }
    if (foo instanceof fafl.Absyn.Define)
    {
       fafl.Absyn.Define _define = (fafl.Absyn.Define) foo;
       render("(");
       render("Define");
       sh(_define.ident_);
       render("[");
       sh(_define.listatypedarg_);
       render("]");
       sh(_define.afuncreturntype_);
       sh(_define.expr_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.StructInit)
    {
       fafl.Absyn.StructInit _structinit = (fafl.Absyn.StructInit) foo;
       render("(");
       render("StructInit");
       sh(_structinit.ident_);
       render("[");
       sh(_structinit.listatypedarg_);
       render("]");
       render(")");
    }
    if (foo instanceof fafl.Absyn.StructConstructor)
    {
       fafl.Absyn.StructConstructor _structconstructor = (fafl.Absyn.StructConstructor) foo;
       render("(");
       render("StructConstructor");
       sh(_structconstructor.ident_);
       render("[");
       sh(_structconstructor.listexpr_);
       render("]");
       render(")");
    }
    if (foo instanceof fafl.Absyn.StructField)
    {
       fafl.Absyn.StructField _structfield = (fafl.Absyn.StructField) foo;
       render("(");
       render("StructField");
       sh(_structfield.expr_);
       sh(_structfield.ident_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.If)
    {
       fafl.Absyn.If _if = (fafl.Absyn.If) foo;
       render("(");
       render("If");
       sh(_if.expr_1);
       sh(_if.expr_2);
       sh(_if.expr_3);
       render(")");
    }
    if (foo instanceof fafl.Absyn.Lambda)
    {
       fafl.Absyn.Lambda _lambda = (fafl.Absyn.Lambda) foo;
       render("(");
       render("Lambda");
       render("[");
       sh(_lambda.listatypedarg_);
       render("]");
       sh(_lambda.afuncreturntype_);
       sh(_lambda.expr_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.DictConstructor)
    {
       fafl.Absyn.DictConstructor _dictconstructor = (fafl.Absyn.DictConstructor) foo;
       render("(");
       render("DictConstructor");
       sh(_dictconstructor.ident_);
       sh(_dictconstructor.type_1);
       sh(_dictconstructor.type_2);
       render("[");
       sh(_dictconstructor.listpair_);
       render("]");
       render(")");
    }
    if (foo instanceof fafl.Absyn.DictSet)
    {
       fafl.Absyn.DictSet _dictset = (fafl.Absyn.DictSet) foo;
       render("(");
       render("DictSet");
       sh(_dictset.expr_);
       sh(_dictset.pair_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.DictGet)
    {
       fafl.Absyn.DictGet _dictget = (fafl.Absyn.DictGet) foo;
       render("(");
       render("DictGet");
       sh(_dictget.expr_1);
       sh(_dictget.expr_2);
       render(")");
    }
    if (foo instanceof fafl.Absyn.DictRemove)
    {
       fafl.Absyn.DictRemove _dictremove = (fafl.Absyn.DictRemove) foo;
       render("(");
       render("DictRemove");
       sh(_dictremove.expr_1);
       sh(_dictremove.expr_2);
       render(")");
    }
    if (foo instanceof fafl.Absyn.DictKeys)
    {
       fafl.Absyn.DictKeys _dictkeys = (fafl.Absyn.DictKeys) foo;
       render("(");
       render("DictKeys");
       sh(_dictkeys.expr_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.DictValues)
    {
       fafl.Absyn.DictValues _dictvalues = (fafl.Absyn.DictValues) foo;
       render("(");
       render("DictValues");
       sh(_dictvalues.expr_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.DictLength)
    {
       fafl.Absyn.DictLength _dictlength = (fafl.Absyn.DictLength) foo;
       render("(");
       render("DictLength");
       sh(_dictlength.expr_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.ArrayConstructor)
    {
       fafl.Absyn.ArrayConstructor _arrayconstructor = (fafl.Absyn.ArrayConstructor) foo;
       render("(");
       render("ArrayConstructor");
       sh(_arrayconstructor.type_);
       sh(_arrayconstructor.expr_);
       render("[");
       sh(_arrayconstructor.listexpr_);
       render("]");
       render(")");
    }
    if (foo instanceof fafl.Absyn.First)
    {
       fafl.Absyn.First _first = (fafl.Absyn.First) foo;
       render("(");
       render("First");
       sh(_first.expr_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.Last)
    {
       fafl.Absyn.Last _last = (fafl.Absyn.Last) foo;
       render("(");
       render("Last");
       sh(_last.expr_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.ArrayGet)
    {
       fafl.Absyn.ArrayGet _arrayget = (fafl.Absyn.ArrayGet) foo;
       render("(");
       render("ArrayGet");
       sh(_arrayget.expr_1);
       sh(_arrayget.expr_2);
       render(")");
    }
    if (foo instanceof fafl.Absyn.ArraySet)
    {
       fafl.Absyn.ArraySet _arrayset = (fafl.Absyn.ArraySet) foo;
       render("(");
       render("ArraySet");
       sh(_arrayset.expr_1);
       sh(_arrayset.expr_2);
       sh(_arrayset.expr_3);
       render(")");
    }
    if (foo instanceof fafl.Absyn.ArrayLength)
    {
       fafl.Absyn.ArrayLength _arraylength = (fafl.Absyn.ArrayLength) foo;
       render("(");
       render("ArrayLength");
       sh(_arraylength.expr_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.TupleConstructor)
    {
       fafl.Absyn.TupleConstructor _tupleconstructor = (fafl.Absyn.TupleConstructor) foo;
       render("(");
       render("TupleConstructor");
       render("[");
       sh(_tupleconstructor.listexpr_);
       render("]");
       render(")");
    }
    if (foo instanceof fafl.Absyn.TupleGet)
    {
       fafl.Absyn.TupleGet _tupleget = (fafl.Absyn.TupleGet) foo;
       render("(");
       render("TupleGet");
       sh(_tupleget.expr_1);
       sh(_tupleget.expr_2);
       render(")");
    }
    if (foo instanceof fafl.Absyn.TupleLength)
    {
       fafl.Absyn.TupleLength _tuplelength = (fafl.Absyn.TupleLength) foo;
       render("(");
       render("TupleLength");
       sh(_tuplelength.expr_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.RaiseEx)
    {
       fafl.Absyn.RaiseEx _raiseex = (fafl.Absyn.RaiseEx) foo;
       render("(");
       render("RaiseEx");
       sh(_raiseex.string_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.TryCatch)
    {
       fafl.Absyn.TryCatch _trycatch = (fafl.Absyn.TryCatch) foo;
       render("(");
       render("TryCatch");
       sh(_trycatch.expr_1);
       sh(_trycatch.expr_2);
       render(")");
    }
    if (foo instanceof fafl.Absyn.Plus)
    {
       fafl.Absyn.Plus _plus = (fafl.Absyn.Plus) foo;
       render("(");
       render("Plus");
       render("[");
       sh(_plus.listexpr_);
       render("]");
       render(")");
    }
    if (foo instanceof fafl.Absyn.Minus)
    {
       fafl.Absyn.Minus _minus = (fafl.Absyn.Minus) foo;
       render("(");
       render("Minus");
       render("[");
       sh(_minus.listexpr_);
       render("]");
       render(")");
    }
    if (foo instanceof fafl.Absyn.Mul)
    {
       fafl.Absyn.Mul _mul = (fafl.Absyn.Mul) foo;
       render("(");
       render("Mul");
       render("[");
       sh(_mul.listexpr_);
       render("]");
       render(")");
    }
    if (foo instanceof fafl.Absyn.Div)
    {
       fafl.Absyn.Div _div = (fafl.Absyn.Div) foo;
       render("(");
       render("Div");
       render("[");
       sh(_div.listexpr_);
       render("]");
       render(")");
    }
    if (foo instanceof fafl.Absyn.Equals)
    {
       fafl.Absyn.Equals _equals = (fafl.Absyn.Equals) foo;
       render("(");
       render("Equals");
       sh(_equals.expr_1);
       sh(_equals.expr_2);
       render(")");
    }
    if (foo instanceof fafl.Absyn.IsLess)
    {
       fafl.Absyn.IsLess _isless = (fafl.Absyn.IsLess) foo;
       render("(");
       render("IsLess");
       sh(_isless.expr_1);
       sh(_isless.expr_2);
       render(")");
    }
    if (foo instanceof fafl.Absyn.IsGreater)
    {
       fafl.Absyn.IsGreater _isgreater = (fafl.Absyn.IsGreater) foo;
       render("(");
       render("IsGreater");
       sh(_isgreater.expr_1);
       sh(_isgreater.expr_2);
       render(")");
    }
    if (foo instanceof fafl.Absyn.And)
    {
       fafl.Absyn.And _and = (fafl.Absyn.And) foo;
       render("(");
       render("And");
       sh(_and.expr_1);
       sh(_and.expr_2);
       render(")");
    }
    if (foo instanceof fafl.Absyn.Or)
    {
       fafl.Absyn.Or _or = (fafl.Absyn.Or) foo;
       render("(");
       render("Or");
       sh(_or.expr_1);
       sh(_or.expr_2);
       render(")");
    }
    if (foo instanceof fafl.Absyn.ReadLine)
    {
       fafl.Absyn.ReadLine _readline = (fafl.Absyn.ReadLine) foo;
       render("ReadLine");
    }
    if (foo instanceof fafl.Absyn.PrintLine)
    {
       fafl.Absyn.PrintLine _printline = (fafl.Absyn.PrintLine) foo;
       render("(");
       render("PrintLine");
       sh(_printline.string_);
       render(")");
    }
  }

  private static void sh(fafl.Absyn.Bool foo)
  {
    if (foo instanceof fafl.Absyn.BoolTrue)
    {
       fafl.Absyn.BoolTrue _booltrue = (fafl.Absyn.BoolTrue) foo;
       render("BoolTrue");
    }
    if (foo instanceof fafl.Absyn.BoolFalse)
    {
       fafl.Absyn.BoolFalse _boolfalse = (fafl.Absyn.BoolFalse) foo;
       render("BoolFalse");
    }
  }

  private static void sh(fafl.Absyn.ListATypedArg foo)
  {
     for (java.util.Iterator<ATypedArg> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(fafl.Absyn.AFuncReturnType foo)
  {
    if (foo instanceof fafl.Absyn.FuncReturnType)
    {
       fafl.Absyn.FuncReturnType _funcreturntype = (fafl.Absyn.FuncReturnType) foo;
       render("(");
       render("FuncReturnType");
       sh(_funcreturntype.type_);
       render(")");
    }
  }

  private static void sh(fafl.Absyn.Pair foo)
  {
    if (foo instanceof fafl.Absyn.DictPair)
    {
       fafl.Absyn.DictPair _dictpair = (fafl.Absyn.DictPair) foo;
       render("(");
       render("DictPair");
       sh(_dictpair.expr_1);
       sh(_dictpair.expr_2);
       render(")");
    }
  }

  private static void sh(fafl.Absyn.ListPair foo)
  {
     for (java.util.Iterator<Pair> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(fafl.Absyn.ATypedArg foo)
  {
    if (foo instanceof fafl.Absyn.TypedArg)
    {
       fafl.Absyn.TypedArg _typedarg = (fafl.Absyn.TypedArg) foo;
       render("(");
       render("TypedArg");
       sh(_typedarg.ident_);
       sh(_typedarg.type_);
       render(")");
    }
  }

  private static void sh(fafl.Absyn.Args foo)
  {
    if (foo instanceof fafl.Absyn.Arguments)
    {
       fafl.Absyn.Arguments _arguments = (fafl.Absyn.Arguments) foo;
       render("(");
       render("Arguments");
       render("[");
       sh(_arguments.listarg_);
       render("]");
       render(")");
    }
  }

  private static void sh(fafl.Absyn.ListArg foo)
  {
     for (java.util.Iterator<Arg> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(fafl.Absyn.Arg foo)
  {
    if (foo instanceof fafl.Absyn.NameArg)
    {
       fafl.Absyn.NameArg _namearg = (fafl.Absyn.NameArg) foo;
       render("(");
       render("NameArg");
       sh(_namearg.ident_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.ExprArg)
    {
       fafl.Absyn.ExprArg _exprarg = (fafl.Absyn.ExprArg) foo;
       render("(");
       render("ExprArg");
       sh(_exprarg.expr_);
       render(")");
    }
  }

  private static void sh(fafl.Absyn.Type foo)
  {
    if (foo instanceof fafl.Absyn.TupleType)
    {
       fafl.Absyn.TupleType _tupletype = (fafl.Absyn.TupleType) foo;
       render("TupleType");
    }
    if (foo instanceof fafl.Absyn.BoolType)
    {
       fafl.Absyn.BoolType _booltype = (fafl.Absyn.BoolType) foo;
       render("BoolType");
    }
    if (foo instanceof fafl.Absyn.IntType)
    {
       fafl.Absyn.IntType _inttype = (fafl.Absyn.IntType) foo;
       render("IntType");
    }
    if (foo instanceof fafl.Absyn.DoubleType)
    {
       fafl.Absyn.DoubleType _doubletype = (fafl.Absyn.DoubleType) foo;
       render("DoubleType");
    }
    if (foo instanceof fafl.Absyn.StringType)
    {
       fafl.Absyn.StringType _stringtype = (fafl.Absyn.StringType) foo;
       render("StringType");
    }
    if (foo instanceof fafl.Absyn.ArrayType)
    {
       fafl.Absyn.ArrayType _arraytype = (fafl.Absyn.ArrayType) foo;
       render("(");
       render("ArrayType");
       sh(_arraytype.type_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.StructType)
    {
       fafl.Absyn.StructType _structtype = (fafl.Absyn.StructType) foo;
       render("(");
       render("StructType");
       sh(_structtype.ident_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.DictType)
    {
       fafl.Absyn.DictType _dicttype = (fafl.Absyn.DictType) foo;
       render("(");
       render("DictType");
       sh(_dicttype.type_1);
       sh(_dicttype.type_2);
       render(")");
    }
    if (foo instanceof fafl.Absyn.StructFieldType)
    {
       fafl.Absyn.StructFieldType _structfieldtype = (fafl.Absyn.StructFieldType) foo;
       render("(");
       render("StructFieldType");
       sh(_structfieldtype.type_);
       render(")");
    }
    if (foo instanceof fafl.Absyn.FuncType)
    {
       fafl.Absyn.FuncType _functype = (fafl.Absyn.FuncType) foo;
       render("(");
       render("FuncType");
       sh(_functype.type_1);
       sh(_functype.type_2);
       render(")");
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

