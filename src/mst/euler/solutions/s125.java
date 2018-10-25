package mst.euler.solutions;

import static mst.euler.Lib.isPalindrome;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mst.euler.Solution;

public class s125 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s125().run());
  }

  private final int N = 100_000_000;
  private int n = N;
  private List<Long> squares = new ArrayList<>();
  private Set<Long> consSums = new HashSet<>();

  public void setN(int n) {
    this.n = n;
  }

  @Override
  public String solve() {
    calculateSquares();
    calculateConsecutiveSums();
    return String.valueOf(
        consSums.stream().filter(s -> isPalindrome(String.valueOf(s))).mapToLong(Long::longValue)
            .sum());
  }

  private void calculateConsecutiveSums() {
    for (int i = 0; i < squares.size() - 1; i++) {
      int j = i + 1;
      long sum = squares.get(i) + squares.get(j);
      while (sum < n) {
        consSums.add(sum);
        j++;
        if (j >= squares.size()) {
          break;
        }
        sum += squares.get(j);
      }
    }
  }


  private void calculateSquares() {
    long c = 1, c2 = 1;
    while (c2 < n) {
      squares.add(c2);
      c++;
      c2 = c * c;
    }
  }
}
