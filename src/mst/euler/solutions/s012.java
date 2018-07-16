package mst.euler.solutions;

import mst.euler.Solution;

import java.util.HashSet;
import java.util.Set;

public class s012 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s012().run());
    }

    @Override
    public String solve() {
        int i=1, tri=1;
        while (countDivisors(tri)<=500) {
            i++;
            tri+=i;
        }
        return String.valueOf(tri);
    }
    public int countDivisors(int num) {
        Set<Integer> divisors = new HashSet<>();
        int i=1;
        while (i<num/i){
            if (num % i == 0) {
                divisors.add(i);
                divisors.add(num/i);
            }
            i++;
        }
        return divisors.size();
    }
}
