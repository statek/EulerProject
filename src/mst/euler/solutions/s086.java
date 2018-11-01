package mst.euler.solutions;

import mst.euler.Solution;

public class s086 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s086().run());
  }

  private final long S = 1_000_000l;
  private long s = S;
  private long cuboidCount = 0;

  public void setS(long s) {
    this.s = s;
  }

  @Override
  public String solve() {
    long a = 0l;
    while (cuboidCount < s) {
      a++;
      for (long b = 1; b <= a; b++) {
        for (long c = 1; c <= b; c++) {
          Cuboid cub = new Cuboid(a,b,c);
          if (cub.shortestLine!=0) cuboidCount++;
        }
      }
    }
    return String.valueOf(a);
  }

  class Cuboid {

    long a, b, c;
    long shortestLine;

    Cuboid(long a, long b, long c) {
      this.a = a;
      this.b = b;
      this.c = c;
      double doubleShortestLine = findShortestLine();
      shortestLine =
          (Math.floor(doubleShortestLine) == doubleShortestLine) ? (long) doubleShortestLine : 0;
    }

    double findShortestLine() {
      double sl = findDiagonal(a, b + c);
      sl = Double.min(sl, findDiagonal(b, a + c));
      sl = Double.min(sl, findDiagonal(c, a + b));
      return sl;
    }

    double findDiagonal(double a, double b) {
      return Math.sqrt(a * a + b * b);
    }
  }
}
