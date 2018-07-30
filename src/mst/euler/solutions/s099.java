package mst.euler.solutions;

import mst.euler.Solution;

import java.util.List;

import static java.lang.Math.log;
import static mst.euler.Lib.readFile;

public class s099 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s099().run());
    }

    @Override
    public String solve() {

        List<String> fileContent = readFile("src/mst/euler/resources/p099_base_exp.txt");
        int lineNumber = 0, maxLineNumber = 0;
        double maxResult = 0;
        for (String line : fileContent) {
            lineNumber++;
            String[] numbers = line.split(",");
            long base = Long.parseLong(numbers[0]);
            long exp = Long.parseLong(numbers[1]);
            double result = exp * log(base);
            if (maxResult < result) {
                maxResult = result;
                maxLineNumber = lineNumber;
            }
        }
        return String.valueOf(maxLineNumber);
    }
}
