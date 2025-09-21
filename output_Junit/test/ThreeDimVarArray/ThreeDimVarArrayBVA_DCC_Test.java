package test.ThreeDimVarArray;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.ThreeDimVarArray;


public class ThreeDimVarArrayBVA_DCC_Test {
  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_ThreeDimVarArray_DCC_1_1")
  void testThreeDimVarArray_1_1() throws Exception {
    int[][][] Arg_1 = {
        {{-25323, -7929, 9722, -5641}, {-20232, 11033, -19556, 29632},
            {16318, -27475, 11904, -21235}, {19085, -30885, -8658, -26936},
            {-20514, 22255, 6228, -13284}},
        {{-22894, -789, 21668, 12342}, {8970, 9876, 22858, -14692}, {-7315, 14951, -2213, 19866},
            {3111, -18572, 7478, 25613}, {11095, -31434, -27781, 12022}},
        {{20225, 30741, 2005, -11044}, {3350, -23549, 29363, -14018}, {29149, 7658, -16484, -13058},
            {-18682, 23390, -26886, 27583}, {10070, 9899, -21618, 12183}}};
    assertEquals(
        "[[[-25323, -7929, 9722, -5641], [-20232, 11033, -19556, 29632], [16318, -27475, 11904, -21235], [19085, -30885, -8658, -26936], [-20514, 22255, 6228, -13284]], [[-22894, -789, 21668, 12342], [8970, 9876, 22858, -14692], [-7315, 14951, -2213, 19866], [3111, -18572, 7478, 25613], [11095, -31434, -27781, 12022]], [[20225, 30741, 2005, -11044], [3350, -23549, 29363, -14018], [29149, 7658, -16484, -13058], [-18682, 23390, -26886, 27583], [10070, 9899, -21618, 12183]]]",
        new ThreeDimVarArray(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DCC_1_1_Exception")
  void testadd_1_1() {
    assertThrows(Exception.class, () -> {
      int[][][] inputarray_Arg_1 = {
          {{-18598, 11975, 18119, 24687, -14486, -2829, 31072},
              {-9502, 29253, -4128, 2035, 2555, 31120, 24432},
              {-16394, 854, 3864, 17490, -19809, -3793, -2086},
              {-14591, 30595, 20290, -5866, -28705, -12507, 20018},
              {-20823, 20814, -5495, -13455, -11613, 1827, 17291}},
          {{-12539, -2745, 22810, -26463, -6678, -32632, 15072},
              {-2046, -19188, -2716, -4458, 3260, -6144, -18099},
              {28169, 13718, 26078, 23535, -30768, -14382, 6060},
              {17271, 6708, -2093, -13244, -28278, 4742, -11094},
              {13577, -26688, -15006, 31200, -15310, -27734, -23890}}};
      int[][][] inputarray_self = {{{-16721}, {-16429}, {22893}, {3003}, {-28957}},
          {{16120}, {-10061}, {-22632}, {-3630}, {-16528}}};
      ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
      ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
      self.add(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DCC_2_1_Exception")
  void testadd_2_1() {
    assertThrows(Exception.class, () -> {
      int[][][] inputarray_Arg_1 = {{{-8292}, {-24374}, {-24789}, {-18796}, {14332}},
          {{-24062}, {14441}, {5026}, {-21687}, {-1980}},
          {{-1665}, {6052}, {13926}, {29627}, {29364}}};
      int[][][] inputarray_self = {{{-17893}}, {{7591}}, {{-18795}}};
      ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
      ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
      self.add(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DCC_4_1_Exception")
  void testadd_4_1() {
    assertThrows(Exception.class, () -> {
      int[][][] inputarray_Arg_1 =
          {{{-21977, 20134, -29074, -628, 11337, 29106, -22819, -18970, -122, 20230},
              {-27910, 15928, 31305, 29472, 6910, -12207, -31686, -30966, 29408, 4686},
              {-16347, -9250, 26372, -32237, -6676, 6702, -25886, -22321, -24746, -15924},
              {-15916, -22040, -17997, -16329, 22134, 1671, -228, -19083, -15008, -7406}}};
      int[][][] inputarray_self = {
          {{-15170, -10689, 17806, -17127, 22607, -15778, 16286, -7000, -13351, -7762},
              {-10166, 16949, 8565, -9449, -8167, 9289, 17330, 6812, -6635, 12127},
              {-22446, -7542, 18665, 4710, 21039, -20737, 19760, -23284, -23631, 2906},
              {-10005, 17318, 4076, -26471, 6524, 1396, -19412, -27913, 3054, 29287}},
          {{-21068, 27386, 3563, -13713, 9822, -22212, -4415, -20457, -25625, 22293},
              {23023, 18550, 10891, 6632, -32700, -3884, 16464, 23672, 883, -16861},
              {28479, -5626, -19584, -11323, -24913, -20961, -22058, 22165, -1631, -15297},
              {6371, -24962, 11234, -24944, 2047, 24408, 15966, 13831, -11430, 23284}},
          {{24500, 8744, -31016, -20939, 27058, 28123, 32480, -13185, -10275, 14661},
              {-21148, 24293, -22686, 2442, 3445, -19701, -24262, -16040, -2221, 12174},
              {30568, -25882, 6885, 16157, 6416, -9843, -26657, 17728, 25882, 2855},
              {-5794, 1325, 31879, -3729, -8073, -8541, 12128, -26644, 30542, 26515}},
          {{-1165, 3968, -898, -8855, -5375, -31042, 27250, 28664, -14412, -3788},
              {21784, 27129, -19099, -903, -6259, 3327, 13816, 27846, 21118, 22229},
              {23052, 15367, -1529, 16367, -28529, -12909, 63, -22140, 16647, -20475},
              {13893, 26558, -716, -18309, -13624, -21668, 19989, 10178, 22038, -17334}},
          {{-5511, 27703, 30227, -31336, -2532, -28587, -21115, 21235, 25328, 13081},
              {-5693, 32178, 11628, -12647, 27922, 10197, -1953, -5739, -30500, -28312},
              {5793, 18605, 170, 23438, -24658, -28117, 20810, 1930, -27037, -18624},
              {-16958, -31407, 5860, -19473, -31535, 8835, 3606, 27480, -18754, -19494}},
          {{-5287, 24930, -15787, 14255, 11027, -19130, 21767, 9246, 16151, 17548},
              {-11663, 9264, 10778, 11130, -4173, 23696, -14173, 27583, -15927, -27301},
              {-26168, -5132, 31608, 11900, 4988, 17003, 20161, 28198, -31761, -20950},
              {29253, -22698, 7340, 25431, -11593, 21183, -31419, 14928, -15387, 4702}},
          {{-1325, 6747, -20137, 12441, 4562, -27435, 17174, -18676, -14854, -20950},
              {-27562, 2999, 7826, -17904, 7921, 18787, 11630, 28668, 11122, -21924},
              {6722, -25472, 32278, -11506, 14996, -5263, -4276, -25195, -3486, 1284},
              {27863, 17476, 9551, 31409, 13358, -28660, 18220, -18187, -20346, 19678}}};
      ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
      ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
      self.add(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DCC_9_1")
  void testadd_9_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{8450}}};
    int[][][] inputarray_self = {{{4128}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[12578]]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DCC_14_1")
  void testadd_14_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{-24354, 22683}}};
    int[][][] inputarray_self = {{{1816, 13137}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[-22538, 35820]]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DCC_19_1")
  void testadd_19_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{-1130, -13444, 5659}}};
    int[][][] inputarray_self = {{{28535, -9559, -13951}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[27405, -23003, -8292]]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DCC_30_1")
  void testadd_30_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{-15291}, {-13918}}};
    int[][][] inputarray_self = {{{24057}, {-19472}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[8766], [-33390]]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DCC_33_1")
  void testadd_33_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{-7195, -3402, 16864, 26733}}};
    int[][][] inputarray_self = {{{-29834, 2480, -1602, 26805}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[-37029, -922, 15262, 53538]]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DCC_68_1")
  void testadd_68_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{0, 28903, -7919, 22203, -9237}}};
    int[][][] inputarray_self = {{{-27560, -6007, 10699, -25707, -19260}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[-27560, 22896, 2780, -3504, -28497]]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DCC_76_1")
  void testadd_76_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{6188}}, {{10585}}};
    int[][][] inputarray_self = {{{-13366}}, {{21644}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[-7178]], [[32229]]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DCC_90_1")
  void testadd_90_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{19673, -20575}, {31372, -29892}}};
    int[][][] inputarray_self = {{{18452, -23984}, {2780, -8610}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[38125, -44559], [34152, -38502]]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DCC_126_1")
  void testadd_126_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{12565, -8168, 24481, 18382, -7952, 5463}}};
    int[][][] inputarray_self = {{{2779, 14906, -10839, -19377, 10396, -27824}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[15344, 6738, 13642, -995, 2444, -22361]]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DCC_137_1")
  void testadd_137_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{18646}, {23160}, {22089}}};
    int[][][] inputarray_self = {{{15763}, {-12117}, {-31939}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[34409], [11043], [-9850]]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DCC_1_1_Exception")
  void testsub_1_1() {
    assertThrows(Exception.class, () -> {
      int[][][] inputarray_Arg_1 = {
          {{3928, -12406, -23790}, {-20823, 26443, -11460}, {-28640, -21660, -27091},
              {4486, -30717, -16504}, {-5733, -29014, 3940}, {-16253, -4611, 21166}},
          {{28108, 13908, -29483}, {17551, -15645, 9558}, {-22428, 9800, 24812},
              {30622, 19203, -13202}, {30185, -24042, 10187}, {28966, 12104, -4886}},
          {{-20610, 15500, 9455}, {23558, -1291, 9335}, {23249, 22066, 31209},
              {-29675, -7171, -21683}, {-13144, 24215, -2200}, {-26888, -31223, -17388}},
          {{11819, -29789, -1245}, {-22131, -28992, -15568}, {-30811, 27114, -23177},
              {24366, 2449, 9942}, {25920, 4565, -21950}, {-20640, -32755, 16195}}};
      int[][][] inputarray_self = {
          {{-16409, 4381, 30610, 12010, 12301, -20833, -1231},
              {-3908, -17694, -10316, -21108, 8285, 31733, -27370},
              {-15016, 16958, 13598, -8068, -31446, -13439, -22154},
              {-19407, 18508, 23588, 12733, 9212, -8010, 20589},
              {28988, -1198, -8610, -23407, -5197, 32625, 17445},
              {27492, -21190, 29903, -22556, -28219, 29344, -4755}},
          {{7433, 11456, 17934, -29328, 28480, -27040, -32240},
              {-3990, 17644, -5151, 4049, 24846, -18066, 4531},
              {2532, -21997, 26880, -1248, 23729, -4457, -29734},
              {17894, -26025, 8056, 22988, -23267, 11474, -30421},
              {24756, 18516, 24495, 7594, 27657, 8211, 3571},
              {-12934, -21390, -24587, -25561, 14158, 30560, 15019}},
          {{31509, 24729, -14685, 18287, -18999, 22809, -31483},
              {12053, 7713, -25149, -15566, 21358, -21202, -5097},
              {-6812, -23995, -16787, -405, -17309, 25788, -11996},
              {-29748, -31249, -31263, -24490, 18646, -2924, -21792},
              {14886, 2971, -3634, -25076, -32629, -25596, 16303},
              {5895, 16614, -11880, 2617, -19526, -19806, -7355}},
          {{13559, -22533, -29113, -24953, 5096, -10526, -24955},
              {-4108, -24048, 25785, 9671, 28348, 19214, 21899},
              {5176, 31848, 31877, -14200, -29979, 31500, -25584},
              {-3208, 15242, -18877, 22375, 10095, -18491, -28957},
              {2572, -12908, 967, -13389, 30095, 9135, -3273},
              {-13544, 28095, -19992, 25296, -28315, 5801, -9053}}};
      ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
      ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
      self.sub(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DCC_2_1_Exception")
  void testsub_2_1() {
    assertThrows(Exception.class, () -> {
      int[][][] inputarray_Arg_1 = {
          {{-32665, -30822, -30706, -28016, -9323, 25275, 1938, 29642},
              {2774, 16882, 11058, 14376, -13148, -3214, -7115, 31463},
              {-18736, 10466, 26285, -2477, 17911, -10418, 13758, -1347},
              {12321, -26678, -32017, -317, -16679, 10574, -2810, -7582}},
          {{-29980, 11530, -909, 2649, -29648, -20238, -766, -6731},
              {-18418, 28357, -26050, 6049, -16924, -9481, -1809, -12754},
              {6989, 29827, -16961, 30216, 25955, -28774, 25839, 27390},
              {26336, 10131, 26818, 5557, 25321, -3986, 7156, 22687}},
          {{-2838, 388, 5735, 27746, -22338, 2239, 18981, 4040},
              {18024, 26050, 23396, -1845, -27402, 29190, -22208, -26071},
              {25992, 3176, -15056, -21342, 26831, 15728, -14981, 1702},
              {-19005, 13959, -3260, 23504, 20130, 31806, 28316, 24463}},
          {{3499, -19397, 22641, 27929, 27043, 1263, -9545, 894},
              {11518, -1739, -15090, -25403, -13108, 22405, -23256, 4745},
              {-27434, -13236, 20564, 1719, 9911, 31663, 13000, -18485},
              {15521, 7758, 22353, 29100, -4241, 28624, -14266, 26609}},
          {{26027, -11278, -25201, -16540, -15228, 22253, -13268, 30752},
              {-14796, -32098, 1550, -17981, 12279, -5734, -25153, 431},
              {-5081, -10466, -5138, -20499, -18390, 8712, 11494, 8223},
              {3236, -12278, -4003, 16484, -25988, 27759, -15271, 16766}},
          {{21396, 2458, -22336, -18697, -22567, -27012, -19625, -23751},
              {21175, -24617, 18417, 23722, -24507, -29384, 25507, -8564},
              {13863, -7180, 5683, -6748, 17862, -31454, 28964, -15021},
              {14046, 26473, 6813, -13454, 32338, -1900, -24982, 2040}},
          {{-5474, -16882, -6559, 31350, 20154, -4982, -24478, -3885},
              {-14321, 23140, -3491, -9814, 6311, -14594, -17275, 16249},
              {26661, -15928, 19276, 20282, -30215, 29010, 11693, -9819},
              {18096, 22447, -22386, 8400, 26172, -26159, 8052, -793}}};
      int[][][] inputarray_self = {
          {{28169, -14370, 512, 22525, 11848, 11957, 12856, 30406},
              {-8285, 20034, -24383, -2466, -16730, -20200, 13177, -15714},
              {1037, 25329, -12407, -25867, -8983, -31352, -22889, 21770},
              {18897, 14827, 18314, -22012, 895, -9897, -14395, -7758},
              {17154, 2701, -17025, -20575, -11689, -7605, -17074, 23530},
              {17365, -31929, -12191, -15865, 1351, 19584, -6838, 7125},
              {27588, 29285, 5578, -23748, 24306, 16420, -19263, -4422},
              {21392, -21677, -18564, 15040, 32048, 23711, 4432, -30128},
              {-28695, -22198, 27996, -12598, 20714, -26449, 29187, 1513},
              {7138, 3506, -22454, -31384, 32311, 21739, -27686, -10425}},
          {{-22207, 19281, 19046, -7135, -12671, 8293, 25456, -13062},
              {16755, 7739, 14933, 7876, -21300, 30424, 28555, -7276},
              {-31036, 19741, -18260, -27218, 26837, 20661, 15694, -9525},
              {-17947, -29510, -6843, -620, -24514, -23853, -1112, 31029},
              {20171, -30815, -26918, -6950, 26881, -24750, -21104, -4769},
              {-14256, -5174, 13817, 29039, 8004, 26837, -28877, -20194},
              {-29887, -24601, -29580, -4817, -24380, -194, -13305, -30916},
              {-2474, 9333, -29866, 31662, 8649, -25658, -8748, 19410},
              {-27088, 11919, 29638, 8049, -786, -20428, 4709, -12522},
              {31085, 18773, -2844, -21455, -30673, -21751, -10672, -30544}},
          {{-6854, 1459, 14284, 22735, 1743, -3092, -25461, 13433},
              {26327, 32679, 29536, -28519, 24322, -27770, 4644, -9510},
              {-20128, -9092, -25200, 28396, -26380, -38, -32248, -658},
              {4655, 21808, -8420, 27217, 19084, 31304, -16346, 22359},
              {-3692, -17632, 13193, -30949, -14520, 32484, -20421, -4285},
              {19911, 5911, 792, -22715, 13724, -11345, -12270, -23432},
              {19670, 13905, -1481, -7940, -3353, -14606, 18869, 13546},
              {-11755, 27341, 24108, 5303, 17735, 13363, 3656, 32157},
              {7868, -8833, -29343, -10841, -27508, -9443, 8805, 32439},
              {22717, 24081, 24214, 18034, -21506, -17809, -6246, -25782}},
          {{13474, 29128, 7101, -21810, 17533, -15935, 19835, -5322},
              {-27652, 22994, -2144, 9814, 15050, 13227, 29650, 634},
              {21763, -9635, -25248, -12628, 2151, -25341, 10155, -571},
              {-8435, 12110, 2544, 18585, 23454, 28936, 24976, 29477},
              {-22389, 19513, 7429, 18402, 28236, 387, 24527, 16956},
              {9151, 20757, 5718, 1016, -27712, 12669, 5339, -27640},
              {9280, -18836, -4542, 15906, 14524, -6721, 19655, -23164},
              {-991, -20000, 27376, 469, -16462, -5872, 23974, -3175},
              {-13036, -20377, 22751, -24278, 7067, -25107, -19339, 23552},
              {2034, 24005, -19087, -20095, 32713, 179, 13969, -27172}},
          {{-32722, -3322, -8452, -7782, -21138, -5142, 607, 13664},
              {-13920, 18525, -13959, -1374, 9037, 27105, 26194, -15695},
              {-1905, -26733, 10273, -1041, -25617, -15677, 11896, 17555},
              {-6522, -31287, -15822, -6183, 11014, -1853, 17806, 29886},
              {9630, 23042, 8409, -11915, -23783, -27817, 18835, 31228},
              {13443, -7722, -30643, 12161, -14854, 20784, -24568, 25583},
              {30435, 32675, 7440, 20139, 10350, 26190, 32475, -16213},
              {21110, -3675, -31815, -26170, -1481, 17636, 23503, 31874},
              {28863, 28857, 19391, 11992, -504, 31999, -16262, 8592},
              {-5335, -4719, -12122, 31211, -10646, 17259, -5452, -23828}},
          {{-10845, 19495, 19128, -26666, 8259, 16786, 8174, -18007},
              {9184, -30087, 29640, -6510, 30115, 30796, 18520, 21579},
              {-25727, 17650, -23983, -19008, 10636, 17686, -15876, -11329},
              {-3230, -22623, 6481, -3138, 16301, 14253, -12843, -5328},
              {2610, 30766, 5176, -25157, -5943, 14173, -8948, -5760},
              {6755, 11537, 6498, 13210, 1444, -18011, -4199, 16405},
              {15711, -25904, 22423, 25076, -404, -24147, -26446, 20504},
              {-20380, -20573, -6448, 23135, 21414, -18714, -21979, 22779},
              {22441, 30733, -25544, 6427, 20173, -26004, 14998, -7454},
              {27204, 24834, 8083, 5422, 18025, -16904, -6262, -19183}},
          {{-1130, 13521, -25865, 11899, -8834, 26213, -12049, 28944},
              {12256, -11718, 28063, 9237, 17265, 702, -26452, 12093},
              {30105, 4186, -13681, -21439, -31203, 14722, -23067, 31157},
              {23498, -3508, 18037, -24381, -21159, -25220, 5111, -29455},
              {12901, -7900, 22754, -21195, -4722, 12931, -9679, 7681},
              {-7283, -19685, -4282, 19331, 28482, 1872, 23825, -22190},
              {-4833, 26295, 1409, 3544, 2107, 19526, 22248, 1285},
              {-12425, -23737, -17823, -12783, -222, -22566, 29404, 12337},
              {-23704, 23604, 27780, -11127, 25631, 10046, 4526, -20607},
              {18367, 30449, -30078, 3986, -25508, 21508, -2058, 12772}}};
      ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
      ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
      self.sub(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DCC_4_1_Exception")
  void testsub_4_1() {
    assertThrows(Exception.class, () -> {
      int[][][] inputarray_Arg_1 = {
          {{26584, 11264, -5051, -18769, 5432, -32191, -29837},
              {-13469, 31591, -25235, 26865, 4270, -23002, 18071},
              {-26012, -18272, -7417, 1197, 21186, 23868, 28038}},
          {{5194, 9148, 9946, 12249, -17084, 2425, -30154},
              {7280, -20857, -2379, -6208, -30872, 29444, 17411},
              {29128, -7359, -741, 25583, -19624, -9864, -4981}},
          {{-27828, -32733, 18374, -11041, 14990, 27151, 18726},
              {19884, 3753, -7696, -27763, 3761, -30249, 23343},
              {-13200, -8103, 26343, 22891, -27639, -8219, -30427}},
          {{28692, -13445, 18946, 32193, 9605, 19797, 6031},
              {-7054, 31519, -15576, -21175, 4548, 16090, 25309},
              {-2884, 26286, 25270, -9209, 20799, -19115, 27859}}};
      int[][][] inputarray_self = {
          {{-9402, -31559, 26703, -19411, 5178, 8552, -24219},
              {-3759, -25768, 3651, -20139, -25409, 21120, 29677},
              {13068, -23071, -2242, -23132, -29181, -15384, -4683}},
          {{5586, -10819, 15878, 11180, 25770, 10442, -16715},
              {5166, -24943, -14821, -26905, 8496, 24432, 11673},
              {8931, -24239, 8948, 10337, 6642, -12940, 2044}},
          {{-25034, 29644, 4204, -21541, 2066, -1383, -32054},
              {-1516, 27649, 9213, 21953, -8246, -2994, 23271},
              {5741, -4404, -30870, -758, -14576, 30327, 5131}},
          {{-13931, 13618, 10167, 4971, 10536, -10028, 12747},
              {27546, 28024, 32489, 30227, 19076, -4377, 31235},
              {-32451, 21157, -10381, -3748, -28769, 15296, -30469}},
          {{27530, -6380, 26432, 9789, -20823, -14298, 10992},
              {-29141, 17565, -12863, 532, 23587, 28061, -1336},
              {-1512, -30998, -25681, -14076, -3434, 21165, 18996}},
          {{23785, 13733, -22966, -30016, -259, 18864, -8488},
              {8813, 30199, -23666, 10467, 8867, 30286, -9516},
              {28298, -31786, 403, 23483, 9104, 5141, 5628}},
          {{-17443, -17172, -6039, -28216, -1458, -16072, 23325},
              {31595, -30954, 5554, -30247, 27625, -5799, -1108},
              {20869, -25574, -4915, 10078, 9390, -8158, -28345}}};
      ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
      ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
      self.sub(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DCC_9_1")
  void testsub_9_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{-11831}}};
    int[][][] inputarray_self = {{{7427}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[19258]]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DCC_14_1")
  void testsub_14_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{-4679, -17847}}};
    int[][][] inputarray_self = {{{-14413, 9595}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[-9734, 27442]]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DCC_19_1")
  void testsub_19_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{-19511, -23891, 22112}}};
    int[][][] inputarray_self = {{{-17397, 32016, -8182}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[2114, 55907, -30294]]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DCC_30_1")
  void testsub_30_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{22458}, {7152}}};
    int[][][] inputarray_self = {{{13849}, {400}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[-8609], [-6752]]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DCC_33_1")
  void testsub_33_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{2212, 31605, 9681, 11144}}};
    int[][][] inputarray_self = {{{25324, 11384, 12122, -12539}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[23112, -20221, 2441, -23683]]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DCC_68_1")
  void testsub_68_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{2975, -30559, 16390, -32461, -23750}}};
    int[][][] inputarray_self = {{{5881, 21926, 8174, 11077, -4209}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[2906, 52485, -8216, 43538, 19541]]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DCC_76_1")
  void testsub_76_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{-27001}}, {{26010}}};
    int[][][] inputarray_self = {{{-2759}}, {{-5891}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[24242]], [[-31901]]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DCC_90_1")
  void testsub_90_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{10489, -13031}, {20799, -3607}}};
    int[][][] inputarray_self = {{{30658, 330}, {30803, 29541}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[20169, 13361], [10004, 33148]]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DCC_126_1")
  void testsub_126_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{29090, 7206, -21383, 30744, 13643, -31453}}};
    int[][][] inputarray_self = {{{18469, 1456, -23856, -4943, 29942, 15745}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[-10621, -5750, -2473, -35687, 16299, 47198]]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DCC_137_1")
  void testsub_137_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{-16244}, {-19536}, {21261}}};
    int[][][] inputarray_self = {{{15457}, {28803}, {29522}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[31701], [48339], [8261]]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_getData_DCC_1_1")
  void testgetData_1_1() throws Exception {
    int[][][] inputarray_self = {
        {{18003, 27418, 32083}, {28297, -2803, 6291}, {-254, -26981, 12689}, {20550, -23677, -2894},
            {27340, -13435, 1897}, {-13142, 32146, -19351}},
        {{16177, -2544, -24809}, {25470, 27509, 29841}, {20879, 694, -20394}, {19423, 24448, 23231},
            {-29788, 10866, -23746}, {16521, -19579, -32312}},
        {{-14948, -32305, -267}, {-28938, -3309, 24176}, {-22126, 26871, 8767},
            {-3442, 6820, -19511}, {-29948, -20711, 14243}, {-11037, -20010, -6611}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    assertEquals(
        "[[[18003, 27418, 32083], [28297, -2803, 6291], [-254, -26981, 12689], [20550, -23677, -2894], [27340, -13435, 1897], [-13142, 32146, -19351]], [[16177, -2544, -24809], [25470, 27509, 29841], [20879, 694, -20394], [19423, 24448, 23231], [-29788, 10866, -23746], [16521, -19579, -32312]], [[-14948, -32305, -267], [-28938, -3309, 24176], [-22126, 26871, 8767], [-3442, 6820, -19511], [-29948, -20711, 14243], [-11037, -20010, -6611]]]",
        self.getData().toString());
  }
}
