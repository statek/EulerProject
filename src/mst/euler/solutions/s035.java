package mst.euler.solutions;

import mst.euler.Solution;

import java.util.Set;

import static mst.euler.Lib.prepareSieve;

public class s035 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s035().run());
    }

    @Override
    public String solve() {
        sieve = prepareSieve(1_000_000);
        int count = 0;
        for (int i = 2; i < 1_000_000; ++i) {
            if (isCircularPrime(i)) {
                count++;
            }
        }
        return String.valueOf(count);
    }

    private Set<Long> sieve;

    private boolean isCircularPrime(int n) {
        String s = n + "";
        String tmp = s;
        for (int i = 0; i < s.length(); ++i) {
            if (sieve.contains(Long.parseLong(tmp))) {
                tmp = s.substring(i + 1) + s.substring(0, i+1);
            } else {
                return false;
            }
        }
        return true;
    }

}

