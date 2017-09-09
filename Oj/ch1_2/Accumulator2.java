import java.lang.*;
import edu.princeton.cs.algs4.StdOut;


public class Accumulator2
{
  private double total;
  private int N;

  public void addDataValue(double val)
  {
    N++;
    total += val;
  }

  public double mean()
  {
    return total / N;
  }
}
