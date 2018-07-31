package mst.euler.solutions;

import mst.euler.Solution;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Math.sqrt;
import static mst.euler.Lib.prepareSieve;

public class s087 extends Solution {

    private static final long N = 50_000_000l;
    private final Set<Long> sieve;

    public static void main(String[] args) {
        System.out.println(new s087().run());
    }

    public s087() {
        sieve = prepareSieve((long) sqrt(N));
    }

    @Override
    public String solve() {
        Set<Long> sieveS = sieve.stream().map(s -> s * s).filter(n -> n < N).collect(Collectors.toSet());
        Set<Long> sieveC = sieve.stream().map(s -> s * s * s).filter(n -> n < N).collect(Collectors.toSet());
        Set<Long> sieveF = sieve.stream().map(s -> s * s * s * s).filter(n -> n < N).collect(Collectors.toSet());
        Set<Long> numbers = new HashSet<>();

        for (long s : sieveS) {
            for (long c : sieveC) {
                for (long f : sieveF) {
                    numbers.add(s + c + f);
                }
            }
        }
        return String.valueOf(numbers.stream().filter(n -> n < N).count());
    }

}
