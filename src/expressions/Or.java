package expressions;

public class Or implements Expression {

  private Expression e1;
  private Expression e2;

  public Or(final Expression e1, final Expression e2) {
    this.e1 = e1;
    this.e2 = e2;
  }

  @Override
  public boolean execute() {
    return e1.execute() || e2.execute();
  }

}
