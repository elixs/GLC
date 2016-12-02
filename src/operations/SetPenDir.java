package operations;

import cup.main.Pen;

public class SetPenDir implements Operation {

  private Pen pen;
  private String dir;

  public SetPenDir(final Pen pen, final String dir) {
    this.pen = pen;
    this.dir = dir;
  }

  @Override
  public void execute() {
    pen.setPenDir(dir);
  }

}
