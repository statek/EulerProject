package mst.euler.solutions;

import static mst.euler.Lib.readFile;

import com.sun.jmx.remote.internal.ArrayQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import mst.euler.Solution;

public class s345 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s345().run());
  }

  final private int HEURISTIC_FACTOR = 900;
  private int heuristicFactor = HEURISTIC_FACTOR;
  private List<List<Integer>> grid = new ArrayList<>();
  private Deque<Integer> chosenIndexes = new ArrayDeque<>();
  private int maxSum = 0;

  public int getMaxSum() {
    return maxSum;
  }

  @Override
  public String solve() {

    List<String> fileContent = readFile("src/mst/euler/resources/p345_matrix.txt");
    loadFileToGrid(fileContent);
    findMaxSum();
    return String.valueOf(getMaxSum());
  }


  public void findMaxSum() {
    int depth = grid.size() - chosenIndexes.size();
    if (depth == 0) {
      maxSum = Integer.max(maxSum, calcSum());
    } else {
      for (int i = 0; i < grid.size(); i++) {
        if (!chosenIndexes.contains(i)
            && calcSum() + depth * heuristicFactor + grid.get(chosenIndexes.size()).get(i) > maxSum) {
          chosenIndexes.addLast(i);
          findMaxSum();
          chosenIndexes.pollLast();
        }
      }
    }
  }

  public int calcSum() {
    int sum = 0;
    List<Integer> idx = new ArrayList(chosenIndexes);
    for (int x = 0; x < idx.size(); x++) {
      sum += grid.get(x).get(idx.get(x));
    }
    return sum;
  }

  public void loadFileToGrid(List<String> fileContent) {
    grid = new ArrayList<>();
    for (int lineIdx = 0; lineIdx < fileContent.size(); lineIdx++) {
      List<String> line = new ArrayList<>(Arrays.asList(fileContent.get(lineIdx).split(",")));
      List<Integer> lineVals = line.stream().map(s -> Integer.parseInt(s))
          .collect(Collectors.toList());
      grid.add(lineVals);
    }
  }

  public void setHeuristicFactor(int heuristicFactor) {
    this.heuristicFactor = heuristicFactor;
  }
}