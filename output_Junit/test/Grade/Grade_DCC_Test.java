package test.Grade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Grade;


public class Grade_DCC_Test {
  @Test
  @DisplayName("tcgen_Grade_Grade_DCC_1")
  void testGrade_1() throws Exception {
    int Arg_1 = 60;

    assertEquals("[ 60 ]", new Grade(Arg_1).toString());
  }

  @Test
  @DisplayName("tcgen_Grade_Grade_DCC_2_Exception")
  void testGrade_2() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -16584;
      new Grade(Arg_1);
    });
  }

  @Test
  @DisplayName("tcgen_Grade_Grade_DCC_3_Exception")
  void testGrade_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 2816;
      new Grade(Arg_1);
    });
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DCC_1")
  void testrating_1() throws Exception {
    Grade self = new Grade(39);
    assertEquals("F", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DCC_2")
  void testrating_2() throws Exception {
    Grade self = new Grade(64);
    assertEquals("D", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DCC_4")
  void testrating_4() throws Exception {
    Grade self = new Grade(70);
    assertEquals("C", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DCC_8")
  void testrating_8() throws Exception {
    Grade self = new Grade(80);
    assertEquals("B", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DCC_23")
  void testrating_23() throws Exception {
    Grade self = new Grade(97);
    assertEquals("A", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_getNumber_DCC_1")
  void testgetNumber_1() throws Exception {
    Grade self = new Grade(85);
    assertEquals("85", self.getNumber());
  }
}
