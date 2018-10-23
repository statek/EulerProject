package mst.euler.solutions;

import static mst.euler.Lib.readFile;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import mst.euler.Solution;

public class s083 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s083().run());
  }

  private List<List<Integer>> grid = new ArrayList<>();
  private List<List<Node>> nodeGrid = new ArrayList<>();
  private Queue<Node> queueToEval = new PriorityQueue<>();
  private Node root, leaf;

  @Override
  public String solve() {

    List<String> fileContent = readFile("src/mst/euler/resources/p083_matrix.txt");
    loadFileToGrid(fileContent);
    buildTree();
    findPath();

    return String.valueOf(root.minSum);
  }

  private void buildTree() {
    root = nodeGrid.get(0).get(0);
    leaf = nodeGrid.get(nodeGrid.size() - 1).get(nodeGrid.size() - 1);
    for (int x = 0; x < nodeGrid.size(); x++) {
      for (int y = 0; y < nodeGrid.get(x).size(); y++) {
        Node n = nodeGrid.get(x).get(y);
        if (x + 1 < nodeGrid.size()) {
          n.addAsNeighbour(nodeGrid.get(x + 1).get(y));
        }
        if (y + 1 < nodeGrid.get(x).size()) {
          n.addAsNeighbour(nodeGrid.get(x).get(y + 1));
        }
        if (x - 1 >= 0) {
          n.addAsNeighbour(nodeGrid.get(x - 1).get(y));
        }
        if (y - 1 >= 0) {
          n.addAsNeighbour(nodeGrid.get(x).get(y - 1));
        }
      }
    }
  }

  public void loadFileToGrid(List<String> fileContent) {
    grid = new ArrayList<>();
    for (int lineIdx = 0; lineIdx < fileContent.size(); lineIdx++) {
      List<String> line = new ArrayList<>(Arrays.asList(fileContent.get(lineIdx).split(",")));
      List<Integer> lineVals = line.stream().map(s -> Integer.parseInt(s))
          .collect(Collectors.toList());
      List<Node> nodeLine = new ArrayList<>();
      for (int idx = 0; idx < lineVals.size(); idx++) {
        nodeLine.add(new Node(lineIdx + idx, lineVals.get(idx)));
      }
      nodeGrid.add(nodeLine);
      grid.add(lineVals);
    }
  }

  public Long findPath() {
    buildTree();
    queueToEval.add(leaf);

    while (!queueToEval.isEmpty()) {
      Node evalNode = queueToEval.poll();
      evalNode.evaluate();
    }

    return root.getMinSum();
  }

  class Node implements Comparable<Node> {

    int level;
    int value;
    Long minSum = Long.valueOf(Integer.MAX_VALUE);
    ArrayList<Node> neighbours;

    Node(int level, int value) {
      this.level = level;
      this.value = value;
      neighbours = new ArrayList<>();
    }

    public long getMinSum() {
      return minSum;
    }

    public void addAsNeighbour(Node node) {
      neighbours.add(node);
    }

    private void evaluate() {
      long mSum = minSum;
      if (this == leaf) {
        minSum = Long.valueOf(value);
      } else {
        for (Node n : neighbours) {
          if (minSum > n.getMinSum() + value) {
            minSum = n.getMinSum() + value;
          }
        }
      }
      if (mSum != minSum) {
        for (Node n : neighbours) {
          if (minSum < n.getMinSum()) {
            if (!queueToEval.contains(n)) {
              queueToEval.add(n);
            }
          }
        }
      }
    }

    @Override
    public int compareTo(Node n) {
      if (this.level==n.level) return 0;
      if (this.level>=n.level) return -1;
      else return 1;
    }
  }
}
