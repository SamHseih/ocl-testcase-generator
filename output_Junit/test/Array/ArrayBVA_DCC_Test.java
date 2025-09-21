package test.Array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Array;


public class ArrayBVA_DCC_Test {
  @Test
  @DisplayName("StaticFixedsizeArrays_Array_Array_DCC_1_1")
  void testArray_1_1() throws Exception {
    int[] Arg_1 = {13299, 32269, 31992, -26096, -10716};
    assertEquals("[13299, 32269, 31992, -26096, -10716]", new Array(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Array_add_DCC_6_1")
  void testadd_6_1() throws Exception {
    int[] inputarray_Arg_1 = {-4328, 27033, 26992, -29013, -10534};
    int[] inputarray_self = {10045, -5257, 4029, -18160, 17801};
    Array self = new Array(inputarray_self);
    Array Arg_1 = new Array(inputarray_Arg_1);
    assertEquals("[5717, 21776, 31021, -47173, 7267]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Array_sub_DCC_6_1")
  void testsub_6_1() throws Exception {
    int[] inputarray_Arg_1 = {22604, 16630, 6984, 8195, 22629};
    int[] inputarray_self = {25246, -24625, -21850, 25033, -14480};
    Array self = new Array(inputarray_self);
    Array Arg_1 = new Array(inputarray_Arg_1);
    assertEquals("[2642, -41255, -28834, 16838, -37109]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Array_getData_DCC_1_1")
  void testgetData_1_1() throws Exception {
    int[] inputarray_self = {17038, -19688, 26285, -8449, -29376};
    Array self = new Array(inputarray_self);
    assertEquals("[17038, -19688, 26285, -8449, -29376]", self.getData().toString());
  }
}
