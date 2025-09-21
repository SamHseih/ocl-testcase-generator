package test.Cube;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Cube;


public class CubeBVA_DCC_Test {
  @Test
  @DisplayName("StaticFixedsizeArrays_Cube_Cube_DCC_1_1")
  void testCube_1_1() throws Exception {
    int[][][] Arg_1 = {{{29530, -19665, -13228, -11017}, {-23451, 13259, 8884, -23354}}};
    assertEquals("[[[29530, -19665, -13228, -11017], [-23451, 13259, 8884, -23354]]]",
        new Cube(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Cube_add_DCC_1391_1")
  void testadd_1391_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{31845, 23787, -4068, -2317}, {-16612, -15050, 22130, 32533}}};
    int[][][] inputarray_self = {{{-20520, 30289, 10985, -21261}, {32021, -28490, 14704, -7300}}};
    Cube self = new Cube(inputarray_self);
    Cube Arg_1 = new Cube(inputarray_Arg_1);
    assertEquals("[[[11325, 54076, 6917, -23578], [15409, -43540, 36834, 25233]]]",
        self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Cube_sub_DCC_1391_1")
  void testsub_1391_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{11867, 17857, -15301, 8413}, {-19445, -18219, 25240, 24775}}};
    int[][][] inputarray_self = {{{5521, -3437, -16246, -2714}, {30327, -10186, -24902, 22506}}};
    Cube self = new Cube(inputarray_self);
    Cube Arg_1 = new Cube(inputarray_Arg_1);
    assertEquals("[[[-6346, -21294, -945, -11127], [49772, 8033, -50142, -2269]]]",
        self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Cube_getData_DCC_1_1")
  void testgetData_1_1() throws Exception {
    int[][][] inputarray_self = {{{-17297, -2393, 30053, 29039}, {1435, 16372, 8395, -185}}};
    Cube self = new Cube(inputarray_self);
    assertEquals("[[[-17297, -2393, 30053, 29039], [1435, 16372, 8395, -185]]]",
        self.getData().toString());
  }
}
