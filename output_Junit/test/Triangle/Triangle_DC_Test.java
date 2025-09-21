package test.Triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Triangle;


public class Triangle_DC_Test {
  @Test
  @DisplayName("tcgen_Triangle_Triangle_DC_1")
  void testTriangle_1() throws Exception {
    int Arg_1 = 28230;
    int Arg_2 = 7035;
    int Arg_3 = 25972;

    assertEquals("[ 28230, 7035, 25972 ]", new Triangle(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Triangle_Triangle_DC_2_Exception")
  void testTriangle_2() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 24391;
      int Arg_2 = 1118;
      int Arg_3 = 28530;
      new Triangle(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Triangle_category_DC_1")
  void testcategory_1() throws Exception {
    Triangle self = new Triangle(1893, 1893, 1893);
    assertEquals("Equilateral", self.category());
  }

  @Test
  @DisplayName("tcgen_Triangle_category_DC_2")
  void testcategory_2() throws Exception {
    Triangle self = new Triangle(20514, 20514, 20064);
    assertEquals("Isosceles", self.category());
  }

  @Test
  @DisplayName("tcgen_Triangle_category_DC_3")
  void testcategory_3() throws Exception {
    Triangle self = new Triangle(25860, 25665, 25860);
    assertEquals("Isosceles", self.category());
  }

  @Test
  @DisplayName("tcgen_Triangle_category_DC_4")
  void testcategory_4() throws Exception {
    Triangle self = new Triangle(23290, 23697, 23697);
    assertEquals("Isosceles", self.category());
  }

  @Test
  @DisplayName("tcgen_Triangle_category_DC_5")
  void testcategory_5() throws Exception {
    Triangle self = new Triangle(26790, 1753, 27541);
    assertEquals("Scalene", self.category());
  }
}
