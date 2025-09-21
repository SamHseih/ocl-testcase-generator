package test.VarArray;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.VarArray;


public class VarArray_DCC_Test {
  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_VarArray_DCC_1")
  void testVarArray_1() throws Exception {
    int[] Arg_1 = {-29700, -9869, 11791, -1611, 73, 17352, 23208};
    assertEquals("[-29700, -9869, 11791, -1611, 73, 17352, 23208]", new VarArray(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_2_Exception")
  void testadd_2() {
    assertThrows(Exception.class, () -> {
      int[] inputarray_Arg_1 = {29472, 14404, 24498};
      int[] inputarray_self = {14585, -12311, 27444, 11745, 7024, -12850};
      VarArray self = new VarArray(inputarray_self);
      VarArray Arg_1 = new VarArray(inputarray_Arg_1);
      self.add(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_4")
  void testadd_4() throws Exception {
    int[] inputarray_Arg_1 = {1532};
    int[] inputarray_self = {28796};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[30328]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_5")
  void testadd_5() throws Exception {
    int[] inputarray_Arg_1 = {28026, -12725};
    int[] inputarray_self = {-12710, -15995};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[15316, -28720]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_6")
  void testadd_6() throws Exception {
    int[] inputarray_Arg_1 = {-22361, -2328, -6367};
    int[] inputarray_self = {-18791, -10566, 12701};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-41152, -12894, 6334]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_7")
  void testadd_7() throws Exception {
    int[] inputarray_Arg_1 = {19142, -30411, 19303, -2214};
    int[] inputarray_self = {-16956, -31894, -8133, 13495};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[2186, -62305, 11170, 11281]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_8")
  void testadd_8() throws Exception {
    int[] inputarray_Arg_1 = {-3880, -26012, 15070, -32029, 2172};
    int[] inputarray_self = {21241, 28311, 5550, -29427, 905};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[17361, 2299, 20620, -61456, 3077]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_9")
  void testadd_9() throws Exception {
    int[] inputarray_Arg_1 = {-6381, -17906, -10308, 11242, 4300, -23789};
    int[] inputarray_self = {-8774, 2756, -22188, -15079, -9979, -28604};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-15155, -15150, -32496, -3837, -5679, -52393]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_10")
  void testadd_10() throws Exception {
    int[] inputarray_Arg_1 = {2393, 17093, 1339, 17578, -15133, 19276, 1569};
    int[] inputarray_self = {-29671, 3824, 8005, 14379, 23825, 1808, 12444};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-27278, 20917, 9344, 31957, 8692, 21084, 14013]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_11")
  void testadd_11() throws Exception {
    int[] inputarray_Arg_1 = {32087, -4975, 12133, -8509, 4673, -27484, -25157, -12911};
    int[] inputarray_self = {2645, -5971, -23137, -25912, -15868, 28256, -28791, 4950};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[34732, -10946, -11004, -34421, -11195, 772, -53948, -7961]",
        self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_12")
  void testadd_12() throws Exception {
    int[] inputarray_Arg_1 = {19220, 23230, -28423, -1163, -31754, -7757, -25234, 15802, 25891};
    int[] inputarray_self = {-26819, -21456, -3708, 17269, -24780, 31186, -5815, 24574, -25824};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-7599, 1774, -32131, 16106, -56534, 23429, -31049, 40376, 67]",
        self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_13")
  void testadd_13() throws Exception {
    int[] inputarray_Arg_1 = {10471, -10086, 13463, -14661, -2059, 2407, 13976, 27051, 10126, 2372};
    int[] inputarray_self =
        {-21691, 4559, -22096, -28020, 4421, -2122, -18006, 11667, -11193, 20150};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-11220, -5527, -8633, -42681, 2362, 285, -4030, 38718, -1067, 22522]",
        self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_2_Exception")
  void testsub_2() {
    assertThrows(Exception.class, () -> {
      int[] inputarray_Arg_1 = {31716, 19610, -30544, 21203, -29472, -27546, -1619};
      int[] inputarray_self = {-23426, -23297, -20401, 13074, 17380, -22857, -20421, 13787, 31582};
      VarArray self = new VarArray(inputarray_self);
      VarArray Arg_1 = new VarArray(inputarray_Arg_1);
      self.sub(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_4")
  void testsub_4() throws Exception {
    int[] inputarray_Arg_1 = {-21448};
    int[] inputarray_self = {-10417};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[11031]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_5")
  void testsub_5() throws Exception {
    int[] inputarray_Arg_1 = {-31597, -27346};
    int[] inputarray_self = {-1474, -16292};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[30123, 11054]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_6")
  void testsub_6() throws Exception {
    int[] inputarray_Arg_1 = {-31896, 13648, -28607};
    int[] inputarray_self = {4074, 15831, 2895};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[35970, 2183, 31502]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_7")
  void testsub_7() throws Exception {
    int[] inputarray_Arg_1 = {3460, 32748, 29236, -22163};
    int[] inputarray_self = {-20116, -20162, -391, -23451};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-23576, -52910, -29627, -1288]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_8")
  void testsub_8() throws Exception {
    int[] inputarray_Arg_1 = {13757, -29625, -6219, 1856, 9266};
    int[] inputarray_self = {-29068, -15470, 10843, -18649, -21092};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-42825, 14155, 17062, -20505, -30358]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_9")
  void testsub_9() throws Exception {
    int[] inputarray_Arg_1 = {-28887, 6955, 14299, 10102, 2157, 4980};
    int[] inputarray_self = {-20616, -13887, 9015, 5080, 14218, -16969};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[8271, -20842, -5284, -5022, 12061, -21949]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_10")
  void testsub_10() throws Exception {
    int[] inputarray_Arg_1 = {-12043, -21445, 17700, 28106, -8065, 18515, -31612};
    int[] inputarray_self = {-5493, 17700, 6401, 579, -3065, -31648, -24532};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[6550, 39145, -11299, -27527, 5000, -50163, 7080]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_11")
  void testsub_11() throws Exception {
    int[] inputarray_Arg_1 = {-22415, 6450, 27015, 23929, -20772, 23244, -28648, 19221};
    int[] inputarray_self = {21402, -31086, 5787, -13802, -21014, 19847, 3755, -9149};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[43817, -37536, -21228, -37731, -242, -3397, 32403, -28370]",
        self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_12")
  void testsub_12() throws Exception {
    int[] inputarray_Arg_1 = {1706, -11441, -24549, -11796, -13760, -33, 19530, -28422, -4071};
    int[] inputarray_self = {-25009, -26610, -28613, -3924, 701, 31102, 30807, -16064, 27517};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-26715, -15169, -4064, 7872, 14461, 31135, 11277, 12358, 31588]",
        self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_13")
  void testsub_13() throws Exception {
    int[] inputarray_Arg_1 = {-7581, -28802, 8224, 2813, 21754, 21328, 23697, 13987, -6476, 13984};
    int[] inputarray_self = {-27735, -5909, -8780, 9689, 13511, -9061, -15864, -19875, -664, -1266};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-20154, 22893, -17004, 6876, -8243, -30389, -39561, -33862, 5812, -15250]",
        self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_getData_DCC_1")
  void testgetData_1() throws Exception {
    int[] inputarray_self = {2746, 2056, -15719, -32118, -13738, 15956, 6737, -10215, 27407, 23362};
    VarArray self = new VarArray(inputarray_self);
    assertEquals("[2746, 2056, -15719, -32118, -13738, 15956, 6737, -10215, 27407, 23362]",
        self.getData().toString());
  }
}
