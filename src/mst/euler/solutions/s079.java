package mst.euler.solutions;

import mst.euler.Solution;

import java.util.*;
import java.util.stream.Collectors;

import static mst.euler.Lib.readFile;

public class s079 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s079().run());
    }

    @Override
    public String solve() {

        Map<Integer, Set<Integer>> conditions = new HashMap<>();

        List<String> fileContent = readFile("src/mst/euler/resources/p079_keylog.txt");
        for (String line : fileContent) {
            String[] t = line.split("");
            int d0 = Integer.parseInt(t[0]);
            int d1 = Integer.parseInt(t[1]);
            int d2 = Integer.parseInt(t[2]);
            if (!conditions.keySet().contains(d0)) conditions.put(d0, new HashSet<>());
            if (!conditions.keySet().contains(d1)) conditions.put(d1, new HashSet<>());
            if (!conditions.keySet().contains(d2)) conditions.put(d2, new HashSet<>());
            conditions.get(d0).add(d1);
            conditions.get(d0).add(d2);
            conditions.get(d1).add(d2);
        }
        String passcode = conditions.entrySet().stream().sorted(Comparator.comparingInt(o -> -o.getValue().size())).map(k -> String.valueOf(k.getKey())).collect(Collectors.joining());
        return passcode;
    }
}
