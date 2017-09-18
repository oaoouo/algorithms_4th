import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;

public class Steque<Item> implements Iterable<Item>
{
  private class Node
  {
    Item item; // 存放节点值
    Node next; // 指向下一个节点
  }
  private int N; // 该数据结构的长度
  private Node first; // 队首节点
  private Node last;  // 队尾节点

  public boolean isEmpty()
  {
    return (N == 0);
  }
  
  public int getSize()
  {
    return N;
  }

  public void push(Item item)
  {
    // 将item添加到队首
    Node oldfirst = first;
    first = new Node(); // 创建一个新的首节点
    first.next = oldfirst;
    first.item = item;
    N++;
    if (N == 1)
    {
      last = first;
    }
  }

  public Item pop()
  {
    // 将队首的item弹栈
    Item item = first.item; // 保存队首值
    first = first.next;
    N--;
    if (N < 2)
    {
      last = first;
    }
    return item;
  }
  
  public void enqueue(Item item)
  {
    // 将item添加到队尾
    Node oldlast = last;
    Node last = new Node();
    last.item = item;
    oldlast.next = last;
    N++;
    if (N == 1)
    {
      first = last;
    }
  }

  public Iterator<Item> iterator()
  {
    return new StequeIterator();
  }

  private class StequeIterator implements Iterator<Item>
  {
    private Node current = first;

    public boolean hasNext()
    {
      return current != null;
    }

    public Item next()
    {
      Item item = current.item;
      current = current.next;
      // current.hasNext()
      return item;
    }

    public void remove() {}
  }

  public static void main(String[] args)
  {
    /* Testing */
    Steque<String> squeue = new Steque<String>();
    String s1 = "neo";
    String s2 = "oao";
    String s3 = "ovo";

    squeue.push(s1);
    squeue.push(s2);

    for (String s : squeue)
    {
      StdOut.print(s + " ");
    }
    StdOut.println();

    squeue.pop();

    for (String s : squeue)
    {
      StdOut.print(s + " ");
    }
    StdOut.println();

    squeue.enqueue(s3);

    for (String s : squeue)
    {
      StdOut.print(s + " ");
    }
    StdOut.println();
  }
}
