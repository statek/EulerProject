package mst.euler.solutions;

import mst.euler.Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static mst.euler.Lib.isPandigital;

public class s032 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s032().run());
    }

    @Override
    public String solve() {
        Set<String> set = generateCombinations(digits);
        Set<Long> productSet = new HashSet<>();
        for (String s : set){
            productSet.addAll(hasPandigitalProduct(s));
        }
        Long sum = productSet.stream().mapToLong(Long::longValue).sum();
        return String.valueOf(sum);
    }

    private String digits = "123456789";

    private long hasPandigitalProduct(long i, long j) {
        long m = i*j;
        return (("" + i + j + m).length()==9 && isPandigital("" + i + j + m)) ? m : 0L;
    }

    private Set<String> generateCombinations(String str) {
        String[] letters = str.split("");
        HashSet<String> validSet = new HashSet<>(Arrays.asList(letters));
        return generateCombinations("",validSet);

    }
    private Set<String> generateCombinations(String str, Set<String> validSet) {
        HashSet<String> resultSet = new HashSet<>();
        for (String l:validSet){
            HashSet<String> tmpSet = new HashSet<>(validSet);
            tmpSet.remove(l);
            resultSet.add(str+l);
            resultSet.addAll(generateCombinations(str+l,tmpSet));
        }
        return resultSet;
    }

    private Set<Long> hasPandigitalProduct(String str) {
        Set<Long> set = new HashSet<>();
        for (int i = 1; i<str.length()-1; i++){
            set.add(hasPandigitalProduct(Long.parseLong(str.substring(0,i)),Long.parseLong(str.substring(i))));
        }
        return set;
    }
}