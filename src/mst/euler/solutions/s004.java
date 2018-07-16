package mst.euler.solutions;

import mst.euler.Solution;

import static mst.euler.Lib.isPalindrome;

public class s004 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s004().run());
    }

    private final int MAX_NUMBER = 1000;

    @Override
    public String solve() {
        return String.valueOf(maxPalindrome(MAX_NUMBER));
    }

    public int maxPalindrome(int maxNumber) {
        int maxPalindrome = 0;
        for (int i = maxNumber - 1; i > 0; --i) {
            for (int j = maxNumber - 1; j >= i; --j) {
                if (i * j <= maxPalindrome) continue;
                maxPalindrome = (isPalindrome(String.valueOf(i * j))) ? i * j : maxPalindrome;
            }
        }
        return maxPalindrome;
    }
}