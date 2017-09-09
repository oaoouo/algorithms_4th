import java.lang.*;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


public class ex15
{
  // static: 直接被类调用
  public static int[] readInts(String name)
  {
    In in = new In(name);
    // input 输入字符串
    String input = in.readAll();
    // "\\s+" 表示所有制表符
    String[] words = input.split("\\s+");
    int[] ints = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      ints[i] = Integer.parseInt(words[i]);
    }
    return ints;
  }

  public static void main(String[] args)
  {
    int[] ints = readInts(args[0]);
    for (int i = 0; i < ints.length; i++) {
      StdOut.println(ints[i]);
    }
  }
}
