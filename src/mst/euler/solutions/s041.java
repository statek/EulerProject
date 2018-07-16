package mst.euler.solutions;

import mst.euler.Solution;

import java.math.BigInteger;

import static mst.euler.Lib.isPandigital;

public class s041 extends Solution {

    //Nine & eight digit numbers cannot be prime sum(1..9)=45 sum(1..8)=36 => both always dividable by 3)
    private Long maxValue = 7_654_321L;

    public static void main(String[] args) {
        System.out.println(new s041().run());
    }

    @Override
    public String solve() {
        BigInteger i;
        for (i = BigInteger.valueOf(maxValue); i.compareTo(BigInteger.ONE) > 0; i = i.add(BigInteger.ONE.negate())) {
            if (isPandigital(String.valueOf(i)) && i.isProbablePrime(10)) {
                break;
            }
        }
        return String.valueOf(i);
    }
}
