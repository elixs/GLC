package expressions;

public class And implements Expression {

  private Expression e1;
  private Expression e2;

  public And(final Expression e1, final Expression e2) {
    this.e1 = e1;
    this.e2 = e2;
  }

  @Override
  public boolean execute() {
    return e1.execute() && e2.execute();
  }

}
