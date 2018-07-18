package mst.euler.solutions;

import mst.euler.Solution;

import java.util.Set;

import static java.lang.Math.sqrt;;
import static mst.euler.Lib.prepareSieve;

public class s069 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s069().run());
    }

    final long N = 1_000_000L;

@Override
    public String solve() {
        Set<Long> sieve = prepareSieve((long)sqrt(N));
        long n = 1;
        for (long prime : sieve){
            if (n*prime>N) break;
            n*=prime;
        }
        return String.valueOf(n);
    }
}
