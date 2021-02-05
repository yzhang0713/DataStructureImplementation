public class IntList {
  public int first;
  public IntList rest;

  public IntList(int f, IntList r) {
    first = f;
    rest = r;
  }

  public static void main(String[] args) {
    IntList list = new IntList(2, null);
    System.out.println(list.first);
  }
}
