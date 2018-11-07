package mst.euler.tests;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import mst.euler.solutions.s123;
import org.junit.Test;

public class t123 {

  @Test
  public void primeSquareReminders() {
    s123 s = new s123();
    s.setR(1_000_000_000l);
    assertEquals("7037", s.solve());
  }
}
