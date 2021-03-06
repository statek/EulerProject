package mst.euler.tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import mst.euler.solutions.s082;
import org.junit.Test;

public class t082 {
    @Test
    public void minPath() {
        s082 s = new s082();
        List<String> fileContent = Arrays.asList(
            "131,673,234,103,018",
            "201,096,342,965,150",
            "630,803,746,422,111",
            "537,699,497,121,956",
            "805,732,524,037,331");
        s.loadFileToGrid(fileContent);

        assertEquals("994", String.valueOf(s.findPath()));
    }
}
