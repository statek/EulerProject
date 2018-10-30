package mst.euler.tests;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import mst.euler.solutions.s100;
import mst.euler.solutions.s102;
import org.junit.Test;

public class t100 {

  @Test
  public void probability15() {
    s100 s = new s100();
    s.setD(BigInteger.valueOf(10));
    assertEquals("15", String.valueOf(s.solve()));
  }

  @Test
  public void probability85() {
    s100 s = new s100();
    s.setD(BigInteger.valueOf(25));
    assertEquals("85", String.valueOf(s.solve()));
  }

}
