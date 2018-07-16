package mst.euler.solutions;

import mst.euler.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static mst.euler.Lib.isPrime;
import static mst.euler.Lib.prepareSieve;

public class s050 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s050().run());
    }

    public String solve() {
        List<Long> sieve = new ArrayList<>(prepareSieve(10_000));
        Collections.sort(sieve);
        long sum, maxSum = 0, maxConsecutivePrimesCount = 5;

        for (int i = 0; i <= sieve.size(); i++) {
            for (int cpc = sieve.size() - i; cpc > maxConsecutivePrimesCount; cpc--) {
                sum = 0;
                for (int j = 0; j < cpc; j++) {
                    sum += sieve.get(i + j);
                }
                if (sum < 1_000_000 && (sieve.contains(sum) || isPrime(sum))) {
                    maxConsecutivePrimesCount = cpc;
                    maxSum = sum;
                }
            }
        }
        return String.valueOf(maxSum);
    }
}