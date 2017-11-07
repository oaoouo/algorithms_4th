import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class LLST<KEY, VAL>
{
  private Node first;  // 链表首节点, 插入新的键操作在首节点完成

  private class Node
  {
    KEY key;  // 存储键
    VAL val;  // 存储值
    Node next;  // 指向下一个链表的链接

    Node(KEY key, VAL val, Node next)
    {
      this.key = key;
      this.val = val;
      this.next = next;
    }
  }

  public void put(KEY key, VAL val)
  {
    // 向符号表中插入键值对
    for (Node x = first; x != null; x = x.next)
    {
      if (key.equals(x.key))  // equals不能是==
      {
        x.val = val;
        return;  // key 不重复
      }
    }
    // 将新的节点插入链表的表头 
    first = new Node(key, val, first);
    return;
  }

  public VAL get(KEY key)
  {
    // 在符号表中查询键值
    for (Node x = first; x != null; x = x.next)
    {
      if (key.equals(x.key))
      {
        return x.val;
      }
    }
    return null;
  }

  public boolean contains(KEY key)
  {
    // 符号表中是否包含键key
    for (Node x = first; x != null; x = x.next)
    {
      if (key.equals(x.key))
      {
        return true;
      }
    }
    return false;
  }

  public Iterable<KEY> keys()
  {
    ResizingArrayStack<KEY> stack = new ResizingArrayStack<KEY>();
    for (Node x = first; x != null; x = x.next)
    {
      stack.push(x.key);
    }
    return stack;
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
