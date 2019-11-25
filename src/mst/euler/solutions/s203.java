package mst.euler.solutions;

import static mst.euler.Lib.prepareSieve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import mst.euler.Solution;

public class s203 extends Solution {

    private Set<Long> squaredPrimes;

    public static void main(String[] args) {
        System.out.println(new s203().run());
    }

    private Integer R = 51;

    @Override
    public String solve() {
        prepareSquaredPrimes();
        Set<Long> numbers = new HashSet();

        List<List<Long>> pascalsTriangle = new ArrayList<>();
        pascalsTriangle.add(Arrays.asList(1l));
        pascalsTriangle.add(Arrays.asList(1l, 1l));
        for (int i = 2; i < R; i++) {
            ArrayList<Long> row = new ArrayList<>();
            row.add(1l);
            for (int j = 1; j < i; j++) {
                row.add(pascalsTriangle
                        .get(i - 1)
                        .get(j - 1)
                        + pascalsTriangle
                        .get(i - 1)
                        .get(j));
            }
            row.add(1l);
            pascalsTriangle.add(row);
            numbers.addAll(row);
        }

        Long sum = numbers
                .stream()
                .filter(n -> isSquareFree(n))
                .reduce(Long::sum)
                .orElse(0l);

        return String.valueOf(sum);
    }

  private void prepareSquaredPrimes() {
    final Set<Long> sieve = prepareSieve(100);
    squaredPrimes = sieve.stream().map( p -> p*p).collect(Collectors.toSet());
  }

  private boolean isSquareFree(final Long n) {
        for (long sp : squaredPrimes) {
            if (n % sp == 0) {
                return false;
            }
        }
        return true;
    }

    public void setR(final int r) {
        R = r;
    }
}
