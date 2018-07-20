package mst.euler.solutions;

import mst.euler.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static mst.euler.Lib.prepareSieve;

public class s070 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s070().run());
    }

    final long N = 10_000_000L;

    private List<Long> sieve;
    private long finalN = 1;
    private double minPhiFactor = Double.MAX_VALUE;

    @Override
    public String solve() {
        sieve = new ArrayList<>(prepareSieve((long) pow(10d,String.valueOf((long)sqrt(N)).length())));
        Collections.reverse(sieve);
        findMinN(1, 1, 1);
        return String.valueOf(finalN);
    }

    private void findMinN(long n, long phi, long maxPrime) {
        for (long prime : sieve) {
            if (prime < maxPrime) continue;
            if (n * prime > N) continue;
            findMinN(n * prime, phi * (prime - 1), prime);
        }
        if (n == 1 || sieve.contains(n)) return;
        double tmpPhiFactor = (double) n / phi;
        if (tmpPhiFactor < minPhiFactor && isPermutation(n, phi)) {
            minPhiFactor = tmpPhiFactor;
            finalN = n;
        }
    }

    private boolean isPermutation(Long l1, Long l2) {
        List<String> s1 = new ArrayList<>(Arrays.asList(l1.toString().split("")));
        List<String> s2 = new ArrayList<>(Arrays.asList(l2.toString().split("")));
        Collections.sort(s1);
        Collections.sort(s2);
        return s1.equals(s2);
    }
}
