import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class RandomBag<Item> implements Iterable<Item>
{
  // 用数组存储背包
  private Item[] bag; // 声明
  private int N;

  public RandomBag()
  {
    // java泛型不能直接创建Item[]数组
    // 创建Object[]数组再cast
    bag = (Item[])new Object[1];
  }
  
  private void resize(int max)
  {
    // 动态改变数组大小
    Item[] temp = (Item [])new Object[max];
    for (int i = 0; i < N; i++)
    {
      temp[i] = bag[i];
    }
    bag = temp;
  }

  public boolean isEmpty()
  {
    return N == 0;
  }

  public int size()
  {
    return N;
  }

  public void add(Item item)
  {
    if (N == bag.length)
    {
      // 数组已满, 动态调整数组大小
      resize(2*bag.length);
    }
    bag[N++] = item;
  } 

  public Iterator<Item> iterator()
  {
    return new RandomBagIterator();
  }

  private class RandomBagIterator implements Iterator<Item>
  {
    private Item[] ramdonBag;
    private int current = 0;

    RandomBagIterator()
    {
      ramdonBag = (Item[])new Object[N];
      for (int i = 0; i < N; i++)
      {
        ramdonBag[i] = bag[i];
      }
      for (int i = 0; i < N; i++)
      {
        // 打乱, 产生随机背包
        Item temp;
        int j = i + (int)((N-i)*StdRandom.random());
        temp = ramdonBag[i];
        ramdonBag[i] = ramdonBag[j];
        ramdonBag[j] = temp;
      }
    }

    public boolean hasNext()
    {
      return current < N;
    }

    public Item next()
    {
      return ramdonBag[current++];
    }
  
    public void remove() {}
  }

  public static void main(String[] args)
  {
    RandomBag<Integer> rbag = new RandomBag<Integer>();
    rbag.add(1); rbag.add(2); rbag.add(3); rbag.add(4); rbag.add(5);

    for (Integer i : rbag)
    {
      StdOut.print(i + " ");
    }
    StdOut.println();
  }
}
