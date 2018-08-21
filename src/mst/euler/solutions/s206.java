package mst.euler.solutions;

import static java.lang.Math.sqrt;

import java.util.Arrays;
import java.util.List;
import mst.euler.Solution;

public class s206 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s206().run());
  }

  private final String MASK = "1_2_3_4_5_6_7_8_9_0";

  @Override
  public String solve() {
    long minI = (long) sqrt(Long.parseLong(MASK.replace("_", "0")))/10*10;
    long maxI = (long) (sqrt(Long.parseLong(MASK.replace("_", "9")))+1)/10*10;
    long i=maxI;
    while (i > minI) {
      if (maskMatch(String.valueOf(i * i), MASK)) {
        break;
      }
      i-=10;
    }
    return String.valueOf(i);
  }

  private boolean maskMatch(String val, String mask) {
    List<String> v = Arrays.asList(val.split(""));
    List<String> m = Arrays.asList(mask.split(""));
    for (int i = 0; i<v.size(); i+=2) {
      if (!v.get(i).equals(m.get(i))) {
        return false;
      }
    }
    return true;
  }
}
