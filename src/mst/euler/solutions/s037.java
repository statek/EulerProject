package mst.euler.solutions;

import mst.euler.Solution;

import java.util.Set;

import static mst.euler.Lib.prepareSieve;

public class s037 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s037().run());
    }

    @Override
    public String solve() {
        sieve = prepareSieve(1_000_000);
        int sum = 0;
        for (Long i : sieve) {
            if (i<10L) continue;
            if (isTruncatablePrime(i)) {
                sum+=i;
            }
        }
        return String.valueOf(sum);
    }

    private Set<Long> sieve;

    private boolean isTruncatablePrime(long n) {
        String s = n + "";
        return isTruncatablePrime(s,'l')&&isTruncatablePrime(s,'r');
    }

    private boolean isTruncatablePrime(String n, char direction) {
        if (n.length()==0) return true;
        return sieve.contains(Long.parseLong(n))&&isTruncatablePrime((direction=='l')?n.substring(1):n.substring(0,n.length()-1),direction);
    }
}
