package mst.euler.solutions;

import mst.euler.Solution;

import java.math.BigInteger;
import java.util.Set;

import static mst.euler.Lib.prepareSieve;

public class s010 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s010().run());
    }

    @Override
    public String solve() {
        BigInteger sum = new BigInteger("0");
        Set<Long> sieve = prepareSieve(2_000_000L);
        for (long i : sieve) {
            sum = sum.add(BigInteger.valueOf(i));
        }
        return String.valueOf(sum);
    }
}
