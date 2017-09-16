import java.util.Iterator; // 迭代器接口

// 泛型
public class ResizingArrayStack<Item> implements Iterable<Item>
{
  private Item[] a = (Item[]) new Object[1]; // 存放元素
  private int N = 0; // 元素个数

  public boolean isEmpty()
  {
    return N == 0;
  }

  public int size()
  {
    return N;
  }

  private void resize(int max)
  {
    // 动态改变数组a的大小为max
    Item[] temp = (Item[]) new Object[max]; // *泛型创建数组的方式
    for (int i = 0; i < max; i++)
    {
      temp[i] = a[i];
    }
    a = temp;
  }

  public void push(Item item)
  {
    if (a.length == N)
    {
      resize(2 * a.length);
    }
    a[N++] = item;
  }

  public Item pop(Item item)
  {
    Item item = a[--N];
    a[N] == null; // *避免对象游离
    if (N > 0 && N == a.length/4)
    {
      // 只缩小一半避免过多的调用resize
      resize(a.length/2);
    }
    return item;
  }

  // 嵌套类实现迭代器
  // 嵌套类可以访问包含他的类的实例变量
  public Iterator<Item> iterator()
  {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<Item>
  {
    private int i = N;
    public boolean hasNext()
    {
      return i > 0;
    }
    public Item next()
    {
      return a[--i];
    }
    public void remove()
    {
      /* 不实现, 避免迭代过程中对被迭代对象的修改 */
    }
  }
}
