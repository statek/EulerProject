package mst.euler.solutions;

import static mst.euler.Lib.prepareSieve;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import mst.euler.Solution;

public class s124 extends Solution {

  private Set<Long> sieve;

  public static void main(String[] args) {
    System.out.println(new s124().run());
  }

  private final int N = 100_000;
  private final int E =  10_000;
  private int n = N;
  private int pr = 0;
  private List<RadicalNumber> rnList = new ArrayList<>();

  public void setN(int n) {
    this.n = n;
  }

  public int getE(int i) {
    return rnList.get(i - 1).getN();
  }

  @Override
  public String solve() {
    sieve = prepareSieve(n);
    for (int i = 1; i <= n; i++) {
      if (100*i/n>pr){
        pr = 100*i/n;
        System.out.print("\r"+pr+"%");
      }
      rnList.add(new RadicalNumber(i));
    }
    Collections.sort(rnList);
    return String.valueOf(getE(E));
  }

  class RadicalNumber implements Comparable<RadicalNumber> {

    int n;
    int radicalProduct = 1;

    public int getN() {
      return n;
    }

    public int getRadicalProduct() {
      return radicalProduct;
    }

    RadicalNumber(int n) {
      this.n = n;
      calcRadicalProduct();
    }

    private void calcRadicalProduct() {
      for (long s : sieve) {
        if (n % s == 0) {
          radicalProduct *= s;
        }
      }
    }

    @Override
    public int compareTo(RadicalNumber o) {
      return (this.getRadicalProduct() == o.getRadicalProduct())
          ? this.getN() - o.getN()
          : this.getRadicalProduct() - o.getRadicalProduct();
    }

    public String toString() {
      return "rad(" + n + ")=" + radicalProduct;
    }
  }
}
