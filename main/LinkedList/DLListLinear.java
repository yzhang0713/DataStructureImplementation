public class DLList {
  private class IntNode {
    public int item;
    public IntNode prev;
    public IntNode next;

    public IntNode(int i, IntNode p, IntNode n) {
      item = i;
      prev = p;
      next = n;
    }
  }

  // private IntNode first;
  private int size = 0;
  private IntNode sentinel = new IntNode(713, null, null);
  private IntNode last = new IntNode(801, null, null);

  public DLList() {
    size = 0;
    sentinel.next = last;
    last.prev = sentinel;
  }

  public DLList(int x) {
    size = 1;
    sentinel.next = new IntNode(x, sentinel, last);
    sentinel.next.prev = sentinel;
    last.prev = sentinel.next;
  }

  public void addFirst(int x) {
    size++;
    IntNode p = new IntNode(x, sentinel, sentinel.next);
    sentinel.next.prev = p;
    sentinel.next = p;
  }

  // This method returns wrong value with empty list
  public int getFirst() {
    return sentinel.next.item;
  }

  public void addLast(int x) {
    size++;
    IntNode p = new IntNode(x, last.prev, last);
    last.prev.next = p;
    last.prev = p;
  }

  // The method returns wrong value with empty list
  public int getLast() {
    return last.prev.item;
  }

  public int get(int i) {
    if (i > size-1) {
      // Should raise exception
      return 0;
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

  public int size() {
    return size;
  }

  public static void main(String[] args) {
    DLList L = new DLList(15);
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
  }
}
