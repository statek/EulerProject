package mst.euler.solutions;

import mst.euler.Solution;

import java.util.Arrays;

import static java.lang.Math.sqrt;

public class s094 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s094().run());
    }

    private final long N = 1_000_000_000;

    @Override
    public String solve() {
        long sumP = 0, p = 0;
        for (long i = 2; p < N; i++) {
            for (int m : Arrays.asList(-1, 1)) {
                p = i + i + i + m;
                if (isAreaIntegral(i + m, i)) {
                    sumP += p;
                }
            }
        }
        return String.valueOf(sumP);
    }

    private boolean isAreaIntegral(long a, long b) {
        if (a % 2 == 1) return false;
        long h2 = b * b - a * a / 4;
        long h = (long) sqrt(h2);
        return h2 == h * h;
    }
}
