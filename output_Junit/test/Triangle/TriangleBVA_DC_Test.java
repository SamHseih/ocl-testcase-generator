package test.Triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Triangle;


public class TriangleBVA_DC_Test {
  @Test
  @DisplayName("tcgen_Triangle_Triangle_DC_1_1")
  void testTriangle_1_1() throws Exception {
    int Arg_1 = 16847;
    int Arg_2 = 24448;
    int Arg_3 = 11567;

    assertEquals("[ 16847, 24448, 11567 ]", new Triangle(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Triangle_Triangle_DC_2_1_Exception")
  void testTriangle_2_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 266;
      int Arg_2 = 14403;
      int Arg_3 = 24060;
      new Triangle(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Triangle_category_DC_1_1")
  void testcategory_1_1() throws Exception {
    Triangle self = new Triangle(24862, 24862, 24862);
    assertEquals("Equilateral", self.category());
  }

  @Test
  @DisplayName("tcgen_Triangle_category_DC_2_1")
  void testcategory_2_1() throws Exception {
    Triangle self = new Triangle(23164, 23164, 879);
    assertEquals("Isosceles", self.category());
  }

  @Test
  @DisplayName("tcgen_Triangle_category_DC_3_1")
  void testcategory_3_1() throws Exception {
    Triangle self = new Triangle(30753, 633, 30753);
    assertEquals("Isosceles", self.category());
  }

  @Test
  @DisplayName("tcgen_Triangle_category_DC_4_1")
  void testcategory_4_1() throws Exception {
    Triangle self = new Triangle(16135, 10918, 10918);
    assertEquals("Isosceles", self.category());
  }

  @Test
  @DisplayName("tcgen_Triangle_category_DC_5_1")
  void testcategory_5_1() throws Exception {
    Triangle self = new Triangle(2953, 22533, 24749);
    assertEquals("Scalene", self.category());
  }
}
