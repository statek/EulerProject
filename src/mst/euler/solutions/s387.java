package mst.euler.solutions;

import static mst.euler.Lib.isPrime;
import static mst.euler.Lib.sumDigits;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import mst.euler.Solution;

public class s387 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s387().run());
  }

  private final long MAX = 100_000_000_000_000l;
//  private final long MAX = 10_000l;

  Set<Long> harshads = new HashSet<>();

  @Override
  public String solve() {
    long sum = 0;
    for (long i = 10; i < 100; i++) {
      if (isHarshad(i)) {
        harshads.add(i);
      }
    }
    int hDigits = 3;
    while (hDigits < String.valueOf(MAX).length()-1) {
      HashSet<Long> nDigitHarshards = new HashSet<>();
      for (long h : harshads) {
        if (String.valueOf(h).length() < hDigits-1) {
          continue;
        }
        for (long d = 0; d < 10; d++) {
          if (isHarshad(h * 10 + d)) {
            nDigitHarshards.add(h * 10 + d);
          }
        }
      }
      harshads.addAll(nDigitHarshards);
      hDigits++;
    }

    Set<Long> strongHarshads = harshads.stream()
        .filter(h -> isPrime(h / sumDigits(String.valueOf(h)))).collect(Collectors.toSet());

    for (long h : strongHarshads) {
      for (long d = 0; d < 10; d++) {
        if (isPrime(h * 10 + d)) {
          sum += h * 10 + d;
        }
      }
    }

    return String.valueOf(sum);
  }

  private boolean isHarshad(long num) {
    boolean isHarshad = true;
    if (num > 10 && !harshads.contains(num)) {
      int digitSum = sumDigits(String.valueOf(num));
      isHarshad &= num % digitSum == 0;
      isHarshad &= isHarshad(num / 10);
    }
    return isHarshad;
  }

  private boolean isStrongHarshad(long num) {
    boolean isStrongHarshad = true;
    if (num > 0) {
      int digitSum = sumDigits(String.valueOf(num));
      isStrongHarshad &= num % digitSum == 0;
      isStrongHarshad &= isPrime(num / digitSum);
      isStrongHarshad &= isHarshad(num / 10);
    }
    return isStrongHarshad;
  }
}
