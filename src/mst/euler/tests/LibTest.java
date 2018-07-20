package mst.euler.tests;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static mst.euler.Lib.*;

public class LibTest {
    @Test
    public void isPrimeTest() {
        assertEquals("false", String.valueOf(isPrime(4)));
        assertEquals("true" , String.valueOf(isPrime(3)));
    }

    @Test
    public void isPalindromeeTest() {
        assertEquals("false", String.valueOf(isPalindrome("123")));
        assertEquals("true" , String.valueOf(isPalindrome("12321")));
    }

    @Test
    public void gcdTest() {
        assertEquals("11", String.valueOf(gcd(121,99)));
        assertEquals("1" , String.valueOf(gcd(121,93)));
    }
}
