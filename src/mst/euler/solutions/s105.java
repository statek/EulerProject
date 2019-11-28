package mst.euler.solutions;

import static mst.euler.Lib.readFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import mst.euler.Solution;

public class s105 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s105().run());
    }

    private Set<Set<Long>> testSets = new HashSet<>();
    private Map<Integer, Set<List<Integer>>> mapOfSplits = new HashMap<>();
    private Integer[] SPLIT_SIGNS = {0, 1};

    @Override
    public String solve() {
        if (testSets.isEmpty()) {
            List<String> fileContent = readFile("src/mst/euler/resources/p105_sets.txt");
            loadFile(fileContent);
        }

        return testSets
                .stream()
                .filter(set -> isSpecialSubsetSum(set))
                .map(set -> set
                        .stream()
                        .reduce(Long::sum)
                        .orElse(0l))
                .reduce(Long::sum)
                .orElse(0l)
                .toString();
    }

    private Set<List<Integer>> generateSetOfSplits(List<Integer> list, Integer n, Set<List<Integer>> setOfSplits) {
        if (list.size() == n) {
            setOfSplits.add(list);
        } else {
            for (int s : SPLIT_SIGNS) {
                ArrayList<Integer> newList = new ArrayList<>(list);
                newList.add(s);
                generateSetOfSplits(newList, n, setOfSplits);
            }
        }
        return setOfSplits;
    }

    public void loadFile(List<String> fileContent) {
        for (int lineIdx = 0; lineIdx < fileContent.size(); lineIdx++) {
            List<String> line = new ArrayList<>(Arrays.asList(fileContent
                    .get(lineIdx)
                    .split(",")));
            Set<Long> lineVals = line
                    .stream()
                    .map(Long::parseLong)
                    .collect(Collectors.toSet());
            testSets.add(lineVals);
        }
    }

    private boolean isSpecialSubsetSum(Set<Long> set) {
        List<Long> setAsList = new ArrayList<>(set);
        TreeMap<Long, Long> sumsMap = new TreeMap<>();
        for (List<Integer> split : getSplitsFor(set.size())) {
            long count = 0;
            long sum = 0;
            for (int i = 0; i < set.size(); i++) {
                if (split.get(i) == 0) {
                    count++;
                    sum += setAsList.get(i);
                }
            }
            sumsMap.put(sum, count);
        }
        if (sumsMap.size() != getSplitsFor(set.size())
                .size()) {
            return false;
        }
        for (long k0 : sumsMap.keySet()) {
            for (long k1 : sumsMap.keySet()) {
                if (k0 >= k1) {
                    continue;
                }
                if (sumsMap.get(k0) > sumsMap.get(k1)) {
                    return false;
                }
            }
        }

        return true;
    }

    private Set<List<Integer>> getSplitsFor(final int size) {
        Set<List<Integer>> splitsSet = mapOfSplits.get(size);
        if (splitsSet == null) {
            splitsSet = generateSetOfSplits(new ArrayList<>(), size, new HashSet<>());
            mapOfSplits.put(size, splitsSet);
        }
        return splitsSet;
    }
}
