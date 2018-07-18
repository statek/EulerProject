package mst.euler;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.Math.sqrt;
import static java.time.OffsetTime.now;

public class Lib {


    public static List<String> readFile(String filePath) {
        List<String> fileContent = null;
        try {
            fileContent = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    public static long factorial(long n) {
        long p = 1;
        for (long i = 1; i <= n; ++i) p *= i;
        return p;
    }

    public static BigInteger biFactorial(long n) {
        BigInteger p = BigInteger.ONE;
        for (long i = 1; i <= n; ++i) p = p.multiply(BigInteger.valueOf(i));
        return p;
    }

    public static boolean isPandigital(String num) {
        if (num.length() > 9 || num.contains("0")) {
            return false;
        }

        HashSet<String> testSet = new HashSet<>();
        for (int i = 1; i <= num.length(); i++) {
            testSet.add(String.valueOf(i));
        }

        String[] s = num.split("");
        HashSet<String> set = new HashSet<>(Arrays.asList(s));
        return set.equals(testSet);
    }

    public static boolean isPalindrome(String number) {
        for (int i = 0; i < number.length() / 2; ++i) {
            if (number.charAt(i) != number.charAt(number.length() - 1 - i)) return false;
        }
        return true;
    }

    public static boolean isPrime(long number) {
        for (long i = 2; i < sqrt(number + 1); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static Set<Long> prepareSieve(long n) {
        Set<Long> hset = new HashSet<>();
        long tmp;
        for (long i = 2L; i <= n; i++) {
            hset.add(i);
        }
        for (long i = 2; i <= n; i++) {
            tmp = i + i;
            while (tmp <= n) {
                hset.remove(tmp);
                tmp += i;
            }
        }
        System.out.println("Sieve for (1-" + n + ") ->\t" + hset.size() + " primes found.");
        return hset;
    }

    public static int sumDigits(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += Integer.parseInt(str.charAt(i) + "");
        }
        return sum;
    }

    public static long gcd(long a, long b) {
        long r = a % b;
        return (r == 0) ? b : gcd(b, r);
    }

    public static List<Long> eulersTotient(long n) {
        Set<Long> sieve = prepareSieve(n);
        ArrayList<Long> phi = new ArrayList<>();
        phi.add(1L);
        phi.add(1L);
        phi.add(1L);
        for (int i = 3; i <= n; i++) {
            if (i % 1_000 == 0) System.out.println(now() + "\t" + (double) 100 * i / n + "%");
            long iPhi = i;
            if (sieve.contains(i)) {
                iPhi--;
            } else {
                for (int d = 1; d < i / 2 + 1; d++) {
                    if (i % d == 0) {
                        iPhi -= phi.get(d);
                    }
                }
            }
            phi.add(iPhi);
        }
        return phi;
    }
}