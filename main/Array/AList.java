public class AList<Item> {
  private Item[] items;
  private int size;

  public AList() {
    items = (Item []) new Object[8];
    size = 0;
  }

  public void addLast(Item x) {
    if (size == items.length) {
      resize(2*size);
    }
    items[size] = x;
    size++;
  }

  public Item getLast() {
    return items[size-1];
  }

  public Item get(int i) {
    return items[i];
  }

  public int size() {
    return size;
  }

  public void removeLast() {
    items[size-1] = null;
    size--;
    if (size < items.length/4) {
      resize(items.length/2);
    }
  }

  public void resize(int capacity) {
    Item[] a = (Item []) new Object[capacity];
    System.arraycopy(items,0,a,0,size);
    items = a;
  }

  public static void main(String[] args) {
    AList<Integer> L = new AList<>();
    L.addLast(1);
    L.addLast(2);
    L.addLast(3);
    System.out.println(L.get(2));
    System.out.println(L.getLast());
    System.out.println(L.size());
    L.removeLast();
    System.out.println(L.getLast());
    AList<String> S = new AList<>();
    S.addLast("hi");
    S.addLast("hello");
    System.out.println(S.get(0));
    System.out.println(S.getLast());
  }
}
