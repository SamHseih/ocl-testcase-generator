package test.Array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Array;


public class Array_DCC_Test {
  @Test
  @DisplayName("StaticFixedsizeArrays_Array_Array_DCC_1")
  void testArray_1() throws Exception {
    int[] Arg_1 = {-32316, -30811, 1431, 6921, -13820};
    assertEquals("[-32316, -30811, 1431, 6921, -13820]", new Array(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Array_add_DCC_6")
  void testadd_6() throws Exception {
    int[] inputarray_Arg_1 = {-5501, 23632, -1196, -12613, 29942};
    int[] inputarray_self = {-13451, -10221, 10115, 30550, 25481};
    Array self = new Array(inputarray_self);
    Array Arg_1 = new Array(inputarray_Arg_1);
    assertEquals("[-18952, 13411, 8919, 17937, 55423]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Array_sub_DCC_6")
  void testsub_6() throws Exception {
    int[] inputarray_Arg_1 = {17160, -21054, 13760, -16461, -26065};
    int[] inputarray_self = {-322, -330, 10295, -8551, -1555};
    Array self = new Array(inputarray_self);
    Array Arg_1 = new Array(inputarray_Arg_1);
    assertEquals("[-17482, 20724, -3465, 7910, 24510]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Array_getData_DCC_1")
  void testgetData_1() throws Exception {
    int[] inputarray_self = {-21980, -27214, -26464, 23958, -110};
    Array self = new Array(inputarray_self);
    assertEquals("[-21980, -27214, -26464, 23958, -110]", self.getData().toString());
  }
}
