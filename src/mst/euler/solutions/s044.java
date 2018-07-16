package mst.euler.solutions;

import mst.euler.Solution;

import java.util.ArrayList;
import java.util.List;

public class s044 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s044().run());
    }

    @Override
    public String solve() {
        List<Integer> pentNums = pentagonalNumbers(10_000);
        int d, s;
        for (int j : pentNums) {
            for (int k : pentNums) {
                d = j - k;
                s = j + k;
                if (d > 0 && pentNums.contains(d) && pentNums.contains(s)) {
                    return String.valueOf(d);
                }
            }
        }
        return null;
    }

    private List<Integer> pentagonalNumbers(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            list.add(i * (3 * i - 1) / 2);
        }
        return list;
    }
}
