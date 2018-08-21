package mst.euler.solutions;

import static java.lang.Math.pow;
import static java.lang.Math.round;
import static java.lang.Math.sqrt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mst.euler.Solution;

public class s205 extends Solution {

  public static void main(String[] args) {
    System.out.println(new s205().run());
  }

  private final Set<Integer> dice4 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
  private final Set<Integer> dice6 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));

  private final Integer DICES4SIDED = 9;
  private final Integer DICES6SIDED = 6;

  private HashMap<Integer, Double> dice4throws = new HashMap<>();
  private HashMap<Integer, Double> dice6throws = new HashMap<>();

  @Override
  public String solve() {
    symulate4throws();
    symulate6throws();

    double win4ratio = 0;
    for (Map.Entry<Integer, Double> e4 : dice4throws.entrySet()) {
      double sum6e = 0;
      for (Map.Entry<Integer, Double> e6 : dice6throws.entrySet()) {
        if(e6.getKey()<e4.getKey()){
          sum6e+=e6.getValue();
        }
      }
      win4ratio+=e4.getValue()*sum6e;
    }

    return String.valueOf((double)round(win4ratio*pow(10,7))/pow(10,7));
  }

  private void symulate4throws() {
    dice(new ArrayList<>(), dice4, DICES4SIDED, dice4throws);
    calcProbability(dice4throws);
  }

  private void symulate6throws() {
    dice(new ArrayList<>(), dice6, DICES6SIDED, dice6throws);
    calcProbability(dice6throws);
  }

  private void calcProbability(HashMap<Integer, Double> diceThrows) {
    double throwsNumber = 0;
    for (double v : diceThrows.values()) {
      throwsNumber += v;
    }
    for (Map.Entry<Integer, Double> e : diceThrows.entrySet()) {
      e.setValue(e.getValue() / throwsNumber);
    }
  }

  private void dice(List<Integer> diceThrows, Set<Integer> dice, Integer diceNumber,
      HashMap<Integer, Double> diceThrowsResults) {
    if (diceThrows.size() == diceNumber) {
      int sum = diceThrows.stream().mapToInt(Integer::intValue).sum();
      diceThrowsResults.putIfAbsent(sum, 0d);
      diceThrowsResults.put(sum, diceThrowsResults.get(sum) + 1);
    } else {
      for (int d : dice) {
        ArrayList<Integer> newThrows = new ArrayList<>(diceThrows);
        newThrows.add(d);
        dice(newThrows, dice, diceNumber, diceThrowsResults);
      }
    }
  }


}
