package expressions;

import cup.main.Pen;

public class IsPenUp implements Expression {

  private Pen pen;

  public IsPenUp(final Pen pen) {
    this.pen = pen;
  }

  @Override
  public boolean execute() {
    return pen.isPenUp();
  }

}
