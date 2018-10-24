package mst.euler.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javafx.util.Pair;
import mst.euler.Solution;

public class s504 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s504().run());
  }

  private final int M = 100;
  private int m = M;
  private Map<Pair<Integer, Integer>, Integer> trianglePointsMap = new HashMap<>();
  private Set<Integer> squares = new HashSet<>();
  int ways = 0;
  int squareWays = 0;

  public int getWays() {
    return ways;
  }

  @Override
  public int hashCode() {
    return Objects.hash(1);
  }

  public void setM(int m) {
    this.m = m;
  }

  @Override
  public String solve() {
    calculateSquares();
    findWays();
    return String.valueOf(squareWays);
  }

  private void calculateSquares() {
    int c = 1, c2 = 1;
    while (c2 < 2 * m * 2 * m) {
      squares.add(c2);
      c++;
      c2 = c * c;
    }
  }

  public int findWays() {
    int p0 = 1;
    for (int a = 1; a <= m; a++) {
      int pa = a - 1;
      for (int b = 1; b <= m; b++) {
        int pb = b - 1;
        int p1 = calculatePoints(a, b);
        for (int c = 1; c <= m; c++) {
          int pc = c - 1;
          int p2 = calculatePoints(b, c);
          for (int d = 1; d <= m; d++) {
            int pd = d - 1;
            int p3 = calculatePoints(c, d);
            int p4 = calculatePoints(d, a);
            int containPoints = pa + pb + pc + pd + p0 +
                p1 + p2 + p3 + p4;

            if (squares.contains(containPoints)) {
              squareWays++;
            }
            ways++;
          }
        }
      }
    }
    return ways;
  }

  private int calculatePoints(int a, int b) {
    Pair<Integer, Integer> pair = new Pair<>(a, b);
    if (!trianglePointsMap.containsKey(pair)) {
      int points = 0;
      for (double i = 1; i < a; i++) {
        double p = i * -b / a + b;
        points += (p == Math.floor(p)) ? (int) p - 1 : (int) p;
      }
      trianglePointsMap.put(pair, points);
      trianglePointsMap.put(new Pair<>(b, a), points);
    }
    return trianglePointsMap.get(pair);
  }
}
