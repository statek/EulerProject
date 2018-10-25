package mst.euler.tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import mst.euler.solutions.s145;
import org.junit.Test;

public class t145 {

  @Test
  public void countReversible() {
    s145 s = new s145();
    s.setN(1000);
    assertEquals("120", String.valueOf(s.solve()));
  }
}
