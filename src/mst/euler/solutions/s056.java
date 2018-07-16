package mst.euler.solutions;

import mst.euler.Solution;

import java.math.BigInteger;

import static mst.euler.Lib.sumDigits;

public class s056 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s056().run());
    }

    @Override
    public String solve() {
        int maxSum = 0;
        int tmpSum;
        for (int a = 1; a <= 100; a++) {
            for (int b = 1; b <= 100; b++) {
                tmpSum = sumDigits(BigInteger.valueOf(a).pow(b).toString());
                if (tmpSum > maxSum) {
                    maxSum = tmpSum;
                }
            }
        }
        return String.valueOf(maxSum);
    }
}