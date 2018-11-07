package mst.euler.solutions;

import java.math.BigInteger;
import mst.euler.Solution;

public class s123 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s123().run());
  }

  private final BigInteger R = BigInteger.TEN.pow(10);
  private BigInteger r = R;

  public void setR(BigInteger r) {
    this.r = r;
  }

  @Override
  public String solve() {
    BigInteger reminder = BigInteger.ZERO;
    BigInteger p = BigInteger.ONE.add(BigInteger.ONE);
    int n = 1;
    while (reminder.subtract(r).signum() < 0) {
      p = p.nextProbablePrime();
      n++;
      if (p.pow(2).subtract(r).signum() < 0) {
        continue;
      }
      reminder = p.subtract(BigInteger.ONE).pow(n).add(p.add(BigInteger.ONE).pow(n)).mod(p.pow(2));
    }

    return String.valueOf(n);
  }

}
