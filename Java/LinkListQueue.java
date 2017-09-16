import java.util.Iterator;

public class LinkListQueue<Item> implements Iterable<Item>
{
  private Node first; // 指向头结点的引用
  private Node last;  // 指向尾节点的引用
  private int N;      // 队列中元素的个数
  // 嵌套类定义节点
  private class Node
  {
    Item item;
    Node next;
  }

  public boolean isEmpty()
  {
    return N == 0;
  }

  public int size()
  {
    return N;
  }

  public void enqueue(Item item)
  {
    // 添加元素到队列尾部
    Node oldlast = last;
    last = new Node();
    last.item = item;
    last.next = null;
    if (isEmpty())  // 此时N还是0
    {
      first = last; // 此时队列中只有一个元素
    }
    else {
      oldlast.next = last;
    } 
    N++;
  }

  public Item dequeue()
  {
    // 删除表头元素
    Item item = first.item;
    first = first.next;
    N--;
    if (N < 2)
    {
      first = last = null;
    }
    return item;
  }

  public Iterator<Item> iterator()
  {
    return new LinkListQueueIterator();
  }

  private class LinkListQueueIterator implements Iterator<Item>
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
      return item;
    }

    public void remove() {}
  }
}
