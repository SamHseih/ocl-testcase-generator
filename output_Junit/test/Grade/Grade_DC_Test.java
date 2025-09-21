package test.Grade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Grade;


public class Grade_DC_Test {
  @Test
  @DisplayName("tcgen_Grade_Grade_DC_1")
  void testGrade_1() throws Exception {
    int Arg_1 = 54;

    assertEquals("[ 54 ]", new Grade(Arg_1).toString());
  }

  @Test
  @DisplayName("tcgen_Grade_Grade_DC_2_Exception")
  void testGrade_2() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -6934;
      new Grade(Arg_1);
    });
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DC_1")
  void testrating_1() throws Exception {
    Grade self = new Grade(5);
    assertEquals("F", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DC_2")
  void testrating_2() throws Exception {
    Grade self = new Grade(69);
    assertEquals("D", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DC_3")
  void testrating_3() throws Exception {
    Grade self = new Grade(76);
    assertEquals("C", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DC_4")
  void testrating_4() throws Exception {
    Grade self = new Grade(83);
    assertEquals("B", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DC_5")
  void testrating_5() throws Exception {
    Grade self = new Grade(90);
    assertEquals("A", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_getNumber_DC_1")
  void testgetNumber_1() throws Exception {
    Grade self = new Grade(34);
    assertEquals("34", self.getNumber());
  }
}
