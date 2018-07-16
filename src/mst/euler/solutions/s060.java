package mst.euler.solutions;

import mst.euler.Solution;

import java.util.*;

import static mst.euler.Lib.isPrime;
import static mst.euler.Lib.prepareSieve;

public class s060 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s060().run());
    }

    private Set<Long> sieve;
    private Set<Long> bestPrimePairSet;
    private long minSum = Long.MAX_VALUE;

    @Override
    public String solve() {
        sieve = prepareSieve(10_000L);
        //findPrimePairSets(new TreeSet<>(), sieve, 4);
        findPrimePairSets(new TreeSet<>(), sieve, 5);
        return String.valueOf(minSum);
    }

    private void findPrimePairSets(Set<Long> primePairSet, Set<Long> filteredValues, int count) {
        long sum = primePairSet.stream().mapToLong(Long::longValue).sum();
        if (sum > minSum) return;
        if (count == 0) {
            minSum = sum;
            bestPrimePairSet = primePairSet;
            System.out.println("\t" + sum + "=" + primePairSet);
        } else {
            Set<Long> newFilteredValues;
            for (long p : filteredValues) {
                int counter = 0;
                newFilteredValues = new TreeSet<>();
                for (long pp : filteredValues) {
                    if (p >= pp) continue;
                    boolean isPrimePair;
                    isPrimePair = sieve.contains(Long.parseLong("" + pp + p)) || isPrime(Long.parseLong("" + pp + p));
                    isPrimePair &= sieve.contains(Long.parseLong("" + p + pp)) || isPrime(Long.parseLong("" + p + pp));
                    if (isPrimePair) {
                        counter++;
                        newFilteredValues.add(pp);
                    }
                }
                if (counter >= count - 1) {
                    primePairSet.add(p);
                    findPrimePairSets(primePairSet, newFilteredValues, count - 1);
                    primePairSet.remove(p);
                }
            }
        }
    }
}