package mst.euler.tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import mst.euler.solutions.s083;
import mst.euler.solutions.s098;
import org.junit.Test;

public class t098 {
    @Test
    public void anagramicSquares() {
        s098 s = new s098();
        List<String> fileContent = Arrays.asList(
            "\"RACE\",\"CARE\"");
        s.loadFile(fileContent);

        assertEquals("9216", String.valueOf(s.solve()));
    }
}
