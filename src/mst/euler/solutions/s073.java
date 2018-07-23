package mst.euler.solutions;

import mst.euler.Solution;
import mst.euler.utils.Fraction;

import java.util.HashSet;
import java.util.TreeSet;

import static mst.euler.Lib.gcd;

public class s073 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s073().run());
    }

    private final long N = 12_000L;
    private final Fraction maxF = new Fraction(1, 2);

    @Override
    public String solve() {
        HashSet<Fraction> fractions = new HashSet<>();
        Fraction f;
        for (long d = 2; d <= N; d++) {
            long n = d / 2;
            while (n>d/3)
            {
                f = new Fraction(n, d);
                fractions.add(f);
                n--;
            }
        }
        fractions.remove(maxF);
        return String.valueOf(fractions.size());
    }
}
