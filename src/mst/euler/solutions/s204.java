package mst.euler.solutions;

import static mst.euler.Lib.prepareSieve;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import mst.euler.Solution;

public class s204 extends Solution {

    private Long max = 1_000_000_000l;
    private Long p = 100l;
    private Set<Long> hammingNumbers = new HashSet();

    public static void main(String[] args) {
        System.out.println(new s204().run());
    }

    @Override
    public String solve() {

        final Deque<Long> primes = new ArrayDeque<>(prepareSieve(p));
        generateHammingNumbers(1, primes);

        return String.valueOf(hammingNumbers.size());
    }

    private void generateHammingNumbers(final long hn, final Deque<Long> primes) {
        if (hn > max) {
            return;
        }
        hammingNumbers.add(hn);
        if (primes.size() > 0) {
            final Long prime = primes.pop();
            for (long i = hn; i <= max; i *= prime) {
                generateHammingNumbers(i, new ArrayDeque<>(primes));
            }
        }
    }

    public void setP(final long p) {
        this.p = p;
    }

    public void setMax(final long max) {
        this.max = max;
    }
}
