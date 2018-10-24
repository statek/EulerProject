package mst.euler.tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import mst.euler.solutions.s345;
import org.junit.Test;

public class t345 {
    @Test
    public void maxSum() {
        s345 s = new s345();
        List<String> fileContent = Arrays.asList(
            "007,053,183,439,863",
            "497,383,563,079,973",
            "287,063,343,169,583",
            "627,343,773,959,943",
            "767,473,103,699,303");
        s.loadFileToGrid(fileContent);
        s.findMaxSum();
        assertEquals("3315", String.valueOf(s.getMaxSum()));
    }
}
