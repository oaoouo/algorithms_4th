import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class RandomQueue<Item> // implements Iterable<Item>
{
  Item[] rq;
  int size;

  private void resize(int max)
  {
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < size; i++)
    {
      temp[i] = rq[i];
    }
    rq= temp;
  }

  public RandomQueue()
  {
    // 构造函数
    rq = (Item[]) new Object[1];
  }

  public boolean isEmpty()
  {
    return size == 0;
  }

  public void enqueue(Item item)
  {    
    // 向数组尾部添加元素
    if (size == rq.length) 
    {
      resize(2 * rq.length);
    }
    rq[size++] = item;
  }

  public Item dequeue()
  {
    // 删除并随机返回一个元素
    // q[0] 与 [1-size)之间的随机元素交换
    int j = (int)((size-1)*StdRandom.random());
    Item temp;
    temp = rq[0];
    rq[0] = rq[j];
    rq[j] = temp;
    // 删除rq[0] 
    Item item = rq[0];
    for (int i = 0; i < size-1; i++)
    {
      rq[i] = rq[i+1];
    }
    rq[--size] = null;
    if (size == (1/4) * rq.length)
    {
      resize(rq.length / 2);
    }
    return item;
  }

  public Item sample()
  {
    // 随机取样不放回
    int j = (int)(size*StdRandom.random());
    return rq[j];
  }

  public static void main(String[] args)
  {
    RandomQueue<Integer> rqueue = new RandomQueue<Integer>();
    // test enqueue and dequeue
    rqueue.enqueue(1); rqueue.enqueue(2); rqueue.enqueue(3);
    rqueue.enqueue(4); rqueue.enqueue(5); rqueue.enqueue(6);
    for (int i = 0; i < 3; i++)
    {
      StdOut.print(rqueue.dequeue() + " ");
    }
    StdOut.println();
    // test sample;
    StdOut.println(rqueue.sample());
  }
}
