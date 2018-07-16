package mst.euler.solutions;

import mst.euler.Solution;

import java.util.Set;

import static mst.euler.Lib.prepareSieve;

public class s046 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s046().run());
    }

    @Override
    public String solve() {
        Set<Long> prime = prepareSieve(10_000);
        double sq;
        long i;
        for (i = 3; i > 0; i++) {
            for (long p : prime) {
                if (i < p || (i - p) % 2 == 1)
                    continue;
                sq = Math.sqrt((i - p) / 2);
                if ((double) (long) sq == sq) {
                    i++;
                    break;
                }
            }
            if (i % 2 == 1) {
                break;
            }
        }
        return String.valueOf(i);
    }
}