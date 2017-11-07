import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class ABST<KEY extends Comparable<KEY>, VAL>
{
  private KEY[] keys;
  private VAL[] vals;
  private int n;

  public ABST(int N)
  {
    // Java里面没有泛型数组, 需要进行类型转换
    keys = (KEY[]) new Comparable[N];
    vals = (VAL[]) new Object[N];
  }

  public int size()
  {
    return this.n;
  }

  private int rank(KEY key)
  {
    int lo = 0;
    int hi = n;
   
    while (lo < hi)
    {
      int mid = lo + (hi-lo)/2;
      int cmp = key.compareTo(keys[mid]);
      if (cmp == 0)
      {
        return mid;
      }
      else if (cmp > 0)
      {
        lo = mid + 1;
      }
      else
      {
        hi = mid - 1;
      }
    }
    return -1;
  }
 
  public VAL get(KEY key)
  {
    int i = this.rank(key);
    if (i != -1) 
    {
      return vals[i];
    }
    else 
    {
      return null;
    }
  }
  
  public void put(KEY key, VAL val)
  {
    int i = this.rank(key);
    if (i != -1)
    {
      vals[i] = val;
      return;
    }
    if (n == keys.length)
    {
      resize(2 * keys.length);
    }
    for (int j = n; j > i;j--)
    {
      keys[j] = keys[j-1];
      vals[j] = vals[j-1];
    }
    keys[i] = key; vals[i] = val;
    n++;
    return;
  }

  public boolean contains(KEY key)
  {
    int i = this.rank(key);
    if (i != -1)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  public Iterable<KEY> keys()
  {
    ResizingArrayStack<KEY> stack = new ResizingArrayStack<KEY>();
    for (int i = 0; i < n; i++)
    {
      stack.push(keys[i]);
    }
    return stack; 
  }

  private void resize(int max)
  {
    KEY[] tkeys = (KEY[]) new Comparable[max];
    VAL[] tvals = (VAL[]) new Object[max];
    for (int i = 0; i < keys.length; i++)
    {
      tkeys[i] = keys[i];
      tvals[i] = vals[i];
    }
    keys = tkeys;
    vals = tvals;
  }

  public static void main(String args[])
  {
    // 词频统计
    int minlen = Integer.parseInt(args[0]);  // 最小键长
    LLST<String, Integer> llst = new LLST<String, Integer>();

    while (!StdIn.isEmpty())
            {
      String word = StdIn.readString();  // 读取源文件中的词
      if (word.length() < minlen)
            {
        continue;  // 忽略较短的词
            }
      if (!llst.contains(word))
            {
        llst.put(word, 1);
            }
      else
            {
        llst.put(word, llst.get(word)+1) ;
            }
            }
    String max = " ";
    llst.put(max, 0);
    for (String word : llst.keys())
            {
      if (llst.get(word) > llst.get(max))
            {
        max = word;
            }
            }
    StdOut.println("max word: " + max + " frequency: " + llst.get(max));
  }
}
