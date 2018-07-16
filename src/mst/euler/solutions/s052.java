package mst.euler.solutions;

import mst.euler.Solution;

import java.util.HashMap;
import java.util.Map;

public class s052 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s052().run());
    }

    @Override
    public String solve() {
        int x = 1;
        while (
                !countDigits(x).equals(countDigits(2 * x))
                        || !countDigits(x).equals(countDigits(3 * x))
                        || !countDigits(x).equals(countDigits(4 * x))
                        || !countDigits(x).equals(countDigits(5 * x))
                        || !countDigits(x).equals(countDigits(6 * x))
                ) {
            x++;
        }
        return String.valueOf(x);
    }

    private static Map<String, Integer> countDigits(int num) {
        String str = String.valueOf(num);
        Map<String, Integer> map = new HashMap<>();
        for (String s : str.split("")) {
            if (map.containsKey(s)) map.put(s, map.get(s) + 1);
            else map.put(s, 1);
        }
        return map;
    }
}