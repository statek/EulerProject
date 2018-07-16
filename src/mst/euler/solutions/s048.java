package mst.euler.solutions;

import mst.euler.Solution;

import java.math.BigInteger;

public class s048 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s048().run());
    }

    @Override
    public String solve() {

        BigInteger tmp, sum=BigInteger.ZERO;
        for (int i=1;i<=1000;i++){
            tmp=BigInteger.valueOf(i);
            tmp=tmp.pow(i);
            sum=sum.add(tmp);
        }
        String str = sum.toString();
        return str.substring(str.length()-10);
    }
}
