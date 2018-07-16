package mst.euler.solutions;

import mst.euler.Solution;

import static mst.euler.Lib.isPrime;

public class s007 extends Solution {
    private final int N_PRIME = 10001;

    public static void main(String[] args) {
        System.out.println(new s007().run());
    }

    @Override
    public String solve() {
        int count = 0;
        int result = 1;
        int i = 1;
        while (count < N_PRIME) {
            i++;
            if (isPrime(i)) {
                result = i;
                count++;
            }
        }
        return String.valueOf(result);
    }

}
