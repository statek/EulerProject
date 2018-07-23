package mst.euler.solutions;

import mst.euler.Solution;

import java.util.*;

import static mst.euler.Lib.factorial;

public class s074 extends Solution {

    public s074() {
        digitsFactorials = new HashMap<>();
        for (long i=0;i<10;i++){
            digitsFactorials.put(i,factorial(i));
        }
    }

    public static void main(String[] args) {
        System.out.println(new s074().run());
    }

    private final long N = 1_000_000L;
    private Map<Long,Long> digitsFactorials;

    @Override
    public String solve() {
        int counter = 0;
        for(int i=0;i<N;i++){
            Set<Long> chain = findChain(i);
            if (chain.size()==60){
                counter++;
            }
        }
        return String.valueOf(counter);
    }

    private Set<Long> findChain(long l) {
        Set<Long> chain = new HashSet<>();
        long sum = l;
        while (!chain.contains(sum)) {
            chain.add(sum);
            long i = sum;
            for (sum = 0; i > 0; i /= 10) {
                sum += digitsFactorials.get(i % 10);
            }
        }
        return chain;
    }
}
