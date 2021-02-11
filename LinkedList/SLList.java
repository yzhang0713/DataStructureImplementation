public class SLList<Item> {
  private class IntNode {
    public Item item;
    public IntNode next;

    public IntNode(Item i, IntNode n) {
      item = i;
      next = n;
    }
  }

  private int size = 0;
  private IntNode sentinel = new IntNode(null, null);

  public SLList() {
    size = 0;
  }

  public SLList(Item x) {
    sentinel.next = new IntNode(x, null);
    size = 1;
  }

  public void addFirst(Item x) {
    IntNode p = new IntNode(x, sentinel.next);
    sentinel.next = p;
    size++;
  }

  public Item getFirst() {
    return sentinel.next.item;
  }

  public void addLast(Item x) {
    size++;
    IntNode p = sentinel;
    while (p.next != null) {
      p = p.next;
    }
    p.next = new IntNode(x, null);
  }

  // The method should not be able to return sentinel.item
  public Item getLast() {
    IntNode p = sentinel;
    while (size > 0 && p.next != null) {
      p = p.next;
    }
    return p.item;
  }

  public Item get(int i) {
    if (i > size-1) {
      // Should raise exception
      return null;
    }
    IntNode p = sentinel;
    while (i > 0) {
      p = p.next;
      i--;
    }
    return p.next.item;
  }

  public void remove(int i) {
    if (i > size-1) {
      // Should raise exception
      return;
    }
    IntNode p = sentinel;
    while (i > 0) {
      p = p.next;
      i--;
    }
    p.next = p.next.next;
    size--;
    return;
  }

  public void insert(Item item, int i) {
    IntNode p = sentinel;
    while (i > 0) {
      p = p.next;
      i--;
    }
    p.next = new IntNode(item, p.next);
    // item.next = p.next;
    // p.next = item;
    return;
  }

  public void removeItem(Item item) {
    IntNode p = sentinel;
    while (p.next != null) {
      if (p.next.item.equals(item)) {
        p.next = p.next.next;
        break;
      }
      p = p.next;
    }
    return;
  }

  // Implementation 3 of size(): use extra variable, constant performance
  public int size() {
    return size;
  }

  public static void main(String[] args) {
    SLList<Integer> L = new SLList<>(15);
    L.addFirst(10);
    L.addFirst(5);
    L.addLast(3);
    int x = L.getFirst();
    int y = L.getLast();
    int z = L.get(1);
    L.remove(0);
    int a = L.getFirst();
    System.out.println(x);
    System.out.println(y);
    System.out.println(z);
    System.out.println(a);
    System.out.println(L.size());
    L.insert(100,1);
    System.out.println(L.get(1));
    System.out.println(L.size());
    L.removeItem(100);
    System.out.println(L.get(1));
    System.out.println(L.size());
    SLList<String> S = new SLList<>("hi");
    System.out.println(S.getFirst());
  }
}
