package mst.euler.solutions;

import java.util.HashMap;
import java.util.Map;
import mst.euler.Solution;

public class s117 extends Solution {

    private static final Integer[] BLOCKS_LENGHT = {1, 2, 3, 4};
    private Long rowLength = 50l;
    private Map<Long, Long> cachedWays;

    public static void main(String[] args) {
        System.out.println(new s117().run());
    }

    @Override
    public String solve() {
        cachedWays = new HashMap<>();
        findWays(rowLength);
        return String.valueOf(cachedWays.get(rowLength));
    }

    private long findWays(final long rowLength) {
        if (rowLength == 0) {
            cachedWays.put(rowLength, 1l);
            return 1;
        }
        if (rowLength < 0) {
            cachedWays.put(rowLength, 0l);
            return 0;
        }

        long sum = 0;
        for (int blockLength : BLOCKS_LENGHT) {
            Long blockWays = cachedWays.get(rowLength - blockLength);
            if (blockWays == null) {
                blockWays = findWays(rowLength - blockLength);
            }
            sum += blockWays;
        }
        cachedWays.put(rowLength, sum);
        return sum;
    }

    public void setRowLength(final Long rowLength) {
        this.rowLength = rowLength;
    }
}
