package mst.euler.solutions;

import mst.euler.Solution;

import java.math.BigInteger;

public class s057 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s057().run());
    }

    @Override
    public String solve() {
        Fraction f;
        long c=0;
        for (int i=1; i<=1_000; i++)
        {
            f=getNexpansion(i);
            if(String.valueOf(f.n).length()>String.valueOf(f.d).length()) {
                c++;
            }
        }
        return String.valueOf(c);
    }

    class Fraction {

        BigInteger n, d;

        Fraction(long n, long d) {
            this.n = BigInteger.valueOf(n);
            this.d = BigInteger.valueOf(d);
        }

        public String toString(){
            return n+"/"+d+" = "+n.divide(d);
        }
        private void reverse(){
            BigInteger tmp=d;
            d=n;
            n=tmp;
        }
        private void plusOne(){
            n=n.add(d);
        }
    }

    private Fraction getNexpansion(int n){
        Fraction f = new Fraction(1,2);
        for (int i=1; i<n; i++)
        {
            f.plusOne();
            f.plusOne();
            f.reverse();
        }
        f.plusOne();
        return f;
    }
}
