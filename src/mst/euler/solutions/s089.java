package mst.euler.solutions;

import mst.euler.Solution;

import java.util.*;

import static mst.euler.Lib.readFile;

public class s089 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s089().run());
    }

    private Map<String, Integer> roman2number = new HashMap<>();
    private Map<Integer, String> number2roman = new HashMap<>();

    public s089() {
        roman2number.put("I", 1);
        roman2number.put("V", 5);
        roman2number.put("X", 10);
        roman2number.put("L", 50);
        roman2number.put("C", 100);
        roman2number.put("D", 500);
        roman2number.put("M", 1000);

        number2roman.put(1000, "M");
        number2roman.put(900, "CM");
        number2roman.put(500, "D");
        number2roman.put(400, "CD");
        number2roman.put(100, "C");
        number2roman.put(90, "XC");
        number2roman.put(50, "L");
        number2roman.put(40, "XL");
        number2roman.put(10, "X");
        number2roman.put(9, "IX");
        number2roman.put(5, "V");
        number2roman.put(4, "IV");
        number2roman.put(1, "I");
    }

    @Override
    public String solve() {
        long cntChars = 0;
        List<String> fileContent = readFile("src/mst/euler/resources/p089_roman.txt");
        for (String line : fileContent) {
            long number = readRoman(line);
            String romanNumber = writeRoman(number);
            cntChars += line.length()-romanNumber.length();
        }
        return String.valueOf(cntChars);
    }

    private long readRoman(String line) {
        ArrayList<String> romanNumber = new ArrayList<>(Arrays.asList(line.split("")));
        long value = 0;
        int i, n;
        for (i = 0; i < romanNumber.size(); i++) {
            n = (i + 1 < romanNumber.size()) ? i + 1 : i;
            if (roman2number.get(romanNumber.get(i)) < roman2number.get(romanNumber.get(n))) {
                value += roman2number.get(romanNumber.get(n)) - roman2number.get(romanNumber.get(i));
                i++;
            } else {
                value += roman2number.get(romanNumber.get(i));
            }
        }
        return value;
    }

    private String writeRoman(long number) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> romanValues = new ArrayList<>(number2roman.keySet());
        Collections.sort(romanValues);
        Collections.reverse(romanValues);
        for (int val : romanValues) {
            while (number >= val) {
                number -= val;
                sb.append(number2roman.get(val));
            }
        }
        return sb.toString();
    }


}
