package mst.euler.tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import mst.euler.solutions.s081;
import mst.euler.solutions.s102;
import org.junit.Test;

public class t102 {

  @Test
  public void trianglePRS() {
    s102 s = new s102();
    List<String> fileContent = Arrays.asList(
        "-1,-1,1,3,3,-2");
    s.loadFile(fileContent);

    assertEquals("1", String.valueOf(s.solve()));
  }

  @Test
  public void countTrianglesContainOrigin() {
    s102 s = new s102();
    List<String> fileContent = Arrays.asList(
        "-340,495,-153,-910,835,-947",
        "-175,041,-421,-714,574,-645");
    s.loadFile(fileContent);

    assertEquals("1", String.valueOf(s.solve()));
  }

  @Test
  public void triangleABC() {
    s102 s = new s102();
    List<String> fileContent = Arrays.asList(
        "-340,495,-153,-910,835,-947");
    s.loadFile(fileContent);

    assertEquals("1", String.valueOf(s.solve()));
  }

  @Test
  public void triangleXYZ() {
    s102 s = new s102();
    List<String> fileContent = Arrays.asList(
        "-175,041,-421,-714,574,-645");
    s.loadFile(fileContent);

    assertEquals("0", String.valueOf(s.solve()));
  }

}
