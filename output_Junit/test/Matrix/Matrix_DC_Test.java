package test.Matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Matrix;


public class Matrix_DC_Test {
  @Test
  @DisplayName("StaticFixedsizeArrays_Matrix_Matrix_DC_1")
  void testMatrix_1() throws Exception {
    int[][] Arg_1 = {{11647, -19563}, {14031, 3430}};
    assertEquals("[[11647, -19563], [14031, 3430]]", new Matrix(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Matrix_add_DC_31")
  void testadd_31() throws Exception {
    int[][] inputarray_Arg_1 = {{12940, -27840}, {19815, 15524}};
    int[][] inputarray_self = {{-14301, 7480}, {-604, -20054}};
    Matrix self = new Matrix(inputarray_self);
    Matrix Arg_1 = new Matrix(inputarray_Arg_1);
    assertEquals("[[-1361, -20360], [19211, -4530]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Matrix_sub_DC_31")
  void testsub_31() throws Exception {
    int[][] inputarray_Arg_1 = {{-28746, 29016}, {20546, -26897}};
    int[][] inputarray_self = {{-4374, -8543}, {15036, -31202}};
    Matrix self = new Matrix(inputarray_self);
    Matrix Arg_1 = new Matrix(inputarray_Arg_1);
    assertEquals("[[24372, -37559], [-5510, -4305]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("StaticFixedsizeArrays_Matrix_getData_DC_1")
  void testgetData_1() throws Exception {
    int[][] inputarray_self = {{19930, -4177}, {-18005, -10618}};
    Matrix self = new Matrix(inputarray_self);
    assertEquals("[[19930, -4177], [-18005, -10618]]", self.getData().toString());
  }
}
