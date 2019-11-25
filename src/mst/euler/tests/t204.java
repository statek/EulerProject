package mst.euler.tests;

import static org.junit.Assert.assertEquals;

import mst.euler.solutions.s204;
import org.junit.Test;

public class t204 {

  @Test
  public void hammingNumbers10_8() {
    s204 s = new s204();
    s.setP(5l);
    s.setMax(100_000_000l);
    assertEquals("1105", String.valueOf(s.solve()));
  }

  @Test
  public void hammingNumbers() {
    s204 s = new s204();
    s.setP(5l);
    s.setMax(15l);
    assertEquals("11", String.valueOf(s.solve()));
  }
}
