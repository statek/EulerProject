package mst.euler.solutions;

import mst.euler.Solution;

public class s003 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s003().run());
    }

    private final long NUMBER = 600851475143L;

    @Override
    public String solve() {
        return String.valueOf(largestPrimeFactor(NUMBER));
    }

    public static long largestFactor(long number) {
        for (int i = 2; i < number / 2 + 1; ++i) {
            if (number % i == 0) {
                return number / i;
            }
        }
        return 1;
    }

    public static long largestPrimeFactor(long number) {
        for (int i = 2; i < number / 2 + 1; ++i) {
            if (number % i == 0 && largestFactor(number / i) == 1) {
                return number / i;
            }
        }
        return 1;
    }
}
