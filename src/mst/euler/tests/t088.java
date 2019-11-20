package mst.euler.tests;

import static org.junit.Assert.assertEquals;

import mst.euler.solutions.s088;
import org.junit.Test;

public class t088 {

  @Test
  public void prodSum6() {
    s088 s = new s088();
    s.setK(6);
    assertEquals("30", String.valueOf(s.solve()));
  }

  @Test
  public void prodSum12() {
    s088 s = new s088();
    s.setK(12);
    assertEquals("61", String.valueOf(s.solve()));
  }
}
