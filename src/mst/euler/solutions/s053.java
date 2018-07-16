package mst.euler.solutions;

import mst.euler.Solution;

import java.math.BigInteger;

import static mst.euler.Lib.biFactorial;

public class s053 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s053().run());
    }

    @Override
    public String solve() {
        int count = 0;
        for (int n = 1; n <= 100; n++) {
            for (int r = 1; r <= n; r++) {
                if (countCombinatoricSelections(n, r).compareTo(BigInteger.TEN.pow(6))>0) {
                    count++;
                }
            }
        }
        return String.valueOf((count));
    }

    private BigInteger countCombinatoricSelections(long n, long r) {
        BigInteger tmp = biFactorial(n);
        tmp = tmp.divide(biFactorial(r));
        tmp = tmp.divide(biFactorial(n-r));
        return tmp;
    }
}