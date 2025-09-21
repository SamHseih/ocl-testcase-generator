package test.Cube;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Cube;


public class CubeBVA_DC_Test {
  @Test
  @DisplayName("StaticFixedsizeArrays_Cube_Cube_DC_1_1")
  void testCube_1_1() throws Exception {
    int[][][] Arg_1 = {{{-29875, 30254, 24626, -7048}, {30715, 2466, -12238, 10074}}};
    assertEquals("[[[-29875, 30254, 24626, -7048], [30715, 2466, -12238, 10074]]]",
        new Cube(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Cube_add_DC_1391_1")
  void testadd_1391_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{6184, 20883, 16025, 25710}, {32575, 24844, 7162, 26387}}};
    int[][][] inputarray_self = {{{-19680, 18274, 407, 16025}, {25587, 23221, -8817, 14020}}};
    Cube self = new Cube(inputarray_self);
    Cube Arg_1 = new Cube(inputarray_Arg_1);
    assertEquals("[[[-13496, 39157, 16432, 41735], [58162, 48065, -1655, 40407]]]",
        self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Cube_sub_DC_1391_1")
  void testsub_1391_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{-11729, -2115, -14587, 10245}, {28976, -16403, -9745, -19078}}};
    int[][][] inputarray_self = {{{21919, 8050, 21186, -3455}, {16119, 12526, -30565, -32152}}};
    Cube self = new Cube(inputarray_self);
    Cube Arg_1 = new Cube(inputarray_Arg_1);
    assertEquals("[[[33648, 10165, 35773, -13700], [-12857, 28929, -20820, -13074]]]",
        self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Cube_getData_DC_1_1")
  void testgetData_1_1() throws Exception {
    int[][][] inputarray_self = {{{30064, 2676, -16056, -10316}, {-15450, -17298, 18322, 17123}}};
    Cube self = new Cube(inputarray_self);
    assertEquals("[[[30064, 2676, -16056, -10316], [-15450, -17298, 18322, 17123]]]",
        self.getData().toString());
  }
}
