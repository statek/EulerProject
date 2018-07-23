package mst.euler.solutions;

import mst.euler.Solution;
import mst.euler.utils.Fraction;

import java.util.*;

import static java.lang.Math.sqrt;
import static mst.euler.Lib.gcd;
import static mst.euler.Lib.isPrime;

public class s072 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s072().run());
    }

    private final int N = 1_000_000;

    @Override
    public String solve() {
        //phi(d) - Euler Totient function represents number of reduced proper fractions for defined d denominator
        List<Long> phiValues = new ArrayList<>();
        phiValues.add(0L);
        phiValues.add(0L);
        for (int n = 2; n <= N; n++) {
            long t = n-1;
            for (int d = 2; d <= sqrt(n); d++) {
                if (n % d == 0)
                {
                    t -= phiValues.get(d);
                    if(n/d!=d)
                        t -= phiValues.get(n/d);
                }
            }
            phiValues.add(t);
        }
        return String.valueOf(phiValues.stream().mapToLong(Long::longValue).sum());
    }
}
