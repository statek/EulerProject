package mst.euler.solutions;

import mst.euler.Solution;
import mst.euler.utils.Fraction;

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
            if(f.getNumerator().length()>f.getDenumerator().length()) {
                c++;
            }
        }
        return String.valueOf(c);
    }

    private Fraction getNexpansion(int n){
        Fraction f = new Fraction(1,2);
        for (int i=1; i<n; i++)
        {
            f.add(2);
            f.reverse();
        }
        f.add(1);
        return f;
    }
}
