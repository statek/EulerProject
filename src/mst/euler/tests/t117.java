package mst.euler.tests;

import static org.junit.Assert.assertEquals;

import mst.euler.solutions.s117;
import org.junit.Test;

public class t117 {

  @Test
  public void rgbTiles() {
    s117 s = new s117();
    s.setRowLength(5l);
    assertEquals("15", String.valueOf(s.solve()));
  }
}
