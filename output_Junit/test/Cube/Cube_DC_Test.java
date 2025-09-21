package test.Cube;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Cube;


public class Cube_DC_Test {
  @Test
  @DisplayName("StaticFixedsizeArrays_Cube_Cube_DC_1")
  void testCube_1() throws Exception {
    int[][][] Arg_1 = {{{-1198, -17029, -20815, 12489}, {-3974, 26172, 22443, -26881}}};
    assertEquals("[[[-1198, -17029, -20815, 12489], [-3974, 26172, 22443, -26881]]]",
        new Cube(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Cube_add_DC_1391")
  void testadd_1391() throws Exception {
    int[][][] inputarray_Arg_1 = {{{7553, 30921, -21024, 13632}, {-16045, 21592, 2681, 28343}}};
    int[][][] inputarray_self = {{{-10594, 9639, 25936, -20824}, {19596, -21580, -32678, 30001}}};
    Cube self = new Cube(inputarray_self);
    Cube Arg_1 = new Cube(inputarray_Arg_1);
    assertEquals("[[[-3041, 40560, 4912, -7192], [3551, 12, -29997, 58344]]]",
        self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Cube_sub_DC_1391")
  void testsub_1391() throws Exception {
    int[][][] inputarray_Arg_1 = {{{15612, -18608, -22276, -18231}, {-32484, -6049, 8252, -28360}}};
    int[][][] inputarray_self = {{{32204, 29878, -6067, -19384}, {17479, -13536, -24804, -17700}}};
    Cube self = new Cube(inputarray_self);
    Cube Arg_1 = new Cube(inputarray_Arg_1);
    assertEquals("[[[16592, 48486, 16209, -1153], [49963, -7487, -33056, 10660]]]",
        self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Cube_getData_DC_1")
  void testgetData_1() throws Exception {
    int[][][] inputarray_self = {{{28892, 11345, -5286, -3314}, {23302, 30063, 20168, -32329}}};
    Cube self = new Cube(inputarray_self);
    assertEquals("[[[28892, 11345, -5286, -3314], [23302, 30063, 20168, -32329]]]",
        self.getData().toString());
  }
}
