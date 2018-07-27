package mst.euler.solutions;

import mst.euler.Solution;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class s064 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s064().run());
    }

    private final long N = 10_000L;

    @Override
    public String solve() {
        List<SquareExpansion> periods = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            SquareExpansion se = new SquareExpansion(i);
            periods.add(se);
        }
        return String.valueOf(periods.stream().filter(p -> p.getPeriod().size() % 2 == 1).count());
    }

    class SquareExpansion {
        long s;
        List<Long> period;

        public List<Long> getPeriod() {
            return period;
        }

        List<Long> a;
        List<Long> d;
        List<Long> m;

        @Override
        public String toString() {
            return "sqrt(" + s + ")=\t" + a + period;
        }

        public SquareExpansion(long sq) {
            this.s = sq;
            a = new ArrayList<>();
            d = new ArrayList<>();
            m = new ArrayList<>();
            period = new ArrayList<>();
            findExpansion();
        }

        private void findExpansion() {
            long tmpD = 1, tmpA = (long) sqrt(s), tmpM = 0;
            this.a.add(tmpA);
            this.d.add(tmpD);
            this.m.add(tmpM);
            if (tmpA*tmpA==s) return;
            while (!hasCycle()) {
                tmpM = tmpD * tmpA - tmpM;
                tmpD = (s - tmpM * tmpM) / tmpD;
                tmpA = (a.get(0) + tmpM) / tmpD;
                this.a.add(tmpA);
                this.d.add(tmpD);
                this.m.add(tmpM);
            }
        }

        private boolean hasCycle() {
            for (int p = 1; p <= a.size() / 2; p++) {
                for (int b = 0; b <= a.size() - 2 * p; b++) {
                    if (a.subList(b, b + p).equals(a.subList(b + p, b + p + p))
                            && d.subList(b, b + p).equals(d.subList(b + p, b + p + p))
                            && m.subList(b, b + p).equals(m.subList(b + p, b + p + p))
                            ) {
                        period = a.subList(b, b + p);
                        a = a.subList(0, b);
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
