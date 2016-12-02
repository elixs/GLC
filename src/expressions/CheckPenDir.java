package expressions;

import cup.main.Pen;

public class CheckPenDir implements Expression {

  private Pen pen;
  private String dir;

  public CheckPenDir(final Pen pen, final String dir) {
    this.pen = pen;
    this.dir = dir;
  }

  @Override
  public boolean execute() {
    return pen.checkPenDir(dir);
  }

}
