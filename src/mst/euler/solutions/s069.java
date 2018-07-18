package mst.euler.solutions;

import mst.euler.Solution;

import java.util.List;

import static mst.euler.Lib.eulersTotient;

public class s069 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s069().run());
    }

    final long N = 1_000_000L;

    @Override
    public String solve() {
        List<Long> phi = eulersTotient(N);
        long n = 0;
        double NPhi, maxNPhi = 0d;
        for (int i = 1; i < phi.size(); i++) {
            NPhi = (double) i / phi.get(i);
            if (NPhi > maxNPhi) {
                maxNPhi = NPhi;
                n = i;
            }
        }
        return String.valueOf(n);
    }

}
