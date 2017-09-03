/***
 * 等值键
 */

import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ex29
{
  public static int bs(int[] whitelist, int key)
  {
    int len = whitelist.length;
    int lo = 0;
    int hi = len-1;

    while (lo <= hi) {
      int mid = lo + (hi - lo)/2;
      if (whitelist[mid] == key) { return mid; }
      else if (whitelist[mid] < key) { lo = mid+1; }
      else if (whitelist[mid] > key) { hi = mid-1; }
    }
    return -1;
  }

  public static int rank(int[] whitelist, int key)
  {
    int num = 0;
    int pos = bs(whitelist, key);
    if (pos == -1) { return -1; }
    for (int i = 0; i < pos; i++) {
      if (whitelist[i] == whitelist[pos]) {
        return i;
      }
    }
    return pos;
  }

  public static int count(int[] whitelist, int key)
  {
    int num = 0;
    int startpos = rank(whitelist, key);
    if (startpos == -1) { return 0; }
    for (int i = startpos; i < whitelist.length; i++) {
      if (whitelist[i] == key) { num++; }
    }
    return num;
  }

  public static void main(String[] args)
  {
    int[] whitelist = In.readInts(args[0]); // 从文件中读取白名单
    Arrays.sort(whitelist);
    int num = rank(whitelist, 20);
    StdOut.println(num);
    StdOut.println(count(whitelist, 20));
  }
}
