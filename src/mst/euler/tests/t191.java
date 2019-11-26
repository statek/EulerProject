package mst.euler.tests;

import static org.junit.Assert.assertEquals;

import mst.euler.solutions.s191;
import org.junit.Test;

public class t191 {

  @Test
  public void priceStringsTest() {
    s191 s = new s191();
    s.setPeriod(4);
    assertEquals("43", String.valueOf(s.solve()));
  }
}
