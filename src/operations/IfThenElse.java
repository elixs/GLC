package operations;

import expressions.Expression;

public class IfThenElse implements Operation {

  private Expression e;
  private Operation o1;
  private Operation o2;

  public IfThenElse(final Expression e, final Operation o1, final Operation o2) {
    this.e = e;
    this.o1 = o1;
    this.o2 = o2;
  }

  @Override
  public void execute() {
    if (e.execute()) {
      o1.execute();
    } else {
      o2.execute();
    }
  }

}
