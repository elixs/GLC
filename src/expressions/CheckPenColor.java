package expressions;

import cup.main.Pen;

public class CheckPenColor implements Expression {

  private Pen pen;
  private String color;

  public CheckPenColor(final Pen pen, final String color) {
    this.pen = pen;
    this.color = color;
  }

  @Override
  public boolean execute() {
    return pen.checkPenColor(color);
  }

}
