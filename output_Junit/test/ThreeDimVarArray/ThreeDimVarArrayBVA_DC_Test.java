package test.ThreeDimVarArray;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.ThreeDimVarArray;


public class ThreeDimVarArrayBVA_DC_Test {
  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_ThreeDimVarArray_DC_1_1")
  void testThreeDimVarArray_1_1() throws Exception {
    int[][][] Arg_1 =
        {{{14511, 28570, 6638}, {-6389, 26194, -5968}, {28849, 21191, 30541}, {25927, 8564, 9578}},
            {{15132, 15551, 20526}, {-12680, 870, 24138}, {-17257, 26966, 7188},
                {-8541, -20302, -30954}},
            {{-22077, -27210, -9784}, {-2701, 2490, 20145}, {13647, 31566, -11611},
                {5258, 14942, 21863}},
            {{-31243, 8530, 19809}, {-31375, 3984, -19141}, {-575, 4269, -17444},
                {11768, -30687, -15202}}};
    assertEquals(
        "[[[14511, 28570, 6638], [-6389, 26194, -5968], [28849, 21191, 30541], [25927, 8564, 9578]], [[15132, 15551, 20526], [-12680, 870, 24138], [-17257, 26966, 7188], [-8541, -20302, -30954]], [[-22077, -27210, -9784], [-2701, 2490, 20145], [13647, 31566, -11611], [5258, 14942, 21863]], [[-31243, 8530, 19809], [-31375, 3984, -19141], [-575, 4269, -17444], [11768, -30687, -15202]]]",
        new ThreeDimVarArray(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DC_1_1_Exception")
  void testadd_1_1() {
    assertThrows(Exception.class, () -> {
      int[][][] inputarray_Arg_1 = {
          {{25363, -6653, 134}, {20745, 55, -16164}, {-25950, -4882, -28026}, {-3017, -9216, -277},
              {-30730, -10, -19671}},
          {{-29229, -31782, -9742}, {-32071, -29646, -28897}, {968, 6297, -10953},
              {-25191, 29043, -29273}, {29019, -11019, 24254}},
          {{3011, 25488, -27640}, {7271, -17804, -20595}, {5566, -4585, 10525},
              {-8330, -15525, 24961}, {-29895, 17994, -23901}},
          {{-27033, -22185, -747}, {-1597, 4748, 25804}, {-13478, 11249, -9157},
              {31691, -13758, -21685}, {22169, -10805, 2642}}};
      int[][][] inputarray_self = {
          {{-8753, 30077, -25412}, {-21151, -26246, 28638}, {-9347, -22913, -22158},
              {-10845, -18336, 32581}, {15175, -22328, -26279}},
          {{-24887, -8155, 31712}, {1125, -20254, 1676}, {-18816, 30393, -12934},
              {-29761, 25259, 8068}, {12396, -27915, 14562}},
          {{-8311, 32484, -20959}, {-6699, -12444, -22802}, {-19120, 27304, 15941},
              {-29241, -9698, 17066}, {-25218, -21637, 30381}}};
      ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
      ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
      self.add(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DC_6_1")
  void testadd_6_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{114}}};
    int[][][] inputarray_self = {{{-20928}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[-20814]]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DC_11_1")
  void testadd_11_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{25006, 31999}}};
    int[][][] inputarray_self = {{{26280, 4000}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[51286, 35999]]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DC_16_1")
  void testadd_16_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{26720, -6458, -4094}}};
    int[][][] inputarray_self = {{{2722, 13866, -16023}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[29442, 7408, -20117]]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DC_27_1")
  void testadd_27_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{-12072}, {-22795}}};
    int[][][] inputarray_self = {{{-7688}, {32180}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[-19760], [9385]]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DC_30_1")
  void testadd_30_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{20322, -20728, 395, 23485}}};
    int[][][] inputarray_self = {{{6976, -6160, 5641, -23294}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[27298, -26888, 6036, 191]]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DC_65_1")
  void testadd_65_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{27148, -28509, -12168, -18922, 23886}}};
    int[][][] inputarray_self = {{{-7575, -18019, 16870, -10301, -4164}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[19573, -46528, 4702, -29223, 19722]]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DC_73_1")
  void testadd_73_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{-23220}}, {{30764}}};
    int[][][] inputarray_self = {{{14958}}, {{-24705}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[-8262]], [[6059]]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DC_87_1")
  void testadd_87_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{6820, 30964}, {11224, 29814}}};
    int[][][] inputarray_self = {{{26811, 16444}, {10367, 4024}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[33631, 47408], [21591, 33838]]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DC_123_1")
  void testadd_123_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{12282, -32089, 15262, -15868, 112, -3975}}};
    int[][][] inputarray_self = {{{-24011, -17138, -27008, 20719, 17594, -31699}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[-11729, -49227, -11746, 4851, 17706, -35674]]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_add_DC_134_1")
  void testadd_134_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{27600}, {13834}, {-27711}}};
    int[][][] inputarray_self = {{{-18144}, {3546}, {15935}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[9456], [17380], [-11776]]]", self.add(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DC_1_1_Exception")
  void testsub_1_1() {
    assertThrows(Exception.class, () -> {
      int[][][] inputarray_Arg_1 = {{{-29128}, {-14541}}, {{-10322}, {-8094}}};
      int[][][] inputarray_self = {{{8383}, {12593}}, {{-25983}, {-29050}}, {{12688}, {-28346}},
          {{15838}, {-9165}}, {{3648}, {26827}}, {{-10090}, {-18225}}, {{-13364}, {21187}},
          {{-27423}, {-20211}}, {{10417}, {1352}}, {{18573}, {31916}}};
      ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
      ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
      self.sub(Arg_1).toString();
    });
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DC_6_1")
  void testsub_6_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{20023}}};
    int[][][] inputarray_self = {{{22091}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[2068]]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DC_11_1")
  void testsub_11_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{-14941, 14428}}};
    int[][][] inputarray_self = {{{-31690, -1045}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[-16749, -15473]]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DC_16_1")
  void testsub_16_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{-23247, -11775, 32289}}};
    int[][][] inputarray_self = {{{-10374, 1630, -24086}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[12873, 13405, -56375]]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DC_27_1")
  void testsub_27_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{30019}, {5124}}};
    int[][][] inputarray_self = {{{2810}, {18341}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[-27209], [13217]]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DC_30_1")
  void testsub_30_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{30870, 13693, -12063, -710}}};
    int[][][] inputarray_self = {{{-18628, -10105, 21032, -22438}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[-49498, -23798, 33095, -21728]]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DC_65_1")
  void testsub_65_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{-1423, -30519, -24492, -28696, 22542}}};
    int[][][] inputarray_self = {{{31923, 12488, -18073, -29244, -13326}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[33346, 43007, 6419, -548, -35868]]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DC_73_1")
  void testsub_73_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{10095}}, {{-4385}}};
    int[][][] inputarray_self = {{{-20837}}, {{-2617}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[-30932]], [[1768]]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DC_87_1")
  void testsub_87_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{-19038, -11643}, {-10819, -9432}}};
    int[][][] inputarray_self = {{{-20456, 10019}, {-14070, -21041}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[-1418, 21662], [-3251, -11609]]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DC_123_1")
  void testsub_123_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{-22687, 25105, 17574, -4380, 11480, 24412}}};
    int[][][] inputarray_self = {{{6259, -13571, 31598, 22619, 20121, -7991}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[28946, -38676, 14024, 26999, 8641, -32403]]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_sub_DC_134_1")
  void testsub_134_1() throws Exception {
    int[][][] inputarray_Arg_1 = {{{-26255}, {7779}, {16797}}};
    int[][][] inputarray_self = {{{20324}, {22254}, {421}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    ThreeDimVarArray Arg_1 = new ThreeDimVarArray(inputarray_Arg_1);
    assertEquals("[[[46579], [14475], [-16376]]]", self.sub(Arg_1).toString());
  }

  @Test
  @DisplayName("DynamicFixedsizeArrays_ThreeDimVarArray_getData_DC_1_1")
  void testgetData_1_1() throws Exception {
    int[][][] inputarray_self = {
        {{28535, 24556, -2059, 6972, -17772, 294}, {16899, -17635, 3218, -4859, 4623, 25606},
            {-10892, -19134, -5663, -1242, -30444, -28397},
            {18292, 11299, 4341, 4201, -9690, 17720}, {-5820, -31547, 23196, -23661, -24107, 7740},
            {-25211, -16508, 10784, 11162, -32675, 32122}},
        {{26815, 24182, -25924, -7160, -16674, 25139}, {24074, 23353, -5688, 461, 8073, -27246},
            {2964, -18192, -24662, 30199, -12930, -8113},
            {-13560, -31122, 20707, -7153, -22362, -20232},
            {27424, -9328, -19491, 13610, 1563, -9192}, {-12323, -4552, -7495, -4526, -850, 9549}},
        {{-12492, 9384, 5087, 31211, 19228, -23829}, {-16627, -24805, 537, 1071, 31891, -12766},
            {-26205, -3596, 4190, -8350, 11541, -16838},
            {-1748, -5274, -18454, -13798, 8542, 15801},
            {-29794, 10096, -29641, -8445, 24647, 13093},
            {-1880, -3121, -9721, 13833, 11979, -30833}},
        {{29019, -17648, -18083, -2672, 9055, -14576}, {-32311, 22094, -23069, 471, 8127, 12821},
            {7747, -17728, 21688, -5944, -28307, -14239},
            {-19200, -19092, 15562, 996, -10242, -22666},
            {19666, 17522, -2538, 18047, -10024, -8613},
            {14457, -17108, 9156, 22502, -29813, -31643}}};
    ThreeDimVarArray self = new ThreeDimVarArray(inputarray_self);
    assertEquals(
        "[[[28535, 24556, -2059, 6972, -17772, 294], [16899, -17635, 3218, -4859, 4623, 25606], [-10892, -19134, -5663, -1242, -30444, -28397], [18292, 11299, 4341, 4201, -9690, 17720], [-5820, -31547, 23196, -23661, -24107, 7740], [-25211, -16508, 10784, 11162, -32675, 32122]], [[26815, 24182, -25924, -7160, -16674, 25139], [24074, 23353, -5688, 461, 8073, -27246], [2964, -18192, -24662, 30199, -12930, -8113], [-13560, -31122, 20707, -7153, -22362, -20232], [27424, -9328, -19491, 13610, 1563, -9192], [-12323, -4552, -7495, -4526, -850, 9549]], [[-12492, 9384, 5087, 31211, 19228, -23829], [-16627, -24805, 537, 1071, 31891, -12766], [-26205, -3596, 4190, -8350, 11541, -16838], [-1748, -5274, -18454, -13798, 8542, 15801], [-29794, 10096, -29641, -8445, 24647, 13093], [-1880, -3121, -9721, 13833, 11979, -30833]], [[29019, -17648, -18083, -2672, 9055, -14576], [-32311, 22094, -23069, 471, 8127, 12821], [7747, -17728, 21688, -5944, -28307, -14239], [-19200, -19092, 15562, 996, -10242, -22666], [19666, 17522, -2538, 18047, -10024, -8613], [14457, -17108, 9156, 22502, -29813, -31643]]]",
        self.getData().toString());
  }
}
