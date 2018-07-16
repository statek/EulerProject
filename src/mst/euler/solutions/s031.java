package mst.euler.solutions;

import mst.euler.Solution;

import java.util.Arrays;
import java.util.List;

public class s031 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s031().run());
    }

    @Override
    public String solve() {
        return String.valueOf(countWaysOfFunding(200, 200));
    }

    private int countWaysOfFunding(int value, int coinsUsed) {
        List<Integer> coins = Arrays.asList(200, 100, 50, 20, 10, 5, 2, 1);
        if (value == 0) {
            return 1;
        }
        if (value < 0) {
            return 0;
        }
        int sum = 0;
        for (Integer c : coins) {
            if (c > coinsUsed) {
                continue;
            }
            sum += countWaysOfFunding(value - c, c);
        }
        return sum;
    }
}
