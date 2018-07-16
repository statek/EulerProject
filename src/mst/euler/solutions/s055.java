package mst.euler.solutions;

import mst.euler.Solution;

import java.math.BigInteger;

import static mst.euler.Lib.isPalindrome;

public class s055 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s055().run());
    }

    @Override
    public String solve() {
        int count = 0;
        for (int n = 1; n <= 10_000; n++) {
            if (isLychrel(n)) {
                count++;
            }
        }
        return String.valueOf(count);
    }

    private boolean isLychrel(long n) {
        StringBuilder sb;
        BigInteger tmp = BigInteger.valueOf(n), tmprev;
        int i=0;
        while (i<=50){
            sb = new StringBuilder();
            sb.append(tmp);
            tmprev = new BigInteger(sb.reverse().toString());
            tmp = tmp.add(tmprev);
            if(isPalindrome(String.valueOf(tmp))) return false;
            i++;
        }
        return true;
    }
}