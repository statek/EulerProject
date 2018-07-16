package mst.euler.solutions;

import mst.euler.Solution;

import static mst.euler.Lib.isPrime;

public class s058 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s058().run());
    }

    @Override
    public String solve() {
        double primes=0, all=1, ratio=1;
        int length = 1;
        int num = 1;
        while (ratio>=0.1){
            for(int i =0; i<4; i++)
            {
                num+=length+1;
                primes+= isPrime(num) ? 1 : 0;
            }
            all+=4;
            length+=2;
            ratio=primes/all;
        }
        return String.valueOf(length);
    }
}
