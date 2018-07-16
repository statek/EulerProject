package mst.euler.solutions;

import mst.euler.Solution;

import java.util.TreeSet;

public class s045 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s045().run());
    }

    @Override
    public String solve() {

        long i = 0, tri, pen, hex;
        TreeSet<Long> triNums = new TreeSet<>();
        TreeSet<Long> penNums = new TreeSet<>();
        TreeSet<Long> hexNums = new TreeSet<>();
        TreeSet<Long> tphNums = new TreeSet<>();
        while (tphNums.size() < 3) {
            i++;
            tri = i * (i + 1) / 2;
            pen = i * (3 * i - 1) / 2;
            hex = i * (2 * i - 1);
            triNums.add(tri);
            penNums.add(pen);
            hexNums.add(hex);
            if (penNums.contains(tri) && hexNums.contains(tri)) {
                tphNums.add(tri);
            }
        }
        return String.valueOf(tphNums.last());
    }
}
