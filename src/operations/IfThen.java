package operations;

import expressions.Expression;

public class IfThen implements Operation {

  private Expression e;
  private Operation o;

  public IfThen(final Expression e, final Operation o) {
    this.e = e;
    this.o = o;
  }

  @Override
  public void execute() {
    if (e.execute()) {
      o.execute();
    }
  }

}
