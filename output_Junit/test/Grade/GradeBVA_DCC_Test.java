package test.Grade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Grade;


public class GradeBVA_DCC_Test {
  @Test
  @DisplayName("tcgen_Grade_Grade_DCC_1_1")
  void testGrade_1_1() throws Exception {
    int Arg_1 = 0;

    assertEquals("[ 0 ]", new Grade(Arg_1).toString());
  }

  @Test
  @DisplayName("tcgen_Grade_Grade_DCC_1_2")
  void testGrade_1_2() throws Exception {
    int Arg_1 = 100;

    assertEquals("[ 100 ]", new Grade(Arg_1).toString());
  }

  @Test
  @DisplayName("tcgen_Grade_Grade_DCC_1_3")
  void testGrade_1_3() throws Exception {
    int Arg_1 = 51;

    assertEquals("[ 51 ]", new Grade(Arg_1).toString());
  }

  @Test
  @DisplayName("tcgen_Grade_Grade_DCC_2_2_Exception")
  void testGrade_2_2() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -29226;
      new Grade(Arg_1);
    });
  }

  @Test
  @DisplayName("tcgen_Grade_Grade_DCC_3_2_Exception")
  void testGrade_3_2() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 4866;
      new Grade(Arg_1);
    });
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DCC_1_1")
  void testrating_1_1() throws Exception {
    Grade self = new Grade(0);
    assertEquals("F", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DCC_1_3")
  void testrating_1_3() throws Exception {
    Grade self = new Grade(59);
    assertEquals("F", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DCC_1_4")
  void testrating_1_4() throws Exception {
    Grade self = new Grade(7);
    assertEquals("F", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DCC_2_3")
  void testrating_2_3() throws Exception {
    Grade self = new Grade(60);
    assertEquals("D", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DCC_2_4")
  void testrating_2_4() throws Exception {
    Grade self = new Grade(69);
    assertEquals("D", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DCC_2_5")
  void testrating_2_5() throws Exception {
    Grade self = new Grade(61);
    assertEquals("D", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DCC_4_4")
  void testrating_4_4() throws Exception {
    Grade self = new Grade(70);
    assertEquals("C", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DCC_4_5")
  void testrating_4_5() throws Exception {
    Grade self = new Grade(79);
    assertEquals("C", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DCC_4_6")
  void testrating_4_6() throws Exception {
    Grade self = new Grade(72);
    assertEquals("C", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DCC_8_5")
  void testrating_8_5() throws Exception {
    Grade self = new Grade(80);
    assertEquals("B", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DCC_8_6")
  void testrating_8_6() throws Exception {
    Grade self = new Grade(89);
    assertEquals("B", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DCC_8_7")
  void testrating_8_7() throws Exception {
    Grade self = new Grade(85);
    assertEquals("B", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DCC_23_2")
  void testrating_23_2() throws Exception {
    Grade self = new Grade(100);
    assertEquals("A", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DCC_23_6")
  void testrating_23_6() throws Exception {
    Grade self = new Grade(90);
    assertEquals("A", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DCC_23_7")
  void testrating_23_7() throws Exception {
    Grade self = new Grade(95);
    assertEquals("A", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_getNumber_DCC_1_1")
  void testgetNumber_1_1() throws Exception {
    Grade self = new Grade(0);
    assertEquals("0", self.getNumber());
  }

  @Test
  @DisplayName("tcgen_Grade_getNumber_DCC_1_2")
  void testgetNumber_1_2() throws Exception {
    Grade self = new Grade(100);
    assertEquals("100", self.getNumber());
  }

  @Test
  @DisplayName("tcgen_Grade_getNumber_DCC_1_3")
  void testgetNumber_1_3() throws Exception {
    Grade self = new Grade(86);
    assertEquals("86", self.getNumber());
  }
}
