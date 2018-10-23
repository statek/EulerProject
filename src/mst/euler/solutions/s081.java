package mst.euler.solutions;

import static mst.euler.Lib.readFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import mst.euler.Solution;

public class s081 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s081().run());
  }

  private List<List<Integer>> grid = new ArrayList<>();
  private List<List<Node>> nodeGrid = new ArrayList<>();
  private Node root;

  @Override
  public String solve() {

    List<String> fileContent = readFile("src/mst/euler/resources/p081_matrix.txt");
    loadFileToGrid(fileContent);
    buildTree();
    findPath();

    return String.valueOf(root.minSum);
  }

  private void buildTree() {
    root = nodeGrid.get(0).get(0);
    for (int x = 0; x < nodeGrid.size(); x++) {
      for (int y = 0; y < nodeGrid.get(x).size(); y++) {
        Node n = nodeGrid.get(x).get(y);
        if (x + 1 < nodeGrid.size()) {
          n.addAsNext(nodeGrid.get(x + 1).get(y));
        }
        if (y + 1 < nodeGrid.get(x).size()) {
          n.addAsNext(nodeGrid.get(x).get(y + 1));
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
    return root.getMinSum();
  }

  class Node {

    int value;
    Long minSum;
    ArrayList<Node> pathTo;

    Node(int value) {
      this.value = value;
      pathTo = new ArrayList<>();
    }

    public void addAsNext(Node node) {
      pathTo.add(node);
    }

    public long getMinSum() {
      if (minSum == null) {
        evaluate();
      }
      return minSum;
    }

    private void evaluate() {
      if (pathTo.isEmpty()) {
        minSum = Long.valueOf(value);
      } else {
        Node nextNode = pathTo.get(0);
        for (Node n : pathTo) {
          if (nextNode.getMinSum() > n.getMinSum()) {
            nextNode = n;
          }
        }
        minSum = value + nextNode.getMinSum();
      }
    }
  }
}
