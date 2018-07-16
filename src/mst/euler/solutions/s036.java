package mst.euler.solutions;

import mst.euler.Solution;

import static mst.euler.Lib.isPalindrome;

public class s036 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s036().run());
    }

    @Override
    public String solve() {
        long sum = 0;
        for (long i = 1L; i < 1_000_000L; ++i) {
            if (isPalindrome(Long.toString(i)) && isPalindrome(Long.toBinaryString(i))) {
                sum += i;
            }
        }
        return String.valueOf(sum);
    }

}
