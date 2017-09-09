import java.lang.*;
import edu.princeton.cs.algs4.StdOut;


public class Rational
{
  // 不可变抽象数据类型
  private final int numerator;
  private final int denominator;
  private static int MAX = 2147483647;
  private static int MIN = -2147483647;

  private int gcd(int a, int b)
  {
    // 求a, b的最大公约数(a > b)
    if (b == 0) { return a; }
    return gcd(b, a % b);
  }

  private boolean isPlusOverflow(int a, int b)
  {
    // 判断加法是否会产生溢出
    return a >= 0 ? a + b < MAX : a + b > MIN;
  }

  private boolean isTimesOverflow(int a, int b)
  {
    // 判断乘法是否会产生溢出
    if (a < 0) { a = -a; }
    if (b < 0) { b = -b; }
    if (a == 0 || b == 0) { return false; }
    else {
        return a * b < MAX;
    }
  }

  public Rational(int numerator, int denominator)
  {
    // 在构造的时候对分子分母进行约分
    if (denominator == 0) {
      // 分母不能为0
      throw new ArithmeticException("Divide by Zero");
    }
    int gcdi = gcd(denominator, numerator);
    this.denominator = denominator / gcdi;
    this.numerator = numerator / gcdi;
  }

  public Rational plus(Rational b)
  {
    // 有理数加法
    assert isPlusOverflow(this.numerator * b.denominator, this.denominator * b.numerator) : "Plus Overflow";
    assert isTimesOverflow(this.denominator, b.denominator) : "Times Overflow";
    int new_denominator = this.denominator * b.denominator;
    int new_numerator = this.numerator * b.denominator + this.denominator * b.numerator;
    Rational r = new Rational(new_numerator, new_denominator);
    return r;
  }

  public Rational minus(Rational b)
  {
    // 有理数减法
    Rational minus_b = new Rational(b.numerator, -(b.denominator));
    return plus(minus_b);
  }

  public Rational times(Rational b)
  {
    // 有理数乘法
    assert isTimesOverflow(this.denominator, b.denominator) : "Times Overflow";
    assert isTimesOverflow(this.numerator, b.numerator) : "Times Overflow";
    int new_denominator = this.denominator * b.denominator;
    int new_numerator = this.numerator * b.numerator;
    Rational r = new Rational(new_numerator, new_denominator);
    return r;
  }

  public Rational divides(Rational b)
  {
    // 有理数乘法
    Rational reciprocal_b = new Rational(b.denominator, b.numerator);
    return times(reciprocal_b);
  }

  public boolean equals(Rational that)
  {
    // 判断两个有理数相等
    return (this.denominator == that.denominator) && (this.numerator == that.numerator);
  }

  public String toString()
  {
    return this.numerator + "/" + this.denominator;
  }

  public static void main(String[] args)
  {
    Rational test_a = new Rational(655350, 655343);
    Rational test_b = new Rational(65535, 65534);
    StdOut.println("test_a: " + test_a);
    StdOut.println("test_b: " + test_b);

    StdOut.println("test_a + test_b = " + test_a.plus(test_b));
    StdOut.println("test_a - test_b = " + test_a.minus(test_b));
    StdOut.println("test_a x test_b = " + test_a.times(test_b));
    StdOut.println("test_a ÷ test_b = " + test_a.divides(test_b));
    StdOut.println("test_a = test_b -> " + test_a.equals(test_b));
  }
}
