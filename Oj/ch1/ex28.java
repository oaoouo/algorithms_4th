import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ex28
{
  public static void arrayrm(int[] array, int p)
  {
    // 删除array数组的第p个元素    
    for (int i = p; i < array.length-1; i++) {
      array[i] = array[i+1];
    }
  }

  public static int[] deldup(int[] whitelist)
  {
    int len = whitelist.length;
    for (int i = 0; i < len-1; i++) {
      if (whitelist[i] == whitelist[i+1]) {
        arrayrm(whitelist, i+1);
        len--;
      }
    }
    int[] delduplist = new int[len];
    for (int i = 0; i < len; i++) {
      delduplist[i] = whitelist[i];
    }
    return delduplist;
  }

  public static void main(String[] args)
  {
    int[] whitelist = In.readInts(args[0]); // 从文件中读取白名单
    Arrays.sort(whitelist);
    whitelist = deldup(whitelist);
    for (int i = 0; i < whitelist.length; i++) {
      StdOut.print(whitelist[i] + " ");
    }
    StdOut.println();
  }
}
