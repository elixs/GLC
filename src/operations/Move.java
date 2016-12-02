package operations;

import cup.main.Pen;

public class Move implements Operation {

  private Pen pen;
  private int n;

  public Move(final Pen pen, final int n) {
    this.pen = pen;
    this.n = n;
  }

  @Override
  public void execute() {
    pen.move(n);
  }

}
