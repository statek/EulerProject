package mst.euler.solutions;

import mst.euler.Solution;

import static mst.euler.Lib.biFactorial;

public class s015 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s015().run());
    }

    @Override
    public String solve() {
        return String.valueOf(latticePathsMath(20));
    }

    public long latticePathsMath(int n){
        return biFactorial(2*n).divide(biFactorial(n)).divide(biFactorial(n)).longValue();
    }


}
