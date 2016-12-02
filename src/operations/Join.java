package operations;

public class Join implements Operation {

  private Operation o1;
  private Operation o2;

  public Join(final Operation o1, final Operation o2) {
    this.o1 = o1;
    this.o2 = o2;
  }

  @Override
  public void execute() {
    o1.execute();
    o2.execute();
  }

}
