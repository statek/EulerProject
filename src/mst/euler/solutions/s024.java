package mst.euler.solutions;

import mst.euler.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s024 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s024().run());
    }

    @Override
    public String solve() {
        lexPerm(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        return result;
    }

    private int number = 0;
    private String result;

    private void lexPerm(String perm, List<Integer> ints) {
        if (result == null) {
            if (ints.isEmpty()) {
                number++;
                if (number == 1_000_000) result = perm;
                return;
            }
            for (Integer i : ints) {
                List<Integer> tmpList = new ArrayList<>(ints);
                tmpList.remove(i);
                lexPerm(perm + i, tmpList);
            }
        }
    }

    private void lexPerm(List<Integer> ints) {
        number = 0;
        lexPerm("", ints);
    }
}
