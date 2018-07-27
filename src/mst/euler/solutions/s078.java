package mst.euler.solutions;

import mst.euler.Solution;

public class s078 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s078().run());
    }

    @Override
    public String solve() {
        long n = 55374;
        long decompositionCounter=1;
        while (decompositionCounter%1_000_000!=0){
            decompositionCounter=findSumDecomposition(n);
            System.out.println(n+"\t"+decompositionCounter);
            n++;
        }
        return String.valueOf(n);
    }

    private long findSumDecomposition(long n) {
        long sum = 0;
        for (long k = 1; k <= n; k++) {
            sum += p(n, k);
        }
        return sum;
    }

    private long p(long n, long k) {
        if (k == 1) return 1;
        if (n == k) return 1;
        if (k > n) return 0;
        return p(n - 1, k - 1) + p(n - k, k);
    }
}
