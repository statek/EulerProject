package mst.euler.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mst.euler.Solution;

public class s093 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s093().run());
  }

  private HashMap<List<Integer>, Set<Double>> values = new HashMap<>();


  @Override
  public String solve() {
    ArtExp best = new ArtExp();
    int i = 0;
    for (int a = 1; a <= 9; a++) {
      for (int b = a + 1; b <= 9; b++) {
        List<Integer> pair = new ArrayList<>();
        pair.add(a);
        pair.add(b);
        for (int c = b + 1; c <= 9; c++) {
          for (int d = c + 1; d <= 9; d++) {
            List<Integer> list = new ArrayList<>();
            list.add(a);
            list.add(b);
            list.add(c);
            list.add(d);
            getValues(list);
            ArtExp ae = new ArtExp(list);
            best = ae.maxConsecutive > best.maxConsecutive ? ae : best;
          }
        }
      }
    }
    return String.valueOf(best);
  }

  private Set<Double> getValues(List<Integer> list) {
    if (values.containsKey(list)) {
      return values.get(list);
    }

    Set<Double> vals = new HashSet<>();
    if (list.size() == 1) {
      vals.add((double) (list.get(0)));
    } else {
      for (Integer a : list) {
        List<Integer> la = new ArrayList<>(list);
        la.remove(a);
        for (Double v : getValues(la)) {
          vals.add(a + v);
          vals.add(a - v);
          vals.add(v - a);
          vals.add(a * v);
          vals.add(v / a);
          vals.add(a / v);
        }
      }
    }
    values.put(list, vals);
    return vals;
  }

  class ArtExp {

    List<Integer> l;
    Set<Double> results = new HashSet<>();
    int maxConsecutive = 0;


    ArtExp() {
    }

    ArtExp(List<Integer> list) {
      l = list;
      results = getValues(list);
      findMaxConsecutive();
    }

    private void findMaxConsecutive() {
      Double max = 1d;
      while (results.contains(max)) {
        max++;
      }
      maxConsecutive = max.intValue() - 1;
    }

    @Override
    public String toString() {
      String s = "";
      for (int c : l) {
        s += c;
      }
      return s;
    }
  }
}
