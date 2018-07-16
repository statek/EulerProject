package mst.euler.solutions;

import mst.euler.Solution;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class s043 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s043().run());
    }

    @Override
    public String solve() {
        BigInteger sum = BigInteger.ZERO;
        for (String num: generatePandigitalNumbers()) {
            if (isSubstringDivisible(num)) {
                sum=sum.add(BigInteger.valueOf(Long.parseLong(num)));
            }
        }
        return String.valueOf(sum);
    }

    private final int[] DIVISORS = {1, 1, 2, 3, 5, 7, 11, 13, 17};

    private final int[] DIGITS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    private boolean isSubstringDivisible(String num) {
        for (int i = 2; i <= 8; i++) {
            Integer n = Integer.parseInt(num.substring(i - 1, i + 2));
            if (n % DIVISORS[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private List<String> generatePandigitalNumbers() {
        List<String> list = new ArrayList<>();
        for (int i : DIGITS) {
            list.addAll(generatePandigitalNumbersRecursive(""+i));
        }
        return list;
    }

    private List<String> generatePandigitalNumbersRecursive(String num) {
        List<String> list = new ArrayList<>();
        if (num.length() == 10) {
            list.add(num);
        } else {
            for (int i : DIGITS) {
                if (!num.contains(String.valueOf(i))) {
                    list.addAll(generatePandigitalNumbersRecursive(num + i));
                }
            }
        }
        return list;
    }
}

