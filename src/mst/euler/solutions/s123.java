package mst.euler.solutions;

import static mst.euler.Lib.isPrime;

import java.math.BigInteger;
import mst.euler.Solution;

public class s123 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s123().run());
  }

  private final long R = 10_000_000_000l;
  private long r = R;

  public void setR(long r) {
    this.r = r;
  }

  @Override
  public String solve() {
    long p = 3;
    long n = 2;
    long reminder = 0;
    while (reminder < r) {
      if (isPrime(p)) {
        n++;
        if (n % 2 == 0) {
          reminder = p * (2 * n % p);
        }
      }
      p += 2;
    }
    return String.valueOf(n-1);
  }

}
