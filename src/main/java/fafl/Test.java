package fafl;
import eval.Evaluator;
import java_cup.runtime.*;
import fafl.*;
import fafl.Absyn.*;
import java.io.*;

public class Test
{
  public static void main(String args[]) throws Exception
  {
    Yylex l = null;
    parser p;
    try
    {
      if (args.length == 0) l = new Yylex(new InputStreamReader(System.in));
      else l = new Yylex(new FileReader(args[0]));
    }
    catch(FileNotFoundException e)
    {
     System.err.println("Error: File not found: " + args[0]);
     System.exit(1);
    }
    p = new parser(l);
    /* The default parser is the first-defined entry point. */
    /* You may want to change this. Other options are: */
    /* pListExpr, pExpr, pBool, pListATypedArg, pAFuncReturnType,
       pPair, pListPair, pATypedArg, pArgs, pListArg, pArg, pType */
    try
    {
      fafl.Absyn.ProgramExprs parse_tree = p.pProgramExprs();
      Program program = (Program) parse_tree;
      for(var expr: program.listexpr_){
        System.out.println(PrettyPrinter.show(Evaluator.evalStep(expr)));
      }
      System.out.println(PrettyPrinter.print(parse_tree));
    }
    catch(Throwable e)
    {
      System.err.println("At line " + String.valueOf(l.line_num()) + ", near \"" + l.buff() + "\" :");
      System.err.println("     " + e.getMessage());
      System.exit(1);
    }
  }
}