package test.TwoDimVarArray;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.TwoDimVarArray;


public class TwoDimVarArray_DC_Test {
  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_TwoDimVarArray_DC_1")
  void testTwoDimVarArray_1() throws Exception {
    int[][] Arg_1 = {{3003, 10218, -26850, -23488, 17752, 24728},
        {16341, 14670, -11625, -28138, 14508, 21078}, {-14479, 31048, -22299, 3912, -10428, -21799},
        {66, -5513, -9014, 6805, -10914, -29636}, {-9525, -16929, 20129, 28196, 6156, 31676},
        {-18897, -11054, 32589, -1576, 19458, 30591}, {8087, -17637, 2156, -20063, -31418, -30376},
        {-31164, 1517, 24350, 27514, -12411, 7358}};
    assertEquals(
        "[[3003, 10218, -26850, -23488, 17752, 24728], [16341, 14670, -11625, -28138, 14508, 21078], [-14479, 31048, -22299, 3912, -10428, -21799], [66, -5513, -9014, 6805, -10914, -29636], [-9525, -16929, 20129, 28196, 6156, 31676], [-18897, -11054, 32589, -1576, 19458, 30591], [8087, -17637, 2156, -20063, -31418, -30376], [-31164, 1517, 24350, 27514, -12411, 7358]]",
        new TwoDimVarArray(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_1_Exception")
  void testadd_1() {
    assertThrows(Exception.class, () -> {
      int[][] inputarray_Arg_1 = {{-1261, -21656, -9510}, {-19561, -26296, 8928},
          {-19423, 17067, 1965}, {-14835, 14627, 19000}, {-27194, 22768, 10841},
          {29467, 10540, -23638}, {22970, 29341, -10584}, {-13578, -21422, 10671},
          {-31114, -327, 22225}, {25855, 18379, 27955}};
      int[][] inputarray_self = {{-13385, 16881, 11083}, {-16954, 3124, 6937},
          {-4364, -14009, 14695}, {21540, -19595, 14417}, {-365, -17004, -8310},
          {-16986, -2118, 14680}, {-18009, -26855, 25131}, {-824, -31464, -1445}};
      TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
      TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
      self.add(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_4")
  void testadd_4() throws Exception {
    int[][] inputarray_Arg_1 = {{3669}};
    int[][] inputarray_self = {{18391}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[22060]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_6")
  void testadd_6() throws Exception {
    int[][] inputarray_Arg_1 = {{16660, 30947}};
    int[][] inputarray_self = {{21113, 23903}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[37773, 54850]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_9")
  void testadd_9() throws Exception {
    int[][] inputarray_Arg_1 = {{13706, 20082, -7888}};
    int[][] inputarray_self = {{-16398, -23224, 23356}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-2692, -3142, 15468]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_12")
  void testadd_12() throws Exception {
    int[][] inputarray_Arg_1 = {{-1211}, {19125}};
    int[][] inputarray_self = {{28546}, {19749}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[27335], [38874]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_14")
  void testadd_14() throws Exception {
    int[][] inputarray_Arg_1 = {{-9247, 23058, 7689, 26577}};
    int[][] inputarray_self = {{-31252, -20850, -13863, -19968}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-40499, 2208, -6174, 6609]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_23")
  void testadd_23() throws Exception {
    int[][] inputarray_Arg_1 = {{24407, 20489, 22090, 222, -26253}};
    int[][] inputarray_self = {{-11108, -11786, 17569, -4272, -20437}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[13299, 8703, 39659, -4050, -46690]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_32")
  void testadd_32() throws Exception {
    int[][] inputarray_Arg_1 = {{3522, -26735}, {-27196, 17051}};
    int[][] inputarray_self = {{23941, -24222}, {-25816, -28262}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[27463, -50957], [-53012, -11211]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_39")
  void testadd_39() throws Exception {
    int[][] inputarray_Arg_1 = {{1625, 8318, 26849, -8207, 16776, -31368}};
    int[][] inputarray_self = {{16117, -27389, -28130, 18645, -18392, -11353}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[17742, -19071, -1281, 10438, -1616, -42721]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_44")
  void testadd_44() throws Exception {
    int[][] inputarray_Arg_1 = {{-6162}, {-29430}, {17591}};
    int[][] inputarray_self = {{-24370}, {16528}, {-29457}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-30532], [-12902], [-11866]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_67")
  void testadd_67() throws Exception {
    int[][] inputarray_Arg_1 = {{3905, -31378, -18488, -20269, 26727, -30794, -16839}};
    int[][] inputarray_self = {{-6981, 29536, -31258, 19385, -22166, -28476, 27868}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-3076, -1842, -49746, -884, 4561, -59270, 11029]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_1_Exception")
  void testsub_1() {
    assertThrows(Exception.class, () -> {
      int[][] inputarray_Arg_1 =
          {{12957, -19526, 25801, -28259, 7134, -4010}, {3344, 32507, 31772, -27400, 1613, -19604},
              {15127, 28737, -16760, -25240, -12069, -7423}};
      int[][] inputarray_self = {{-16196, 28116, 29495, -11793, 1832, -5559},
          {-28525, 18132, -27819, 18900, 19289, -20321}, {7246, -19057, -25340, 12308, 15226, 1540},
          {-18156, -25996, -30894, 32571, -4786, -5282},
          {-10032, 24798, 14087, -28324, -8617, 6492}};
      TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
      TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
      self.sub(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_4")
  void testsub_4() throws Exception {
    int[][] inputarray_Arg_1 = {{-8844}};
    int[][] inputarray_self = {{22439}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[31283]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_6")
  void testsub_6() throws Exception {
    int[][] inputarray_Arg_1 = {{-4944, -1808}};
    int[][] inputarray_self = {{6872, 19747}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[11816, 21555]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_9")
  void testsub_9() throws Exception {
    int[][] inputarray_Arg_1 = {{-8462, 22446, 4555}};
    int[][] inputarray_self = {{5601, -4309, 16074}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[14063, -26755, 11519]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_12")
  void testsub_12() throws Exception {
    int[][] inputarray_Arg_1 = {{12762}, {14047}};
    int[][] inputarray_self = {{7594}, {-16795}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-5168], [-30842]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_14")
  void testsub_14() throws Exception {
    int[][] inputarray_Arg_1 = {{15622, 15043, -25786, -10245}};
    int[][] inputarray_self = {{-5892, 28983, 8053, 11666}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-21514, 13940, 33839, 21911]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_23")
  void testsub_23() throws Exception {
    int[][] inputarray_Arg_1 = {{-29079, 3752, 18354, 24025, 26356}};
    int[][] inputarray_self = {{-18042, 12320, 25650, 12250, 19202}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[11037, 8568, 7296, -11775, -7154]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_32")
  void testsub_32() throws Exception {
    int[][] inputarray_Arg_1 = {{-10218, 23140}, {11159, 32635}};
    int[][] inputarray_self = {{12132, 27029}, {30836, -23844}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[22350, 3889], [19677, -56479]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_39")
  void testsub_39() throws Exception {
    int[][] inputarray_Arg_1 = {{29670, -620, -6000, 21224, -14249, 15991}};
    int[][] inputarray_self = {{-10395, -3252, -6819, -30093, 5998, -31424}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-40065, -2632, -819, -51317, 20247, -47415]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_44")
  void testsub_44() throws Exception {
    int[][] inputarray_Arg_1 = {{-6039}, {16074}, {-29180}};
    int[][] inputarray_self = {{-25241}, {5691}, {7494}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-19202], [-10383], [36674]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_67")
  void testsub_67() throws Exception {
    int[][] inputarray_Arg_1 = {{-29808, -5956, -18800, 12108, 30346, 16633, -17289}};
    int[][] inputarray_self = {{-26972, 4160, -31070, 15167, 28548, -12157, 7268}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[2836, 10116, -12270, 3059, -1798, -28790, 24557]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_getData_DC_1")
  void testgetData_1() throws Exception {
    int[][] inputarray_self =
        {{-24399, 20196, -18631, -26054, -11311}, {-8942, -606, 21365, 13607, -9373},
            {-17587, 27579, -25989, -2886, -10686}, {20813, 8984, -22608, -29959, -21455}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    assertEquals(
        "[[-24399, 20196, -18631, -26054, -11311], [-8942, -606, 21365, 13607, -9373], [-17587, 27579, -25989, -2886, -10686], [20813, 8984, -22608, -29959, -21455]]",
        self.getData().toString());
  }
}
