package eval;

import fafl.Absyn.Program;
import fafl.PrettyPrinter;
import fafl.Yylex;
import fafl.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Interpreter
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
            System.out.println();
            System.out.println("Parse Succesful!");
            System.out.println();
            System.out.println("[Abstract Syntax]");
            System.out.println();
            System.out.println(PrettyPrinter.show(parse_tree));
            System.out.println();
            System.out.println("[Linearized Tree]");
            System.out.println();
            System.out.println(PrettyPrinter.print(parse_tree));
            System.out.println();
            Program program = (Program)parse_tree;
            var context = new Context().context;
            System.out.println("Type check results:");
            for(var expr : program.listexpr_)
            {
                System.out.println(PrettyPrinter.print(TypeChecker.typeOf(context, expr, false)));
                //System.out.println(PrettyPrinter.show(TypeChecker.typeOf(context, expr, false)));
            }
            System.out.println("-------------------------------");
            System.out.println("Eval results:");
            for(var expr : program.listexpr_)
            {
                System.out.println(PrettyPrinter.print(Evaluator.evalStep(expr)));
            }
        }
        catch(Throwable e)
        {
            System.err.println("At line " + String.valueOf(l.line_num()) + ", near \"" + l.buff() + "\" :");
            System.err.println("     " + e.getMessage());
            System.exit(0);
        }
    }
}
