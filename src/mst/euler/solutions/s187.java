package mst.euler.solutions;

import static mst.euler.Lib.prepareSieve;

import java.util.Set;
import mst.euler.Solution;

public class s187 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s187().run());
  }

  private Set<Long> sieve;
  private final int N = 100_000_000;
  private int n = N;

  public void setN(int n) {
    this.n = n;
  }

  @Override
  public String solve() {
    sieve = prepareSieve(n / 2);
    long cnt = 0;
    int pcnt=0;
    for (long p1 : sieve) {
      System.out.print("\r"+100*pcnt++/sieve.size()+"%");
      for (long p2 : sieve) {
        if (p1 >= p2) {
          long sp = p1 * p2;
          if (sp <= n) {
            cnt++;
          }
        }
      }
    }
    return String.valueOf(cnt);
  }
}
