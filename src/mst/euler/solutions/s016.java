package mst.euler.solutions;

import mst.euler.Solution;

import java.math.BigInteger;

import static mst.euler.Lib.sumDigits;

public class s016 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s016().run());
    }

    @Override
    public String solve() {
        return String.valueOf(sumDigits(new BigInteger("2").pow(1_000).toString()));
    }
}
