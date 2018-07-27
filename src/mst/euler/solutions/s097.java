package mst.euler.solutions;

import mst.euler.Solution;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class s097 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s097().run());
    }

    @Override
    public String solve() {
        BigInteger p = BigInteger.valueOf(28433);
        for (long i = 0; i < 7830457l; i++) {
            p=p.shiftLeft(1);
            p=p.mod(BigInteger.TEN.pow(10));
        }
        p = p.add(BigInteger.ONE);
        return String.valueOf(p);
    }

}
