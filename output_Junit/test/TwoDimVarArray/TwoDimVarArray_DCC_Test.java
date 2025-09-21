package test.TwoDimVarArray;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.TwoDimVarArray;


public class TwoDimVarArray_DCC_Test {
  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_TwoDimVarArray_DCC_1")
  void testTwoDimVarArray_1() throws Exception {
    int[][] Arg_1 = {{-15360}, {5231}, {4155}, {5504}};
    assertEquals("[[-15360], [5231], [4155], [5504]]", new TwoDimVarArray(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_1_Exception")
  void testadd_1() {
    assertThrows(Exception.class, () -> {
      int[][] inputarray_Arg_1 = {{-29852, -5963, -28653, -14109, 9303, 16613, 927, 25457},
          {-7412, 23837, -7774, 29570, -25459, 15959, 10221, -13561},
          {-28408, 1450, -25713, 280, 16543, -6000, 13020, 15524},
          {20404, 12573, 364, 27727, 10683, 6956, -2464, 32342},
          {14177, 28427, 7706, -2003, 16433, -4601, -22420, -2451}};
      int[][] inputarray_self = {{32017, -16317, 5027, -3862, -9016, 22356, -26948, 31227, -19771},
          {-22575, -10798, 1711, 18096, 25025, 30488, 32456, -18410, -31239},
          {5240, 12818, -24576, 6573, -32594, 11120, -9337, -14901, -24997},
          {27150, 13855, 6625, 25179, 21238, -29697, -16167, -31891, 9335},
          {24110, 5288, 17530, 9161, 9481, -23746, 3952, 13395, -15301}};
      TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
      TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
      self.add(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_3_Exception")
  void testadd_3() {
    assertThrows(Exception.class, () -> {
      int[][] inputarray_Arg_1 = {{16100}};
      int[][] inputarray_self = {{-31990}, {-28771}, {-6506}, {8601}, {27972}, {3490}};
      TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
      TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
      self.add(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_6")
  void testadd_6() throws Exception {
    int[][] inputarray_Arg_1 = {{10476}};
    int[][] inputarray_self = {{12394}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[22870]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_8")
  void testadd_8() throws Exception {
    int[][] inputarray_Arg_1 = {{-2993, -2172}};
    int[][] inputarray_self = {{-28457, 6956}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-31450, 4784]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_11")
  void testadd_11() throws Exception {
    int[][] inputarray_Arg_1 = {{2728, -23417, 18824}};
    int[][] inputarray_self = {{24538, 2935, 17995}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[27266, -20482, 36819]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_14")
  void testadd_14() throws Exception {
    int[][] inputarray_Arg_1 = {{-18560}, {2607}};
    int[][] inputarray_self = {{12396}, {-6823}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-6164], [-4216]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_16")
  void testadd_16() throws Exception {
    int[][] inputarray_Arg_1 = {{14209, 14207, -23871, -19112}};
    int[][] inputarray_self = {{22032, -83, 1829, 25441}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[36241, 14124, -22042, 6329]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_25")
  void testadd_25() throws Exception {
    int[][] inputarray_Arg_1 = {{6122, -12883, 20561, -31320, 12863}};
    int[][] inputarray_self = {{-3700, 14912, 12883, -15645, 15716}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[2422, 2029, 33444, -46965, 28579]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_34")
  void testadd_34() throws Exception {
    int[][] inputarray_Arg_1 = {{29953, 6733}, {-20370, 28423}};
    int[][] inputarray_self = {{-16275, -25258}, {-23228, -21356}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[13678, -18525], [-43598, 7067]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_41")
  void testadd_41() throws Exception {
    int[][] inputarray_Arg_1 = {{13107, -29303, 15264, 25866, -6908, 15293}};
    int[][] inputarray_self = {{29330, 27870, 5404, 514, -8549, 23167}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[42437, -1433, 20668, 26380, -15457, 38460]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_46")
  void testadd_46() throws Exception {
    int[][] inputarray_Arg_1 = {{-7721}, {17553}, {12596}};
    int[][] inputarray_self = {{-21213}, {1270}, {1148}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-28934], [18823], [13744]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DCC_69")
  void testadd_69() throws Exception {
    int[][] inputarray_Arg_1 = {{22597, 8456, -23363, 22670, -14297, 29275, -7008}};
    int[][] inputarray_self = {{-4690, 9110, -25262, -12833, -7058, -21174, 19951}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[17907, 17566, -48625, 9837, -21355, 8101, 12943]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_1_Exception")
  void testsub_1() {
    assertThrows(Exception.class, () -> {
      int[][] inputarray_Arg_1 =
          {{-29109, -25581, -24594, -27047, -13087, -11272, -27465, -16572, 25396},
              {-3736, -19484, -26848, 15352, 10487, -25243, 31114, -15915, 6665},
              {-21778, -19155, 18027, -25539, 19099, -30951, 23753, -8092, 31524},
              {-7719, -4301, -27327, 7212, 7535, 28542, 17039, -16317, -7935}};
      int[][] inputarray_self = {{-13557, -22170, -6203}, {17042, -950, -14115},
          {22, -9524, -26613}, {14904, 7400, -23338}};
      TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
      TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
      self.sub(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_3_Exception")
  void testsub_3() {
    assertThrows(Exception.class, () -> {
      int[][] inputarray_Arg_1 = {{-7412, 19618, 22836, 11623, 2413, 1205, -7572},
          {-6402, -21594, 3858, 12320, -30182, 19377, 26385},
          {-26229, -1215, -15297, -31959, 5466, -29316, -13889}};
      int[][] inputarray_self = {{25964, 27921, -27543, -31203, -9172, 22630, -32056},
          {27927, 7750, 27898, -2321, -27639, 29272, -20450}};
      TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
      TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
      self.sub(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_6")
  void testsub_6() throws Exception {
    int[][] inputarray_Arg_1 = {{18793}};
    int[][] inputarray_self = {{28807}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[10014]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_8")
  void testsub_8() throws Exception {
    int[][] inputarray_Arg_1 = {{3090, 1005}};
    int[][] inputarray_self = {{-28775, 16270}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-31865, 15265]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_11")
  void testsub_11() throws Exception {
    int[][] inputarray_Arg_1 = {{16671, -18812, -5019}};
    int[][] inputarray_self = {{31240, 17744, 32067}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[14569, 36556, 37086]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_14")
  void testsub_14() throws Exception {
    int[][] inputarray_Arg_1 = {{19010}, {24925}};
    int[][] inputarray_self = {{-496}, {-12871}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-19506], [-37796]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_16")
  void testsub_16() throws Exception {
    int[][] inputarray_Arg_1 = {{-20940, -28114, -19084, 2391}};
    int[][] inputarray_self = {{31661, 27617, -28658, -6032}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[52601, 55731, -9574, -8423]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_25")
  void testsub_25() throws Exception {
    int[][] inputarray_Arg_1 = {{24973, 3630, -11022, 1018, -6757}};
    int[][] inputarray_self = {{-15563, 1916, 17394, 14414, 27224}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-40536, -1714, 28416, 13396, 33981]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_34")
  void testsub_34() throws Exception {
    int[][] inputarray_Arg_1 = {{-16776, -5366}, {-11770, 28634}};
    int[][] inputarray_self = {{-2086, -19250}, {-32165, 15159}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[14690, -13884], [-20395, -13475]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_41")
  void testsub_41() throws Exception {
    int[][] inputarray_Arg_1 = {{9423, -7184, 7231, 32463, 24250, -26476}};
    int[][] inputarray_self = {{20281, 28532, -25919, -28210, 26955, -29162}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[10858, 35716, -33150, -60673, 2705, -2686]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_46")
  void testsub_46() throws Exception {
    int[][] inputarray_Arg_1 = {{3894}, {-10596}, {-7742}};
    int[][] inputarray_self = {{-5906}, {5273}, {13409}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-9800], [15869], [21151]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_69")
  void testsub_69() throws Exception {
    int[][] inputarray_Arg_1 = {{24030, -2444, 6539, -17895, 23819, -27297, 27811}};
    int[][] inputarray_self = {{28390, 889, 27335, 17858, -26618, -10965, 5720}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[4360, 3333, 20796, 35753, -50437, 16332, -22091]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_getData_DCC_1")
  void testgetData_1() throws Exception {
    int[][] inputarray_self = {{32675, -19436, -6626, 3650, -10094, -31132, -1902, 22783, 18092},
        {14676, 22378, 4526, 9331, 25868, -16148, -15923, -11498, -21233},
        {11918, -20115, 15524, -6218, 26806, 22018, 14849, -20917, -3201},
        {-28589, 18552, 9541, 3845, -25463, 15059, 28203, 29000, -14120},
        {23684, -3179, -24862, 18204, -15446, -15288, 7841, 2078, -16672},
        {23365, -5776, 19825, 27245, 108, -22592, -13249, 28856, 23126},
        {-12017, 29260, -18326, 6966, 4988, 9034, 18487, 7384, -6661},
        {2620, 14726, -23957, -7431, 4305, 27574, -8534, -12382, 23930},
        {631, -13689, -25240, -31881, 18699, 25189, -19521, 16897, 21435},
        {28346, 3292, 24893, -20624, -3356, 26733, -19811, 28796, 13685}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    assertEquals(
        "[[32675, -19436, -6626, 3650, -10094, -31132, -1902, 22783, 18092], [14676, 22378, 4526, 9331, 25868, -16148, -15923, -11498, -21233], [11918, -20115, 15524, -6218, 26806, 22018, 14849, -20917, -3201], [-28589, 18552, 9541, 3845, -25463, 15059, 28203, 29000, -14120], [23684, -3179, -24862, 18204, -15446, -15288, 7841, 2078, -16672], [23365, -5776, 19825, 27245, 108, -22592, -13249, 28856, 23126], [-12017, 29260, -18326, 6966, 4988, 9034, 18487, 7384, -6661], [2620, 14726, -23957, -7431, 4305, 27574, -8534, -12382, 23930], [631, -13689, -25240, -31881, 18699, 25189, -19521, 16897, 21435], [28346, 3292, 24893, -20624, -3356, 26733, -19811, 28796, 13685]]",
        self.getData().toString());
  }
}
