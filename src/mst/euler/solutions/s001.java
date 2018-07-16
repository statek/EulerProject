package mst.euler.solutions;

import mst.euler.Solution;

public class s001 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s001().run());
    }

    @Override
    public String solve() {
        int sum = 0;
        for (int i = 1; i < 1000; ++i) {
            if (i % 3 == 0 || i % 5 == 0)
                sum += i;
        }
        return String.valueOf(sum);
    }
}
