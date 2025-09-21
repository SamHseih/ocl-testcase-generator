package test.Matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Matrix;


public class Matrix_DCC_Test {
  @Test
  @DisplayName("StaticFixedsizeArrays_Matrix_Matrix_DCC_1")
  void testMatrix_1() throws Exception {
    int[][] Arg_1 = {{-13234, 5893}, {2311, 15076}};
    assertEquals("[[-13234, 5893], [2311, 15076]]", new Matrix(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Matrix_add_DCC_31")
  void testadd_31() throws Exception {
    int[][] inputarray_Arg_1 = {{-29676, 26054}, {-28350, -17603}};
    int[][] inputarray_self = {{-4494, 10097}, {28485, 5343}};
    Matrix self = new Matrix(inputarray_self);
    Matrix Arg_1 = new Matrix(inputarray_Arg_1);
    assertEquals("[[-34170, 36151], [135, -12260]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Matrix_sub_DCC_31")
  void testsub_31() throws Exception {
    int[][] inputarray_Arg_1 = {{-11882, -26443}, {22501, -10471}};
    int[][] inputarray_self = {{-15222, -11400}, {-4308, 2873}};
    Matrix self = new Matrix(inputarray_self);
    Matrix Arg_1 = new Matrix(inputarray_Arg_1);
    assertEquals("[[-3340, 15043], [-26809, 13344]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Matrix_getData_DCC_1")
  void testgetData_1() throws Exception {
    int[][] inputarray_self = {{4563, -4489}, {-17860, 25114}};
    Matrix self = new Matrix(inputarray_self);
    assertEquals("[[4563, -4489], [-17860, 25114]]", self.getData().toString());
  }
}
