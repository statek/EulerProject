package mst.euler.solutions;

import mst.euler.Solution;

public class s014 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s014().run());
    }

    @Override
    public String solve() {
        int num = 0, maxChain = 0, tmpChain;
        for (int i = 1; i <= 1_000_000; i++) {
            tmpChain = collatzSequence(i);
            if (maxChain <= tmpChain) {
                num = i;
                maxChain = tmpChain;
            }
        }
        return String.valueOf(num);
    }

    private int collatzSequence(int startNumber) {
        int count = 1;
        long tmp = startNumber;
        while (tmp > 1) {
            tmp = (tmp % 2 == 0) ? tmp / 2 : 3 * tmp + 1;
            count++;
        }
        return count;
    }
}
