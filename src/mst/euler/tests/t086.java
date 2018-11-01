package mst.euler.tests;

import static org.junit.Assert.assertEquals;

import mst.euler.solutions.s086;
import org.junit.Test;

public class t086 {

  @Test
  public void cuboidShortestLine() {
    s086 s = new s086();
    s.setS(2000);
    assertEquals("100", String.valueOf(s.solve()));
  }
}
