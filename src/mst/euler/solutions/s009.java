package mst.euler.solutions;

import mst.euler.Solution;

public class s009 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s009().run());
    }

    @Override
    public String solve() {
        return String.valueOf(findPitagorianProduct(1000));
    }

    public boolean isPitagorian(int a, int b, int c) {
        return (a * a + b * b == c * c);
    }

    public int findPitagorianProduct(int sum) {
        for (int i = 1; i < sum; i++) {
            for (int j = 1; j < sum - i; j++) {
                if (isPitagorian(i, j, sum - i - j)) return i * j * (sum - i - j);
            }
        }
        return -1;
    }
}
