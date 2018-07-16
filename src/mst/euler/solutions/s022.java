package mst.euler.solutions;

import mst.euler.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static mst.euler.Lib.readFile;

public class s022 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s022().run());
    }

    @Override
    public String solve() {
        List<String> fileContent = readFile("src/mst/euler/resources/p022_names.txt");
        List<String> names = new ArrayList<>(Arrays.asList(fileContent.get(0).replace("\"","").split(",")));
        Collections.sort(names);
        long sum = 0;
        for (int i = 0; i < names.size(); i++) {
            sum += (i+1) * nameValue(names.get(i));
        }
        return String.valueOf(sum);
    }

    private long nameValue(String s) {
        long val = 0;
        for (char sign : s.toCharArray()) {
            val+=sign-'A'+1;
        }
        return val;
    }
}
