import java.util.Iterator;

public class LinkListStack<Item> implements Iterable<Item>
{
  // 下压栈的链表实现
  private int N = 0; // 链表中元素个数  
  // 嵌套类定义节点
  private class Node<Item>
  {
    Item item = null;
    Node next = null;
  }
  private Node first; // 表头节点

  public boolean isEmpty()
  {
    return N == 0;
  }

  public int size()
  {
    return first.next == null;
  }

  public void push(Item item)
  {
    // 将item插入表头
    Node<Item> oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    N++;
  }

  public Item pop()
  {
    // 返回并删除表头元素
    Item item = first.item;
    first = first.next;
    N--;
    return item;
  }

  public Iterator<Item> iterator()
  {
    return new LinkListStackIterator()
  }

  private class LinkListStackIterator() implements Iterator<Item>
  {
    // 从表头向表尾遍历
    private Node current = first;
    public boolean hasNext()
    {
      return current != null;
    }

    public Item next()
    {
      // 遍历元素值item
      Item item = current.item;
      current = current.next;
      return item;
    }

    public void remove() {}
  }
}
