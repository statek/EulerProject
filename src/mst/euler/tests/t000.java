package mst.euler.tests;

import mst.euler.solutions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class t000 {
    @Test
    public void exampleTest() {
        assertEquals("null", String.valueOf(new s000().solve()));
    }
}
