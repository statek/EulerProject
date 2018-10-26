package mst.euler.tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import mst.euler.solutions.s067;
import mst.euler.solutions.s119;
import org.junit.Test;

public class t119 {

  @Test
  public void digitPowerSum2() {
    s119 s = new s119();
    s.setN(2);
    assertEquals("512", String.valueOf(s.solve()));
  }

  @Test
  public void digitPowerSum10() {
    s119 s = new s119();
    s.setN(10);

    assertEquals("614656", String.valueOf(s.solve()));
  }
}
