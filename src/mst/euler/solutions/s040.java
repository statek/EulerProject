package mst.euler.solutions;

import mst.euler.Solution;

import static mst.euler.Lib.sumDigits;

public class s040 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s040().run());
    }

    @Override
    public String solve() {
        long d = 0;
        long num = 1;
        String n;
        long product = 1;
        int tmpd;
        while (d < 1_000_000) {
            n = num + "";
            for (int i = 0; i < n.length(); i++) {
                d++;
                tmpd = Integer.parseInt(n.charAt(i) + "");
                if (sumDigits(d + "") == 1) {
                    product *= tmpd;
                }
            }
            num++;
        }
        return String.valueOf(product);
    }
}

