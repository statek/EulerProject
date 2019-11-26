package mst.euler.tests;

import static org.junit.Assert.assertEquals;

import mst.euler.solutions.s116;
import org.junit.Test;

public class t116 {

  @Test
  public void rgbTiles() {
    s116 s = new s116();
    s.setRowLength(5);
    assertEquals("12", String.valueOf(s.solve()));
  }
}
