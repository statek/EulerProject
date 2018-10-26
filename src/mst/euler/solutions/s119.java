package mst.euler.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static mst.euler.Lib.sumDigits;
import mst.euler.Solution;

public class s119 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s119().run());
  }

  private final int N = 30;
  private int n = N;
  List<Long> a = new ArrayList<>();

  public void setN(int n) {
    this.n = n;
  }

  public long getA(int n) {
    return a.get(n);
  }

  @Override
  public String solve() {
    a.add(0l);
    long p = 1;
    while (p<100) {
      p++;
      long pn = p;
      while (pn<=Long.MAX_VALUE/p){
        pn*=p;
        long s = sumDigits(pn);
        if(s==p) {
          a.add(pn);
        }
      }
    }
    Collections.sort(a);
    return String.valueOf(a.get(n));
  }
}
