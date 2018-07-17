package mst.euler.solutions;

import mst.euler.Solution;

import java.util.*;
import java.util.stream.Collectors;

public class s061 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s061().run());
    }

    @Override
    public String solve() {
        List<Set<Integer>> nums = new ArrayList<>();
        nums.add(generateDefinedTypeNumbersFromScope(3, 1000, 9999));   // 96
        nums.add(generateDefinedTypeNumbersFromScope(4, 1000, 9999));   // 68
        nums.add(generateDefinedTypeNumbersFromScope(5, 1000, 9999));   // 56
        nums.add(generateDefinedTypeNumbersFromScope(6, 1000, 9999));   // 48
        nums.add(generateDefinedTypeNumbersFromScope(7, 1000, 9999));   // 43
        nums.add(generateDefinedTypeNumbersFromScope(8, 1000, 9999));   // 40

        Set<Integer> digits = new HashSet<>();
        Set<Integer> lastDigits = new HashSet<>();

        for (Set<Integer> set : nums) {
            digits.addAll(set.stream().map(n -> n / 100).collect(Collectors.toSet()));    // "XX??"
            lastDigits.addAll(set.stream().map(n -> n % 100).collect(Collectors.toSet()));    // "??XX"
        }

        digits.retainAll(lastDigits);

        for (int i = 0; i < nums.size(); i++) {
            nums.set(i, nums.get(i).stream().filter(n -> digits.contains(n % 100)).collect(Collectors.toSet())); // remove not matching last
            nums.set(i, nums.get(i).stream().filter(n -> digits.contains(n / 100)).collect(Collectors.toSet())); // remove not matching first
        }

        List<Integer> resultChain = findChain(nums, new ArrayList<>(), new HashSet<>());
        System.out.println(resultChain);

        return String.valueOf(resultChain.stream().mapToInt(Integer::intValue).sum());
    }

    private List<Integer> findChain(List<Set<Integer>> nums, ArrayList<Integer> chain, Set<Integer> usedTypes) {
        if (usedTypes.size()==nums.size() && chain.get(chain.size()-1)%100 == chain.get(0)/100){
            return chain;
        }
        List<Integer> resultChain = null;
        for (int i = 0; i< nums.size(); i++)
        {
            if (usedTypes.contains(i)) continue;
            for(int n : nums.get(i)){
                if (chain.size()==0 || chain.get(chain.size()-1)%100 == n/100){
                    chain.add(n);
                    usedTypes.add(i);
                    resultChain = findChain(nums, chain, usedTypes);
                    if (resultChain!= null) return resultChain;
                    chain.remove((Integer)n);
                    usedTypes.remove(i);
                }
            }
        }
        return resultChain;
    }



    private TreeSet<Integer> generateDefinedTypeNumbersFromScope(int type, int min, int max) {
        TreeSet<Integer> numbers = new TreeSet<>();
        int num = 0, i = 1;
        do {
            if (num >= min) numbers.add(num);
            num = generateDefinedTypeNumber(type, i);
            i++;
        } while (num <= max);
        return numbers;
    }

    private int generateDefinedTypeNumber(int type, int n) {
        return
                (type == 3) ? n * (n + 1) / 2 :
                        (type == 4) ? n * n :
                                (type == 5) ? n * (3 * n - 1) / 2 :
                                        (type == 6) ? n * (2 * n - 1) :
                                                (type == 7) ? n * (5 * n - 3) / 2 :
                                                        (type == 8) ? n * (3 * n - 2) :
                                                                n;
    }
}
