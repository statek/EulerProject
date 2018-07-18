package mst.euler.solutions;

import mst.euler.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static mst.euler.Lib.readFile;

public class s067 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s067().run());
    }

    final int HEURISTIC_FACTOR = 75;

    public long getMaxSum() {
        return maxSum;
    }

    public void setHeuristicFactor(int heuristicFactor) {
        this.heuristicFactor = heuristicFactor;
    }

    int heuristicFactor=HEURISTIC_FACTOR;
    long maxSum = 0;
    int depth;
    List<List<Integer>> triTable = new ArrayList<>();

    @Override
    public String solve() {

        List<String> fileContent = readFile("src/mst/euler/resources/p067_triangle.txt");
        loadFileToTriTable(fileContent);
        findPath(0, 0, 0);

        return String.valueOf(maxSum);
    }

    public void loadFileToTriTable(List<String> fileContent) {
        triTable = new ArrayList<>();
        for (int lineIdx = 0; lineIdx < fileContent.size(); lineIdx++) {
            List<String> line = new ArrayList<>(Arrays.asList(fileContent.get(lineIdx).split(" ")));
            List<Integer> level = line.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
            triTable.add(level);
        }
        depth = triTable.size();
    }

    public void findPath(int level, int idx, long sum) {
        sum += triTable.get(level).get(idx);
        if (level + 1 < depth) {

            long lval = evaluate(level + 1, idx, sum);
            long rval = evaluate(level + 1, idx + 1, sum);
            if (lval > rval) {
                if (lval > 0) findPath(level + 1, idx, sum);
                if (rval > 0) findPath(level + 1, idx + 1, sum);
            } else {
                if (rval > 0) findPath(level + 1, idx + 1, sum);
                if (lval > 0) findPath(level + 1, idx, sum);
            }
        } else {
            maxSum = Long.max(sum, maxSum);
        }
    }

    private long evaluate(int level, int idx, long sum) {
        long val = (depth - level) * heuristicFactor + triTable.get(level).get(idx) + sum;
        val = (val > maxSum) ? val : 0;
        return val;
    }

}
