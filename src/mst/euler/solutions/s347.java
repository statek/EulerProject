package mst.euler.solutions;

import static java.lang.Math.sqrt;
import static mst.euler.Lib.prepareSieve;

import java.util.HashSet;
import java.util.Set;
import mst.euler.Solution;

public class s347 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s347().run());
  }

  private static final long MAX = 10_000_000l;

  @Override
  public String solve() {
    long sum = 0;
    Set<Long> sieve = prepareSieve(MAX);
    for (long p : sieve) {
      if (p > sqrt(MAX)) {
        break;
      }
      for (long q : sieve) {
        if (p < q) {
          sum += m(p, q);
        }
      }
    }
    return String.valueOf(sum);
  }


  public long m(long p, long q) {
    long base = p * q;
    long max = 0;
    if (base <= MAX) {
      Set<Long> m = new HashSet<>();
      long mp = base;
      while (mp <= MAX) {
        m.add(mp);
        mp *= p;
      }
      Set<Long> pm = new HashSet<>(m);
      for (long pmv : pm) {
        long mq = pmv;
        while (mq <= MAX) {
          m.add(mq);
          mq *= q;
        }
      }
      max = m.stream().mapToLong(Long::longValue).max().getAsLong();
    }
    return max;
  }

}
