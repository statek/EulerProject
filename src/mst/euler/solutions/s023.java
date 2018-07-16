package mst.euler.solutions;

import mst.euler.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class s023 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s023().run());
    }

    @Override
    public String solve() {
        List<Integer> abunds = findAbundant(28123);
        Set<Integer> nonAbundantSums = new HashSet<>();
        for(int i=1;i< 28123; i++){
            nonAbundantSums.add(i);
        }
        for (int i : abunds) {
            for (int j : abunds) {
                nonAbundantSums.remove(i+j);
            }
        }
        return String.valueOf(nonAbundantSums.stream().mapToInt(i -> i).sum());
    }

    private static int sumDivisors(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    private static boolean isAbundant(int n) {
        return sumDivisors(n) > n;
    }

    private static List<Integer> findAbundant(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (isAbundant(i)) {
                list.add(i);
            }
        }
        return list;
    }
}
