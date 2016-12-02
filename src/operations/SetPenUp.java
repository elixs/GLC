package operations;

import cup.main.Pen;

public class SetPenUp implements Operation {

  private Pen pen;

  public SetPenUp(final Pen pen) {
    this.pen = pen;
  }

  @Override
  public void execute() {
    pen.setPenUp();
  }

}
