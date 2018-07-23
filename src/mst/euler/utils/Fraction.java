package mst.euler.utils;

import java.math.BigInteger;
import java.util.Objects;

public class Fraction implements Comparable<Fraction> {

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

    public double doubleValue() {
        return n.doubleValue()/d.doubleValue();
    }

    public void reverse() {
        BigInteger tmp = d;
        d = n;
        n = tmp;
    }

    public void add(long val) {
        n = n.add(d.multiply(BigInteger.valueOf(val)));
    }

    @Override
    public int compareTo(Fraction o) {
        return equals(o)? 0 : doubleValue()>=o.doubleValue() ? 1 : -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return fraction.doubleValue()==this.doubleValue();
    }

    @Override
    public int hashCode() {

        return Objects.hash(doubleValue());
    }
}