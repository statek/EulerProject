package mst.euler.solutions;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.util.HashSet;
import java.util.Set;
import mst.euler.Solution;

public class s346 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s346().run());
  }

  private static final long MAX = 1_000_000_000_000l;

  private Set<Long> repunits = new HashSet<>();

  @Override
  public String solve() {
    repunits.add(1l);
    for (long i = 2; i < sqrt(MAX); i++) {
      long j = 1;
      long p = 2;
      j += i + pow(i, p);
      p++;
      while (j < MAX) {
        repunits.add(j);
        j += pow(i, p);
        p++;
      }
    }

    return String.valueOf(
        repunits.stream().mapToLong(Long::longValue).sum());
  }


}
