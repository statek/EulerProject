package mst.euler.tests;

import mst.euler.solutions.s067;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class t067 {
    @Test
    public void maxPath() {
        s067 s = new s067();
        List<String> fileContent = Arrays.asList("3", "7 4", "2 4 6", "8 5 9 3");

        s.loadFileToTriTable(fileContent);
        s.setHeuristicFactor(7);
        s.findPath(0, 0, 0);

        assertEquals("23", String.valueOf(s.getMaxSum()));
    }
}
