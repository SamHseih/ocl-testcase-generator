package test.VarArray;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.VarArray;


public class VarArrayBVA_DCC_Test {
  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_VarArray_DCC_1_1")
  void testVarArray_1_1() throws Exception {
    int[] Arg_1 = {-23539, 12424, -29610, -5541, 25418, 5682, 11649};
    assertEquals("[-23539, 12424, -29610, -5541, 25418, 5682, 11649]",
        new VarArray(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_2_1_Exception")
  void testadd_2_1() {
    assertThrows(Exception.class, () -> {
      int[] inputarray_Arg_1 = {12681, -26084, 9731, 4121, -21856, 10158, 27984, -821, -16181};
      int[] inputarray_self = {-14184, 22365, 6438};
      VarArray self = new VarArray(inputarray_self);
      VarArray Arg_1 = new VarArray(inputarray_Arg_1);
      self.add(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_4_1")
  void testadd_4_1() throws Exception {
    int[] inputarray_Arg_1 = {-20049};
    int[] inputarray_self = {-21783};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-41832]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_5_1")
  void testadd_5_1() throws Exception {
    int[] inputarray_Arg_1 = {29152, -15531};
    int[] inputarray_self = {6196, 1495};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[35348, -14036]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_6_1")
  void testadd_6_1() throws Exception {
    int[] inputarray_Arg_1 = {24163, 9803, 10967};
    int[] inputarray_self = {-14412, 30360, 30776};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[9751, 40163, 41743]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_7_1")
  void testadd_7_1() throws Exception {
    int[] inputarray_Arg_1 = {32521, -22204, 9998, 12250};
    int[] inputarray_self = {3661, -1548, 17827, -12030};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[36182, -23752, 27825, 220]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_8_1")
  void testadd_8_1() throws Exception {
    int[] inputarray_Arg_1 = {-18690, -14423, 22953, 29664, 24170};
    int[] inputarray_self = {-11700, -22109, 7943, -23355, 28860};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-30390, -36532, 30896, 6309, 53030]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_9_1")
  void testadd_9_1() throws Exception {
    int[] inputarray_Arg_1 = {4026, -29699, 23937, -26897, 27287, -26980};
    int[] inputarray_self = {21820, -14087, -20128, 17132, 23799, -18850};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[25846, -43786, 3809, -9765, 51086, -45830]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_10_1")
  void testadd_10_1() throws Exception {
    int[] inputarray_Arg_1 = {20930, -20115, -8373, 28333, 15844, -24882, 30307};
    int[] inputarray_self = {6555, 31054, 4344, -22875, -12916, 23521, 6613};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[27485, 10939, -4029, 5458, 2928, -1361, 36920]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_11_1")
  void testadd_11_1() throws Exception {
    int[] inputarray_Arg_1 = {20692, 2238, 32509, -588, -31372, 4020, -20910, -1674};
    int[] inputarray_self = {3367, -20471, 11313, 18627, -3619, -31669, 9273, 18237};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[24059, -18233, 43822, 18039, -34991, -27649, -11637, 16563]",
        self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_12_1")
  void testadd_12_1() throws Exception {
    int[] inputarray_Arg_1 = {4006, -9199, -17182, -13729, 9822, 32301, -23932, -15315, -20853};
    int[] inputarray_self = {12981, -10947, 21789, -496, -13799, -18374, -30921, -24211, -24065};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[16987, -20146, 4607, -14225, -3977, 13927, -54853, -39526, -44918]",
        self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DCC_13_1")
  void testadd_13_1() throws Exception {
    int[] inputarray_Arg_1 =
        {-19888, -14402, -22565, -6712, 24333, 16462, -17761, 30619, 8169, -1751};
    int[] inputarray_self =
        {-19562, -10907, 30252, 30031, 1922, -7735, 23227, 27275, 18898, -17474};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-39450, -25309, 7687, 23319, 26255, 8727, 5466, 57894, 27067, -19225]",
        self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_2_1_Exception")
  void testsub_2_1() {
    assertThrows(Exception.class, () -> {
      int[] inputarray_Arg_1 = {15074, -31175, 8045};
      int[] inputarray_self = {-21227, -18007, -2498, 15308, -17950, 27737, -28128};
      VarArray self = new VarArray(inputarray_self);
      VarArray Arg_1 = new VarArray(inputarray_Arg_1);
      self.sub(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_4_1")
  void testsub_4_1() throws Exception {
    int[] inputarray_Arg_1 = {-3500};
    int[] inputarray_self = {-10369};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-6869]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_5_1")
  void testsub_5_1() throws Exception {
    int[] inputarray_Arg_1 = {-6199, -14645};
    int[] inputarray_self = {-8328, -31989};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-2129, -17344]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_6_1")
  void testsub_6_1() throws Exception {
    int[] inputarray_Arg_1 = {-13979, -5499, 7080};
    int[] inputarray_self = {9561, -15394, 1748};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[23540, -9895, -5332]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_7_1")
  void testsub_7_1() throws Exception {
    int[] inputarray_Arg_1 = {15619, -19757, -3095, -30126};
    int[] inputarray_self = {20571, 28247, 7772, 7585};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[4952, 48004, 10867, 37711]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_8_1")
  void testsub_8_1() throws Exception {
    int[] inputarray_Arg_1 = {-1801, -12197, -8157, 14155, -21179};
    int[] inputarray_self = {17673, -11121, -5605, -16828, -9048};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[19474, 1076, 2552, -30983, 12131]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_9_1")
  void testsub_9_1() throws Exception {
    int[] inputarray_Arg_1 = {20805, 24815, -8379, -11159, -5738, 3900};
    int[] inputarray_self = {-3080, 1816, 4142, 27542, 31923, -12724};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-23885, -22999, 12521, 38701, 37661, -16624]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_10_1")
  void testsub_10_1() throws Exception {
    int[] inputarray_Arg_1 = {-29840, 28079, -2200, 15710, 26667, 3144, -6315};
    int[] inputarray_self = {-17835, -23122, -10389, -695, 13544, 25412, -4018};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[12005, -51201, -8189, -16405, -13123, 22268, 2297]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_11_1")
  void testsub_11_1() throws Exception {
    int[] inputarray_Arg_1 = {-799, -9467, 31280, 8209, 2443, -16765, 4117, -23062};
    int[] inputarray_self = {-15339, -31565, -951, -19972, -804, -6422, -29820, 14567};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-14540, -22098, -32231, -28181, -3247, 10343, -33937, 37629]",
        self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_12_1")
  void testsub_12_1() throws Exception {
    int[] inputarray_Arg_1 = {-15842, -11635, -31197, 9424, 32069, -7538, 8970, 15998, -16800};
    int[] inputarray_self = {-12005, 2258, 30997, -20530, -16026, 12924, -17997, 21035, 11611};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[3837, 13893, 62194, -29954, -48095, 20462, -26967, 5037, 28411]",
        self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DCC_13_1")
  void testsub_13_1() throws Exception {
    int[] inputarray_Arg_1 =
        {-19096, -9683, -2734, -4020, 13932, 15430, -25668, -28036, 27269, -22760};
    int[] inputarray_self =
        {22787, -32091, 13299, -28677, 29444, 27297, 6372, -28505, -26741, 22353};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[41883, -22408, 16033, -24657, 15512, 11867, 32040, -469, -54010, 45113]",
        self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_getData_DCC_1_1")
  void testgetData_1_1() throws Exception {
    int[] inputarray_self = {-26309, 12975, -2178, -11297, 24223, -23115, -4875};
    VarArray self = new VarArray(inputarray_self);
    assertEquals("[-26309, 12975, -2178, -11297, 24223, -23115, -4875]", self.getData().toString());
  }
}
