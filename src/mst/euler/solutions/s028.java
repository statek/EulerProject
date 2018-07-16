package mst.euler.solutions;

import mst.euler.Solution;

public class s028 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s028().run());
    }

    @Override
    public String solve() {
        return String.valueOf(spriralDiagonalNumber(1_001));
    }

    public int spriralDiagonalNumber(int size) {
        int sum=1, val=1;
        int r=2;
        while (r<size) {
            for (int direct = 0; direct < 4; direct++) {
                val += r;
                sum += val;
            }
            r += 2;
        }
        return sum;
    }
}

