package mst.euler.utils;

import java.math.BigInteger;

public class Fraction {

    public String getNumerator() {
        return n.toString();
    }

    public String getDenumerator() {
        return d.toString();
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getD() {
        return d;
    }

    BigInteger n, d;

    public Fraction(long n, long d) {
        this.n = BigInteger.valueOf(n);
        this.d = BigInteger.valueOf(d);
    }

    public String toString() {
        return n + "/" + d;
    }

    public void reverse() {
        BigInteger tmp = d;
        d = n;
        n = tmp;
    }

    public void add(long val) {
        n = n.add(d.multiply(BigInteger.valueOf(val)));
    }
}