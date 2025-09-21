package test.TwoDimVarArray;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.TwoDimVarArray;


public class TwoDimVarArrayBVA_DC_Test {
  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_TwoDimVarArray_DC_1_1")
  void testTwoDimVarArray_1_1() throws Exception {
    int[][] Arg_1 = {{-19876, 19121, 8383, -21203, -13822, 21316, -9982, -17841},
        {24833, 18665, -3459, -12052, 12018, 20774, 21650, -12475},
        {-32545, -7155, 29463, 18720, 3520, -17210, -28990, -22498},
        {25193, -26182, -31989, -4279, -27930, 12738, 23488, -19790},
        {-3514, 3585, -20956, -6035, 455, -12353, -11146, -13685},
        {-24218, 19454, -29612, 11146, -19451, -22397, 29733, 28959},
        {1021, -31240, 15401, -16987, 11745, -30096, 5234, -30051},
        {26301, 15683, -18815, 2472, 1389, 31674, -13909, -6291},
        {-17840, -2180, -2072, -5295, 22453, 12645, -6933, 30352},
        {8323, -15563, 31781, 13978, 2796, -3772, -18681, -11415}};
    assertEquals(
        "[[-19876, 19121, 8383, -21203, -13822, 21316, -9982, -17841], [24833, 18665, -3459, -12052, 12018, 20774, 21650, -12475], [-32545, -7155, 29463, 18720, 3520, -17210, -28990, -22498], [25193, -26182, -31989, -4279, -27930, 12738, 23488, -19790], [-3514, 3585, -20956, -6035, 455, -12353, -11146, -13685], [-24218, 19454, -29612, 11146, -19451, -22397, 29733, 28959], [1021, -31240, 15401, -16987, 11745, -30096, 5234, -30051], [26301, 15683, -18815, 2472, 1389, 31674, -13909, -6291], [-17840, -2180, -2072, -5295, 22453, 12645, -6933, 30352], [8323, -15563, 31781, 13978, 2796, -3772, -18681, -11415]]",
        new TwoDimVarArray(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_1_1_Exception")
  void testadd_1_1() {
    assertThrows(Exception.class, () -> {
      int[][] inputarray_Arg_1 = {{-2485, 20637, -25593, -8912, 29186, 27947, 497}};
      int[][] inputarray_self = {{31691, 28918, 8885, -29587, -12364, 19905, -13581},
          {11031, -22486, 26150, 12056, 10711, -32474, 30438},
          {-15740, 19194, -14546, 23644, -14727, 6349, -12744},
          {-28315, 2704, 8103, 1099, -23344, -386, -2990},
          {-4961, 13861, -4310, -12693, 23410, 8442, -20678},
          {2560, -19711, -4096, 24620, 5523, 28350, -32382},
          {-5255, -22716, -12716, -21988, -17288, 213, 28259},
          {-22273, 12538, 27806, 20249, 14133, 5541, 21513}};
      TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
      TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
      self.add(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_4_1")
  void testadd_4_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-21666}};
    int[][] inputarray_self = {{12198}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-9468]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_6_1")
  void testadd_6_1() throws Exception {
    int[][] inputarray_Arg_1 = {{19827, -14457}};
    int[][] inputarray_self = {{10560, 20017}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[30387, 5560]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_9_1")
  void testadd_9_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-1712, 31277, -17882}};
    int[][] inputarray_self = {{6909, -1728, 28096}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[5197, 29549, 10214]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_12_1")
  void testadd_12_1() throws Exception {
    int[][] inputarray_Arg_1 = {{15600}, {-11383}};
    int[][] inputarray_self = {{28863}, {-27048}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[44463], [-38431]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_14_1")
  void testadd_14_1() throws Exception {
    int[][] inputarray_Arg_1 = {{29216, -14938, -2901, -13512}};
    int[][] inputarray_self = {{-11069, -18934, -23263, -23519}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[18147, -33872, -26164, -37031]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_23_1")
  void testadd_23_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-26622, -30734, 11863, 19044, -30679}};
    int[][] inputarray_self = {{-21351, 29114, 27110, 27418, 7659}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-47973, -1620, 38973, 46462, -23020]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_32_1")
  void testadd_32_1() throws Exception {
    int[][] inputarray_Arg_1 = {{28352, -4955}, {4101, 13910}};
    int[][] inputarray_self = {{-23142, 19117}, {16407, 5074}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[5210, 14162], [20508, 18984]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_39_1")
  void testadd_39_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-1650, -8988, 18074, -2288, 1047, -24908}};
    int[][] inputarray_self = {{-31570, 15019, -10640, 23101, -9837, 32746}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-33220, 6031, 7434, 20813, -8790, 7838]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_44_1")
  void testadd_44_1() throws Exception {
    int[][] inputarray_Arg_1 = {{4881}, {19102}, {294}};
    int[][] inputarray_self = {{25208}, {-27253}, {-4069}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[30089], [-8151], [-3775]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_add_DC_67_1")
  void testadd_67_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-24584, -5606, -5716, 22158, 34, 15418, -16245}};
    int[][] inputarray_self = {{-11235, -7668, -25859, 31780, 10323, 10064, 781}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-35819, -13274, -31575, 53938, 10357, 25482, -15464]]",
        self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_1_1_Exception")
  void testsub_1_1() {
    assertThrows(Exception.class, () -> {
      int[][] inputarray_Arg_1 = {{-17290, 915, 3896, -2977, -26654, 22588, -15455, -9489, 22426},
          {8691, 7217, 22104, 6608, -30403, -13335, -25304, 29273, -22963}};
      int[][] inputarray_self = {{12718, -6085, -22530, -29780, 2082, 14142, -10742, -4602, 2273},
          {23128, -20447, -22744, 8442, 27521, 19147, 24931, -28549, -32440},
          {-24553, -20833, 22621, -14605, 16734, -5356, 28536, 31126, 13980},
          {9110, 20651, 5697, 17973, -31255, 10913, 31939, 8918, -14826},
          {11330, 29653, -27469, -4009, -14847, 23193, 23343, 5030, 10022},
          {9205, 2545, 1971, 18711, 23695, -13657, 16950, 16757, -23274},
          {-1840, 25857, 31416, -7384, -4995, 7004, -9950, -3958, 4006},
          {1795, 21954, -20644, 16045, 22693, 18978, 2024, 1207, 12868}};
      TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
      TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
      self.sub(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_4_1")
  void testsub_4_1() throws Exception {
    int[][] inputarray_Arg_1 = {{32128}};
    int[][] inputarray_self = {{-13769}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-45897]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_6_1")
  void testsub_6_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-19589, -9450}};
    int[][] inputarray_self = {{22115, 12338}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[41704, 21788]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_9_1")
  void testsub_9_1() throws Exception {
    int[][] inputarray_Arg_1 = {{20843, -21986, 22651}};
    int[][] inputarray_self = {{-3929, -13052, -10431}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-24772, 8934, -33082]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_12_1")
  void testsub_12_1() throws Exception {
    int[][] inputarray_Arg_1 = {{2963}, {-329}};
    int[][] inputarray_self = {{-10722}, {-11114}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-13685], [-10785]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_14_1")
  void testsub_14_1() throws Exception {
    int[][] inputarray_Arg_1 = {{8529, -26119, 30448, -20276}};
    int[][] inputarray_self = {{-7482, 17460, 26785, 6926}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-16011, 43579, -3663, 27202]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_23_1")
  void testsub_23_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-16194, 20877, -31182, -16512, -22765}};
    int[][] inputarray_self = {{11577, 21121, 17896, 7766, -25829}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[27771, 244, 49078, 24278, -3064]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_32_1")
  void testsub_32_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-19908, -4835}, {-5412, -9210}};
    int[][] inputarray_self = {{1585, 30305}, {-23528, -25000}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[21493, 35140], [-18116, -15790]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_39_1")
  void testsub_39_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-19352, -18715, -7694, -1072, -20714, 27591}};
    int[][] inputarray_self = {{2887, -30913, 25120, -11964, 2012, 9867}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[22239, -12198, 32814, -10892, 22726, -17724]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_44_1")
  void testsub_44_1() throws Exception {
    int[][] inputarray_Arg_1 = {{29309}, {28906}, {-5159}};
    int[][] inputarray_self = {{22959}, {-11116}, {7769}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[-6350], [-40022], [12928]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_sub_DC_67_1")
  void testsub_67_1() throws Exception {
    int[][] inputarray_Arg_1 = {{-15422, -30457, 16404, 3275, -15677, -18123, 26229}};
    int[][] inputarray_self = {{31967, -22920, -30601, -12417, -6977, -15150, -10281}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    TwoDimVarArray Arg_1 = new TwoDimVarArray(inputarray_Arg_1);
    assertEquals("[[47389, 7537, -47005, -15692, 8700, 2973, -36510]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_TwoDimVarArray_getData_DC_1_1")
  void testgetData_1_1() throws Exception {
    int[][] inputarray_self = {{-7574, -12685, 5473, 20664, 30369, -13427, 22952, -14008, 32560},
        {-31642, 19926, -13767, 25771, 7104, -982, 25463, 15122, -13140}};
    TwoDimVarArray self = new TwoDimVarArray(inputarray_self);
    assertEquals(
        "[[-7574, -12685, 5473, 20664, 30369, -13427, 22952, -14008, 32560], [-31642, 19926, -13767, 25771, 7104, -982, 25463, 15122, -13140]]",
        self.getData().toString());
  }
}
