package test.Grade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Grade;


public class GradeBVA_DC_Test {
  @Test
  @DisplayName("tcgen_Grade_Grade_DC_1_1")
  void testGrade_1_1() throws Exception {
    int Arg_1 = 0;

    assertEquals("[ 0 ]", new Grade(Arg_1).toString());
  }

  @Test
  @DisplayName("tcgen_Grade_Grade_DC_1_2")
  void testGrade_1_2() throws Exception {
    int Arg_1 = 100;

    assertEquals("[ 100 ]", new Grade(Arg_1).toString());
  }

  @Test
  @DisplayName("tcgen_Grade_Grade_DC_1_3")
  void testGrade_1_3() throws Exception {
    int Arg_1 = 43;

    assertEquals("[ 43 ]", new Grade(Arg_1).toString());
  }

  @Test
  @DisplayName("tcgen_Grade_Grade_DC_2_1_Exception")
  void testGrade_2_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -3242;
      new Grade(Arg_1);
    });
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DC_1_1")
  void testrating_1_1() throws Exception {
    Grade self = new Grade(0);
    assertEquals("F", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DC_1_3")
  void testrating_1_3() throws Exception {
    Grade self = new Grade(59);
    assertEquals("F", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DC_1_4")
  void testrating_1_4() throws Exception {
    Grade self = new Grade(41);
    assertEquals("F", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DC_2_3")
  void testrating_2_3() throws Exception {
    Grade self = new Grade(60);
    assertEquals("D", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DC_2_4")
  void testrating_2_4() throws Exception {
    Grade self = new Grade(69);
    assertEquals("D", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DC_2_5")
  void testrating_2_5() throws Exception {
    Grade self = new Grade(61);
    assertEquals("D", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DC_3_3")
  void testrating_3_3() throws Exception {
    Grade self = new Grade(70);
    assertEquals("C", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DC_3_4")
  void testrating_3_4() throws Exception {
    Grade self = new Grade(79);
    assertEquals("C", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DC_3_5")
  void testrating_3_5() throws Exception {
    Grade self = new Grade(75);
    assertEquals("C", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DC_4_3")
  void testrating_4_3() throws Exception {
    Grade self = new Grade(80);
    assertEquals("B", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DC_4_4")
  void testrating_4_4() throws Exception {
    Grade self = new Grade(89);
    assertEquals("B", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DC_4_5")
  void testrating_4_5() throws Exception {
    Grade self = new Grade(84);
    assertEquals("B", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DC_5_2")
  void testrating_5_2() throws Exception {
    Grade self = new Grade(100);
    assertEquals("A", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DC_5_3")
  void testrating_5_3() throws Exception {
    Grade self = new Grade(90);
    assertEquals("A", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_rating_DC_5_4")
  void testrating_5_4() throws Exception {
    Grade self = new Grade(92);
    assertEquals("A", self.rating());
  }

  @Test
  @DisplayName("tcgen_Grade_getNumber_DC_1_1")
  void testgetNumber_1_1() throws Exception {
    Grade self = new Grade(0);
    assertEquals("0", self.getNumber());
  }

  @Test
  @DisplayName("tcgen_Grade_getNumber_DC_1_2")
  void testgetNumber_1_2() throws Exception {
    Grade self = new Grade(100);
    assertEquals("100", self.getNumber());
  }

  @Test
  @DisplayName("tcgen_Grade_getNumber_DC_1_3")
  void testgetNumber_1_3() throws Exception {
    Grade self = new Grade(71);
    assertEquals("71", self.getNumber());
  }
}
