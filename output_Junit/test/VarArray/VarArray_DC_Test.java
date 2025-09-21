package test.VarArray;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.VarArray;


public class VarArray_DC_Test {
  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_VarArray_DC_1")
  void testVarArray_1() throws Exception {
    int[] Arg_1 = {-22121, 13992, 31097, -11677, -23052, 31891, -3322};
    assertEquals("[-22121, 13992, 31097, -11677, -23052, 31891, -3322]",
        new VarArray(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_1_Exception")
  void testadd_1() {
    assertThrows(Exception.class, () -> {
      int[] inputarray_Arg_1 = {18168, 16586, -25880, 26932, 24690, -7851};
      int[] inputarray_self = {12048, 28613};
      VarArray self = new VarArray(inputarray_self);
      VarArray Arg_1 = new VarArray(inputarray_Arg_1);
      self.add(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_3")
  void testadd_3() throws Exception {
    int[] inputarray_Arg_1 = {-3579};
    int[] inputarray_self = {-21156};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-24735]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_4")
  void testadd_4() throws Exception {
    int[] inputarray_Arg_1 = {-5455, -21276};
    int[] inputarray_self = {-8971, -3722};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-14426, -24998]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_5")
  void testadd_5() throws Exception {
    int[] inputarray_Arg_1 = {-19312, 18409, -17057};
    int[] inputarray_self = {-28992, 17422, -11039};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-48304, 35831, -28096]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_6")
  void testadd_6() throws Exception {
    int[] inputarray_Arg_1 = {28353, 18424, 29566, -22754};
    int[] inputarray_self = {-13542, -9619, -24483, 7036};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[14811, 8805, 5083, -15718]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_7")
  void testadd_7() throws Exception {
    int[] inputarray_Arg_1 = {28814, -9733, 13424, 15164, -27449};
    int[] inputarray_self = {-14163, 32334, -30353, 24239, -2874};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[14651, 22601, -16929, 39403, -30323]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_8")
  void testadd_8() throws Exception {
    int[] inputarray_Arg_1 = {14118, 2335, 3477, 6272, 16365, -11537};
    int[] inputarray_self = {-18141, -26493, 7685, 10766, 24446, 15221};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-4023, -24158, 11162, 17038, 40811, 3684]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_9")
  void testadd_9() throws Exception {
    int[] inputarray_Arg_1 = {8080, -31921, -9486, -32498, -29257, 13350, -32119};
    int[] inputarray_self = {25773, -13337, -5115, -2019, 15575, 17872, 24436};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[33853, -45258, -14601, -34517, -13682, 31222, -7683]",
        self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_10")
  void testadd_10() throws Exception {
    int[] inputarray_Arg_1 = {6126, 14904, 8390, -14045, -21969, -14913, 5961, 3855};
    int[] inputarray_self = {11226, 3976, -15620, -21155, 29467, -21639, 7477, 24831};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[17352, 18880, -7230, -35200, 7498, -36552, 13438, 28686]",
        self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_11")
  void testadd_11() throws Exception {
    int[] inputarray_Arg_1 = {11245, -14979, -21985, 21001, 909, -17202, 27882, 8026, -21104};
    int[] inputarray_self = {16637, 25395, -28599, -31128, -2552, -24961, 241, 2022, -18822};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[27882, 10416, -50584, -10127, -1643, -42163, 28123, 10048, -39926]",
        self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_add_DC_12")
  void testadd_12() throws Exception {
    int[] inputarray_Arg_1 = {-10599, 31467, -24434, 1637, 19223, 14239, 30176, -8080, 1104, 17991};
    int[] inputarray_self = {-7827, 30657, 5903, 14691, 25753, 8062, 10769, -314, -9566, -24232};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-18426, 62124, -18531, 16328, 44976, 22301, 40945, -8394, -8462, -6241]",
        self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_1_Exception")
  void testsub_1() {
    assertThrows(Exception.class, () -> {
      int[] inputarray_Arg_1 =
          {434, -11812, 11419, 19068, -5225, -2862, 18186, -17054, -11830, 11147};
      int[] inputarray_self = {-29870, 18895, 25227, -15640, 17308, -14137, -13782, 10027, 7996};
      VarArray self = new VarArray(inputarray_self);
      VarArray Arg_1 = new VarArray(inputarray_Arg_1);
      self.sub(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_3")
  void testsub_3() throws Exception {
    int[] inputarray_Arg_1 = {-8831};
    int[] inputarray_self = {5518};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[14349]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_4")
  void testsub_4() throws Exception {
    int[] inputarray_Arg_1 = {9105, 853};
    int[] inputarray_self = {24724, 23872};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[15619, 23019]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_5")
  void testsub_5() throws Exception {
    int[] inputarray_Arg_1 = {8362, -16416, 13471};
    int[] inputarray_self = {17042, -26078, 19733};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[8680, -9662, 6262]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_6")
  void testsub_6() throws Exception {
    int[] inputarray_Arg_1 = {29878, 8269, 15730, -24231};
    int[] inputarray_self = {27316, -6393, -14793, 7790};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-2562, -14662, -30523, 32021]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_7")
  void testsub_7() throws Exception {
    int[] inputarray_Arg_1 = {-1099, -24741, 25251, 17690, -361};
    int[] inputarray_self = {-13712, -1118, 8762, 17229, -27197};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-12613, 23623, -16489, -461, -26836]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_8")
  void testsub_8() throws Exception {
    int[] inputarray_Arg_1 = {-17192, -28806, 24744, -11402, -1577, -10039};
    int[] inputarray_self = {7356, -9952, -31424, -19168, -10921, 15744};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[24548, 18854, -56168, -7766, -9344, 25783]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_9")
  void testsub_9() throws Exception {
    int[] inputarray_Arg_1 = {17499, 11266, 15940, 22912, 21772, -1836, 21414};
    int[] inputarray_self = {6991, -20452, 22667, -23285, -12024, 5991, -4600};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-10508, -31718, 6727, -46197, -33796, 7827, -26014]",
        self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_10")
  void testsub_10() throws Exception {
    int[] inputarray_Arg_1 = {-643, 2976, -23569, -22763, -6718, 21994, -31112, -7718};
    int[] inputarray_self = {-11033, -506, 32738, -32380, 30104, -25503, 3098, 817};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-10390, -3482, 56307, -9617, 36822, -47497, 34210, 8535]",
        self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_11")
  void testsub_11() throws Exception {
    int[] inputarray_Arg_1 = {-23543, 23103, 11640, 12870, -21593, -28982, 31667, -28801, -25693};
    int[] inputarray_self = {4696, 1268, 9311, 13093, 27080, -25867, -10320, 26029, 14675};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[28239, -21835, -2329, 223, 48673, 3115, -41987, 54830, 40368]",
        self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_sub_DC_12")
  void testsub_12() throws Exception {
    int[] inputarray_Arg_1 =
        {21562, 12340, -32700, -5623, -5706, -15393, -5756, -29164, -26173, 15905};
    int[] inputarray_self =
        {-8527, -28654, -18698, 22431, 4288, -23427, -13555, 5551, -1994, 31987};
    VarArray self = new VarArray(inputarray_self);
    VarArray Arg_1 = new VarArray(inputarray_Arg_1);
    assertEquals("[-30089, -40994, 14002, 28054, 9994, -8034, -7799, 34715, 24179, 16082]",
        self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeVarArrays_VarArray_getData_DC_1")
  void testgetData_1() throws Exception {
    int[] inputarray_self = {-26348, 18033, 904, 26431, 20131, -20548, 19819, 18114};
    VarArray self = new VarArray(inputarray_self);
    assertEquals("[-26348, 18033, 904, 26431, 20131, -20548, 19819, 18114]",
        self.getData().toString());
  }
}
