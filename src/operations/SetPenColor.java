package operations;

import cup.main.Pen;

public class SetPenColor implements Operation {

  private Pen pen;
  private String color;

  public SetPenColor(final Pen pen, final String color) {
    this.pen = pen;
    this.color = color;
  }

  @Override
  public void execute() {
    pen.setPenColor(color);
  }

}
