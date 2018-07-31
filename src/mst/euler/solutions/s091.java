package mst.euler.solutions;

import mst.euler.Solution;

import static mst.euler.Lib.gcd;

public class s091 extends Solution {

    private static final long N = 50;

    public static void main(String[] args) {
        System.out.println(new s091().run());
    }

    @Override
    public String solve() {
        long cntTriangles = N * N; //both points placed on axis
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= x; y++) {
                long cnt = 0;
                long gcd = gcd(x, y);
                long x1 = x / gcd, y1 = y / gcd;
                long x2 = x, y2 = y;
                while (x2 >= 0 && x2 <= N && y2 >= 0 && y2 <= N) {
                    cnt++;
                    x2 += y1;
                    y2 -= x1;
                }
                x2 = x;
                y2 = y;
                while (x2 >= 0 && x2 <= N && y2 >= 0 && y2 <= N) {
                    cnt++;
                    x2 -= y1;
                    y2 += x1;
                }
                cntTriangles += (x == y) ? cnt : 2 * cnt;
            }
        }
        return String.valueOf(cntTriangles);
    }

}
