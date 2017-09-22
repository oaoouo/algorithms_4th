// 双向队列
// 支持同时两端添加和删除元素

import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item>
{
  private class Denode
  {
    Item item;   // 存放值
    Denode next; // 指向下一个节点的引用
    Denode prev; // 指向上一个节点的引用
  }
  private Denode first; // 初始节点引用
  private Denode last;  // 末尾节点引用
  private int N; // 队列中节点的个数

  public Deque()
  {
    first = new Denode();
    last = new Denode();
  }

  public boolean isEmpty()
  {
    return N == 0;
  }

  public int size()
  {
    return N;
  }

  public void pushLeft(Item item)
  {
    // 向队列左端first添加元素
    Denode oldfirst = first; // oldfirst指向[原先]first节点
    first = new Denode(); // first指向新的节点
    first.item = item;
    first.next = oldfirst;
    oldfirst.prev = first;
    N++;
    if (N == 1)
    {
      last = first;
    }
  }

  public void pushRight(Item item)
  {
    // 向队列右端添加元素
    Denode oldlast = last;
    last = new Denode();
    last.item = item;
    oldlast.next = last;
    last.prev = oldlast;
    N++;
    if (N == 1)
    {
      first = last;
    }
  }

  public Item popLeft()
  {
    // 删除队列左端first元素  
    Item item = first.item;
    first = first.next;
    first.prev = null;
    N--;
    if (N == 0 || N == 1)
    {
      last = first;
    }
    return item;
  }

  public Item popRight()
  {
    // 删除队列右端元素
    Item item = last.item;
    last = last.prev;
    last.next = null;
    N--;
    if (N == 0 || N == 1)
    {
      first = last;
    }
    return item;
  }

  public Iterator<Item> iterator()
  {
    return new DequeIterator();
  }

  private class DequeIterator implements Iterator<Item>
  {
    // 从左到右遍历
    private Denode current = first;

    public boolean hasNext()
    {
      return current != null && current.item != null; // 这里有点...
    }
  
    public Item next()
    {
      // 迭代并返回可迭代对象
      Item item = current.item;
      current = current.next; 
      return item;
    }

    public void remove() {}
  }

  /*
  public void show(Deque<Item> deque)
  {
    StdOut.print(">> 当前deque为: ");
    for (Item item : deque)
    {
      StdOut.print(item + " ");
    }
    StdOut.print(", 当前deque大小: " + deque.size());
    StdOut.println();
  }
  */

  public static void main(String[] args)
  {
    Deque<String> deque = new Deque<String>();
    String s1 = "neo";
    String s2 = "oao";
    String s3 = "ouo";
    String s4 = "1218";

    deque.pushLeft(s4);
    deque.pushLeft(s1);
    // deque.show();

    deque.popLeft();
    StdOut.print(">> 当前deque为: ");
    for (String item : deque)
    {
      StdOut.print(item + " ");
    }
    StdOut.print(", 当前deque大小: " + deque.size());
    StdOut.println();

    deque.pushLeft(s2);
    StdOut.print(">> 当前deque为: ");
    for (String item : deque)
    {
      StdOut.print(item + " ");
    }
    StdOut.print(", 当前deque大小: " + deque.size());
    StdOut.println();

    deque.popRight();
    StdOut.print(">> 当前deque为: ");
    for (String item : deque)
    {
      StdOut.print(item + " ");
    }
    StdOut.print(", 当前deque大小: " + deque.size());
    StdOut.println();

    deque.pushRight(s3);
    StdOut.print(">> 当前deque为: ");
    for (String item : deque)
    {
      StdOut.print(item + " ");
    }
    StdOut.print(", 当前deque大小: " + deque.size());
    StdOut.println();
  }
}
