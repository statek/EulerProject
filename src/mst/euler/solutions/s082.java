package mst.euler.solutions;

import static mst.euler.Lib.readFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import mst.euler.Solution;

public class s082 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s082().run());
  }

  private List<List<Integer>> grid = new ArrayList<>();
  private List<List<Node>> nodeGrid = new ArrayList<>();
  private Node root, leaf;

  @Override
  public String solve() {

    List<String> fileContent = readFile("src/mst/euler/resources/p082_matrix.txt");
    loadFileToGrid(fileContent);
    buildTree();
    findPath();

    return String.valueOf(root.minSum);
  }

  private void buildTree() {
    leaf = new Node(0);
    leaf.setMinSum(0);
    root = new Node(0);
    root.setMinSum(Long.MAX_VALUE);
    for (int x = 0; x < nodeGrid.size(); x++) {
      for (int y = nodeGrid.get(x).size()-1; y >= 0; y--) {
        Node n = nodeGrid.get(x).get(y);
        if (x - 1 >= 0) {
          n.addAsNeighbour(nodeGrid.get(x - 1).get(y));
        }
        if (x + 1 < nodeGrid.size()) {
          n.addAsNeighbour(nodeGrid.get(x + 1).get(y));
        }
        if (y + 1 < nodeGrid.get(x).size()) {
          n.setShortPath(nodeGrid.get(x).get(y + 1));
        }
        if (y == 0) {
          root.addAsNeighbour(nodeGrid.get(x).get(y));
        }
        if (y + 1 == nodeGrid.get(x).size()) {
          n.setShortPath(leaf);
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
      for (int i : lineVals) {
        nodeLine.add(new Node(i));
      }
      nodeGrid.add(nodeLine);
      grid.add(lineVals);
    }
  }

  public Long findPath() {
    buildTree();

    int wayLength = nodeGrid.get(0).size()-1;
    for (int y = wayLength; y >= 0; y--) {
      for (int x = wayLength; x >= 0; x--) {
        nodeGrid.get(x).get(y).evaluateShortPath();
      }
      boolean c = true;
      while (c) {
        c = false;
        for (int x = wayLength; x >= 0; x--) {
          c |= nodeGrid.get(x).get(y).evaluateNeighbours();
        }
      }
    }
    root.evaluateNeighbours();
    return root.getMinSum();
  }

  class Node {

    int value;
    Long minSum;
    ArrayList<Node> neighbours;
    Node shortPathNode;

    Node(int value) {
      this.value = value;
      neighbours = new ArrayList<>();
    }

    public void addAsNeighbour(Node node) {
      neighbours.add(node);
    }

    public void setShortPath(Node node) {
      shortPathNode = node;
    }

    public long getMinSum() {
      return minSum;
    }

    public void setMinSum(long sum) {
      minSum = sum;
    }

    private boolean evaluateNeighbours() {
      long mSum = minSum;
      if (this == leaf) {
        minSum = 0l;
      } else {
        for (Node n : neighbours) {
          if (minSum > n.getMinSum() + value) {
            minSum = n.getMinSum() + value;
          }
        }
      }
      return minSum != mSum;
    }

    public void evaluateShortPath() {
      minSum = value + shortPathNode.getMinSum();
    }
  }
}
