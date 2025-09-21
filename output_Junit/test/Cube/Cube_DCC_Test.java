package test.Cube;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Cube;


public class Cube_DCC_Test {
  @Test
  @DisplayName("StaticFixedsizeArrays_Cube_Cube_DCC_1")
  void testCube_1() throws Exception {
    int[][][] Arg_1 = {{{1499, 16785, -20552, -26708}, {-15445, 7930, 20715, -3269}}};
    assertEquals("[[[1499, 16785, -20552, -26708], [-15445, 7930, 20715, -3269]]]",
        new Cube(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Cube_add_DCC_1391")
  void testadd_1391() throws Exception {
    int[][][] inputarray_Arg_1 =
        {{{-16648, -8187, 25996, -21073}, {-11671, -17484, -25974, -2557}}};
    int[][][] inputarray_self = {{{28242, 20076, -25404, -10717}, {27914, -21908, 10159, 10501}}};
    Cube self = new Cube(inputarray_self);
    Cube Arg_1 = new Cube(inputarray_Arg_1);
    assertEquals("[[[11594, 11889, 592, -31790], [16243, -39392, -15815, 7944]]]",
        self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Cube_sub_DCC_1391")
  void testsub_1391() throws Exception {
    int[][][] inputarray_Arg_1 = {{{10433, -23135, -2805, -32738}, {14603, 24751, -10358, -7738}}};
    int[][][] inputarray_self = {{{2869, -16887, -7507, 1512}, {9019, -18590, -25563, 6962}}};
    Cube self = new Cube(inputarray_self);
    Cube Arg_1 = new Cube(inputarray_Arg_1);
    assertEquals("[[[-7564, 6248, -4702, 34250], [-5584, -43341, -15205, 14700]]]",
        self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Cube_getData_DCC_1")
  void testgetData_1() throws Exception {
    int[][][] inputarray_self = {{{5199, -3809, -933, 12424}, {1843, -31478, -7037, -8089}}};
    Cube self = new Cube(inputarray_self);
    assertEquals("[[[5199, -3809, -933, 12424], [1843, -31478, -7037, -8089]]]",
        self.getData().toString());
  }
}
