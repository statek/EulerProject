package mst.euler.solutions;

import mst.euler.Solution;

import java.util.*;

import static mst.euler.Lib.prepareSieve;

public class s047 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s047().run());
    }

    @Override
    public String solve() {
        sieve = new ArrayList<>();
        sieve.addAll(prepareSieve(200_000));
        long i = 0;
        while (true) {
            i++;
            if (
                    numberOfPrimeFactors(i) == 4 &&
                    numberOfPrimeFactors(i + 1) == 4 &&
                    numberOfPrimeFactors(i + 2) == 4 &&
                    numberOfPrimeFactors(i + 3) == 4) {
                return String.valueOf(i);
            }
        }
    }

    private List<Long> sieve;

    private int numberOfPrimeFactors(long num) {
        Set<Long> primeDividors = new TreeSet<>();
        if (num > sieve.get(sieve.size() - 1)) {
            sieve = new ArrayList<>();
            sieve.addAll(prepareSieve(num * 10));
            Collections.sort(sieve);
        }
        for (long p : sieve) {
            if (num % p == 0) primeDividors.add(p);
            if (num / 2 < p) break;
        }
        return primeDividors.size();
    }
}
