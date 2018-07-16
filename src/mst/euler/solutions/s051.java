package mst.euler.solutions;

import mst.euler.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static mst.euler.Lib.prepareSieve;

public class s051 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s051().run());
    }

    @Override
    public String solve() {
        {
            sieve = prepareSieve(1_000_000);
            long j = 0;
            List<Long> members;
            List<String> families;
            int maxMembersSize = 8;
            while (true) {
                for (long i : sieve) {
                    if (i < j) continue;
                    j = i;
                    families = getPossibleFamilies(i);
                    for (String f : families) {
                        members = filterNonPrimes(getFamilyMembers(f));
                        if (members.size() == maxMembersSize) {
                            return String.valueOf(members.get(0));
                        }
                    }
                }
            }
        }
    }

    private Set<Long> sieve;

    private boolean isPrime(long number) {
        return sieve.contains(number);
    }

    private List<Long> filterNonPrimes(List<Long> numbers) {
        return numbers.stream().filter(i -> isPrime(i)).collect(Collectors.toList());
    }

    private List<Long> getFamilyMembers(String number) {
        List<Long> members = new ArrayList<>();
        Long tmp;
        for (long i = 0; i <= 9; i++) {
            tmp = Long.parseLong(number.replace("*", String.valueOf(i)));
            if (tmp.toString().length() == number.length()) {
                members.add(tmp);
            }
        }
        return members;
    }

    private List<String> getPossibleFamilies(Long number) {
        List<String> families = new ArrayList<>();
        String num = String.valueOf(number);
        List<String> masks = getMasks(num.length());
        String fam;

        for (String m : masks) {
            fam = "";
            for (int i = 0; i < num.length(); i++) {
                fam += m.charAt(i) == '1' ? "*" : num.charAt(i);
            }
            families.add(fam);
        }
        return families;
    }

    private List<String> getMasks(int length) {
        int i = 1;
        String m, templ = "";
        for (int j = 0; j < length; j++) {
            templ += "0";
        }
        List<String> masks = new ArrayList<>();
        while (Integer.toBinaryString(i).length() <= length) {
            m = templ + Integer.toBinaryString(i);
            masks.add(m.substring(m.length() - length));
            i++;
        }
        return masks;
    }
}
