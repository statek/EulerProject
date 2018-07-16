package mst.euler;

public abstract class Solution {

    public String run() {
        long startTime = System.currentTimeMillis();
        String result = solve();
        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
        return result;
    }

    public abstract String solve();

}