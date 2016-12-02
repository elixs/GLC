package operations;

import cup.main.Pen;

public class SetPenDown implements Operation {

  private Pen pen;

  public SetPenDown(final Pen pen) {
    this.pen = pen;
  }

  @Override
  public void execute() {
    pen.setPenDown();
  }

}
