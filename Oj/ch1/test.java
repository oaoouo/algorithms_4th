import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class test
{
  public static void main(String[] args)
  {
    double[][] m = new double[2][3]; // 2x3矩阵
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 3; j++) {
        m[i][j] = i+j-1; // 初始化矩阵
      }
    }

    double[][] n = new double[3][4]; // 3x4矩阵
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 4; j++) {
        n[i][j] = i+j-2; // 初始化矩阵
      }
    }

    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 3; j++) {
        StdOut.print(m[i][j] + " ");
      }
      StdOut.print("\n");
    }

    StdOut.println("-----------------");

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 4; j++) {
        StdOut.print(n[i][j] + " ");
      }
      StdOut.print("\n");
    }

    double[][] mn = new double[2][4];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 4; j++) {
        for (int k = 0; k < 3; k++) {
          mn[i][j] += m[i][k] * n[k][j];
        }
      }
    }

    StdOut.println("-----------------");

    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 4; j++) {
        StdOut.print(mn[i][j] + " ");
      }
      StdOut.print("\n");
    }
  }
}
