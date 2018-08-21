package mst.euler.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import mst.euler.Solution;

public class s112 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s112().run());
  }

  @Override
  public String solve() {
    long n = 100, bouncyCnt = 0;
    double ratio = 0;
    while (ratio < 0.99) {
      n++;
      if (isBouncyNumber(n)) {
        bouncyCnt++;
      }
      ratio = (double) bouncyCnt / n;
    }
    return String.valueOf(n);
  }

  private boolean isBouncyNumber(long num) {
    String numStr = String.valueOf(num);
    List<String> numDigits = new ArrayList<>(Arrays.asList(numStr.split("")));
    List<String> sortedNumDigits = new ArrayList<>(numDigits);
    Collections.sort(numDigits);
    boolean isBouncy = true;
    isBouncy &= !numDigits.equals(sortedNumDigits);
    Collections.reverse(sortedNumDigits);
    isBouncy &= !numDigits.equals(sortedNumDigits);
    return isBouncy;
  }
}
