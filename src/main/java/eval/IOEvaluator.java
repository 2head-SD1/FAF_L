package eval;

import fafl.Absyn.*;

import java.util.Scanner;

public class IOEvaluator
{
    private static Scanner scanner = new Scanner(System.in);

    public static boolean isExprIO(Expr expr)
    {
        return expr instanceof ReadLine ||
                expr instanceof PrintLine;
    }

    public static Expr doIOExpr(Expr expr) throws Exception
    {
        if (expr instanceof PrintLine)
        {
            PrintLine printLine = (PrintLine) expr;
            return doPrintLine(printLine);
        }
        if (expr instanceof ReadLine)
        {
            ReadLine readLine = (ReadLine) expr;
            return doReadLine(readLine);
        }
        throw new Exception("Cannot handle such IO expression");
    }

    private static Expr doPrintLine(PrintLine printLine) throws Exception
    {
        Expr expr = Evaluator.evalStep(printLine.expr_);
        if (expr instanceof StringConst)
        {
            StringConst stringConst = (StringConst) expr;
            System.out.println(stringConst.string_);
            return stringConst;
        }

        throw new Exception("Cannot print such expression. Try casting to string.");
    }

    private static Expr doReadLine(ReadLine readLine) throws Exception
    {
        return new StringConst(scanner.nextLine());
    }
}
