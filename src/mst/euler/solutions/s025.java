package mst.euler.solutions;

import mst.euler.Solution;

import java.math.BigInteger;

public class s025 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s025().run());
    }

    @Override
    public String solve() {
        return String.valueOf(firstFibb(1_000));
    }

    private int firstFibb(int digits) {
        BigInteger n= BigInteger.ONE, n1= BigInteger.ONE, n2;
        int counter=2;
        while (n.toString().length() < digits)
        {
            n2=n1;
            n1=n;
            counter++;
            n=n1.add(n2);
        }
        return counter;
    }
}
