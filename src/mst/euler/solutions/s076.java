package mst.euler.solutions;

import mst.euler.Solution;

public class s076 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s076().run());
    }

    private final int N = 100;

    @Override
    public String solve() {
        return String.valueOf(findSumDecomposition(N));
    }

    private long findSumDecomposition(int n) {
        long sum = -1;
        for (int k = 1; k <= n; k++) {
            sum += p(n, k);
        }
        return sum;
    }

    private long p(int n, int k) {
        if (k == 1) return 1;
        if (n == k) return 1;
        if (k > n) return 0;
        return p(n - 1, k - 1) + p(n - k, k);
    }
}
