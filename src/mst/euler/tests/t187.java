package mst.euler.tests;

import static org.junit.Assert.assertEquals;

import mst.euler.solutions.s145;
import mst.euler.solutions.s187;
import org.junit.Test;

public class t187 {

  @Test
  public void countSemiprimes() {
    s187 s = new s187();
    s.setN(30);
    assertEquals("10", String.valueOf(s.solve()));
  }
}
