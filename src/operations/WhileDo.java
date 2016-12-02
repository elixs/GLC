package operations;

import expressions.Expression;

public class WhileDo implements Operation {

  private Expression e;
  private Operation o;

  public WhileDo(final Expression e, final Operation o) {
    this.e = e;
    this.o = o;
  }

  @Override
  public void execute() {
    while (e.execute()) {
      o.execute();
    }
  }

}
