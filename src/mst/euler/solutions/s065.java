package mst.euler.solutions;

import mst.euler.Solution;
import mst.euler.utils.Fraction;

import java.util.ArrayList;
import java.util.List;

import static mst.euler.Lib.sumDigits;

public class s065 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s065().run());
    }

    final int N = 100;
    List<Integer> eValues = new ArrayList<>();

    @Override
    public String solve() {
        return String.valueOf(sumDigits(getConvergent(N).getNumerator()));
    }

    private Fraction getConvergent(int i) {
        generateE(i);
        i--;
        Fraction f = new Fraction((i == 0) ? 0 : 1, eValues.get(i));
        for (int idx = i - 1; idx > 0; idx--) {
            f.add(eValues.get(idx));
            f.reverse();
        }
        f.add(eValues.get(0));
        return f;
    }

    private void generateE(int n) {
        eValues.clear();
        eValues.add(2);
        int i = 1;
        while (eValues.size() <= n) {
            eValues.add(1);
            eValues.add(2 * i);
            eValues.add(1);
            i++;
        }
    }
}
