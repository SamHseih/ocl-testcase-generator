package test.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Date;


public class DateBVA_DC_Test {
  @Test
  @DisplayName("tcgen_Date_Date_DC_1_1_Exception")
  void testDate_1_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -12161;
      int Arg_2 = 3;
      int Arg_3 = 4;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DC_2_1")
  void testDate_2_1() throws Exception {
    int Arg_1 = 1;
    int Arg_2 = 1;
    int Arg_3 = 26;

    assertEquals("[ 1, 1, 26 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DC_2_2")
  void testDate_2_2() throws Exception {
    int Arg_1 = 16240;
    int Arg_2 = 1;
    int Arg_3 = 1;

    assertEquals("[ 16240, 1, 1 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DC_2_3")
  void testDate_2_3() throws Exception {
    int Arg_1 = 22124;
    int Arg_2 = 12;
    int Arg_3 = 6;

    assertEquals("[ 22124, 12, 6 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DC_2_4")
  void testDate_2_4() throws Exception {
    int Arg_1 = 11849;
    int Arg_2 = 1;
    int Arg_3 = 1;

    assertEquals("[ 11849, 1, 1 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DC_2_5")
  void testDate_2_5() throws Exception {
    int Arg_1 = 5653;
    int Arg_2 = 1;
    int Arg_3 = 31;

    assertEquals("[ 5653, 1, 31 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DC_2_6")
  void testDate_2_6() throws Exception {
    int Arg_1 = 22840;
    int Arg_2 = 3;
    int Arg_3 = 25;

    assertEquals("[ 22840, 3, 25 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DC_3_1")
  void testDate_3_1() throws Exception {
    int Arg_1 = 1;
    int Arg_2 = 4;
    int Arg_3 = 17;

    assertEquals("[ 1, 4, 17 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DC_3_4")
  void testDate_3_4() throws Exception {
    int Arg_1 = 17162;
    int Arg_2 = 4;
    int Arg_3 = 1;

    assertEquals("[ 17162, 4, 1 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DC_3_5")
  void testDate_3_5() throws Exception {
    int Arg_1 = 13614;
    int Arg_2 = 4;
    int Arg_3 = 30;

    assertEquals("[ 13614, 4, 30 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DC_3_6")
  void testDate_3_6() throws Exception {
    int Arg_1 = 30426;
    int Arg_2 = 4;
    int Arg_3 = 18;

    assertEquals("[ 30426, 4, 18 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DC_4_4")
  void testDate_4_4() throws Exception {
    int Arg_1 = 20400;
    int Arg_2 = 2;
    int Arg_3 = 1;

    assertEquals("[ 20400, 2, 1 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DC_4_5")
  void testDate_4_5() throws Exception {
    int Arg_1 = 30000;
    int Arg_2 = 2;
    int Arg_3 = 28;

    assertEquals("[ 30000, 2, 28 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_1_1")
  void testnext_1_1() throws Exception {
    Date self = new Date(1, 12, 31);
    assertEquals("[ 2, 1, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_1_3")
  void testnext_1_3() throws Exception {
    Date self = new Date(2853, 12, 31);
    assertEquals("[ 2854, 1, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_2_1")
  void testnext_2_1() throws Exception {
    Date self = new Date(1, 12, 19);
    assertEquals("[ 1, 12, 20 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_2_3")
  void testnext_2_3() throws Exception {
    Date self = new Date(27239, 12, 18);
    assertEquals("[ 27239, 12, 19 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_2_4")
  void testnext_2_4() throws Exception {
    Date self = new Date(30876, 12, 1);
    assertEquals("[ 30876, 12, 2 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_3_1")
  void testnext_3_1() throws Exception {
    Date self = new Date(1, 1, 31);
    assertEquals("[ 1, 2, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_3_2")
  void testnext_3_2() throws Exception {
    Date self = new Date(24194, 1, 31);
    assertEquals("[ 24194, 2, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_3_5")
  void testnext_3_5() throws Exception {
    Date self = new Date(6309, 3, 31);
    assertEquals("[ 6309, 4, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_4_1")
  void testnext_4_1() throws Exception {
    Date self = new Date(1, 1, 14);
    assertEquals("[ 1, 1, 15 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_4_2")
  void testnext_4_2() throws Exception {
    Date self = new Date(20549, 1, 6);
    assertEquals("[ 20549, 1, 7 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_4_4")
  void testnext_4_4() throws Exception {
    Date self = new Date(23312, 1, 1);
    assertEquals("[ 23312, 1, 2 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_4_5")
  void testnext_4_5() throws Exception {
    Date self = new Date(5616, 3, 23);
    assertEquals("[ 5616, 3, 24 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_5_1")
  void testnext_5_1() throws Exception {
    Date self = new Date(1, 4, 30);
    assertEquals("[ 1, 5, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_5_5")
  void testnext_5_5() throws Exception {
    Date self = new Date(162, 4, 30);
    assertEquals("[ 162, 5, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_6_1")
  void testnext_6_1() throws Exception {
    Date self = new Date(1, 4, 22);
    assertEquals("[ 1, 4, 23 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_6_4")
  void testnext_6_4() throws Exception {
    Date self = new Date(21060, 4, 1);
    assertEquals("[ 21060, 4, 2 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_6_5")
  void testnext_6_5() throws Exception {
    Date self = new Date(23089, 4, 3);
    assertEquals("[ 23089, 4, 4 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_7_5")
  void testnext_7_5() throws Exception {
    Date self = new Date(23600, 2, 29);
    assertEquals("[ 23600, 3, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_8_4")
  void testnext_8_4() throws Exception {
    Date self = new Date(9600, 2, 1);
    assertEquals("[ 9600, 2, 2 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_8_5")
  void testnext_8_5() throws Exception {
    Date self = new Date(12000, 2, 26);
    assertEquals("[ 12000, 2, 27 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_9_1")
  void testnext_9_1() throws Exception {
    Date self = new Date(1, 2, 28);
    assertEquals("[ 1, 3, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_9_5")
  void testnext_9_5() throws Exception {
    Date self = new Date(23615, 2, 28);
    assertEquals("[ 23615, 3, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_10_1")
  void testnext_10_1() throws Exception {
    Date self = new Date(1, 2, 27);
    assertEquals("[ 1, 2, 28 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_10_4")
  void testnext_10_4() throws Exception {
    Date self = new Date(11650, 2, 1);
    assertEquals("[ 11650, 2, 2 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_10_5")
  void testnext_10_5() throws Exception {
    Date self = new Date(28539, 2, 15);
    assertEquals("[ 28539, 2, 16 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_1_1_Exception")
  void testgetYear_1_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 1, 194);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_1_2_Exception")
  void testgetYear_1_2() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(14681, 1, 14135);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_1_3_Exception")
  void testgetYear_1_3() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(11910, 12, 31704);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_1_5_Exception")
  void testgetYear_1_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(21999, 3, 8468);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_2_1")
  void testgetYear_2_1() throws Exception {
    Date self = new Date(1, 1, 14);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_2_2")
  void testgetYear_2_2() throws Exception {
    Date self = new Date(14232, 1, 8);
    assertEquals("14232", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_2_3")
  void testgetYear_2_3() throws Exception {
    Date self = new Date(21685, 12, 25);
    assertEquals("21685", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_2_4")
  void testgetYear_2_4() throws Exception {
    Date self = new Date(20020, 1, 1);
    assertEquals("20020", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_2_5")
  void testgetYear_2_5() throws Exception {
    Date self = new Date(1, 1, 22);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_2_6")
  void testgetYear_2_6() throws Exception {
    Date self = new Date(9575, 1, 21);
    assertEquals("9575", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_2_7")
  void testgetYear_2_7() throws Exception {
    Date self = new Date(1716, 12, 6);
    assertEquals("1716", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_2_8")
  void testgetYear_2_8() throws Exception {
    Date self = new Date(19640, 1, 1);
    assertEquals("19640", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_2_9")
  void testgetYear_2_9() throws Exception {
    Date self = new Date(24555, 1, 31);
    assertEquals("24555", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_2_10")
  void testgetYear_2_10() throws Exception {
    Date self = new Date(2047, 3, 22);
    assertEquals("2047", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_3_1")
  void testgetYear_3_1() throws Exception {
    Date self = new Date(1, 4, 6);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_3_4")
  void testgetYear_3_4() throws Exception {
    Date self = new Date(28555, 4, 1);
    assertEquals("28555", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_3_5")
  void testgetYear_3_5() throws Exception {
    Date self = new Date(1, 4, 11);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_3_8")
  void testgetYear_3_8() throws Exception {
    Date self = new Date(31393, 4, 1);
    assertEquals("31393", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_3_9")
  void testgetYear_3_9() throws Exception {
    Date self = new Date(27970, 4, 30);
    assertEquals("27970", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_3_10")
  void testgetYear_3_10() throws Exception {
    Date self = new Date(17398, 4, 13);
    assertEquals("17398", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_4_4")
  void testgetYear_4_4() throws Exception {
    Date self = new Date(22000, 2, 1);
    assertEquals("22000", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_4_8")
  void testgetYear_4_8() throws Exception {
    Date self = new Date(2400, 2, 1);
    assertEquals("2400", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_4_9")
  void testgetYear_4_9() throws Exception {
    Date self = new Date(1200, 2, 29);
    assertEquals("1200", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_4_10")
  void testgetYear_4_10() throws Exception {
    Date self = new Date(5200, 2, 11);
    assertEquals("5200", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_1_1_Exception")
  void testgetMonth_1_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 1, 32507);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_1_2_Exception")
  void testgetMonth_1_2() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(2712, 1, 12777);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_1_3_Exception")
  void testgetMonth_1_3() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1670, 12, 11295);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_1_5_Exception")
  void testgetMonth_1_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(4994, 3, 4225);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_2_1")
  void testgetMonth_2_1() throws Exception {
    Date self = new Date(1, 1, 26);
    assertEquals("1", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_2_2")
  void testgetMonth_2_2() throws Exception {
    Date self = new Date(28555, 1, 22);
    assertEquals("1", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_2_3")
  void testgetMonth_2_3() throws Exception {
    Date self = new Date(20536, 12, 2);
    assertEquals("12", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_2_4")
  void testgetMonth_2_4() throws Exception {
    Date self = new Date(23413, 1, 1);
    assertEquals("1", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_2_5")
  void testgetMonth_2_5() throws Exception {
    Date self = new Date(1, 1, 2);
    assertEquals("1", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_2_6")
  void testgetMonth_2_6() throws Exception {
    Date self = new Date(28982, 1, 18);
    assertEquals("1", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_2_7")
  void testgetMonth_2_7() throws Exception {
    Date self = new Date(7826, 12, 13);
    assertEquals("12", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_2_8")
  void testgetMonth_2_8() throws Exception {
    Date self = new Date(30766, 1, 1);
    assertEquals("1", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_2_9")
  void testgetMonth_2_9() throws Exception {
    Date self = new Date(5001, 1, 31);
    assertEquals("1", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_2_10")
  void testgetMonth_2_10() throws Exception {
    Date self = new Date(14397, 3, 3);
    assertEquals("3", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_3_1")
  void testgetMonth_3_1() throws Exception {
    Date self = new Date(1, 4, 24);
    assertEquals("4", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_3_4")
  void testgetMonth_3_4() throws Exception {
    Date self = new Date(31851, 4, 1);
    assertEquals("4", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_3_5")
  void testgetMonth_3_5() throws Exception {
    Date self = new Date(1, 4, 5);
    assertEquals("4", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_3_8")
  void testgetMonth_3_8() throws Exception {
    Date self = new Date(21180, 4, 1);
    assertEquals("4", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_3_9")
  void testgetMonth_3_9() throws Exception {
    Date self = new Date(5906, 4, 30);
    assertEquals("4", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_3_10")
  void testgetMonth_3_10() throws Exception {
    Date self = new Date(5574, 4, 2);
    assertEquals("4", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_4_4")
  void testgetMonth_4_4() throws Exception {
    Date self = new Date(30000, 2, 1);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_4_8")
  void testgetMonth_4_8() throws Exception {
    Date self = new Date(30400, 2, 1);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_4_9")
  void testgetMonth_4_9() throws Exception {
    Date self = new Date(31600, 2, 29);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_4_10")
  void testgetMonth_4_10() throws Exception {
    Date self = new Date(20400, 2, 13);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_1_1_Exception")
  void testgetDay_1_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 1, 479);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_1_2_Exception")
  void testgetDay_1_2() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1433, 1, 1525);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_1_3_Exception")
  void testgetDay_1_3() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(24761, 12, 30290);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_1_5_Exception")
  void testgetDay_1_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(2101, 3, 18028);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_2_1")
  void testgetDay_2_1() throws Exception {
    Date self = new Date(1, 1, 31);
    assertEquals("31", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_2_2")
  void testgetDay_2_2() throws Exception {
    Date self = new Date(3591, 1, 15);
    assertEquals("15", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_2_3")
  void testgetDay_2_3() throws Exception {
    Date self = new Date(5065, 12, 19);
    assertEquals("19", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_2_4")
  void testgetDay_2_4() throws Exception {
    Date self = new Date(8604, 1, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_2_5")
  void testgetDay_2_5() throws Exception {
    Date self = new Date(1, 1, 17);
    assertEquals("17", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_2_6")
  void testgetDay_2_6() throws Exception {
    Date self = new Date(31395, 1, 28);
    assertEquals("28", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_2_7")
  void testgetDay_2_7() throws Exception {
    Date self = new Date(6912, 12, 11);
    assertEquals("11", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_2_8")
  void testgetDay_2_8() throws Exception {
    Date self = new Date(20994, 1, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_2_9")
  void testgetDay_2_9() throws Exception {
    Date self = new Date(5917, 1, 31);
    assertEquals("31", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_2_10")
  void testgetDay_2_10() throws Exception {
    Date self = new Date(31365, 3, 9);
    assertEquals("9", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_3_1")
  void testgetDay_3_1() throws Exception {
    Date self = new Date(1, 4, 27);
    assertEquals("27", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_3_4")
  void testgetDay_3_4() throws Exception {
    Date self = new Date(25330, 4, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_3_5")
  void testgetDay_3_5() throws Exception {
    Date self = new Date(1, 4, 17);
    assertEquals("17", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_3_8")
  void testgetDay_3_8() throws Exception {
    Date self = new Date(6318, 4, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_3_9")
  void testgetDay_3_9() throws Exception {
    Date self = new Date(7214, 4, 30);
    assertEquals("30", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_3_10")
  void testgetDay_3_10() throws Exception {
    Date self = new Date(5752, 4, 16);
    assertEquals("16", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_4_4")
  void testgetDay_4_4() throws Exception {
    Date self = new Date(25200, 2, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_4_8")
  void testgetDay_4_8() throws Exception {
    Date self = new Date(31200, 2, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_4_9")
  void testgetDay_4_9() throws Exception {
    Date self = new Date(8400, 2, 29);
    assertEquals("29", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_4_10")
  void testgetDay_4_10() throws Exception {
    Date self = new Date(3200, 2, 5);
    assertEquals("5", self.getDay());
  }
}
