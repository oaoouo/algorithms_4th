/***
 * 打乱数组
 */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

public class Shuffle
{
  public static void shuffle(double[] a)
  {
    // 打乱数组   
    double tmp = 0;
    for (int i = 0; i < a.length; i++) {
      // StdRandom.uniform()返回[0,1)间的随机整数
      // [i, alen)
      int j = i + (int)((a.length-i)*StdRandom.random());
      tmp = a[i];
      a[i] = a[j];
      a[j] = tmp;
    }
  }

  public static void main(String[] args) {
    double[] a = {1, 2, 3, 4, 5, 5, 6};
    shuffle(a);
    for (int i = 0; i < a.length; i++) {
      StdOut.println(a[i]);
    }
  }
}
