package mst.euler.solutions;

import mst.euler.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static mst.euler.Lib.prepareSieve;

public class s049 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s049().run());
    }

    @Override
    public String solve() {
        sieve = new ArrayList<>();
        sieve.addAll(prepareSieve(10_000));
        Collections.sort(sieve);
        Long p3;
        for (Long p2 : sieve) {
            for (Long p1 : sieve) {
                if (p1 >= p2) break;
                p3 = p2 - p1 + p2;
                if (p1 != 1487 && sieve.contains(p3) && arePermutations(String.valueOf(p1), String.valueOf(p2)) && arePermutations(String.valueOf(p1), String.valueOf(p3))) {
                    return "" + p1 + p2 + p3;
                }
            }
        }
        return null;
    }

    private static List<Long> sieve;

    private static boolean arePermutations(String s1, String s2) {
        List<String> l1 = new ArrayList<>(Arrays.asList(s1.split(""))), l2 = new ArrayList<>(Arrays.asList(s2.split("")));
        Collections.sort(l1);
        Collections.sort(l2);
        return l1.equals(l2);
    }
}
