package test.VarArray;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.VarArray;


public class VarArrayBVA_DC_Test {
  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_VarArray_DC_1_1")
  void testVarArray_1_1() throws Exception {
    int[] Arg_1 = {23106, 8290, -20986, 9443, 2537, 11696};
    assertEquals("[23106, 8290, -20986, 9443, 2537, 11696]", new VarArray(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_1_1_Exception")
  void testadd_1_1() {
    assertThrows(Exception.class, () -> {
      int[] inputarray_Arg_1 = {-19238, -13746, -13800, -11184, -23070, -9311};
      int[] inputarray_self = {32487, -11869, 31471};
      VarArray self = new VarArray(inputarray_self);
      VarArray Arg_1 = new VarArray(inputarray_Arg_1);
      self.add(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_3_1")
  void testadd_3_1() throws Exception {
    int[] inputarray_Arg_1 = {-5485};
    int[] inputarray_self = {12793};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[7308]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_4_1")
  void testadd_4_1() throws Exception {
    int[] inputarray_Arg_1 = {-3849, -24825};
    int[] inputarray_self = {18253, -31337};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[14404, -56162]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_5_1")
  void testadd_5_1() throws Exception {
    int[] inputarray_Arg_1 = {1896, -20404, 23392};
    int[] inputarray_self = {14563, 10393, 4998};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[16459, -10011, 28390]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_6_1")
  void testadd_6_1() throws Exception {
    int[] inputarray_Arg_1 = {21012, -19601, 19959, 12591};
    int[] inputarray_self = {-5772, -17397, -21520, -29525};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[15240, -36998, -1561, -16934]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_7_1")
  void testadd_7_1() throws Exception {
    int[] inputarray_Arg_1 = {15488, 17760, 24576, 2135, 8701};
    int[] inputarray_self = {-10346, -11707, 20598, -21606, 487};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[5142, 6053, 45174, -19471, 9188]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_8_1")
  void testadd_8_1() throws Exception {
    int[] inputarray_Arg_1 = {-14188, 23571, -2031, -14604, -11525, -21994};
    int[] inputarray_self = {-4483, 4457, 20920, -6462, 31403, 24201};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-18671, 28028, 18889, -21066, 19878, 2207]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_9_1")
  void testadd_9_1() throws Exception {
    int[] inputarray_Arg_1 = {-17618, 32332, -26847, -6560, 14807, 30771, -15761};
    int[] inputarray_self = {-30777, 19198, -3803, 17906, 23852, -24549, 22694};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-48395, 51530, -30650, 11346, 38659, 6222, 6933]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_10_1")
  void testadd_10_1() throws Exception {
    int[] inputarray_Arg_1 = {12402, -8591, 24396, 20675, -22126, -1562, -5081, 15784};
    int[] inputarray_self = {-8168, 28889, -19820, 8235, -14136, 27682, -28747, 25808};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[4234, 20298, 4576, 28910, -36262, 26120, -33828, 41592]",
        self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_11_1")
  void testadd_11_1() throws Exception {
    int[] inputarray_Arg_1 = {18412, -2399, 3924, 29040, 21664, -10551, -8075, -25839, -12422};
    int[] inputarray_self = {7039, 4182, -10519, 25016, 6714, -25235, -23517, -13503, -15514};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[25451, 1783, -6595, 54056, 28378, -35786, -31592, -39342, -27936]",
        self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_12_1")
  void testadd_12_1() throws Exception {
    int[] inputarray_Arg_1 =
        {-1009, -30839, -22469, -1169, 22871, 23062, 32597, 4352, 6167, -15778};
    int[] inputarray_self =
        {27935, 22845, 24892, 31084, -11430, -30389, 9185, -11407, -21473, -24395};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[26926, -7994, 2423, 29915, 11441, -7327, 41782, -7055, -15306, -40173]",
        self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_1_1_Exception")
  void testsub_1_1() {
    assertThrows(Exception.class, () -> {
      int[] inputarray_Arg_1 = {-5309, 22212, 763, -31108, 14020, 16356};
      int[] inputarray_self = {18551, -2274, 5885, 12289, -25347, 2909, 1460};
      VarArray self = new VarArray(inputarray_self);
      VarArray Arg_1 = new VarArray(inputarray_Arg_1);
      self.sub(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_3_1")
  void testsub_3_1() throws Exception {
    int[] inputarray_Arg_1 = {-24925};
    int[] inputarray_self = {-22901};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[2024]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_4_1")
  void testsub_4_1() throws Exception {
    int[] inputarray_Arg_1 = {-5057, -19011};
    int[] inputarray_self = {-25887, 3738};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-20830, 22749]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_5_1")
  void testsub_5_1() throws Exception {
    int[] inputarray_Arg_1 = {14411, -25001, -2394};
    int[] inputarray_self = {-24234, -18694, 19873};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-38645, 6307, 22267]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_6_1")
  void testsub_6_1() throws Exception {
    int[] inputarray_Arg_1 = {-19130, 14858, 22209, -6375};
    int[] inputarray_self = {31020, -29583, 1131, 3722};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[50150, -44441, -21078, 10097]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_7_1")
  void testsub_7_1() throws Exception {
    int[] inputarray_Arg_1 = {-8441, 7622, 16421, 4153, -25668};
    int[] inputarray_self = {15404, 9377, -9689, -6700, 16507};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[23845, 1755, -26110, -10853, 42175]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_8_1")
  void testsub_8_1() throws Exception {
    int[] inputarray_Arg_1 = {24023, 24329, -4068, -9113, 32233, -17643};
    int[] inputarray_self = {-1924, 20167, 25942, 1644, -6009, 26180};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-25947, -4162, 30010, 10757, -38242, 43823]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_9_1")
  void testsub_9_1() throws Exception {
    int[] inputarray_Arg_1 = {4550, -10587, 24953, 726, 14252, -32616, -25917};
    int[] inputarray_self = {-18889, -28527, 30735, 11857, -5864, 1560, -18060};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-23439, -17940, 5782, 11131, -20116, 34176, 7857]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_10_1")
  void testsub_10_1() throws Exception {
    int[] inputarray_Arg_1 = {-31206, 15221, -24456, 25201, -25573, 16837, -16848, -18622};
    int[] inputarray_self = {12000, -11647, -10197, -2033, -107, -14334, -24512, 307};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[43206, -26868, 14259, -27234, 25466, -31171, -7664, 18929]",
        self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_11_1")
  void testsub_11_1() throws Exception {
    int[] inputarray_Arg_1 = {-26376, -5106, -15263, 17113, -4212, -12783, 6187, -24126, -4335};
    int[] inputarray_self = {27900, 15101, 11838, -24994, -14613, 20465, -21047, 13893, 1293};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[54276, 20207, 27101, -42107, -10401, 33248, -27234, 38019, 5628]",
        self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_12_1")
  void testsub_12_1() throws Exception {
    int[] inputarray_Arg_1 =
        {19049, -2273, 22673, 9234, -26068, -9896, 16956, -30002, 16246, 20474};
    int[] inputarray_self =
        {-29150, -18152, -28483, -15426, 22146, -6907, 16383, 26627, -10972, 11031};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-48199, -15879, -51156, -24660, 48214, 2989, -573, 56629, -27218, -9443]",
        self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_getData_DC_1_1")
  void testgetData_1_1() throws Exception {
    int[] inputarray_self = {19561, -5998, -13695};
    VarArray self = new VarArray(inputarray_self);
    assertEquals("[19561, -5998, -13695]", self.getData().toString());
  }
}
