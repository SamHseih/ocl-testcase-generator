package test.Triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Triangle;


public class TriangleBVA_DCC_Test {
  @Test
  @DisplayName("tcgen_Triangle_Triangle_DCC_1_1")
  void testTriangle_1_1() throws Exception {
    int Arg_1 = 1710;
    int Arg_2 = 32460;
    int Arg_3 = 32459;

    assertEquals("[ 1710, 32460, 32459 ]", new Triangle(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Triangle_Triangle_DCC_5_1_Exception")
  void testTriangle_5_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 3057;
      int Arg_2 = 17906;
      int Arg_3 = 14849;
      new Triangle(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Triangle_Triangle_DCC_5_2_Exception")
  void testTriangle_5_2() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 19801;
      int Arg_2 = 26520;
      int Arg_3 = 4720;
      new Triangle(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Triangle_Triangle_DCC_6_1_Exception")
  void testTriangle_6_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 8500;
      int Arg_2 = 16808;
      int Arg_3 = 25308;
      new Triangle(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Triangle_Triangle_DCC_6_2_Exception")
  void testTriangle_6_2() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 29971;
      int Arg_2 = 2624;
      int Arg_3 = 32703;
      new Triangle(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Triangle_Triangle_DCC_7_1_Exception")
  void testTriangle_7_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 13022;
      int Arg_2 = 4866;
      int Arg_3 = 8156;
      new Triangle(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Triangle_Triangle_DCC_7_2_Exception")
  void testTriangle_7_2() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 4555;
      int Arg_2 = 1994;
      int Arg_3 = 73;
      new Triangle(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Triangle_category_DCC_1_1")
  void testcategory_1_1() throws Exception {
    Triangle self = new Triangle(32748, 32748, 32748);
    assertEquals("Equilateral", self.category());
  }

  @Test
  @DisplayName("tcgen_Triangle_category_DCC_2_1")
  void testcategory_2_1() throws Exception {
    Triangle self = new Triangle(31985, 31985, 30775);
    assertEquals("Isosceles", self.category());
  }

  @Test
  @DisplayName("tcgen_Triangle_category_DCC_3_1")
  void testcategory_3_1() throws Exception {
    Triangle self = new Triangle(2391, 346, 2391);
    assertEquals("Isosceles", self.category());
  }

  @Test
  @DisplayName("tcgen_Triangle_category_DCC_4_1")
  void testcategory_4_1() throws Exception {
    Triangle self = new Triangle(7298, 19852, 19852);
    assertEquals("Isosceles", self.category());
  }

  @Test
  @DisplayName("tcgen_Triangle_category_DCC_5_1")
  void testcategory_5_1() throws Exception {
    Triangle self = new Triangle(9035, 22263, 20674);
    assertEquals("Scalene", self.category());
  }
}
