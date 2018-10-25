package mst.euler.solutions;

import mst.euler.Solution;

public class s145 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s145().run());
  }

  private final int N = 1_000_000_000;
  private int n = N;
  private int reversibleCount = 0;


  public void setN(int n) {
    this.n = n;
  }

  @Override
  public String solve() {
    for (int i = 1; i < n; i++) {
      if (i % 10 == 0) {
        continue;
      }
      int ri = reverse(i);
      if (countainsOddsOnly(i + ri)) {
        reversibleCount++;
      }
    }
    return String.valueOf(reversibleCount);
  }

  private boolean countainsOddsOnly(int i) {
    while (i > 0) {
      if (i % 2 == 0) {
        return false;
      } else {
        i = i / 10;
      }
    }
    return true;
  }

  private Integer reverse(int i) {
    int j = 0;
    while (i > 0) {
      j *= 10;
      j += i % 10;
      i /= 10;
    }
    return j;
  }
}
