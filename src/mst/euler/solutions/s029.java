package mst.euler.solutions;

import mst.euler.Solution;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class s029 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s029().run());
    }

    @Override
    public String solve() {
        return String.valueOf(distinctFactors(2,100));
    }

    public static int distinctFactors(int m, int n) {
        Set<BigInteger> set = new HashSet<>();
        for (int i=m;i<=n;i++)
            for (int j=m;j<=n;j++)
            {
                set.add(BigInteger.valueOf(i).pow(j));
            }
        return set.size();
    }
}