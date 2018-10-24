package mst.euler.tests;

import static org.junit.Assert.assertEquals;

import mst.euler.solutions.s504;
import org.junit.Test;

public class t504 {

  @Test
  public void squarePoints() {
    s504 s = new s504();
    s.setM(4);

    assertEquals("42", String.valueOf(s.solve()));
    assertEquals("256", String.valueOf(s.getWays()));
  }
}
