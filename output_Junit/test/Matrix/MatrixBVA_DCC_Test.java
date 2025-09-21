package test.Matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Matrix;


public class MatrixBVA_DCC_Test {
  @Test
  @DisplayName("StaticFixedsizeArrays_Matrix_Matrix_DCC_1_1")
  void testMatrix_1_1() throws Exception {
    int[][] Arg_1 = {{31175, 22538}, {-26404, 30530}};
    assertEquals("[[31175, 22538], [-26404, 30530]]", new Matrix(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Matrix_add_DCC_31_1")
  void testadd_31_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-8065, 10330}, {5070, 24242}};
    int[][] inputarray_self = {{1012, -3496}, {12185, 12548}};
    Matrix self = new Matrix(inputarray_self);
    Matrix Arg_1 = new Matrix(inputarray_Arg_1);
    assertEquals("[[-7053, 6834], [17255, 36790]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Matrix_sub_DCC_31_1")
  void testsub_31_1() throws Exception {
    int[][] inputarray_Arg_1 = {{19018, 6886}, {-21960, -17664}};
    int[][] inputarray_self = {{21886, -13777}, {9575, -18911}};
    Matrix self = new Matrix(inputarray_self);
    Matrix Arg_1 = new Matrix(inputarray_Arg_1);
    assertEquals("[[2868, -20663], [31535, -1247]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Matrix_getData_DCC_1_1")
  void testgetData_1_1() throws Exception {
    int[][] inputarray_self = {{-30603, -23665}, {-22140, -8806}};
    Matrix self = new Matrix(inputarray_self);
    assertEquals("[[-30603, -23665], [-22140, -8806]]", self.getData().toString());
  }
}
