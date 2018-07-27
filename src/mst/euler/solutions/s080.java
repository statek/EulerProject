package mst.euler.solutions;

import mst.euler.Solution;

import java.math.BigInteger;

import static java.lang.Math.sqrt;
import static mst.euler.Lib.sumDigits;

public class s080 extends Solution {

    private final int N = 100;

    public static void main(String[] args) {
        System.out.println(new s080().run());
    }

    @Override
    public String solve() {
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += squareRootDigitsSum(i);
        }
        return String.valueOf(sum);
    }

    private long squareRootDigitsSum(int n) {
        if (sqrt(n) == (int) sqrt(n)) return 0;
        StringBuilder sb = new StringBuilder();
        String base = String.valueOf(n).length() % 2 == 1 ? "0" + String.valueOf(n) : String.valueOf(n);
        BigInteger c, r = BigInteger.ZERO, p = BigInteger.ZERO, y, x;
        int i = 0, dx;
        while (sb.length() < 100) {
            c = BigInteger.ZERO;
            if (i + 2 <= base.length()) {
                c = BigInteger.valueOf(Integer.parseInt(base.substring(i, i + 2)));
            }
            i += 2;
            c = r.multiply(BigInteger.TEN).multiply(BigInteger.TEN).add(c);
            dx = 0;
            y = BigInteger.ZERO;
            while (y.compareTo(c) <= 0) {
                dx++;
                x = BigInteger.valueOf(dx);
                y = p.add(p).multiply(BigInteger.TEN).add(x).multiply(x);
            }
            dx--;
            x = BigInteger.valueOf(dx);
            y = p.add(p).multiply(BigInteger.TEN).add(x).multiply(x);
            sb.append(x);
            p = p.multiply(BigInteger.TEN).add(x);
            r = c.subtract(y);
        }
        System.out.println(n+"\t"+sb+"\t"+sumDigits(sb.toString()));
        return sumDigits(sb.substring(sb.indexOf(".")+1));
    }
}
