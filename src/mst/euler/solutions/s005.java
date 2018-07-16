package mst.euler.solutions;

import mst.euler.Solution;

import static mst.euler.Lib.isPrime;

public class s005 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s005().run());
    }

    @Override
    public String solve() {
        return String.valueOf(smallestMultiple(20));
    }


    private int maxPower(int number, int divider) {
        return (number%divider==0) ? maxPower(number/divider,divider)*divider : 1;
    }

    public int smallestMultiple(int number) {
        int mult=1;
        for (int primeNum = 2; primeNum < number; ++primeNum) {
            if (isPrime(primeNum))
            {
                int max=0;
                for (int j = 2; j <= number; ++j) {
                    max=(max< maxPower(j,primeNum))? maxPower(j,primeNum):max;
                }
                mult*=max;
            }
        }
        return mult;
    }
}