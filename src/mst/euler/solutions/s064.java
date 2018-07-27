package mst.euler.solutions;

import mst.euler.Solution;
import mst.euler.utils.SquareRootContinuedFraction;

import java.util.ArrayList;
import java.util.List;

public class s064 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s064().run());
    }

    private final long N = 10_000L;

    @Override
    public String solve() {
        List<SquareRootContinuedFraction> periods = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            SquareRootContinuedFraction scf = new SquareRootContinuedFraction(i);
            periods.add(scf);
        }
        return String.valueOf(periods.stream().filter(p -> p.getPeriod().size() % 2 == 1).count());
    }
}
