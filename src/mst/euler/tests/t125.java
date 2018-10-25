package mst.euler.tests;

import static org.junit.Assert.assertEquals;

import mst.euler.solutions.s125;
import org.junit.Test;

public class t125 {

  @Test
  public void consecutiveSums() {
    s125 s = new s125();
    s.setN(1000);
    assertEquals("4164", String.valueOf(s.solve()));
  }
}
