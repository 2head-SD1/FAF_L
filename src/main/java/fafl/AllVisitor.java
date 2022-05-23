package fafl;

import fafl.Absyn.*;

/** BNFC-Generated All Visitor */
public interface AllVisitor<R,A> extends
  fafl.Absyn.ProgramExprs.Visitor<R,A>,
  fafl.Absyn.Expr.Visitor<R,A>,
  fafl.Absyn.Bool.Visitor<R,A>,
  fafl.Absyn.AFuncReturnType.Visitor<R,A>,
  fafl.Absyn.Pair.Visitor<R,A>,
  fafl.Absyn.ATypedArg.Visitor<R,A>,
  fafl.Absyn.Args.Visitor<R,A>,
  fafl.Absyn.Arg.Visitor<R,A>,
  fafl.Absyn.Type.Visitor<R,A>
{}
