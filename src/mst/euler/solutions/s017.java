package mst.euler.solutions;

import mst.euler.Solution;

import java.util.HashMap;
import java.util.Map;

public class s017 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s017().run());
    }

    @Override
    public String solve() {
        initNumbersLength();
        int sum = 0;
        for (int i = 0; i <= 99; i++) {
            sum += countLetters(i);
        }
        int sum1_99=sum;
        for (int i = 1; i < 10; i++) {
            sum += (countLetters(i) + countLetters(100));
            sum += (countLetters(i) + countLetters(100) + "and".length()) * 99;
            sum += sum1_99;
        }
        sum += (countLetters(1) + countLetters(1000));
        return String.valueOf(sum);
    }

    private Map<Integer, Integer> numbersLength = new HashMap<>();

    private int countLetters(int i) {
        return (numbersLength.containsKey(i)) ? numbersLength.get(i) : countLetters(i / 10 * 10) + countLetters(i % 10);
    }

    private void initNumbersLength() {
        numbersLength.put(0, 0);
        numbersLength.put(1, "one".length());
        numbersLength.put(2, "two".length());
        numbersLength.put(3, "three".length());
        numbersLength.put(4, "four".length());
        numbersLength.put(5, "five".length());
        numbersLength.put(6, "six".length());
        numbersLength.put(7, "seven".length());
        numbersLength.put(8, "eight".length());
        numbersLength.put(9, "nine".length());
        numbersLength.put(10, "ten".length());
        numbersLength.put(11, "eleven".length());
        numbersLength.put(12, "twelve".length());
        numbersLength.put(13, "thirteen".length());
        numbersLength.put(14, "fourteen".length());
        numbersLength.put(15, "fifteen".length());
        numbersLength.put(16, "sixteen".length());
        numbersLength.put(17, "seventeen".length());
        numbersLength.put(18, "eighteen".length());
        numbersLength.put(19, "nineteen".length());
        numbersLength.put(20, "twenty".length());
        numbersLength.put(30, "thirty".length());
        numbersLength.put(40, "forty".length());
        numbersLength.put(50, "fifty".length());
        numbersLength.put(60, "sixty".length());
        numbersLength.put(70, "seventy".length());
        numbersLength.put(80, "eighty".length());
        numbersLength.put(90, "ninety".length());
        numbersLength.put(100, "hundred".length());
        numbersLength.put(1000, "thousand".length());
    }
}
