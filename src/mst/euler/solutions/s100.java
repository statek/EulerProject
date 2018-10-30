package mst.euler.solutions;

import java.math.BigInteger;
import mst.euler.Solution;

public class s100 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s100().run());
  }

  final BigInteger D = BigInteger.TEN.pow(12);
  final BigInteger TWO = BigInteger.ONE.add(BigInteger.ONE);
  BigInteger d = D;
  BigInteger b = BigInteger.TEN.pow(11);

  public void setD(BigInteger d) {
    this.d = d;
  }

  @Override
  public String solve() {
    BigInteger r = d.multiply(d.subtract(BigInteger.ONE));
    b = BigInteger.valueOf((long) Math.sqrt(r.doubleValue() / 2));
    BigInteger l = b.multiply(b.subtract(BigInteger.ONE)).multiply(TWO);
    while (l.compareTo(r) != 0) {
      //if (b.mod(BigInteger.TEN.pow(8)).equals(BigInteger.ZERO)) {
      //  System.out.println(LocalDate.now()+ "\t"+b + "\t" + d);
      //}
      if (l.compareTo(r) > 0) {
        d = d.add(BigInteger.ONE);
      } else {
        b = b.add(BigInteger.ONE);
      }
      l = b.multiply(b.subtract(BigInteger.ONE)).multiply(TWO);
      r = d.multiply(d.subtract(BigInteger.ONE));
    }
    return String.valueOf(b);
  }
}
