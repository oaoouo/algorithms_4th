import java.util.Arrays;
import java.lang.Double;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class ex33
{
    public static double dot(double[] x, double[] y)
    {
      // 向量点乘, 返回一个值
      double sum = 0.0;
      int lenx = x.length;
      int leny = y.length;
      if (lenx != leny) {
        return Double.POSITIVE_INFINITY;
      }
      for (int i = 0; i < lenx; i++) {
        sum += x[i]*y[i];
      }
      return sum;
    }

    public static double[][] mult(double[][] a, double[][] b)
    {
      // 矩阵相乘
      int N = a.length;
      double[][] res = new double[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          for (int k = 0; k < N; k++) {
            res[i][j] = a[i][k] + a[k][j];
          }
        }
      }
      return res;
    }

    public static void main(String[] args)
    {
      StdOut.println("------ test dot ------");
      double[] x = {1, 2, 3, 4};
      double[] y = {2, 3, 4, 5};
      double sum = dot(x, y);
      if (sum != Double.POSITIVE_INFINITY) {
        StdOut.println(sum);
      } else {
        StdOut.println("can't dot!");
      }

      StdOut.println("------ test mult ------");
      double[][] a = new double[2][2];
      double[][] b = new double[2][2];
      double[][] res = new double[2][2];
      for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
          a[i][j] = 1;
          b[i][j] = 2;
        }
      }
      res = mult(a, b);
      for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
          StdOut.print(res[i][j] + " ");
        }
        StdOut.print("\n");
      }
    }
}
