package mst.euler.solutions;

import mst.euler.Solution;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.sqrt;
import static mst.euler.Lib.prepareSieve;
import static mst.euler.Lib.readFile;

public class s095 extends Solution {


    public static void main(String[] args) {
        System.out.println(new s095().run());
    }

    private final long N = 10_000_000;

    @Override
    public String solve() {

        List<Integer> sumDivisorsList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            sumDivisorsList.add(1);
        }

        for (int i = 2; i <= N / 2; i++) {
            for (int j = 2 * i; j < N; j += i) {
                sumDivisorsList.set(j, sumDivisorsList.get(j) + i);
            }
        }

        Set<Integer> numbersChecked = new HashSet<>();
        List<Integer> longestChain = new ArrayList<>();

        for (int i = 2; i < N; i++) {
            if (numbersChecked.contains(i)) continue;
            List<Integer> chain = new ArrayList<>();
            int n = i;
            while (!numbersChecked.contains(n) && n < N) {
                chain.add(n);
                n = sumDivisorsList.get(n);
                if (chain.contains(n)) {
                    numbersChecked.addAll(chain);
                    chain = chain.subList(chain.indexOf(n), chain.size());
                    if (chain.size() > longestChain.size()) {
                        longestChain = chain;
                    }
                    break;
                }
            }
            numbersChecked.addAll(chain);
        }
        return String.valueOf(longestChain.stream().mapToLong(Integer::intValue).min().getAsLong());
    }
}
