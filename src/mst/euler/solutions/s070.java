package mst.euler.solutions;

import mst.euler.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static mst.euler.Lib.eulersTotient;

public class s070 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s070().run());
    }

    final long N=10_000_000L;

    @Override
    public String solve() {

        List<Long> phi = eulersTotient(N);
        long n = 0;
        double nPhi, minPhi = 0d;
        for (int i = 1; i < phi.size(); i++) {
            nPhi = (double) i / phi.get(i);
            if (isPermutation((long)i,phi.get(i)) && nPhi < minPhi) {
                minPhi = nPhi;
                n = i;
            }
        }
        return String.valueOf(n);
    }


    private boolean isPermutation(Long l1, Long l2) {
        List<String> s1 = new ArrayList<>(Arrays.asList(l1.toString().split("")));
        List<String> s2 = new ArrayList<>(Arrays.asList(l2.toString().split("")));
        Collections.sort(s1);
        Collections.sort(s2);
        return s1.equals(s2);
    }
}
