import edu.princeton.cs.algs4.StdOut;

public class ex27
{
  private static long cnt = 0;

  public static double binomial(int N, int k, double p)
  {
    /**
     * 这里使用递归的关键是一个二项分布计算公式
     * -- B(e=k)=C(N,k)*p^k*(1-p)^(N-k)
     * -- = (1-p)*C(N-1, k)*p^k*(1-p)^(N-1-k)
     *  + = p*C(N-1, k-1)*p^(k-1)*(1-p)^(N-k)
     */
    cnt++;
    if (N == 0 && k == 0) {
        return 1.0;   // 递归的结束条件
    }
    if (N < 0 || k < 0) {
        return 0.0;   // 递归的结束条件
    }
    return (1.0 - p)*binomial(N-1, k, p) + p*binomial(N-1, k-1, p);
  }

  public static double factorial(int n)
  {
    // 计算n的阶乘
    if (n == 1) { return 1; }
    return n*factorial(n-1);
  }

  public static double ex(double n, int k)
  {
    double res = 1.0;
    for (int i = 0; i < k; i++) {
      res *= n;
    }
    return res;
  }

  public static double C(int N, int k)
  {
    // 计算C(N, k) 
    return factorial(N) / (factorial(k)*factorial(N-k));
  }

  public static double betterBinomial(int N, int k, double p)
  {
    double x, y, z = 0.0;
    x = C(N, k);
    y = ex(p, k);
    z = ex(1-p, N-k);
    return x*y*z;
  }

  public static void main(String[] args) 
  {
    // 进行100次伯努利实验, 成功50次的概率
    // binomial(100, 50, 0.25); // 递归调用次数太多! (具体多少次?)
    // StdOut.println(cnt);
    double p = 0.0;
    p = betterBinomial(2, 1, 0.5);
    StdOut.println(p);
    p = betterBinomial(100, 50, 0.25);
    StdOut.println(p);
  }
}
