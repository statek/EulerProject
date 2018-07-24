package mst.euler.solutions;

import mst.euler.Solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class s077 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s077().run());
    }

    private final long N = 1_500_000L;

    private Map<Long, Set<Set<Long>>> validLengths = new HashMap<>();

    @Override
    public String solve() {
        long k, l, a, b, c;
        for (long n = 1; n < N / 3; n++) {
            for (long m = 1; m < n; m++) {
                a = n * n - m * m;
                b = 2 * n * m;
                c = n * n + m * m;
                l = a + b + c;
                k = 1;
                if (l > N) break;
                while (k * l < N) {
                    if (!validLengths.containsKey(k * l)) {
                        validLengths.put(k * l, new HashSet<>());
                    }
                    Set<Long> triple = new HashSet<>();
                    triple.add(a * k);
                    triple.add(b * k);
                    triple.add(c * k);
                    validLengths.get(k * l).add(triple);
                    k++;
                }
            }
        }
        return String.valueOf(validLengths.entrySet().stream().filter(e -> e.getValue().size() == 1).count());
    }

}
