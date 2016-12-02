package expressions;

public class Not implements Expression {

  private Expression e;

  public Not(final Expression e) {
    this.e = e;
  }

  @Override
  public boolean execute() {
    return !e.execute();
  }

}
