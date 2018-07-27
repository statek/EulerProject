package mst.euler.utils;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class SquareRootContinuedFraction {
    long s;
    List<Long> period;

    List<Long> a;
    List<Long> d;
    List<Long> m;

    public List<Long> getPeriod() {
        return period;
    }

    @Override
    public String toString() {
        return "sqrt(" + s + ")=\t" + a + period;
    }

    public SquareRootContinuedFraction(long sq) {
        this.s = sq;
        a = new ArrayList<>();
        d = new ArrayList<>();
        m = new ArrayList<>();
        period = new ArrayList<>();
        findContinuedFraction();
    }

    private void findContinuedFraction() {
        long tmpD = 1, tmpA = (long) sqrt(s), tmpM = 0;
        this.a.add(tmpA);
        this.d.add(tmpD);
        this.m.add(tmpM);
        if (tmpA * tmpA == s) return;
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
                    return true;
                }
            }
        }
        return false;
    }

    public Fraction getFraction(int i) {
        i--;
        Fraction f = new Fraction((i == 0) ? 0 : 1, a.get(i));
        for (int idx = i - 1; idx > 0; idx--) {
            f.add(a.get(idx));
            f.reverse();
        }
        f.add(a.get(0));
        return f;
    }
}
