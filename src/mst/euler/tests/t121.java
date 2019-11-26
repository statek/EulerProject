package mst.euler.tests;

import static org.junit.Assert.assertEquals;

import mst.euler.solutions.s121;
import org.junit.Test;

public class t121 {

  @Test
  public void discGamePrizeFundTest() {
    s121 s = new s121();
    s.setRoundNumber(4);
    assertEquals("10", String.valueOf(s.solve()));
  }
}
