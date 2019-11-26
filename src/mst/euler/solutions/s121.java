package mst.euler.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mst.euler.Solution;

public class s121 extends Solution {

    private int roundNumber = 15;
    private Set<List<Integer>> luckyTries = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(new s121().run());
    }

    @Override
    public String solve() {
        generateLuckyTries(new ArrayList());
        long luckyTries = countLuckyTries();
        long tries = countTries();

        return String.valueOf(tries / luckyTries);
    }

    private long countLuckyTries() {
        long countSum = 0;
        for (List<Integer> t : luckyTries) {
            long p = 2;
            long count = 1;
            for (Integer r : t) {
                count *= r > 0 ? 1 : (p - 1);
                p++;
            }
            countSum += count;
        }
        return countSum;
    }

    private void generateLuckyTries(final List<Integer> triesList) {
        if (triesList.size() == roundNumber) {
            final long blueCount = triesList
                    .stream()
                    .filter(t -> t > 0)
                    .count();
            if (blueCount > roundNumber - blueCount) {
                luckyTries.add(triesList);
            }
        } else {
            final ArrayList<Integer> redTaken = new ArrayList<>(triesList);
            redTaken.add(0);
            generateLuckyTries(redTaken);
            final ArrayList<Integer> blueTaken = new ArrayList<>(triesList);
            blueTaken.add(1);
            generateLuckyTries(blueTaken);
        }
    }

    private long countTries() {
        long count = 1;
        long p = 2;
        for (int r = 0; r < roundNumber; r++) {
            count *= p;
            p++;
        }
        return count;
    }

    public void setRoundNumber(final int roundNumber) {
        this.roundNumber = roundNumber;
    }
}
