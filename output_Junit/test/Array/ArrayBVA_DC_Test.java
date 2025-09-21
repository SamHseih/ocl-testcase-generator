package test.Array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Array;


public class ArrayBVA_DC_Test {
  @Test
  @DisplayName("StaticFixedsizeArrays_Array_Array_DC_1_1")
  void testArray_1_1() throws Exception {
    int[] Arg_1 = {-8842, -27473, 18060, -8272, 19213};
    assertEquals("[-8842, -27473, 18060, -8272, 19213]", new Array(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Array_add_DC_6_1")
  void testadd_6_1() throws Exception {
    int[] inputarray_Arg_1 = {9336, -5921, -30620, 4455, -16070};
    int[] inputarray_self = {24242, 21716, -17463, 11792, -8069};
    Array self = new Array(inputarray_self);
    Array Arg_1 = new Array(inputarray_Arg_1);
    assertEquals("[33578, 15795, -48083, 16247, -24139]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Array_sub_DC_6_1")
  void testsub_6_1() throws Exception {
    int[] inputarray_Arg_1 = {9729, 13848, 18912, -4139, -17611};
    int[] inputarray_self = {-20967, 20322, 1229, 27177, -31527};
    Array self = new Array(inputarray_self);
    Array Arg_1 = new Array(inputarray_Arg_1);
    assertEquals("[-30696, 6474, -17683, 31316, -13916]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Array_getData_DC_1_1")
  void testgetData_1_1() throws Exception {
    int[] inputarray_self = {-8476, 16490, -2471, -22216, 17049};
    Array self = new Array(inputarray_self);
    assertEquals("[-8476, 16490, -2471, -22216, 17049]", self.getData().toString());
  }
}
