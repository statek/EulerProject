package mst.euler.solutions;

import mst.euler.Solution;

import java.math.BigInteger;

public class s063 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s063().run());
    }

    @Override
    public String solve() {
        BigInteger b, pow;
        long counter=0;
        for (int p=1;p<1000;p++)
        {
            b=BigInteger.ONE;
            pow = BigInteger.ZERO;
            while(String.valueOf(pow).length()<=p){
                pow = b.pow(p);
                if(String.valueOf(pow).length()==p) {
                    System.out.println(b+"^"+p+"="+pow);
                    counter++;
                }
                b = b.add(BigInteger.ONE);
            }
        }
        return String.valueOf(counter);
    }
}
