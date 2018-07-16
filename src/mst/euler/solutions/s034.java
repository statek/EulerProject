package mst.euler.solutions;

import mst.euler.Solution;

import static mst.euler.Lib.factorial;

public class s034 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s034().run());
    }

    @Override
    public String solve() {
        long sum=0;
        for(int i=3;i<10_000_000;++i){
            if(isDigitFactorial(i)) {
                sum+=i;
            }
        }
        return String.valueOf(sum);
    }

    private boolean isDigitFactorial(int n) {
        String num = String.valueOf(n);
        int sum=0;
        for(int i=0;i<num.length();++i){
            sum+=factorial(Integer.parseInt(num.charAt(i)+""));
        }
        return n==sum;
    }
}
