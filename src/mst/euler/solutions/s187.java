package mst.euler.solutions;

import static mst.euler.Lib.prepareSieve;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import mst.euler.Solution;

public class s187 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s187().run());
  }

  private List<Long> sieve;
  private final int N = 100_000_000;
  private int n = N;

  public void setN(int n) {
    this.n = n;
  }

  @Override
  public String solve() {
    sieve = new ArrayList<>(prepareSieve(n / 2));
    Collections.sort(sieve);
    long cnt = 0;
    int idx = sieve.size() - 1;
    for (int pi=0; pi<sieve.size(); pi++) {
      while (sieve.get(idx) > n / sieve.get(pi)) {
        idx--;
      }
      cnt += idx+1-pi;
      if(idx<=pi) break;
    }
    return String.valueOf(cnt);
  }
}
