import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;


public class WQUUF
{
  private int[] id;
  private int[] size;
  private int count;

  WQUUF(int N)
  {
    /* 构造存储UnionFind节点的数据结构 */
    count = N;  /* 初始状态下各自为营 */
    id = new int[N];
    size = new int[N];
    for (int i = 0; i < N; i++)
    {
      id[i] = i;
      size[i] = 0;
    }
  }

  public int count()
  {
    return count;
  }

  void union(int p, int q)
  {
    /* 连接p, q两个节点 */
    // O(树的高度)
    int pid = find(p);
    int qid = find(q);
    int qsize = size[q];
    int psize = size[p];

    if (pid == qid)
    {
      return;
    }
    // 接近O(logN)
    if (qsize > psize)
    {
      id[pid] = qid;
      size[q] = size[q] + 1;
    }
    else
    {
      id[qid] = pid;
      size[p] = size[p] + 1;
    }
    count--;
  }

  int find(int p)
  {
    /* 找出p所在分量簇的id */
    // O(树的高度)
    int i = p;
    for (; i != id[i]; i = id[i])
                  {
                  }
    return i;
  }

  boolean connected(int p, int q)
  {
    /* 判断两个节点p, q是否相连 */
    return (find(p) == find(q));
  }

  public static void main(String[] args)
  {
    int N = StdIn.readInt();
    WQUUF ufo = new WQUUF(N);

    while (!StdIn.isEmpty())
    {
      int p = StdIn.readInt();
      int q = StdIn.readInt();
      if (ufo.connected(p, q)) continue;
      ufo.union(p, q);
      StdOut.println(p + "(" + ufo.find(p) + ")" + "~" + q + "(" + ufo.find(q) + ")");
    }
    StdOut.println(ufo.count());
  }
}
