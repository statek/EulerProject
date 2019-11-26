package mst.euler.solutions;

import java.util.HashMap;
import java.util.Map;
import mst.euler.Solution;

public class s116 extends Solution {

    private static final Integer[] BLOCKS_LENGHT = {2, 3, 4};
    private int rowLength = 50;
    private Map<Long, Long> cachedWays;

    public static void main(String[] args) {
        System.out.println(new s116().run());
    }

    @Override
    public String solve() {
        long sum = 0;
        for (int block : BLOCKS_LENGHT) {
            cachedWays = new HashMap<>();
            long ways = findWays(block, rowLength) - 1;
            sum += ways;
            System.out.println(block + "\t:\t" + ways);
        }
        return String.valueOf(sum);
    }

    private long findWays(final long blockLength, final long rowLength) {
        if (rowLength == 0) {
            cachedWays.put(rowLength, 1l);
            return 1;
        }
        if (rowLength < 0) {
            cachedWays.put(rowLength, 0l);
            return 0;
        }
        Long countIfBlock = cachedWays.get(rowLength - blockLength);
        if (countIfBlock == null) {
            countIfBlock = findWays(blockLength, rowLength - blockLength);
        }
        Long countIfEmpty = cachedWays.get(rowLength - 1);
        if (countIfEmpty == null) {
            countIfEmpty = findWays(blockLength, rowLength - 1);
        }
        Long count = countIfBlock + countIfEmpty;
        cachedWays.put(rowLength, count);
        return count;
    }

    public void setRowLength(final int rowLength) {
        this.rowLength = rowLength;
    }
}
