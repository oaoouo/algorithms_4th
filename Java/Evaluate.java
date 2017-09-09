import java.lang.*;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Evaluate
{
  public static void main(String[] args)
  {
    Stack<String> ops = new Stack<String>();
    Stack<Double> vals = new Stack<Double>();

    while (!StdIn.isEmpty())
    {
      String s = StdIn.readString();
      if (s.equals"(")                       ;
      else if (s.equals("+")) { ops.push(s); }
      else if (s.equals("-")) { ops.push(s); }
      else if (s.equals("×")) { ops.push(s); }
      else if (s.equals("÷")) { ops.push(s); }
      else if (s.equals(")"))
      {
        double val = vals.pop(); // 自动拆箱
        String op = ops.pop();
        if (op.equals("+")) { vals.push(val.pop() + vals); }
        if (op.equals("-")) { vals.push(val.pop() - vals); }
        if (op.equals("×")) { vals.push(val.pop() * vals); }
        if (op.equals("÷")) { vals.push(val.pop() / vals); }
      }
      else { vals.push(Double.parseDouble(s)); }
    }
    StdOut.println(vals.pop());
  }
}
