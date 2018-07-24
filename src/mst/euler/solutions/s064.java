package mst.euler.solutions;

import mst.euler.Solution;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class s064 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s064().run());
    }

    //    final long N = 10_000L;
    final long N = 13L;
    @Override
    public String solve() {
        List<SquareExpansion> periods = new ArrayList<>();
        for(int i=0; i<=N; i++){
            SquareExpansion se = new SquareExpansion(i);
            System.out.println(se);
            periods.add(se);
        }
        return String.valueOf(periods.stream().filter(p-> p.getPeriod().size()%2==1).count());
    }

    class SquareExpansion {
        long s;
        List<Long> period;

        public List<Long> getPeriod() {
            return period;
        }

        List<Long> a;
        List<Long> d;
        List<Long> n;

        @Override
        public String toString() {
            return "sqrt("+s+")=\t" + a + period;
        }

        public SquareExpansion(long sq) {
            this.s = sq;
            a = new ArrayList<>();
            d = new ArrayList<>();
            n = new ArrayList<>();
            period=new ArrayList<>();
            findExpansion();
        }

        private void findExpansion() {
            // a + (sqrt(s)-n)/d
            long tmpD = 1, tmpN, tmpA;
            tmpA = (long) sqrt(s);
            tmpN = tmpA;
            this.a.add(tmpA);
            this.d.add(tmpD);
            this.n.add(tmpN);
            while (!hasCycle()) {
                tmpD = (s - tmpN * tmpN) / tmpD;
                if (tmpD==0) return;
                tmpA = (tmpN / tmpD + 1);
                tmpN = tmpD * tmpA - tmpN;
                this.a.add(tmpA);
                this.d.add(tmpD);
                this.n.add(tmpN);
            }
        }

        private boolean hasCycle() {
            for (int p = 1; p <= a.size() / 2; p++) {
                for (int b = 0; b < a.size() - 2*p; b++) {
                    if(a.subList(b,b+p).equals(a.subList(b+p,b+p+p))
                            && d.subList(b,b+p).equals(d.subList(b+p,b+p+p))
                            && n.subList(b,b+p).equals(n.subList(b+p,b+p+p)))
                    {
                        period= a.subList(b,b+p);
                        a = a.subList(0,b);
                        return true;
                    }
                }
            }
            return false;
        }


    }
}
