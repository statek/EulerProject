package mst.euler.solutions;

import mst.euler.Solution;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import static mst.euler.Lib.isPandigital;

public class s038 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s038().run());
    }

    @Override
    public String solve() {
        BigInteger tmp, max = BigInteger.ZERO;
        String str;
        int j;
        Set<Integer> set = new HashSet<>();
        set.add(1);
        for (int i = 2; i <= 9; i++) {
            set.add(i);
            for (j = 1; j > 0; j++) {
                str = concatMultiplies(j, set);
                if (str.length()>9) {
                    break;
                }
                if (str.length()<9) {
                    continue;
                }
                tmp = BigInteger.valueOf(Long.parseLong(str));
                if (isPandigital(str) && max.compareTo(tmp) == -1) {
                    max = tmp;
                }
            }
        }
        return String.valueOf(max);
    }


    private String concatMultiplies(int n, Set<Integer> set) {
        String res="";
        for (int i:set) {
            res += (n * i);
        }
        return res;
    }
}
