import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;


public class UF
{
  private int[] id;
  private int count;

  UF(int N)
  {
    /* 构造存储UnionFind节点的数据结构 */
    count = N;  /* 初始状态下各自为营 */
    id = new int[N];
    for (int i = 0; i < N; i++)
    {
      id[i] = i;
    }
  }

  public int count()
  {
    return count;
  }

  void union(int p, int q)
  {
    /* 连接p, q两个节点 */
    int pid = find(p);
    int qid = find(q);

    if (pid == qid)  return;

    for (int i = 0; i < id.length; i++)
    {
      // O(N)
      if (id[i] == qid)
      {
        id[i] = pid;
      }
    }
    count--;
  }

  int find(int p)
  {
    /* 找出p所在分量簇的id */
    // O(1)
    return id[p];
  }

  boolean connected(int p, int q)
  {
    /* 判断两个节点p, q是否相连 */
    return (find(p) == find(q));
  }

  public static void main(String[] args)
  {
    int N = StdIn.readInt();
    UF ufo = new UF(N);

    while (!StdIn.isEmpty())
    {
      int p = StdIn.readInt();
      int q = StdIn.readInt();
      if (ufo.connected(p, q)) continue;
      ufo.union(p, q);
      StdOut.println(p + "~" + q);
    }
    StdOut.println(ufo.count());
  }
}
