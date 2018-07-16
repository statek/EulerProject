package mst.euler.solutions;

import mst.euler.Solution;

import static mst.euler.Lib.isPrime;

public class s027 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s027().run());
    }

    @Override
    public String solve() {
        int maxCount=0, product=1, tmpCount;
        for(int a =-999;a<1000;a++){
            for(int b =-1000;b<=1000;b++) {
                tmpCount= countPrimesGeneratedByFormula(a,b);
                if (tmpCount>=maxCount) {
                    maxCount = tmpCount;
                    product=a*b;
                }
            }
        }
        return String.valueOf(product);
    }

    private int countPrimesGeneratedByFormula(int a, int b) {
        int n=-1;
        int tmpN=1;
        while (tmpN>0 && isPrime(tmpN)){
            n++;
            tmpN=n*n+a*n+b;
        }
        return n-1;
    }
}
