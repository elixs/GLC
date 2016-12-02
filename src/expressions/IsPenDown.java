package expressions;

import cup.main.Pen;

public class IsPenDown implements Expression {

  private Pen pen;

  public IsPenDown(final Pen pen) {
    this.pen = pen;
  }

  @Override
  public boolean execute() {
    return pen.isPenDown();
  }

}
