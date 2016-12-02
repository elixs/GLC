package expressions;

import cup.main.Pen;

public class IsBoardColor implements Expression {

  private Pen pen;
  private String color;

  public IsBoardColor(final Pen pen, final String color) {
    this.pen = pen;
    this.color = color;
  }

  @Override
  public boolean execute() {
    return pen.isBoardColor(color);
  }

}
