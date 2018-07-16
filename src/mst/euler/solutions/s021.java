package mst.euler.solutions;

import mst.euler.Solution;

public class s021 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s021().run());
    }

    @Override
    public String solve() {
        int sum=0;
        for (int i = 1; i < 10_000; i++) {
            sum += isAmicable(i) ? i : 0;
        }
        return String.valueOf(sum);
    }

    private int sumDividers(int num) {
        int sum = 0;
        for (int i = 1; i < num / 2 + 1; i++) {
            if (num % i == 0) {
                sum=sum+i;
            }
        }
        return sum;
    }
    public boolean isAmicable(int num) {

        return num==sumDividers(sumDividers(num)) && num!=sumDividers(num);
    }
}
