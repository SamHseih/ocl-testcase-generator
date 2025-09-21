package test.TwoDimVarArray;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.TwoDimVarArray;


public class TwoDimVarArrayBVA_DCC_Test {
  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_TwoDimVarArray_DCC_1_1")
  void testTwoDimVarArray_1_1() throws Exception {
    int[][] Arg_1 = {{-26113, -2209, 20268, 2105, -12452, -30706, -7698, -18985},
        {-10345, 1567, 30493, 28400, 20916, -6656, 31726, 4366},
        {5462, 22919, 11420, 4388, 32474, 29643, 24486, 31095},
        {31424, -20941, -5785, -19197, 23892, 21161, -9334, 11251},
        {3069, 11567, -564, 2963, -14165, 11718, -27255, 30503},
        {-9580, 31874, 14716, -8276, -32321, 2614, -18762, -6724},
        {28771, 3706, 15118, -1447, -7354, 3392, -20591, -342},
        {-18304, -22232, -31513, -32732, 31496, 14692, 3437, -7207},
        {16279, -1412, -19243, -4033, -18745, -23052, 2041, -4142},
        {-30452, 32596, 32601, -16204, 21109, 26811, 22117, -25025}};
    assertEquals(
        "[[-26113, -2209, 20268, 2105, -12452, -30706, -7698, -18985], [-10345, 1567, 30493, 28400, 20916, -6656, 31726, 4366], [5462, 22919, 11420, 4388, 32474, 29643, 24486, 31095], [31424, -20941, -5785, -19197, 23892, 21161, -9334, 11251], [3069, 11567, -564, 2963, -14165, 11718, -27255, 30503], [-9580, 31874, 14716, -8276, -32321, 2614, -18762, -6724], [28771, 3706, 15118, -1447, -7354, 3392, -20591, -342], [-18304, -22232, -31513, -32732, 31496, 14692, 3437, -7207], [16279, -1412, -19243, -4033, -18745, -23052, 2041, -4142], [-30452, 32596, 32601, -16204, 21109, 26811, 22117, -25025]]",
        new TwoDimVarArray(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_1_1_Exception")
  void testadd_1_1() {
    assertThrows(Exception.class, () -> {
      int[][] inputarray_Arg_1 = {{3486, -4049, -1471, -28145}, {12713, 3217, -9391, -27058},
          {-22584, 15402, -8977, -32160}, {-21565, -21988, -19802, -9643},
          {-5092, -20992, -7148, -24651}, {16073, -12102, 19904, 9995},
          {6819, -17741, -16817, -4342}, {2620, -4384, -26639, 9215}};
      int[][] inputarray_self =
          {{-19969}, {20547}, {13732}, {32706}, {15802}, {23874}, {3686}, {1693}};
      TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
      TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
      self.add(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_3_1_Exception")
  void testadd_3_1() {
    assertThrows(Exception.class, () -> {
      int[][] inputarray_Arg_1 =
          {{8741, -6703, 13686, 12246, -27745, -12454, -26105, -31766, -15742, 22392},
              {-30389, -3416, 30040, -19519, -14097, 5999, -5038, -29232, 27421, 29468},
              {22700, -32390, 32176, -19576, -17951, -26184, 2820, 20923, -975, 4734},
              {23406, 2655, -11718, 26251, -29423, -26232, 21551, 712, -8775, 2562},
              {-31879, 27306, 9998, 24911, -3603, -32407, -19108, 19559, -30145, 1017},
              {-21366, 28620, -20762, -23454, -32241, -12144, -20249, 30148, -599, 21695},
              {-8331, 28409, 30477, 20266, -20526, -30613, -1528, 3670, -26634, -18375}};
      int[][] inputarray_self =
          {{20246, -51, 30140, -2974, -24110, 2812, 16354, -21438, -11258, -28574},
              {-2470, -7071, 31376, 22674, 3138, -22180, 27959, -14827, -29178, 15085},
              {-27072, 26997, -4748, 17338, -29427, -23456, -15782, 2298, -22658, 28038}};
      TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
      TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
      self.add(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_6_1")
  void testadd_6_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-20300}};
    int[][] inputarray_self = {{-22853}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-43153]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_8_1")
  void testadd_8_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-26125, -4680}};
    int[][] inputarray_self = {{3998, 6470}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-22127, 1790]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_11_1")
  void testadd_11_1() throws Exception {
    int[][] inputarray_Arg_1 = {{7541, 4247, -31272}};
    int[][] inputarray_self = {{-11976, 10271, -30796}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-4435, 14518, -62068]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_14_1")
  void testadd_14_1() throws Exception {
    int[][] inputarray_Arg_1 = {{7675}, {6433}};
    int[][] inputarray_self = {{64}, {-26021}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[7739], [-19588]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_16_1")
  void testadd_16_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-8595, 26573, 14591, -30316}};
    int[][] inputarray_self = {{17249, -3448, -7093, -8099}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[8654, 23125, 7498, -38415]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_25_1")
  void testadd_25_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-19721, 30801, 21009, -17793, -13620}};
    int[][] inputarray_self = {{2128, -2057, 25667, -13158, -16704}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-17593, 28744, 46676, -30951, -30324]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_34_1")
  void testadd_34_1() throws Exception {
    int[][] inputarray_Arg_1 = {{13993, 18725}, {-23402, 30395}};
    int[][] inputarray_self = {{30665, 8769}, {15657, 31023}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[44658, 27494], [-7745, 61418]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_41_1")
  void testadd_41_1() throws Exception {
    int[][] inputarray_Arg_1 = {{15420, -17254, -12862, -3724, -24592, 6240}};
    int[][] inputarray_self = {{-23540, 3129, -430, 24938, 21017, 18757}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-8120, -14125, -13292, 21214, -3575, 24997]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_46_1")
  void testadd_46_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-13221}, {29366}, {22263}};
    int[][] inputarray_self = {{25728}, {-12033}, {-31006}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[12507], [17333], [-8743]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_69_1")
  void testadd_69_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-29853, 7397, -13207, 31246, 10625, 15105, 25698}};
    int[][] inputarray_self = {{-24697, 25039, -16355, -13567, -24202, 6251, -28147}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-54550, 32436, -29562, 17679, -13577, 21356, -2449]]",
        self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_1_1_Exception")
  void testsub_1_1() {
    assertThrows(Exception.class, () -> {
      int[][] inputarray_Arg_1 =
          {{6953, -28729, -31605, 9828, -20, -23536, -2381, -16852, 16115, -19530},
              {24360, -29410, 30182, 2877, 11966, 2230, -26864, 9187, 8586, -22521},
              {10487, -4236, 2457, 2969, 31360, -18612, -20719, -11120, 13757, 21846},
              {1002, 20555, 2419, 5011, 19837, -19906, -25951, -5932, 1352, 14080},
              {9046, 28187, 23837, -27682, 21148, -4429, 571, 13278, 21331, 12009},
              {22071, -20072, 11600, 6807, -13175, -3501, -16180, 7921, -6003, 11469},
              {-9797, 9020, 20984, -5134, -10314, 26512, -12520, -14206, -12386, 20982},
              {5826, -28807, 32323, 25845, -2596, 12081, 32495, -21356, 27055, -10229},
              {-11233, -23965, -17129, -21597, 17495, 31862, 20389, -4177, -3801, -18294},
              {-24659, -4201, -6832, 936, -6945, 4153, 28581, -5977, 10383, -12126}};
      int[][] inputarray_self =
          {{-32198, -4044}, {632, -20233}, {-11513, 18348}, {-16349, 9070}, {1228, -1331},
              {-1902, -14888}, {-16392, 26858}, {3957, -5300}, {20585, -21141}, {31476, -7206}};
      TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
      TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
      self.sub(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_3_1_Exception")
  void testsub_3_1() {
    assertThrows(Exception.class, () -> {
      int[][] inputarray_Arg_1 =
          {{7003, 19056, 19984, -18401, -9769, -1999, -15857, -8235, -30523, -16876},
              {26811, 27055, -23140, -25938, 24910, -22453, -32330, -11417, 15601, 10852},
              {-11362, -13181, -4968, 24013, 18013, -9595, 28708, 16071, 15981, -31776},
              {25504, -14651, 672, 9966, -3675, 31296, -23772, 9896, -21172, 6785},
              {16842, -13749, 20874, -29338, 23690, -26431, 5666, 26331, -27237, -24886}};
      int[][] inputarray_self =
          {{20157, -32596, 30411, -32096, -30436, 17253, -2119, 23713, 14456, 7189},
              {-16952, 5146, -14483, -28493, -1899, -23548, -20231, 476, 18525, 8788},
              {-2289, -24676, -14201, -25973, -15710, -18832, 15703, -20260, -28844, 20724},
              {-16930, 25574, -13988, -18451, -8118, -9000, 404, -25988, 27379, -11232}};
      TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
      TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
      self.sub(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_6_1")
  void testsub_6_1() throws Exception {
    int[][] inputarray_Arg_1 = {{559}};
    int[][] inputarray_self = {{-5924}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-6483]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_8_1")
  void testsub_8_1() throws Exception {
    int[][] inputarray_Arg_1 = {{13814, 19931}};
    int[][] inputarray_self = {{10124, 27680}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-3690, 7749]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_11_1")
  void testsub_11_1() throws Exception {
    int[][] inputarray_Arg_1 = {{1710, 6281, 22058}};
    int[][] inputarray_self = {{32078, -8019, -7768}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[30368, -14300, -29826]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_14_1")
  void testsub_14_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-17637}, {-30937}};
    int[][] inputarray_self = {{-10618}, {-2104}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[7019], [28833]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_16_1")
  void testsub_16_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-29203, 565, -18856, -17481}};
    int[][] inputarray_self = {{10941, -19591, 11900, -30815}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[40144, -20156, 30756, -13334]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_25_1")
  void testsub_25_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-8511, 22977, 17145, 30988, 4465}};
    int[][] inputarray_self = {{-10398, 22373, 17341, 9520, -22137}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-1887, -604, 196, -21468, -26602]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_34_1")
  void testsub_34_1() throws Exception {
    int[][] inputarray_Arg_1 = {{7505, -2851}, {-17741, 18401}};
    int[][] inputarray_self = {{26345, -127}, {-13537, -20346}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[18840, 2724], [4204, -38747]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_41_1")
  void testsub_41_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-23597, 8805, -27704, -22910, -5287, -28943}};
    int[][] inputarray_self = {{14992, -13860, -5598, 12952, 32500, -13742}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[38589, -22665, 22106, 35862, 37787, 15201]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_46_1")
  void testsub_46_1() throws Exception {
    int[][] inputarray_Arg_1 = {{113}, {17227}, {5292}};
    int[][] inputarray_self = {{788}, {-17597}, {-10398}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[675], [-34824], [-15690]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_69_1")
  void testsub_69_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-12178, -12230, 7646, 12066, 27345, 10229, -15663}};
    int[][] inputarray_self = {{23602, -15080, -7373, 4086, -18305, -1007, -16837}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[35780, -2850, -15019, -7980, -45650, -11236, -1174]]",
        self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_getData_DCC_1_1")
  void testgetData_1_1() throws Exception {
    int[][] inputarray_self = {{-13517, 21141, -6634, 6367, 6831},
        {-28119, 5715, -14527, -29322, 24417}, {-20586, -9758, -7361, -18760, 22928}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    assertEquals(
        "[[-13517, 21141, -6634, 6367, 6831], [-28119, 5715, -14527, -29322, 24417], [-20586, -9758, -7361, -18760, 22928]]",
        self.getData().toString());
  }
}
