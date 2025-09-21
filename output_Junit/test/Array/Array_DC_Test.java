package test.Array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Array;


public class Array_DC_Test {
  @Test
  @DisplayName("StaticFixedsizeArrays_Array_Array_DC_1")
  void testArray_1() throws Exception {
    int[] Arg_1 = {-27421, -2738, -22779, -23685, -20496};
    assertEquals("[-27421, -2738, -22779, -23685, -20496]", new Array(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Array_add_DC_6")
  void testadd_6() throws Exception {
    int[] inputarray_Arg_1 = {-13644, -9072, 31358, 6521, -27835};
    int[] inputarray_self = {-11609, 25198, 9885, 14232, 24642};
    Array self = new Array(inputarray_self);
    Array Arg_1 = new Array(inputarray_Arg_1);
    assertEquals("[-25253, 16126, 41243, 20753, -3193]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Array_sub_DC_6")
  void testsub_6() throws Exception {
    int[] inputarray_Arg_1 = {17280, 11769, -25904, -8624, 10638};
    int[] inputarray_self = {-28985, -988, -13171, 31152, -11322};
    Array self = new Array(inputarray_self);
    Array Arg_1 = new Array(inputarray_Arg_1);
    assertEquals("[-46265, -12757, 12733, 39776, -21960]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Array_getData_DC_1")
  void testgetData_1() throws Exception {
    int[] inputarray_self = {-9108, 2278, 24600, 21614, 19859};
    Array self = new Array(inputarray_self);
    assertEquals("[-9108, 2278, 24600, 21614, 19859]", self.getData().toString());
  }
}
