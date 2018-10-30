package mst.euler.solutions;

import static mst.euler.Lib.readFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import javafx.util.Pair;
import mst.euler.Solution;

public class s098 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s098().run());
  }

  private Set<AnagramicPair> anagramicPairs = new HashSet<>();
  private List<String> dictionary = new ArrayList<>();
  private Set<Long> squares = new HashSet<>();
  private Set<Long> anagramicSquares = new HashSet<>();
  int maxLength = 0;

  @Override
  public String solve() {
    if (dictionary.isEmpty()) {
      List<String> fileContent = readFile("src/mst/euler/resources/p098_words.txt");
      loadFile(fileContent);
    }
    generateAnagramicPairs();
    generateSquares();
    findMaxAnagramicSquare();
    return String.valueOf(anagramicSquares.stream().mapToLong(Long::longValue).max().getAsLong());
  }

  private void generateAnagramicPairs() {
    AnagramicPairBuilder builder = new AnagramicPairBuilder();
    for (int i1 = 0; i1 < dictionary.size(); i1++) {
      String w1 = dictionary.get(i1);
      for (int i2 = i1 + 1; i2 < dictionary.size(); i2++) {
        String w2 = dictionary.get(i2);
        AnagramicPair ap = builder.buildAnagramicPair(w1, w2);
        if (ap != null) {
          maxLength = Integer.max(w1.length(), maxLength);
          anagramicPairs.add(ap);
        }
      }
    }
  }

  private void findMaxAnagramicSquare() {
    for (AnagramicPair ap : anagramicPairs) {
      for (Long k : squares) {
        Long k2 = ap.code(k);
        if (squares.contains(k2) && k2 > 0 && !k.equals(k2)) {
          anagramicSquares.add(k2);
          anagramicSquares.add(k);
        }
      }
    }
  }

  private void generateSquares() {
    long x = 1, x2 = 1;
    long y = (long) Math.pow(10, maxLength);
    while (x2 < y) {
      squares.add(x2);
      x++;
      x2 = x * x;
    }
  }

  public void loadFile(List<String> fileContent) {
    for (int lineIdx = 0; lineIdx < fileContent.size(); lineIdx++) {
      Set<String> line = new HashSet<>(Arrays.asList(fileContent.get(lineIdx).split("\"")));
      line.remove(",");
      line.remove("");
      dictionary.addAll(line.stream().filter(w -> w.length() >= 2).collect(Collectors.toSet()));
    }
  }

  class AnagramicPairBuilder {

    AnagramicPair buildAnagramicPair(String a, String b) {
      if (!a.equals(b) && a.length() == b.length() && areAnagramic(a, b)) {
        return new AnagramicPair(a, b);
      }
      return null;
    }

    private boolean areAnagramic(String s1, String s2) {
      ArrayList<String> s1set = new ArrayList<>(Arrays.asList(s1.split("")));
      ArrayList<String> s2set = new ArrayList<>(Arrays.asList(s2.split("")));
      Collections.sort(s1set);
      Collections.sort(s2set);
      return s1set.equals(s2set);
    }
  }

  class AnagramicPair {

    String s1, s2;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      AnagramicPair that = (AnagramicPair) o;
      return Objects.equals(s1, that.s1) &&
          Objects.equals(s2, that.s2);
    }

    @Override
    public int hashCode() {
      return Objects.hash(s1, s2);
    }

    AnagramicPair(String a, String b) {
      if (a.compareTo(b) > 0) {
        s1 = a;
        s2 = b;
      } else {
        s1 = b;
        s2 = a;
      }
    }

    long code(long key) {
      if (String.valueOf(key).length() == s1.length()) {
        String[] k = String.valueOf(key).split("");
        String[] s1t = String.valueOf(s1).split("");
        Set<String> s1set = new HashSet<>(Arrays.asList(s1t));
        Set<String> kset = new HashSet<>(Arrays.asList(k));
        if (kset.size() == s1set.size()) {
          Map<String, String> cipherMap = new HashMap<>();
          for (int i = 0; i < s1.length(); i++) {
            cipherMap.put(s1t[i], k[i]);
          }
          StringBuilder sb = new StringBuilder();
          for (int i = 0; i < s1.length(); i++) {
            sb.append(cipherMap.get(s1t[i]));
          }
          if (sb.toString().equals(String.valueOf(key))) {
            String[] s2t = String.valueOf(s2).split("");
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < s1.length(); i++) {
              sb2.append(cipherMap.get(s2t[i]));
            }
            if (Long.valueOf(sb2.toString()).toString().length() == s1.length()) {
              return Long.valueOf(sb2.toString());
            }
          }
        }
      }
      return 0l;
    }
  }
}
