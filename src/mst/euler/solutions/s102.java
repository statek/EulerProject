package mst.euler.solutions;

import static java.lang.Math.signum;
import static mst.euler.Lib.readFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import mst.euler.Solution;

public class s102 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s102().run());
  }

  private List<Triangle> triangles = new ArrayList<>();

  @Override
  public String solve() {
    if (triangles.isEmpty()) {
      List<String> fileContent = readFile("src/mst/euler/resources/p102_triangles.txt");
      loadFile(fileContent);
    }
    return String.valueOf(triangles.stream().filter(t -> t.containsOrigin()).count());
  }

  public void loadFile(List<String> fileContent) {
    for (int lineIdx = 0; lineIdx < fileContent.size(); lineIdx++) {
      List<String> line = new ArrayList<>(Arrays.asList(fileContent.get(lineIdx).split(",")));
      List<Integer> lineVals = line.stream().map(s -> Integer.parseInt(s))
          .collect(Collectors.toList());
      triangles.add(new Triangle(lineVals));
    }
  }

  class Point implements Comparable<Point> {

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }

    int x, y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Point o) {
      return x - o.x;
    }
  }

  class Triangle {

    List<Point> points = new ArrayList<>();

    public boolean containsOrigin() {
      return containsOrigin;
    }

    boolean containsOrigin;

    public Triangle(List<Integer> p) {
      points.add(new Point(p.get(0), p.get(1)));
      points.add(new Point(p.get(2), p.get(3)));
      points.add(new Point(p.get(4), p.get(5)));
      Collections.sort(points);
      if (points.get(1).getX() < 0) {
        Collections.sort(points, Collections.reverseOrder());
      }
      if (Integer.signum(points.get(0).getX()) != Integer.signum(points.get(2).getX())) {
        checkOrigin();
      }
    }

    private void checkOrigin() {
      containsOrigin =
          signum(x0value(points.get(0), points.get(1))) !=
          signum(x0value(points.get(0), points.get(2)));
    }

    private double x0value(Point p0, Point p1) {
      double a = ((double) p0.getY() - p1.getY()) / ((double) p0.getX() - p1.getX());
      double b = (double) p0.getY() - a * p0.getX();
      return b;
    }
  }
}
