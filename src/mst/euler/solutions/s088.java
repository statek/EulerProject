package mst.euler.solutions;

import java.math.BigInteger;
import java.util.HashSet;
import mst.euler.Solution;

public class s088 extends Solution {

    private static int K = 12_000;

    public static void main(String[] args) {
        System.out.println(new s088().run());
    }

    public static void setK(final int k) {
        K = k;
    }

    @Override
    public String solve() {
        HashSet<Long> results = new HashSet();
        for (int k = 2; k <= K; k++) {
            long p = k+1;
            while (!isProductSumElements(p, p, k)) {
                p++;
            }
            results.add(p);
            System.out.println(k * 100 / K + "%\t k=" + k + "\tp=" + p);
        }
        return results
                .stream()
                .map(l->BigInteger.valueOf(l))
                .reduce(BigInteger::add)
                .orElse(BigInteger.ZERO)
                .toString();
    }

    private boolean isProductSumElements(final long product, final long sum, final long count) {
        if (count == 0) {
            return product == 1 && sum == 0;
        }
        if (product == 1l) {
            return isProductSumElements(product, sum - 1, count - 1);
        }
        for (long e = 2; e <= product; e++) {
            if (product % e == 0l && isProductSumElements(product / e, sum - e, count - 1)) {
                return true;
            }
        }
        return false;
    }
}
