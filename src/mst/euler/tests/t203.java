package mst.euler.tests;

import static org.junit.Assert.assertEquals;

import mst.euler.solutions.s203;
import org.junit.Test;

public class t203 {

  @Test
  public void squarefreeBinomialCoefficients8Rows() {
    s203 s = new s203();
    s.setR(8);
    assertEquals("105", String.valueOf(s.solve()));
  }
}
