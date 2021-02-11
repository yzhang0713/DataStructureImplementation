public class DLList<Item> {
  private class IntNode {
    public Item item;
    public IntNode prev;
    public IntNode next;

    public IntNode(Item i, IntNode p, IntNode n) {
      item = i;
      prev = p;
      next = n;
    }
  }

  // private IntNode first;
  private int size = 0;
  private IntNode sentinel = new IntNode(null, null, null);
  // private IntNode last = new IntNode(801, null, null);

  public DLList() {
    size = 0;
    sentinel.next = sentinel;
    sentinel.prev = sentinel;
  }

  public DLList(Item x) {
    size = 1;
    sentinel.next = new IntNode(x, sentinel, sentinel);
    sentinel.prev = sentinel.next;
  }

  public void addFirst(Item x) {
    size++;
    IntNode p = new IntNode(x, sentinel, sentinel.next);
    sentinel.next.prev = p;
    sentinel.next = p;
  }

  // This method returns wrong value with empty list
  public Item getFirst() {
    return sentinel.next.item;
  }

  public void addLast(Item x) {
    size++;
    IntNode p = new IntNode(x, sentinel.prev, sentinel);
    sentinel.prev.next = p;
    sentinel.prev = p;
  }

  // The method returns wrong value with empty list
  public Item getLast() {
    return sentinel.prev.item;
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
    p.next.next.prev = p;
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
    p.next = new IntNode(item, p, p.next);
    p.next.next.prev = p.next;
    return;
  }

  public void removeItem(Item item) {
    IntNode p = sentinel;
    while (p.next != sentinel) {
      if (p.next.item.equals(item)) {
        p.next = p.next.next;
        p.next.prev = p;
        break;
      }
      p = p.next;
    }
    return;
  }

  public int size() {
    return size;
  }

  public static void main(String[] args) {
    DLList<Integer> L = new DLList<>(15);
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
    DLList<String> S = new DLList<>("hi");
    System.out.println(S.getFirst());
  }
}
