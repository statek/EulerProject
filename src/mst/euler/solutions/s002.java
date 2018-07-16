package mst.euler.solutions;

import mst.euler.Solution;

public class s002 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s002().run());
    }

    @Override
    public String solve() {
        int fn = 1, fn1 = 2;
        int sum = 0;
        while (fn < 4_000_000) {
            sum += (fn % 2 == 0) ? fn : 0;
            int tmp = fn1 + fn;
            fn = fn1;
            fn1 = tmp;
        }
        return String.valueOf(sum);
    }
}