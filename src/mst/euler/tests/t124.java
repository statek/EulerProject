package mst.euler.tests;

import static org.junit.Assert.assertEquals;

import mst.euler.solutions.s124;
import org.junit.Test;

public class t124 {

  @Test
  public void consecutiveSums() {
    s124 s = new s124();
    s.setN(10);
    s.solve();
    assertEquals(8, s.getE(4));
    assertEquals(9, s.getE(6));
  }
}
