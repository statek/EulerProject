package mst.euler.solutions;

import mst.euler.Solution;
import mst.euler.utils.Fraction;

import java.util.TreeSet;

import static mst.euler.Lib.gcd;

public class s071 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s071().run());
    }

    //   private final long N = 8L;
    private final long N = 1_000_000L;
    private final Fraction f37 = new Fraction(3, 7);

    @Override
    public String solve() {
        TreeSet<Fraction> fractions = new TreeSet<>();
        Fraction f;
        for (long d = N; d > 0; d--) {
            long n = 3 * d / 7;
            if (n == 0) break;
            while (gcd(d, n) != 1) {
                n--;
            }
            f = new Fraction(n, d);
            fractions.add(f);
        }
        fractions.remove(f37);
        return fractions.last().getNumerator();
    }
}
