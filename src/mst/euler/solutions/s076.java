package mst.euler.solutions;

import mst.euler.Solution;

import java.util.ArrayList;

public class s076 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s076().run());
    }

    private final int N = 100;
    //private final int N = 5;
    private int counter = 0;
    private ArrayList<Integer> decomposition = new ArrayList<>();

    @Override
    public String solve() {
        findSumDecomposition(0, N - 1);
        return String.valueOf(counter);
    }

    private void findSumDecomposition(int sum, int l) {
        if (sum < N) {
            for (int i = l; i > 0; i--) {
                decomposition.add(i);
                findSumDecomposition(sum + i, i);
                decomposition.remove((Integer) i);
            }
        }
        if (sum == N) {
            System.out.println(decomposition);
            counter++;
        }
    }

}
