package mst.euler.solutions;

import mst.euler.Solution;

public class s085 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s085().run());
    }

    private final long R = 2_000_000l;

    @Override
    public String solve() {
        long a = 1, b;
        long cntAbs = Long.MAX_VALUE;
        Rectangle rr = new Rectangle(1, 1), r;
        do {
            a++;
            b = 1;
            r = new Rectangle(a, b);
            while (r.getrCnt() < R) {
                b++;
                r = new Rectangle(a, b);
                long abs = Math.abs(r.getrCnt() - R);
                if (abs < cntAbs) {
                    cntAbs = abs;
                    rr = r;
                }
            }
            r = new Rectangle(a, 1);
        } while (r.getrCnt() < R);

        return String.valueOf(rr.getArea());
    }

    class Rectangle {
        long a;
        long b;
        long rCnt;

        public long getrCnt() {
            return rCnt;
        }

        public long getArea() {
            return a * b;
        }

        public Rectangle(long a, long b) {
            this.a = a;
            this.b = b;
            countRectangles();
        }

        private void countRectangles() {
            long cnt = 0;
            for (long i = 1; i <= a; i++) {
                for (long j = 1; j <= b; j++) {
                    long pr = (i) * (j);
                    cnt += pr;
                }
            }
            rCnt = cnt;
        }

    }
}
