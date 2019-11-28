package mst.euler.tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import mst.euler.solutions.s105;
import org.junit.Test;

public class t105 {

  @Test
  public void countTrianglesContainOrigin() {
    s105 s = new s105();
    List<String> fileContent = Arrays.asList(
            "81,88,75,42,87,84,86,65",
        "157,150,164,119,79,159,161,139,158");
    s.loadFile(fileContent);

    assertEquals("1286", String.valueOf(s.solve()));
  }
}
