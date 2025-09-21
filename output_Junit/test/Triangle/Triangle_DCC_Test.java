package test.Triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Triangle;


public class Triangle_DCC_Test {
  @Test
  @DisplayName("tcgen_Triangle_Triangle_DCC_1")
  void testTriangle_1() throws Exception {
    int Arg_1 = 885;
    int Arg_2 = 32648;
    int Arg_3 = 32243;

    assertEquals("[ 885, 32648, 32243 ]", new Triangle(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Triangle_Triangle_DCC_5_Exception")
  void testTriangle_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 32697;
      int Arg_2 = 32753;
      int Arg_3 = 14;
      new Triangle(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Triangle_Triangle_DCC_6_Exception")
  void testTriangle_6() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 3963;
      int Arg_2 = 4724;
      int Arg_3 = 29456;
      new Triangle(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Triangle_Triangle_DCC_7_Exception")
  void testTriangle_7() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 4071;
      int Arg_2 = 3786;
      int Arg_3 = 139;
      new Triangle(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Triangle_category_DCC_1")
  void testcategory_1() throws Exception {
    Triangle self = new Triangle(29541, 29541, 29541);
    assertEquals("Equilateral", self.category());
  }

  @Test
  @DisplayName("tcgen_Triangle_category_DCC_2")
  void testcategory_2() throws Exception {
    Triangle self = new Triangle(14153, 14153, 4837);
    assertEquals("Isosceles", self.category());
  }

  @Test
  @DisplayName("tcgen_Triangle_category_DCC_3")
  void testcategory_3() throws Exception {
    Triangle self = new Triangle(29765, 2498, 29765);
    assertEquals("Isosceles", self.category());
  }

  @Test
  @DisplayName("tcgen_Triangle_category_DCC_4")
  void testcategory_4() throws Exception {
    Triangle self = new Triangle(6692, 22393, 22393);
    assertEquals("Isosceles", self.category());
  }

  @Test
  @DisplayName("tcgen_Triangle_category_DCC_5")
  void testcategory_5() throws Exception {
    Triangle self = new Triangle(31664, 21350, 24563);
    assertEquals("Scalene", self.category());
  }
}
