package test.Matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Matrix;


public class MatrixBVA_DC_Test {
  @Test
  @DisplayName("StaticFixedsizeArrays_Matrix_Matrix_DC_1_1")
  void testMatrix_1_1() throws Exception {
    int[][] Arg_1 = {{15723, 19530}, {25347, -19748}};
    assertEquals("[[15723, 19530], [25347, -19748]]", new Matrix(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Matrix_add_DC_31_1")
  void testadd_31_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-23785, 42}, {-27926, 20156}};
    int[][] inputarray_self = {{29514, 19790}, {9114, 10634}};
    Matrix self = new Matrix(inputarray_self);
    Matrix Arg_1 = new Matrix(inputarray_Arg_1);
    assertEquals("[[5729, 19832], [-18812, 30790]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Matrix_sub_DC_31_1")
  void testsub_31_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-30826, -5118}, {-7094, 29732}};
    int[][] inputarray_self = {{19953, 10308}, {-23886, 7175}};
    Matrix self = new Matrix(inputarray_self);
    Matrix Arg_1 = new Matrix(inputarray_Arg_1);
    assertEquals("[[50779, 15426], [-16792, -22557]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Matrix_getData_DC_1_1")
  void testgetData_1_1() throws Exception {
    int[][] inputarray_self = {{17997, 11198}, {-32580, 2584}};
    Matrix self = new Matrix(inputarray_self);
    assertEquals("[[17997, 11198], [-32580, 2584]]", self.getData().toString());
  }
}
