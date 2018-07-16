package mst.euler.solutions;

import mst.euler.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.*;
import static mst.euler.Lib.readFile;

public class s042 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s042().run());
    }

    @Override
    public String solve() {
        List<String> fileContent = readFile("src/mst/euler/resources/p042_words.txt");
        List<String> words = new ArrayList<>(Arrays.asList(fileContent.get(0).replace("\"","").split(",")));
        int counter=0;
        for(String w : words)
        {
            if (isTriangleNumber(wordValue(w))) counter++;
        }
        return String.valueOf(counter);
    }
    private boolean isTriangleNumber(long l) {
        Long newl = (long) sqrt(2*l);
        newl*=(newl+1);
        newl/=2;
        return l==newl;
    }

    private long wordValue(String s) {
        long val = 0;
        for (char sign : s.toCharArray()) {
            val+=sign-'A'+1;
        }
        return val;
    }
}
