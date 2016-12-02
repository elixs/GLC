package expressions;

import cup.main.Pen;

public class Edge implements Expression {

  private Pen pen;

  public Edge(final Pen pen) {
    this.pen = pen;
  }

  @Override
  public boolean execute() {
    return pen.edge();
  }

}
