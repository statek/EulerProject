package mst.euler.solutions;

import static mst.euler.Lib.isPandigital;
import static mst.euler.Lib.sumDigits;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import mst.euler.Solution;

public class s104 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s104().run());
  }


  @Override
  public String solve() {
    long n = 2l;
    BigInteger fn;
    List<BigInteger> fnEnd = new ArrayList<>();
    List<BigInteger> fnFront = new ArrayList<>();
    fnEnd.add(BigInteger.ONE);
    fnEnd.add(BigInteger.ONE);
    fnFront.add(BigInteger.ONE);
    fnFront.add(BigInteger.ONE);
    String fnE = "99", fnF ="99";
    while (!(
        String.valueOf(fnEnd.get(1)).length()>=9
        && isPandigital(String.valueOf(fnE))
        && isPandigital(String.valueOf(fnF))
    ))
    {
      n++;
      fn = fnEnd.get(0).add(fnEnd.get(1));
      fn = fn.mod(BigInteger.TEN.pow(9));
      fnEnd.add(fn);
      fnEnd.remove(0);
      fnE = fn.toString();

      fn = fnFront.get(0).add(fnFront.get(1));
      fnFront.add(fn);
      fnFront.remove(0);
      if (fn.compareTo(BigInteger.TEN.pow(15)) > 0) {
        fnFront.add(fnFront.get(0).divide(BigInteger.TEN));
        fnFront.add(fnFront.get(1).divide(BigInteger.TEN));
        fnFront.remove(0);
        fnFront.remove(0);
      }
      fnF = fn.toString().substring(0,fn.toString().length()>9 ? 9 : fn.toString().length());
    }
    return String.valueOf(n);
  }
}
