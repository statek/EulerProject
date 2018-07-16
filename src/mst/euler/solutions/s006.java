package mst.euler.solutions;

import mst.euler.Solution;

public class s006 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s006().run());
    }

    @Override
    public String solve() {
        return String.valueOf(sqdiff(MAX_NUMBER));
    }

    private final int MAX_NUMBER = 100;

    public int sumsq(int number) {
        int sum = 0;
        for (int i = 1; i <= number; ++i) {
            sum += i * i;
        }
        return sum;
    }

    public int sqsum(int number) {
        int sum = 0;
        for (int i = 1; i <= number; ++i) {
            sum += i;
        }
        return sum * sum;
    }

    public int sqdiff(int number) {
        return sqsum(number) - sumsq(number);
    }
}