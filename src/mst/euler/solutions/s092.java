package mst.euler.solutions;

import mst.euler.Solution;

import java.util.HashSet;
import java.util.Set;

public class s092 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s092().run());
    }

    private final long N = 10_000_000;
    private Set<Long> sdc1 = new HashSet<>();
    private Set<Long> sdc89 = new HashSet<>();

    @Override
    public String solve() {
        sdc1.add(1l);
        sdc89.add(89l);
        for (int i = 1; i < N; i++) {
            long tmpI = i;
            Set<Long> sdcI = new HashSet<>();
            while (true) {
                if (sdc1.contains(tmpI)) {
                    sdc1.addAll(sdcI);
                    break;
                }
                if (sdc89.contains(tmpI)) {
                    sdc89.addAll(sdcI);
                    break;
                }
                sdcI.add(tmpI);
                tmpI = addSquareDigits(tmpI);
            }


        }
        return String.valueOf(sdc89.size());
    }

    private long addSquareDigits(long n) {
        long sum=0;
        for (long i = n; i > 0; i = i / 10) {
            sum+=(i%10)*(i%10);
        }
        return sum;
    }
}
