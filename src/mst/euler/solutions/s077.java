package mst.euler.solutions;

import mst.euler.Solution;

import java.util.ArrayList;
import java.util.Set;

import static mst.euler.Lib.prepareSieve;

public class s077 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s077().run());
    }

    private int counter = 0;
    private Set<Long> sieve = prepareSieve(100);

    @Override
    public String solve() {
        long n = 10;
        while (counter<5_000){
            n++;
            counter=0;
            findSumDecomposition(0, n-1,n);
        }
        return String.valueOf(n);
    }

    private long findSumDecomposition(long sum, long l, long n) {
        if (sum < n) {
            for (long p : sieve){
                if (p>l) break;
                findSumDecomposition(sum + p, p, n);
            }
        }
        if (sum == n) {
            counter++;
        }
        return counter;
    }

}
