package mst.euler.solutions;

import mst.euler.Solution;
import mst.euler.utils.Fraction;
import mst.euler.utils.SquareRootContinuedFraction;

import java.math.BigInteger;

import static java.lang.Math.sqrt;

public class s066 extends Solution {
    // based on Pell's equation solution via continued fractions
    public static void main(String[] args) {
        System.out.println(new s066().run());
    }

    private final int D = 1000;

    @Override
    public String solve() {

        int resultD = 0;
        BigInteger maxX=BigInteger.ZERO;
        for (int d = 1; d < D; d++) {
            if (sqrt(d)==(long)sqrt(d)) continue;
            BigInteger x = BigInteger.ONE, y = BigInteger.ONE;
            int i = 1;
            while (x.pow(2).subtract(y.pow(2).multiply(BigInteger.valueOf(d))).compareTo(BigInteger.ONE) != 0) {
                SquareRootContinuedFraction srcf = new SquareRootContinuedFraction(d);
                Fraction f = srcf.getFraction(i);
                x = f.getN();
                y = f.getD();
                i++;
            }
            if (x.compareTo(maxX)>0){
                maxX=x;
                resultD=d;
            }
        }
        return String.valueOf(resultD);
    }
}


