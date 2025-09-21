package test.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Date;


public class DateBVA_DCC_Test {
  @Test
  @DisplayName("tcgen_Date_Date_DCC_1_1")
  void testDate_1_1() throws Exception {
    int Arg_1 = 1;
    int Arg_2 = 12;
    int Arg_3 = 27;

    assertEquals("[ 1, 12, 27 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_1_3")
  void testDate_1_3() throws Exception {
    int Arg_1 = 23585;
    int Arg_2 = 12;
    int Arg_3 = 27;

    assertEquals("[ 23585, 12, 27 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_1_4")
  void testDate_1_4() throws Exception {
    int Arg_1 = 4925;
    int Arg_2 = 12;
    int Arg_3 = 1;

    assertEquals("[ 4925, 12, 1 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_1_5")
  void testDate_1_5() throws Exception {
    int Arg_1 = 24527;
    int Arg_2 = 12;
    int Arg_3 = 31;

    assertEquals("[ 24527, 12, 31 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_2_1_Exception")
  void testDate_2_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 12;
      int Arg_3 = 15788;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_2_3_Exception")
  void testDate_2_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 25356;
      int Arg_2 = 12;
      int Arg_3 = 18837;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_3_1")
  void testDate_3_1() throws Exception {
    int Arg_1 = 1;
    int Arg_2 = 10;
    int Arg_3 = 9;

    assertEquals("[ 1, 10, 9 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_3_4")
  void testDate_3_4() throws Exception {
    int Arg_1 = 11988;
    int Arg_2 = 10;
    int Arg_3 = 1;

    assertEquals("[ 11988, 10, 1 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_3_5")
  void testDate_3_5() throws Exception {
    int Arg_1 = 23592;
    int Arg_2 = 10;
    int Arg_3 = 31;

    assertEquals("[ 23592, 10, 31 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_3_6")
  void testDate_3_6() throws Exception {
    int Arg_1 = 24403;
    int Arg_2 = 10;
    int Arg_3 = 3;

    assertEquals("[ 24403, 10, 3 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_4_1_Exception")
  void testDate_4_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 12;
      int Arg_3 = -7584;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_4_3_Exception")
  void testDate_4_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 25625;
      int Arg_2 = 12;
      int Arg_3 = -12902;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_5_1_Exception")
  void testDate_5_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 10;
      int Arg_3 = 7039;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_5_5_Exception")
  void testDate_5_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 11960;
      int Arg_2 = 10;
      int Arg_3 = 23347;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_6_1")
  void testDate_6_1() throws Exception {
    int Arg_1 = 1;
    int Arg_2 = 8;
    int Arg_3 = 10;

    assertEquals("[ 1, 8, 10 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_6_4")
  void testDate_6_4() throws Exception {
    int Arg_1 = 18693;
    int Arg_2 = 8;
    int Arg_3 = 1;

    assertEquals("[ 18693, 8, 1 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_6_5")
  void testDate_6_5() throws Exception {
    int Arg_1 = 30327;
    int Arg_2 = 8;
    int Arg_3 = 31;

    assertEquals("[ 30327, 8, 31 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_6_6")
  void testDate_6_6() throws Exception {
    int Arg_1 = 2271;
    int Arg_2 = 8;
    int Arg_3 = 24;

    assertEquals("[ 2271, 8, 24 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_8_1_Exception")
  void testDate_8_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 10;
      int Arg_3 = -20303;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_8_5_Exception")
  void testDate_8_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 10217;
      int Arg_2 = 10;
      int Arg_3 = -2360;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_9_1_Exception")
  void testDate_9_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 8;
      int Arg_3 = 13445;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_9_5_Exception")
  void testDate_9_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 19537;
      int Arg_2 = 8;
      int Arg_3 = 28544;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_10_1")
  void testDate_10_1() throws Exception {
    int Arg_1 = 1;
    int Arg_2 = 7;
    int Arg_3 = 4;

    assertEquals("[ 1, 7, 4 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_10_4")
  void testDate_10_4() throws Exception {
    int Arg_1 = 13447;
    int Arg_2 = 7;
    int Arg_3 = 1;

    assertEquals("[ 13447, 7, 1 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_10_5")
  void testDate_10_5() throws Exception {
    int Arg_1 = 1741;
    int Arg_2 = 7;
    int Arg_3 = 31;

    assertEquals("[ 1741, 7, 31 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_10_6")
  void testDate_10_6() throws Exception {
    int Arg_1 = 20621;
    int Arg_2 = 7;
    int Arg_3 = 25;

    assertEquals("[ 20621, 7, 25 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_11_2_Exception")
  void testDate_11_2() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -647;
      int Arg_2 = 12;
      int Arg_3 = 8;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_11_3_Exception")
  void testDate_11_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -280;
      int Arg_2 = 12;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_11_4_Exception")
  void testDate_11_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -2762;
      int Arg_2 = 12;
      int Arg_3 = 31;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_14_1_Exception")
  void testDate_14_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 8;
      int Arg_3 = -19113;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_14_5_Exception")
  void testDate_14_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 12648;
      int Arg_2 = 8;
      int Arg_3 = -24488;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_15_1_Exception")
  void testDate_15_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 7;
      int Arg_3 = 18630;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_15_5_Exception")
  void testDate_15_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 31860;
      int Arg_2 = 7;
      int Arg_3 = 16079;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_16_1")
  void testDate_16_1() throws Exception {
    int Arg_1 = 1;
    int Arg_2 = 5;
    int Arg_3 = 24;

    assertEquals("[ 1, 5, 24 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_16_4")
  void testDate_16_4() throws Exception {
    int Arg_1 = 7358;
    int Arg_2 = 5;
    int Arg_3 = 1;

    assertEquals("[ 7358, 5, 1 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_16_5")
  void testDate_16_5() throws Exception {
    int Arg_1 = 7424;
    int Arg_2 = 5;
    int Arg_3 = 31;

    assertEquals("[ 7424, 5, 31 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_16_6")
  void testDate_16_6() throws Exception {
    int Arg_1 = 23600;
    int Arg_2 = 5;
    int Arg_3 = 30;

    assertEquals("[ 23600, 5, 30 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_17_3_Exception")
  void testDate_17_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -30326;
      int Arg_2 = 10;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_17_4_Exception")
  void testDate_17_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -22974;
      int Arg_2 = 10;
      int Arg_3 = 31;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_17_5_Exception")
  void testDate_17_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -31153;
      int Arg_2 = 10;
      int Arg_3 = 28;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_20_1_Exception")
  void testDate_20_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 7;
      int Arg_3 = -31937;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_20_5_Exception")
  void testDate_20_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 14355;
      int Arg_2 = 7;
      int Arg_3 = -20310;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_21_1_Exception")
  void testDate_21_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 5;
      int Arg_3 = 24853;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_21_5_Exception")
  void testDate_21_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 17090;
      int Arg_2 = 5;
      int Arg_3 = 7855;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_22_1")
  void testDate_22_1() throws Exception {
    int Arg_1 = 1;
    int Arg_2 = 11;
    int Arg_3 = 22;

    assertEquals("[ 1, 11, 22 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_22_4")
  void testDate_22_4() throws Exception {
    int Arg_1 = 26706;
    int Arg_2 = 11;
    int Arg_3 = 1;

    assertEquals("[ 26706, 11, 1 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_22_5")
  void testDate_22_5() throws Exception {
    int Arg_1 = 14296;
    int Arg_2 = 11;
    int Arg_3 = 30;

    assertEquals("[ 14296, 11, 30 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_22_6")
  void testDate_22_6() throws Exception {
    int Arg_1 = 3432;
    int Arg_2 = 11;
    int Arg_3 = 18;

    assertEquals("[ 3432, 11, 18 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_23_1_Exception")
  void testDate_23_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 11;
      int Arg_3 = 18572;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_23_5_Exception")
  void testDate_23_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 11249;
      int Arg_2 = 11;
      int Arg_3 = 13203;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_24_1")
  void testDate_24_1() throws Exception {
    int Arg_1 = 1;
    int Arg_2 = 1;
    int Arg_3 = 29;

    assertEquals("[ 1, 1, 29 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_24_2")
  void testDate_24_2() throws Exception {
    int Arg_1 = 18405;
    int Arg_2 = 1;
    int Arg_3 = 20;

    assertEquals("[ 18405, 1, 20 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_24_4")
  void testDate_24_4() throws Exception {
    int Arg_1 = 10281;
    int Arg_2 = 1;
    int Arg_3 = 1;

    assertEquals("[ 10281, 1, 1 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_24_5")
  void testDate_24_5() throws Exception {
    int Arg_1 = 15322;
    int Arg_2 = 1;
    int Arg_3 = 31;

    assertEquals("[ 15322, 1, 31 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_25_1")
  void testDate_25_1() throws Exception {
    int Arg_1 = 1;
    int Arg_2 = 3;
    int Arg_3 = 6;

    assertEquals("[ 1, 3, 6 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_25_4")
  void testDate_25_4() throws Exception {
    int Arg_1 = 18885;
    int Arg_2 = 3;
    int Arg_3 = 1;

    assertEquals("[ 18885, 3, 1 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_25_5")
  void testDate_25_5() throws Exception {
    int Arg_1 = 25230;
    int Arg_2 = 3;
    int Arg_3 = 31;

    assertEquals("[ 25230, 3, 31 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_25_6")
  void testDate_25_6() throws Exception {
    int Arg_1 = 1540;
    int Arg_2 = 3;
    int Arg_3 = 28;

    assertEquals("[ 1540, 3, 28 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_26_3_Exception")
  void testDate_26_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -30438;
      int Arg_2 = 8;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_26_4_Exception")
  void testDate_26_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -15988;
      int Arg_2 = 8;
      int Arg_3 = 31;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_26_5_Exception")
  void testDate_26_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -23071;
      int Arg_2 = 8;
      int Arg_3 = 19;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_29_1_Exception")
  void testDate_29_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 5;
      int Arg_3 = -22366;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_29_5_Exception")
  void testDate_29_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 23553;
      int Arg_2 = 5;
      int Arg_3 = -11128;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_30_1_Exception")
  void testDate_30_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 1;
      int Arg_3 = 31193;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_30_2_Exception")
  void testDate_30_2() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 24581;
      int Arg_2 = 1;
      int Arg_3 = 23627;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_31_1_Exception")
  void testDate_31_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 3;
      int Arg_3 = 7419;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_31_5_Exception")
  void testDate_31_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 24286;
      int Arg_2 = 3;
      int Arg_3 = 11591;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_32_1")
  void testDate_32_1() throws Exception {
    int Arg_1 = 1;
    int Arg_2 = 9;
    int Arg_3 = 11;

    assertEquals("[ 1, 9, 11 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_32_4")
  void testDate_32_4() throws Exception {
    int Arg_1 = 21447;
    int Arg_2 = 9;
    int Arg_3 = 1;

    assertEquals("[ 21447, 9, 1 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_32_5")
  void testDate_32_5() throws Exception {
    int Arg_1 = 24677;
    int Arg_2 = 9;
    int Arg_3 = 30;

    assertEquals("[ 24677, 9, 30 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_32_6")
  void testDate_32_6() throws Exception {
    int Arg_1 = 19472;
    int Arg_2 = 9;
    int Arg_3 = 24;

    assertEquals("[ 19472, 9, 24 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_33_1_Exception")
  void testDate_33_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 11;
      int Arg_3 = -10750;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_33_5_Exception")
  void testDate_33_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 9000;
      int Arg_2 = 11;
      int Arg_3 = -20801;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_34_1_Exception")
  void testDate_34_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 9;
      int Arg_3 = 1609;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_34_5_Exception")
  void testDate_34_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 30063;
      int Arg_2 = 9;
      int Arg_3 = 24654;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_35_3_Exception")
  void testDate_35_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -7004;
      int Arg_2 = 7;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_35_4_Exception")
  void testDate_35_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -25090;
      int Arg_2 = 7;
      int Arg_3 = 31;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_35_5_Exception")
  void testDate_35_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -27454;
      int Arg_2 = 7;
      int Arg_3 = 8;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_38_1_Exception")
  void testDate_38_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 1;
      int Arg_3 = -13246;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_38_2_Exception")
  void testDate_38_2() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 15039;
      int Arg_2 = 1;
      int Arg_3 = -25940;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_39_1_Exception")
  void testDate_39_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 3;
      int Arg_3 = -22344;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_39_5_Exception")
  void testDate_39_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 959;
      int Arg_2 = 3;
      int Arg_3 = -12509;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_40_1")
  void testDate_40_1() throws Exception {
    int Arg_1 = 1;
    int Arg_2 = 4;
    int Arg_3 = 11;

    assertEquals("[ 1, 4, 11 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_40_4")
  void testDate_40_4() throws Exception {
    int Arg_1 = 27656;
    int Arg_2 = 4;
    int Arg_3 = 1;

    assertEquals("[ 27656, 4, 1 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_40_5")
  void testDate_40_5() throws Exception {
    int Arg_1 = 10488;
    int Arg_2 = 4;
    int Arg_3 = 30;

    assertEquals("[ 10488, 4, 30 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_40_6")
  void testDate_40_6() throws Exception {
    int Arg_1 = 24875;
    int Arg_2 = 4;
    int Arg_3 = 15;

    assertEquals("[ 24875, 4, 15 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_41_1")
  void testDate_41_1() throws Exception {
    int Arg_1 = 1;
    int Arg_2 = 6;
    int Arg_3 = 20;

    assertEquals("[ 1, 6, 20 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_41_4")
  void testDate_41_4() throws Exception {
    int Arg_1 = 10659;
    int Arg_2 = 6;
    int Arg_3 = 1;

    assertEquals("[ 10659, 6, 1 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_41_5")
  void testDate_41_5() throws Exception {
    int Arg_1 = 32744;
    int Arg_2 = 6;
    int Arg_3 = 30;

    assertEquals("[ 32744, 6, 30 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_41_6")
  void testDate_41_6() throws Exception {
    int Arg_1 = 9873;
    int Arg_2 = 6;
    int Arg_3 = 13;

    assertEquals("[ 9873, 6, 13 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_43_1_Exception")
  void testDate_43_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 9;
      int Arg_3 = -8291;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_43_5_Exception")
  void testDate_43_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 11671;
      int Arg_2 = 9;
      int Arg_3 = -32175;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_44_1_Exception")
  void testDate_44_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 4;
      int Arg_3 = 10522;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_44_5_Exception")
  void testDate_44_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 2680;
      int Arg_2 = 4;
      int Arg_3 = 22453;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_45_1_Exception")
  void testDate_45_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 6;
      int Arg_3 = 17809;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_45_5_Exception")
  void testDate_45_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 4041;
      int Arg_2 = 6;
      int Arg_3 = 26824;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_46_3_Exception")
  void testDate_46_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -3344;
      int Arg_2 = 5;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_46_4_Exception")
  void testDate_46_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -5030;
      int Arg_2 = 5;
      int Arg_3 = 31;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_46_5_Exception")
  void testDate_46_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -4674;
      int Arg_2 = 5;
      int Arg_3 = 10;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_50_4")
  void testDate_50_4() throws Exception {
    int Arg_1 = 25200;
    int Arg_2 = 2;
    int Arg_3 = 1;

    assertEquals("[ 25200, 2, 1 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_50_5")
  void testDate_50_5() throws Exception {
    int Arg_1 = 16400;
    int Arg_2 = 2;
    int Arg_3 = 26;

    assertEquals("[ 16400, 2, 26 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_51_3_Exception")
  void testDate_51_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -4185;
      int Arg_2 = 11;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_51_4_Exception")
  void testDate_51_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -22043;
      int Arg_2 = 11;
      int Arg_3 = 30;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_51_5_Exception")
  void testDate_51_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -21696;
      int Arg_2 = 11;
      int Arg_3 = 9;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_54_1_Exception")
  void testDate_54_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 4;
      int Arg_3 = -12477;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_54_5_Exception")
  void testDate_54_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 11168;
      int Arg_2 = 4;
      int Arg_3 = -6724;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_55_1_Exception")
  void testDate_55_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 6;
      int Arg_3 = -204;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_55_5_Exception")
  void testDate_55_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 2100;
      int Arg_2 = 6;
      int Arg_3 = -20461;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_56_5_Exception")
  void testDate_56_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 26000;
      int Arg_2 = 2;
      int Arg_3 = 30;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_56_6_Exception")
  void testDate_56_6() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 19600;
      int Arg_2 = 2;
      int Arg_3 = 7051;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_57_4")
  void testDate_57_4() throws Exception {
    int Arg_1 = 19544;
    int Arg_2 = 2;
    int Arg_3 = 1;

    assertEquals("[ 19544, 2, 1 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_57_5")
  void testDate_57_5() throws Exception {
    int Arg_1 = 10692;
    int Arg_2 = 2;
    int Arg_3 = 18;

    assertEquals("[ 10692, 2, 18 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_58_1_Exception")
  void testDate_58_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -15709;
      int Arg_2 = 1;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_58_3_Exception")
  void testDate_58_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -28412;
      int Arg_2 = 1;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_58_4_Exception")
  void testDate_58_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -5987;
      int Arg_2 = 1;
      int Arg_3 = 31;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_59_3_Exception")
  void testDate_59_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -31744;
      int Arg_2 = 3;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_59_4_Exception")
  void testDate_59_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -9004;
      int Arg_2 = 3;
      int Arg_3 = 31;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_59_5_Exception")
  void testDate_59_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -24254;
      int Arg_2 = 3;
      int Arg_3 = 22;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_62_5_Exception")
  void testDate_62_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 20960;
      int Arg_2 = 2;
      int Arg_3 = 30;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_62_6_Exception")
  void testDate_62_6() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 17220;
      int Arg_2 = 2;
      int Arg_3 = 2544;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_63_1")
  void testDate_63_1() throws Exception {
    int Arg_1 = 1;
    int Arg_2 = 2;
    int Arg_3 = 7;

    assertEquals("[ 1, 2, 7 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_63_4")
  void testDate_63_4() throws Exception {
    int Arg_1 = 6713;
    int Arg_2 = 2;
    int Arg_3 = 1;

    assertEquals("[ 6713, 2, 1 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_63_5")
  void testDate_63_5() throws Exception {
    int Arg_1 = 13929;
    int Arg_2 = 2;
    int Arg_3 = 2;

    assertEquals("[ 13929, 2, 2 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_64_4")
  void testDate_64_4() throws Exception {
    int Arg_1 = 8900;
    int Arg_2 = 2;
    int Arg_3 = 1;

    assertEquals("[ 8900, 2, 1 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_64_5")
  void testDate_64_5() throws Exception {
    int Arg_1 = 29500;
    int Arg_2 = 2;
    int Arg_3 = 28;

    assertEquals("[ 29500, 2, 28 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_65_3_Exception")
  void testDate_65_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -6460;
      int Arg_2 = 9;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_65_4_Exception")
  void testDate_65_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -18590;
      int Arg_2 = 9;
      int Arg_3 = 30;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_65_5_Exception")
  void testDate_65_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -431;
      int Arg_2 = 9;
      int Arg_3 = 9;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_69_4_Exception")
  void testDate_69_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 20800;
      int Arg_2 = 2;
      int Arg_3 = -24380;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_70_1_Exception")
  void testDate_70_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 2;
      int Arg_3 = 31090;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_70_5_Exception")
  void testDate_70_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 21117;
      int Arg_2 = 2;
      int Arg_3 = 29;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_70_6_Exception")
  void testDate_70_6() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 3347;
      int Arg_2 = 2;
      int Arg_3 = 24461;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_71_5_Exception")
  void testDate_71_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 6900;
      int Arg_2 = 2;
      int Arg_3 = 29;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_71_6_Exception")
  void testDate_71_6() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 2200;
      int Arg_2 = 2;
      int Arg_3 = 28181;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_72_4_Exception")
  void testDate_72_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 6112;
      int Arg_2 = 2;
      int Arg_3 = -2175;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_73_3_Exception")
  void testDate_73_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -16712;
      int Arg_2 = 4;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_73_4_Exception")
  void testDate_73_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -23819;
      int Arg_2 = 4;
      int Arg_3 = 30;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_73_5_Exception")
  void testDate_73_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -19075;
      int Arg_2 = 4;
      int Arg_3 = 2;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_74_3_Exception")
  void testDate_74_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -28002;
      int Arg_2 = 6;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_74_4_Exception")
  void testDate_74_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -31532;
      int Arg_2 = 6;
      int Arg_3 = 30;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_74_5_Exception")
  void testDate_74_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -28509;
      int Arg_2 = 6;
      int Arg_3 = 25;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_77_3_Exception")
  void testDate_77_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 4400;
      int Arg_2 = 10402;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_77_4_Exception")
  void testDate_77_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 14400;
      int Arg_2 = 18371;
      int Arg_3 = 16;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_78_1_Exception")
  void testDate_78_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 2;
      int Arg_3 = -28420;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_78_4_Exception")
  void testDate_78_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 20175;
      int Arg_2 = 2;
      int Arg_3 = -11366;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_79_4_Exception")
  void testDate_79_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 2900;
      int Arg_2 = 2;
      int Arg_3 = -6704;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_80_3_Exception")
  void testDate_80_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 19324;
      int Arg_2 = 23177;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_80_4_Exception")
  void testDate_80_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 24824;
      int Arg_2 = 12195;
      int Arg_3 = 8;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_81_3_Exception")
  void testDate_81_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -4400;
      int Arg_2 = 2;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_81_4_Exception")
  void testDate_81_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -20800;
      int Arg_2 = 2;
      int Arg_3 = 17;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_82_3_Exception")
  void testDate_82_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 13200;
      int Arg_2 = -12122;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_82_4_Exception")
  void testDate_82_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 29600;
      int Arg_2 = -15501;
      int Arg_3 = 23;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_83_1_Exception")
  void testDate_83_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = 29212;
      int Arg_3 = 3;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_83_3_Exception")
  void testDate_83_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 18885;
      int Arg_2 = 19796;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_83_4_Exception")
  void testDate_83_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 23235;
      int Arg_2 = 15471;
      int Arg_3 = 26;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_84_3_Exception")
  void testDate_84_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 3100;
      int Arg_2 = 7075;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_84_4_Exception")
  void testDate_84_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 22100;
      int Arg_2 = 27106;
      int Arg_3 = 15;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_85_3_Exception")
  void testDate_85_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -29628;
      int Arg_2 = 2;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_85_4_Exception")
  void testDate_85_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -8232;
      int Arg_2 = 2;
      int Arg_3 = 10;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_86_3_Exception")
  void testDate_86_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 25884;
      int Arg_2 = -22451;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_86_4_Exception")
  void testDate_86_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 24556;
      int Arg_2 = -279;
      int Arg_3 = 13;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_87_3_Exception")
  void testDate_87_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -13906;
      int Arg_2 = 2;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_87_4_Exception")
  void testDate_87_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -8037;
      int Arg_2 = 2;
      int Arg_3 = 9;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_88_3_Exception")
  void testDate_88_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -19500;
      int Arg_2 = 2;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_88_4_Exception")
  void testDate_88_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -8900;
      int Arg_2 = 2;
      int Arg_3 = 26;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_89_1_Exception")
  void testDate_89_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1;
      int Arg_2 = -31966;
      int Arg_3 = 13;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_89_3_Exception")
  void testDate_89_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 28257;
      int Arg_2 = -26202;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_89_4_Exception")
  void testDate_89_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 4557;
      int Arg_2 = -6637;
      int Arg_3 = 7;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_90_3_Exception")
  void testDate_90_3() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 21900;
      int Arg_2 = -32059;
      int Arg_3 = 1;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_90_4_Exception")
  void testDate_90_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 9700;
      int Arg_2 = -7530;
      int Arg_3 = 13;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_1_1")
  void testnext_1_1() throws Exception {
    Date self = new Date(1, 12, 31);
    assertEquals("[ 2, 1, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_1_3")
  void testnext_1_3() throws Exception {
    Date self = new Date(2968, 12, 31);
    assertEquals("[ 2969, 1, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_2_1")
  void testnext_2_1() throws Exception {
    Date self = new Date(1, 12, 23);
    assertEquals("[ 1, 12, 24 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_2_3")
  void testnext_2_3() throws Exception {
    Date self = new Date(16238, 12, 27);
    assertEquals("[ 16238, 12, 28 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_2_4")
  void testnext_2_4() throws Exception {
    Date self = new Date(27758, 12, 1);
    assertEquals("[ 27758, 12, 2 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_3_1")
  void testnext_3_1() throws Exception {
    Date self = new Date(1, 10, 31);
    assertEquals("[ 1, 11, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_3_5")
  void testnext_3_5() throws Exception {
    Date self = new Date(11446, 10, 31);
    assertEquals("[ 11446, 11, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_4_1")
  void testnext_4_1() throws Exception {
    Date self = new Date(1, 10, 22);
    assertEquals("[ 1, 10, 23 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_4_4")
  void testnext_4_4() throws Exception {
    Date self = new Date(17846, 10, 1);
    assertEquals("[ 17846, 10, 2 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_4_5")
  void testnext_4_5() throws Exception {
    Date self = new Date(23614, 10, 19);
    assertEquals("[ 23614, 10, 20 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_5_1")
  void testnext_5_1() throws Exception {
    Date self = new Date(1, 8, 31);
    assertEquals("[ 1, 9, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_5_5")
  void testnext_5_5() throws Exception {
    Date self = new Date(22658, 8, 31);
    assertEquals("[ 22658, 9, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_6_1")
  void testnext_6_1() throws Exception {
    Date self = new Date(1, 8, 12);
    assertEquals("[ 1, 8, 13 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_6_4")
  void testnext_6_4() throws Exception {
    Date self = new Date(11543, 8, 1);
    assertEquals("[ 11543, 8, 2 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_6_5")
  void testnext_6_5() throws Exception {
    Date self = new Date(29803, 8, 17);
    assertEquals("[ 29803, 8, 18 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_7_1")
  void testnext_7_1() throws Exception {
    Date self = new Date(1, 7, 31);
    assertEquals("[ 1, 8, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_7_5")
  void testnext_7_5() throws Exception {
    Date self = new Date(17561, 7, 31);
    assertEquals("[ 17561, 8, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_8_1")
  void testnext_8_1() throws Exception {
    Date self = new Date(1, 7, 2);
    assertEquals("[ 1, 7, 3 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_8_4")
  void testnext_8_4() throws Exception {
    Date self = new Date(28652, 7, 1);
    assertEquals("[ 28652, 7, 2 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_8_5")
  void testnext_8_5() throws Exception {
    Date self = new Date(7240, 7, 15);
    assertEquals("[ 7240, 7, 16 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_9_1")
  void testnext_9_1() throws Exception {
    Date self = new Date(1, 5, 31);
    assertEquals("[ 1, 6, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_9_5")
  void testnext_9_5() throws Exception {
    Date self = new Date(18464, 5, 31);
    assertEquals("[ 18464, 6, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_10_1")
  void testnext_10_1() throws Exception {
    Date self = new Date(1, 5, 11);
    assertEquals("[ 1, 5, 12 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_10_4")
  void testnext_10_4() throws Exception {
    Date self = new Date(17913, 5, 1);
    assertEquals("[ 17913, 5, 2 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_10_5")
  void testnext_10_5() throws Exception {
    Date self = new Date(9448, 5, 6);
    assertEquals("[ 9448, 5, 7 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_11_1")
  void testnext_11_1() throws Exception {
    Date self = new Date(1, 1, 31);
    assertEquals("[ 1, 2, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_11_2")
  void testnext_11_2() throws Exception {
    Date self = new Date(17782, 1, 31);
    assertEquals("[ 17782, 2, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_12_1")
  void testnext_12_1() throws Exception {
    Date self = new Date(1, 3, 31);
    assertEquals("[ 1, 4, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_12_5")
  void testnext_12_5() throws Exception {
    Date self = new Date(16799, 3, 31);
    assertEquals("[ 16799, 4, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_13_1")
  void testnext_13_1() throws Exception {
    Date self = new Date(1, 11, 30);
    assertEquals("[ 1, 12, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_13_5")
  void testnext_13_5() throws Exception {
    Date self = new Date(18578, 11, 30);
    assertEquals("[ 18578, 12, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_14_1")
  void testnext_14_1() throws Exception {
    Date self = new Date(1, 1, 19);
    assertEquals("[ 1, 1, 20 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_14_2")
  void testnext_14_2() throws Exception {
    Date self = new Date(9513, 1, 18);
    assertEquals("[ 9513, 1, 19 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_14_4")
  void testnext_14_4() throws Exception {
    Date self = new Date(7191, 1, 1);
    assertEquals("[ 7191, 1, 2 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_15_1")
  void testnext_15_1() throws Exception {
    Date self = new Date(1, 3, 15);
    assertEquals("[ 1, 3, 16 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_15_4")
  void testnext_15_4() throws Exception {
    Date self = new Date(19188, 3, 1);
    assertEquals("[ 19188, 3, 2 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_15_5")
  void testnext_15_5() throws Exception {
    Date self = new Date(31969, 3, 15);
    assertEquals("[ 31969, 3, 16 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_16_1")
  void testnext_16_1() throws Exception {
    Date self = new Date(1, 11, 8);
    assertEquals("[ 1, 11, 9 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_16_4")
  void testnext_16_4() throws Exception {
    Date self = new Date(17053, 11, 1);
    assertEquals("[ 17053, 11, 2 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_16_5")
  void testnext_16_5() throws Exception {
    Date self = new Date(7694, 11, 29);
    assertEquals("[ 7694, 11, 30 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_17_1")
  void testnext_17_1() throws Exception {
    Date self = new Date(1, 9, 30);
    assertEquals("[ 1, 10, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_17_5")
  void testnext_17_5() throws Exception {
    Date self = new Date(19997, 9, 30);
    assertEquals("[ 19997, 10, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_18_1")
  void testnext_18_1() throws Exception {
    Date self = new Date(1, 9, 18);
    assertEquals("[ 1, 9, 19 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_18_4")
  void testnext_18_4() throws Exception {
    Date self = new Date(31775, 9, 1);
    assertEquals("[ 31775, 9, 2 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_18_5")
  void testnext_18_5() throws Exception {
    Date self = new Date(2217, 9, 19);
    assertEquals("[ 2217, 9, 20 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_19_1")
  void testnext_19_1() throws Exception {
    Date self = new Date(1, 4, 30);
    assertEquals("[ 1, 5, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_19_5")
  void testnext_19_5() throws Exception {
    Date self = new Date(19441, 4, 30);
    assertEquals("[ 19441, 5, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_20_1")
  void testnext_20_1() throws Exception {
    Date self = new Date(1, 6, 30);
    assertEquals("[ 1, 7, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_20_5")
  void testnext_20_5() throws Exception {
    Date self = new Date(16667, 6, 30);
    assertEquals("[ 16667, 7, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_21_1")
  void testnext_21_1() throws Exception {
    Date self = new Date(1, 4, 24);
    assertEquals("[ 1, 4, 25 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_21_4")
  void testnext_21_4() throws Exception {
    Date self = new Date(21164, 4, 1);
    assertEquals("[ 21164, 4, 2 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_21_5")
  void testnext_21_5() throws Exception {
    Date self = new Date(19252, 4, 4);
    assertEquals("[ 19252, 4, 5 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_22_1")
  void testnext_22_1() throws Exception {
    Date self = new Date(1, 6, 13);
    assertEquals("[ 1, 6, 14 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_22_4")
  void testnext_22_4() throws Exception {
    Date self = new Date(32693, 6, 1);
    assertEquals("[ 32693, 6, 2 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_22_5")
  void testnext_22_5() throws Exception {
    Date self = new Date(17608, 6, 3);
    assertEquals("[ 17608, 6, 4 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_23_5")
  void testnext_23_5() throws Exception {
    Date self = new Date(3200, 2, 29);
    assertEquals("[ 3200, 3, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_24_4")
  void testnext_24_4() throws Exception {
    Date self = new Date(800, 2, 1);
    assertEquals("[ 800, 2, 2 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_24_5")
  void testnext_24_5() throws Exception {
    Date self = new Date(32400, 2, 25);
    assertEquals("[ 32400, 2, 26 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_25_5")
  void testnext_25_5() throws Exception {
    Date self = new Date(2892, 2, 29);
    assertEquals("[ 2892, 3, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_26_4")
  void testnext_26_4() throws Exception {
    Date self = new Date(30956, 2, 1);
    assertEquals("[ 30956, 2, 2 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_26_5")
  void testnext_26_5() throws Exception {
    Date self = new Date(16380, 2, 6);
    assertEquals("[ 16380, 2, 7 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_27_1")
  void testnext_27_1() throws Exception {
    Date self = new Date(1, 2, 28);
    assertEquals("[ 1, 3, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_27_5")
  void testnext_27_5() throws Exception {
    Date self = new Date(14830, 2, 28);
    assertEquals("[ 14830, 3, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_28_5")
  void testnext_28_5() throws Exception {
    Date self = new Date(1000, 2, 28);
    assertEquals("[ 1000, 3, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_29_1")
  void testnext_29_1() throws Exception {
    Date self = new Date(1, 2, 6);
    assertEquals("[ 1, 2, 7 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_29_4")
  void testnext_29_4() throws Exception {
    Date self = new Date(22149, 2, 1);
    assertEquals("[ 22149, 2, 2 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_29_5")
  void testnext_29_5() throws Exception {
    Date self = new Date(13407, 2, 10);
    assertEquals("[ 13407, 2, 11 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_30_4")
  void testnext_30_4() throws Exception {
    Date self = new Date(14200, 2, 1);
    assertEquals("[ 14200, 2, 2 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_30_5")
  void testnext_30_5() throws Exception {
    Date self = new Date(9300, 2, 12);
    assertEquals("[ 9300, 2, 13 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_1_1")
  void testgetYear_1_1() throws Exception {
    Date self = new Date(1, 12, 21);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_1_3")
  void testgetYear_1_3() throws Exception {
    Date self = new Date(3407, 12, 23);
    assertEquals("3407", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_1_4")
  void testgetYear_1_4() throws Exception {
    Date self = new Date(24490, 12, 1);
    assertEquals("24490", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_1_5")
  void testgetYear_1_5() throws Exception {
    Date self = new Date(1, 12, 28);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_1_7")
  void testgetYear_1_7() throws Exception {
    Date self = new Date(423, 12, 28);
    assertEquals("423", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_1_8")
  void testgetYear_1_8() throws Exception {
    Date self = new Date(11945, 12, 1);
    assertEquals("11945", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_1_9")
  void testgetYear_1_9() throws Exception {
    Date self = new Date(19309, 12, 31);
    assertEquals("19309", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_2_1")
  void testgetYear_2_1() throws Exception {
    Date self = new Date(1, 10, 23);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_2_4")
  void testgetYear_2_4() throws Exception {
    Date self = new Date(23293, 10, 1);
    assertEquals("23293", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_2_5")
  void testgetYear_2_5() throws Exception {
    Date self = new Date(1, 10, 5);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_2_8")
  void testgetYear_2_8() throws Exception {
    Date self = new Date(29353, 10, 1);
    assertEquals("29353", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_2_9")
  void testgetYear_2_9() throws Exception {
    Date self = new Date(7775, 10, 31);
    assertEquals("7775", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_2_10")
  void testgetYear_2_10() throws Exception {
    Date self = new Date(2097, 10, 5);
    assertEquals("2097", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_3_1_Exception")
  void testgetYear_3_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 12, 20009);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_3_3_Exception")
  void testgetYear_3_3() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(30408, 12, 21153);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_3_5_Exception")
  void testgetYear_3_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 12, 16908);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_3_7_Exception")
  void testgetYear_3_7() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(8461, 12, 2729);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_4_1")
  void testgetYear_4_1() throws Exception {
    Date self = new Date(1, 8, 27);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_4_4")
  void testgetYear_4_4() throws Exception {
    Date self = new Date(17924, 8, 1);
    assertEquals("17924", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_4_5")
  void testgetYear_4_5() throws Exception {
    Date self = new Date(1, 8, 19);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_4_8")
  void testgetYear_4_8() throws Exception {
    Date self = new Date(31730, 8, 1);
    assertEquals("31730", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_4_9")
  void testgetYear_4_9() throws Exception {
    Date self = new Date(26764, 8, 31);
    assertEquals("26764", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_4_10")
  void testgetYear_4_10() throws Exception {
    Date self = new Date(10396, 8, 24);
    assertEquals("10396", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_6_1_Exception")
  void testgetYear_6_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 10, 1249);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_6_5_Exception")
  void testgetYear_6_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 10, 29383);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_6_9_Exception")
  void testgetYear_6_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(19071, 10, 8930);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_7_1")
  void testgetYear_7_1() throws Exception {
    Date self = new Date(1, 7, 15);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_7_4")
  void testgetYear_7_4() throws Exception {
    Date self = new Date(26190, 7, 1);
    assertEquals("26190", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_7_5")
  void testgetYear_7_5() throws Exception {
    Date self = new Date(1, 7, 8);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_7_8")
  void testgetYear_7_8() throws Exception {
    Date self = new Date(4351, 7, 1);
    assertEquals("4351", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_7_9")
  void testgetYear_7_9() throws Exception {
    Date self = new Date(900, 7, 31);
    assertEquals("900", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_7_10")
  void testgetYear_7_10() throws Exception {
    Date self = new Date(14543, 7, 17);
    assertEquals("14543", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_10_1_Exception")
  void testgetYear_10_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 8, 26162);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_10_5_Exception")
  void testgetYear_10_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 8, 16613);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_10_9_Exception")
  void testgetYear_10_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(18592, 8, 22806);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_11_1")
  void testgetYear_11_1() throws Exception {
    Date self = new Date(1, 5, 19);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_11_4")
  void testgetYear_11_4() throws Exception {
    Date self = new Date(24476, 5, 1);
    assertEquals("24476", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_11_5")
  void testgetYear_11_5() throws Exception {
    Date self = new Date(1, 5, 12);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_11_8")
  void testgetYear_11_8() throws Exception {
    Date self = new Date(13302, 5, 1);
    assertEquals("13302", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_11_9")
  void testgetYear_11_9() throws Exception {
    Date self = new Date(23349, 5, 31);
    assertEquals("23349", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_11_10")
  void testgetYear_11_10() throws Exception {
    Date self = new Date(6051, 5, 7);
    assertEquals("6051", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_16_1_Exception")
  void testgetYear_16_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 7, 30311);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_16_5_Exception")
  void testgetYear_16_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 7, 19574);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_16_9_Exception")
  void testgetYear_16_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(5930, 7, 9202);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_17_1")
  void testgetYear_17_1() throws Exception {
    Date self = new Date(1, 11, 11);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_17_4")
  void testgetYear_17_4() throws Exception {
    Date self = new Date(22813, 11, 1);
    assertEquals("22813", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_17_5")
  void testgetYear_17_5() throws Exception {
    Date self = new Date(1, 11, 17);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_17_8")
  void testgetYear_17_8() throws Exception {
    Date self = new Date(25252, 11, 1);
    assertEquals("25252", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_17_9")
  void testgetYear_17_9() throws Exception {
    Date self = new Date(30499, 11, 30);
    assertEquals("30499", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_17_10")
  void testgetYear_17_10() throws Exception {
    Date self = new Date(10553, 11, 3);
    assertEquals("10553", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_18_1")
  void testgetYear_18_1() throws Exception {
    Date self = new Date(1, 1, 20);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_18_2")
  void testgetYear_18_2() throws Exception {
    Date self = new Date(22596, 1, 28);
    assertEquals("22596", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_18_4")
  void testgetYear_18_4() throws Exception {
    Date self = new Date(12550, 1, 1);
    assertEquals("12550", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_18_5")
  void testgetYear_18_5() throws Exception {
    Date self = new Date(1, 1, 11);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_18_6")
  void testgetYear_18_6() throws Exception {
    Date self = new Date(26753, 1, 23);
    assertEquals("26753", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_18_8")
  void testgetYear_18_8() throws Exception {
    Date self = new Date(15787, 1, 1);
    assertEquals("15787", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_18_9")
  void testgetYear_18_9() throws Exception {
    Date self = new Date(27567, 1, 31);
    assertEquals("27567", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_19_1")
  void testgetYear_19_1() throws Exception {
    Date self = new Date(1, 3, 24);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_19_4")
  void testgetYear_19_4() throws Exception {
    Date self = new Date(28440, 3, 1);
    assertEquals("28440", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_19_5")
  void testgetYear_19_5() throws Exception {
    Date self = new Date(1, 3, 4);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_19_8")
  void testgetYear_19_8() throws Exception {
    Date self = new Date(27996, 3, 1);
    assertEquals("27996", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_19_9")
  void testgetYear_19_9() throws Exception {
    Date self = new Date(7617, 3, 31);
    assertEquals("7617", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_19_10")
  void testgetYear_19_10() throws Exception {
    Date self = new Date(15347, 3, 15);
    assertEquals("15347", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_24_1_Exception")
  void testgetYear_24_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 5, 26127);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_24_5_Exception")
  void testgetYear_24_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 5, 2109);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_24_9_Exception")
  void testgetYear_24_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(25614, 5, 9568);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_25_1")
  void testgetYear_25_1() throws Exception {
    Date self = new Date(1, 9, 16);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_25_4")
  void testgetYear_25_4() throws Exception {
    Date self = new Date(13938, 9, 1);
    assertEquals("13938", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_25_5")
  void testgetYear_25_5() throws Exception {
    Date self = new Date(1, 9, 18);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_25_8")
  void testgetYear_25_8() throws Exception {
    Date self = new Date(24750, 9, 1);
    assertEquals("24750", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_25_9")
  void testgetYear_25_9() throws Exception {
    Date self = new Date(1992, 9, 30);
    assertEquals("1992", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_25_10")
  void testgetYear_25_10() throws Exception {
    Date self = new Date(10029, 9, 5);
    assertEquals("10029", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_26_1_Exception")
  void testgetYear_26_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 11, 23148);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_26_5_Exception")
  void testgetYear_26_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 11, 3513);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_26_9_Exception")
  void testgetYear_26_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(21344, 11, 18830);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_31_1_Exception")
  void testgetYear_31_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 1, 12817);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_31_2_Exception")
  void testgetYear_31_2() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(28049, 1, 13786);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_31_5_Exception")
  void testgetYear_31_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 1, 29475);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_31_6_Exception")
  void testgetYear_31_6() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(21128, 1, 14010);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_32_1_Exception")
  void testgetYear_32_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 3, 5351);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_32_5_Exception")
  void testgetYear_32_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 3, 1245);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_32_9_Exception")
  void testgetYear_32_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(6212, 3, 8765);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_33_1")
  void testgetYear_33_1() throws Exception {
    Date self = new Date(1, 4, 8);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_33_4")
  void testgetYear_33_4() throws Exception {
    Date self = new Date(18612, 4, 1);
    assertEquals("18612", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_33_5")
  void testgetYear_33_5() throws Exception {
    Date self = new Date(1, 4, 13);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_33_8")
  void testgetYear_33_8() throws Exception {
    Date self = new Date(5105, 4, 1);
    assertEquals("5105", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_33_9")
  void testgetYear_33_9() throws Exception {
    Date self = new Date(17229, 4, 30);
    assertEquals("17229", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_33_10")
  void testgetYear_33_10() throws Exception {
    Date self = new Date(6891, 4, 22);
    assertEquals("6891", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_34_1")
  void testgetYear_34_1() throws Exception {
    Date self = new Date(1, 6, 4);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_34_4")
  void testgetYear_34_4() throws Exception {
    Date self = new Date(15446, 6, 1);
    assertEquals("15446", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_34_5")
  void testgetYear_34_5() throws Exception {
    Date self = new Date(1, 6, 1);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_34_8")
  void testgetYear_34_8() throws Exception {
    Date self = new Date(14339, 6, 1);
    assertEquals("14339", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_34_9")
  void testgetYear_34_9() throws Exception {
    Date self = new Date(28572, 6, 30);
    assertEquals("28572", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_34_10")
  void testgetYear_34_10() throws Exception {
    Date self = new Date(9997, 6, 12);
    assertEquals("9997", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_36_1_Exception")
  void testgetYear_36_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 9, 27747);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_36_5_Exception")
  void testgetYear_36_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 9, 1856);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_36_9_Exception")
  void testgetYear_36_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(22663, 9, 25785);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_42_4")
  void testgetYear_42_4() throws Exception {
    Date self = new Date(23200, 2, 1);
    assertEquals("23200", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_42_8")
  void testgetYear_42_8() throws Exception {
    Date self = new Date(800, 2, 1);
    assertEquals("800", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_42_9")
  void testgetYear_42_9() throws Exception {
    Date self = new Date(7600, 2, 29);
    assertEquals("7600", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_42_10")
  void testgetYear_42_10() throws Exception {
    Date self = new Date(26400, 2, 3);
    assertEquals("26400", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_45_1_Exception")
  void testgetYear_45_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 4, 14162);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_45_5_Exception")
  void testgetYear_45_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 4, 16424);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_45_9_Exception")
  void testgetYear_45_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(10961, 4, 7970);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_46_1_Exception")
  void testgetYear_46_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 6, 30415);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_46_5_Exception")
  void testgetYear_46_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 6, 26725);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_46_9_Exception")
  void testgetYear_46_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(8133, 6, 4409);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_47_4")
  void testgetYear_47_4() throws Exception {
    Date self = new Date(17456, 2, 1);
    assertEquals("17456", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_47_8")
  void testgetYear_47_8() throws Exception {
    Date self = new Date(28156, 2, 1);
    assertEquals("28156", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_47_9")
  void testgetYear_47_9() throws Exception {
    Date self = new Date(25216, 2, 29);
    assertEquals("25216", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_47_10")
  void testgetYear_47_10() throws Exception {
    Date self = new Date(9360, 2, 4);
    assertEquals("9360", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_52_1")
  void testgetYear_52_1() throws Exception {
    Date self = new Date(1, 2, 9);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_52_4")
  void testgetYear_52_4() throws Exception {
    Date self = new Date(21135, 2, 1);
    assertEquals("21135", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_52_5")
  void testgetYear_52_5() throws Exception {
    Date self = new Date(1, 2, 24);
    assertEquals("1", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_52_8")
  void testgetYear_52_8() throws Exception {
    Date self = new Date(14043, 2, 1);
    assertEquals("14043", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_52_9")
  void testgetYear_52_9() throws Exception {
    Date self = new Date(14195, 2, 28);
    assertEquals("14195", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_52_10")
  void testgetYear_52_10() throws Exception {
    Date self = new Date(21141, 2, 8);
    assertEquals("21141", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_53_4")
  void testgetYear_53_4() throws Exception {
    Date self = new Date(29500, 2, 1);
    assertEquals("29500", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_53_8")
  void testgetYear_53_8() throws Exception {
    Date self = new Date(8100, 2, 1);
    assertEquals("8100", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_53_9")
  void testgetYear_53_9() throws Exception {
    Date self = new Date(30900, 2, 28);
    assertEquals("30900", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_53_10")
  void testgetYear_53_10() throws Exception {
    Date self = new Date(6100, 2, 25);
    assertEquals("6100", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_59_9_Exception")
  void testgetYear_59_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(22400, 2, 28776);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_64_9_Exception")
  void testgetYear_64_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(30024, 2, 14092);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_70_1_Exception")
  void testgetYear_70_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 2, 19965);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_70_5_Exception")
  void testgetYear_70_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 2, 5426);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_70_9_Exception")
  void testgetYear_70_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(22783, 2, 12262);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_71_9_Exception")
  void testgetYear_71_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(600, 2, 660);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_1_1")
  void testgetMonth_1_1() throws Exception {
    Date self = new Date(1, 12, 27);
    assertEquals("12", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_1_3")
  void testgetMonth_1_3() throws Exception {
    Date self = new Date(4231, 12, 14);
    assertEquals("12", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_1_4")
  void testgetMonth_1_4() throws Exception {
    Date self = new Date(26510, 12, 1);
    assertEquals("12", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_1_5")
  void testgetMonth_1_5() throws Exception {
    Date self = new Date(1, 12, 1);
    assertEquals("12", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_1_7")
  void testgetMonth_1_7() throws Exception {
    Date self = new Date(4051, 12, 24);
    assertEquals("12", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_1_8")
  void testgetMonth_1_8() throws Exception {
    Date self = new Date(1161, 12, 1);
    assertEquals("12", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_1_9")
  void testgetMonth_1_9() throws Exception {
    Date self = new Date(16788, 12, 31);
    assertEquals("12", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_2_1")
  void testgetMonth_2_1() throws Exception {
    Date self = new Date(1, 10, 20);
    assertEquals("10", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_2_4")
  void testgetMonth_2_4() throws Exception {
    Date self = new Date(7721, 10, 1);
    assertEquals("10", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_2_5")
  void testgetMonth_2_5() throws Exception {
    Date self = new Date(1, 10, 8);
    assertEquals("10", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_2_8")
  void testgetMonth_2_8() throws Exception {
    Date self = new Date(3356, 10, 1);
    assertEquals("10", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_2_9")
  void testgetMonth_2_9() throws Exception {
    Date self = new Date(14808, 10, 31);
    assertEquals("10", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_2_10")
  void testgetMonth_2_10() throws Exception {
    Date self = new Date(4822, 10, 19);
    assertEquals("10", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_3_1_Exception")
  void testgetMonth_3_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 12, 2616);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_3_3_Exception")
  void testgetMonth_3_3() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(516, 12, 12734);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_3_5_Exception")
  void testgetMonth_3_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 12, 19098);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_3_7_Exception")
  void testgetMonth_3_7() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(3919, 12, 513);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_4_1")
  void testgetMonth_4_1() throws Exception {
    Date self = new Date(1, 8, 3);
    assertEquals("8", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_4_4")
  void testgetMonth_4_4() throws Exception {
    Date self = new Date(13580, 8, 1);
    assertEquals("8", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_4_5")
  void testgetMonth_4_5() throws Exception {
    Date self = new Date(1, 8, 24);
    assertEquals("8", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_4_8")
  void testgetMonth_4_8() throws Exception {
    Date self = new Date(30845, 8, 1);
    assertEquals("8", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_4_9")
  void testgetMonth_4_9() throws Exception {
    Date self = new Date(2849, 8, 31);
    assertEquals("8", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_4_10")
  void testgetMonth_4_10() throws Exception {
    Date self = new Date(26849, 8, 10);
    assertEquals("8", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_6_1_Exception")
  void testgetMonth_6_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 10, 16717);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_6_5_Exception")
  void testgetMonth_6_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 10, 13973);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_6_9_Exception")
  void testgetMonth_6_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(10269, 10, 31303);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_7_1")
  void testgetMonth_7_1() throws Exception {
    Date self = new Date(1, 7, 4);
    assertEquals("7", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_7_4")
  void testgetMonth_7_4() throws Exception {
    Date self = new Date(27506, 7, 1);
    assertEquals("7", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_7_5")
  void testgetMonth_7_5() throws Exception {
    Date self = new Date(1, 7, 13);
    assertEquals("7", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_7_8")
  void testgetMonth_7_8() throws Exception {
    Date self = new Date(17529, 7, 1);
    assertEquals("7", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_7_9")
  void testgetMonth_7_9() throws Exception {
    Date self = new Date(17524, 7, 31);
    assertEquals("7", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_7_10")
  void testgetMonth_7_10() throws Exception {
    Date self = new Date(5658, 7, 20);
    assertEquals("7", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_10_1_Exception")
  void testgetMonth_10_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 8, 18479);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_10_5_Exception")
  void testgetMonth_10_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 8, 6661);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_10_9_Exception")
  void testgetMonth_10_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(21738, 8, 27728);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_11_1")
  void testgetMonth_11_1() throws Exception {
    Date self = new Date(1, 5, 2);
    assertEquals("5", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_11_4")
  void testgetMonth_11_4() throws Exception {
    Date self = new Date(28858, 5, 1);
    assertEquals("5", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_11_5")
  void testgetMonth_11_5() throws Exception {
    Date self = new Date(1, 5, 3);
    assertEquals("5", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_11_8")
  void testgetMonth_11_8() throws Exception {
    Date self = new Date(22298, 5, 1);
    assertEquals("5", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_11_9")
  void testgetMonth_11_9() throws Exception {
    Date self = new Date(21143, 5, 31);
    assertEquals("5", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_11_10")
  void testgetMonth_11_10() throws Exception {
    Date self = new Date(27170, 5, 18);
    assertEquals("5", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_16_1_Exception")
  void testgetMonth_16_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 7, 7648);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_16_5_Exception")
  void testgetMonth_16_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 7, 387);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_16_9_Exception")
  void testgetMonth_16_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(4562, 7, 7098);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_17_1")
  void testgetMonth_17_1() throws Exception {
    Date self = new Date(1, 11, 25);
    assertEquals("11", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_17_4")
  void testgetMonth_17_4() throws Exception {
    Date self = new Date(21442, 11, 1);
    assertEquals("11", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_17_5")
  void testgetMonth_17_5() throws Exception {
    Date self = new Date(1, 11, 14);
    assertEquals("11", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_17_8")
  void testgetMonth_17_8() throws Exception {
    Date self = new Date(1377, 11, 1);
    assertEquals("11", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_17_9")
  void testgetMonth_17_9() throws Exception {
    Date self = new Date(5580, 11, 30);
    assertEquals("11", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_17_10")
  void testgetMonth_17_10() throws Exception {
    Date self = new Date(19867, 11, 5);
    assertEquals("11", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_18_1")
  void testgetMonth_18_1() throws Exception {
    Date self = new Date(1, 1, 25);
    assertEquals("1", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_18_2")
  void testgetMonth_18_2() throws Exception {
    Date self = new Date(28920, 1, 5);
    assertEquals("1", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_18_4")
  void testgetMonth_18_4() throws Exception {
    Date self = new Date(13213, 1, 1);
    assertEquals("1", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_18_5")
  void testgetMonth_18_5() throws Exception {
    Date self = new Date(1, 1, 10);
    assertEquals("1", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_18_6")
  void testgetMonth_18_6() throws Exception {
    Date self = new Date(24700, 1, 31);
    assertEquals("1", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_18_8")
  void testgetMonth_18_8() throws Exception {
    Date self = new Date(2365, 1, 1);
    assertEquals("1", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_18_9")
  void testgetMonth_18_9() throws Exception {
    Date self = new Date(24122, 1, 31);
    assertEquals("1", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_19_1")
  void testgetMonth_19_1() throws Exception {
    Date self = new Date(1, 3, 23);
    assertEquals("3", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_19_4")
  void testgetMonth_19_4() throws Exception {
    Date self = new Date(17082, 3, 1);
    assertEquals("3", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_19_5")
  void testgetMonth_19_5() throws Exception {
    Date self = new Date(1, 3, 21);
    assertEquals("3", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_19_8")
  void testgetMonth_19_8() throws Exception {
    Date self = new Date(21166, 3, 1);
    assertEquals("3", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_19_9")
  void testgetMonth_19_9() throws Exception {
    Date self = new Date(23254, 3, 31);
    assertEquals("3", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_19_10")
  void testgetMonth_19_10() throws Exception {
    Date self = new Date(19519, 3, 25);
    assertEquals("3", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_24_1_Exception")
  void testgetMonth_24_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 5, 25753);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_24_5_Exception")
  void testgetMonth_24_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 5, 14893);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_24_9_Exception")
  void testgetMonth_24_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(25260, 5, 21246);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_25_1")
  void testgetMonth_25_1() throws Exception {
    Date self = new Date(1, 9, 30);
    assertEquals("9", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_25_4")
  void testgetMonth_25_4() throws Exception {
    Date self = new Date(27750, 9, 1);
    assertEquals("9", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_25_5")
  void testgetMonth_25_5() throws Exception {
    Date self = new Date(1, 9, 9);
    assertEquals("9", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_25_8")
  void testgetMonth_25_8() throws Exception {
    Date self = new Date(5793, 9, 1);
    assertEquals("9", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_25_9")
  void testgetMonth_25_9() throws Exception {
    Date self = new Date(31805, 9, 30);
    assertEquals("9", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_25_10")
  void testgetMonth_25_10() throws Exception {
    Date self = new Date(26186, 9, 27);
    assertEquals("9", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_26_1_Exception")
  void testgetMonth_26_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 11, 3079);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_26_5_Exception")
  void testgetMonth_26_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 11, 30955);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_26_9_Exception")
  void testgetMonth_26_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1034, 11, 3592);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_31_1_Exception")
  void testgetMonth_31_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 1, 18443);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_31_2_Exception")
  void testgetMonth_31_2() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(11631, 1, 21077);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_31_5_Exception")
  void testgetMonth_31_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 1, 21985);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_31_6_Exception")
  void testgetMonth_31_6() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(12978, 1, 21307);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_32_1_Exception")
  void testgetMonth_32_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 3, 18866);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_32_5_Exception")
  void testgetMonth_32_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 3, 14777);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_32_9_Exception")
  void testgetMonth_32_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(14672, 3, 24148);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_33_1")
  void testgetMonth_33_1() throws Exception {
    Date self = new Date(1, 4, 15);
    assertEquals("4", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_33_4")
  void testgetMonth_33_4() throws Exception {
    Date self = new Date(22921, 4, 1);
    assertEquals("4", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_33_5")
  void testgetMonth_33_5() throws Exception {
    Date self = new Date(1, 4, 4);
    assertEquals("4", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_33_8")
  void testgetMonth_33_8() throws Exception {
    Date self = new Date(3321, 4, 1);
    assertEquals("4", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_33_9")
  void testgetMonth_33_9() throws Exception {
    Date self = new Date(15485, 4, 30);
    assertEquals("4", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_33_10")
  void testgetMonth_33_10() throws Exception {
    Date self = new Date(16260, 4, 9);
    assertEquals("4", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_34_1")
  void testgetMonth_34_1() throws Exception {
    Date self = new Date(1, 6, 15);
    assertEquals("6", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_34_4")
  void testgetMonth_34_4() throws Exception {
    Date self = new Date(5518, 6, 1);
    assertEquals("6", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_34_5")
  void testgetMonth_34_5() throws Exception {
    Date self = new Date(1, 6, 20);
    assertEquals("6", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_34_8")
  void testgetMonth_34_8() throws Exception {
    Date self = new Date(15860, 6, 1);
    assertEquals("6", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_34_9")
  void testgetMonth_34_9() throws Exception {
    Date self = new Date(30534, 6, 30);
    assertEquals("6", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_34_10")
  void testgetMonth_34_10() throws Exception {
    Date self = new Date(13601, 6, 2);
    assertEquals("6", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_36_1_Exception")
  void testgetMonth_36_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 9, 9062);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_36_5_Exception")
  void testgetMonth_36_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 9, 16958);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_36_9_Exception")
  void testgetMonth_36_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(8505, 9, 9948);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_42_4")
  void testgetMonth_42_4() throws Exception {
    Date self = new Date(22800, 2, 1);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_42_8")
  void testgetMonth_42_8() throws Exception {
    Date self = new Date(25200, 2, 1);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_42_9")
  void testgetMonth_42_9() throws Exception {
    Date self = new Date(26400, 2, 29);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_42_10")
  void testgetMonth_42_10() throws Exception {
    Date self = new Date(26400, 2, 23);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_45_1_Exception")
  void testgetMonth_45_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 4, 4030);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_45_5_Exception")
  void testgetMonth_45_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 4, 17190);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_45_9_Exception")
  void testgetMonth_45_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(9228, 4, 25212);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_46_1_Exception")
  void testgetMonth_46_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 6, 22271);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_46_5_Exception")
  void testgetMonth_46_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 6, 23359);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_46_9_Exception")
  void testgetMonth_46_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(14396, 6, 2337);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_47_4")
  void testgetMonth_47_4() throws Exception {
    Date self = new Date(21608, 2, 1);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_47_8")
  void testgetMonth_47_8() throws Exception {
    Date self = new Date(4216, 2, 1);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_47_9")
  void testgetMonth_47_9() throws Exception {
    Date self = new Date(22312, 2, 29);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_47_10")
  void testgetMonth_47_10() throws Exception {
    Date self = new Date(24208, 2, 20);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_52_1")
  void testgetMonth_52_1() throws Exception {
    Date self = new Date(1, 2, 27);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_52_4")
  void testgetMonth_52_4() throws Exception {
    Date self = new Date(10933, 2, 1);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_52_5")
  void testgetMonth_52_5() throws Exception {
    Date self = new Date(1, 2, 20);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_52_8")
  void testgetMonth_52_8() throws Exception {
    Date self = new Date(29129, 2, 1);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_52_9")
  void testgetMonth_52_9() throws Exception {
    Date self = new Date(6375, 2, 28);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_52_10")
  void testgetMonth_52_10() throws Exception {
    Date self = new Date(19981, 2, 4);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_53_4")
  void testgetMonth_53_4() throws Exception {
    Date self = new Date(6100, 2, 1);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_53_8")
  void testgetMonth_53_8() throws Exception {
    Date self = new Date(25900, 2, 1);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_53_9")
  void testgetMonth_53_9() throws Exception {
    Date self = new Date(16600, 2, 28);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_53_10")
  void testgetMonth_53_10() throws Exception {
    Date self = new Date(14600, 2, 21);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_59_9_Exception")
  void testgetMonth_59_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(6000, 2, 10889);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_64_9_Exception")
  void testgetMonth_64_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(7732, 2, 22082);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_70_1_Exception")
  void testgetMonth_70_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 2, 6762);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_70_5_Exception")
  void testgetMonth_70_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 2, 23177);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_70_9_Exception")
  void testgetMonth_70_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(27363, 2, 16410);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_71_9_Exception")
  void testgetMonth_71_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(26500, 2, 29918);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_1_1")
  void testgetDay_1_1() throws Exception {
    Date self = new Date(1, 12, 5);
    assertEquals("5", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_1_3")
  void testgetDay_1_3() throws Exception {
    Date self = new Date(27184, 12, 8);
    assertEquals("8", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_1_4")
  void testgetDay_1_4() throws Exception {
    Date self = new Date(24431, 12, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_1_5")
  void testgetDay_1_5() throws Exception {
    Date self = new Date(1, 12, 9);
    assertEquals("9", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_1_7")
  void testgetDay_1_7() throws Exception {
    Date self = new Date(17059, 12, 29);
    assertEquals("29", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_1_8")
  void testgetDay_1_8() throws Exception {
    Date self = new Date(13406, 12, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_1_9")
  void testgetDay_1_9() throws Exception {
    Date self = new Date(21476, 12, 31);
    assertEquals("31", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_2_1")
  void testgetDay_2_1() throws Exception {
    Date self = new Date(1, 10, 12);
    assertEquals("12", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_2_4")
  void testgetDay_2_4() throws Exception {
    Date self = new Date(21583, 10, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_2_5")
  void testgetDay_2_5() throws Exception {
    Date self = new Date(1, 10, 27);
    assertEquals("27", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_2_8")
  void testgetDay_2_8() throws Exception {
    Date self = new Date(7257, 10, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_2_9")
  void testgetDay_2_9() throws Exception {
    Date self = new Date(26104, 10, 31);
    assertEquals("31", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_2_10")
  void testgetDay_2_10() throws Exception {
    Date self = new Date(19726, 10, 17);
    assertEquals("17", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_3_1_Exception")
  void testgetDay_3_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 12, 24050);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_3_3_Exception")
  void testgetDay_3_3() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(5981, 12, 17449);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_3_5_Exception")
  void testgetDay_3_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 12, 12827);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_3_7_Exception")
  void testgetDay_3_7() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(6453, 12, 23686);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_4_1")
  void testgetDay_4_1() throws Exception {
    Date self = new Date(1, 8, 18);
    assertEquals("18", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_4_4")
  void testgetDay_4_4() throws Exception {
    Date self = new Date(25832, 8, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_4_5")
  void testgetDay_4_5() throws Exception {
    Date self = new Date(1, 8, 7);
    assertEquals("7", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_4_8")
  void testgetDay_4_8() throws Exception {
    Date self = new Date(3107, 8, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_4_9")
  void testgetDay_4_9() throws Exception {
    Date self = new Date(9133, 8, 31);
    assertEquals("31", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_4_10")
  void testgetDay_4_10() throws Exception {
    Date self = new Date(31999, 8, 15);
    assertEquals("15", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_6_1_Exception")
  void testgetDay_6_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 10, 12525);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_6_5_Exception")
  void testgetDay_6_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 10, 5268);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_6_9_Exception")
  void testgetDay_6_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(13348, 10, 29422);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_7_1")
  void testgetDay_7_1() throws Exception {
    Date self = new Date(1, 7, 6);
    assertEquals("6", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_7_4")
  void testgetDay_7_4() throws Exception {
    Date self = new Date(32343, 7, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_7_5")
  void testgetDay_7_5() throws Exception {
    Date self = new Date(1, 7, 8);
    assertEquals("8", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_7_8")
  void testgetDay_7_8() throws Exception {
    Date self = new Date(31465, 7, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_7_9")
  void testgetDay_7_9() throws Exception {
    Date self = new Date(9333, 7, 31);
    assertEquals("31", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_7_10")
  void testgetDay_7_10() throws Exception {
    Date self = new Date(27338, 7, 18);
    assertEquals("18", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_10_1_Exception")
  void testgetDay_10_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 8, 28682);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_10_5_Exception")
  void testgetDay_10_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 8, 27139);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_10_9_Exception")
  void testgetDay_10_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(17059, 8, 26581);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_11_1")
  void testgetDay_11_1() throws Exception {
    Date self = new Date(1, 5, 15);
    assertEquals("15", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_11_4")
  void testgetDay_11_4() throws Exception {
    Date self = new Date(29811, 5, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_11_5")
  void testgetDay_11_5() throws Exception {
    Date self = new Date(1, 5, 20);
    assertEquals("20", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_11_8")
  void testgetDay_11_8() throws Exception {
    Date self = new Date(16752, 5, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_11_9")
  void testgetDay_11_9() throws Exception {
    Date self = new Date(17543, 5, 31);
    assertEquals("31", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_11_10")
  void testgetDay_11_10() throws Exception {
    Date self = new Date(17572, 5, 18);
    assertEquals("18", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_16_1_Exception")
  void testgetDay_16_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 7, 28054);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_16_5_Exception")
  void testgetDay_16_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 7, 1501);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_16_9_Exception")
  void testgetDay_16_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(10279, 7, 780);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_17_1")
  void testgetDay_17_1() throws Exception {
    Date self = new Date(1, 11, 21);
    assertEquals("21", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_17_4")
  void testgetDay_17_4() throws Exception {
    Date self = new Date(5760, 11, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_17_5")
  void testgetDay_17_5() throws Exception {
    Date self = new Date(1, 11, 18);
    assertEquals("18", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_17_8")
  void testgetDay_17_8() throws Exception {
    Date self = new Date(134, 11, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_17_9")
  void testgetDay_17_9() throws Exception {
    Date self = new Date(30719, 11, 30);
    assertEquals("30", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_17_10")
  void testgetDay_17_10() throws Exception {
    Date self = new Date(4947, 11, 15);
    assertEquals("15", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_18_1")
  void testgetDay_18_1() throws Exception {
    Date self = new Date(1, 1, 3);
    assertEquals("3", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_18_2")
  void testgetDay_18_2() throws Exception {
    Date self = new Date(23679, 1, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_18_4")
  void testgetDay_18_4() throws Exception {
    Date self = new Date(27718, 1, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_18_5")
  void testgetDay_18_5() throws Exception {
    Date self = new Date(1, 1, 22);
    assertEquals("22", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_18_6")
  void testgetDay_18_6() throws Exception {
    Date self = new Date(22680, 1, 27);
    assertEquals("27", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_18_8")
  void testgetDay_18_8() throws Exception {
    Date self = new Date(7711, 1, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_18_9")
  void testgetDay_18_9() throws Exception {
    Date self = new Date(6922, 1, 31);
    assertEquals("31", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_19_1")
  void testgetDay_19_1() throws Exception {
    Date self = new Date(1, 3, 8);
    assertEquals("8", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_19_4")
  void testgetDay_19_4() throws Exception {
    Date self = new Date(16920, 3, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_19_5")
  void testgetDay_19_5() throws Exception {
    Date self = new Date(1, 3, 17);
    assertEquals("17", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_19_8")
  void testgetDay_19_8() throws Exception {
    Date self = new Date(9519, 3, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_19_9")
  void testgetDay_19_9() throws Exception {
    Date self = new Date(2706, 3, 31);
    assertEquals("31", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_19_10")
  void testgetDay_19_10() throws Exception {
    Date self = new Date(28721, 3, 18);
    assertEquals("18", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_24_1_Exception")
  void testgetDay_24_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 5, 18027);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_24_5_Exception")
  void testgetDay_24_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 5, 14441);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_24_9_Exception")
  void testgetDay_24_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(7015, 5, 13815);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_25_1")
  void testgetDay_25_1() throws Exception {
    Date self = new Date(1, 9, 29);
    assertEquals("29", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_25_4")
  void testgetDay_25_4() throws Exception {
    Date self = new Date(32235, 9, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_25_5")
  void testgetDay_25_5() throws Exception {
    Date self = new Date(1, 9, 19);
    assertEquals("19", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_25_8")
  void testgetDay_25_8() throws Exception {
    Date self = new Date(15925, 9, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_25_9")
  void testgetDay_25_9() throws Exception {
    Date self = new Date(24762, 9, 30);
    assertEquals("30", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_25_10")
  void testgetDay_25_10() throws Exception {
    Date self = new Date(3405, 9, 23);
    assertEquals("23", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_26_1_Exception")
  void testgetDay_26_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 11, 15742);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_26_5_Exception")
  void testgetDay_26_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 11, 2661);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_26_9_Exception")
  void testgetDay_26_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(22206, 11, 4042);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_31_1_Exception")
  void testgetDay_31_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 1, 20456);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_31_2_Exception")
  void testgetDay_31_2() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(29901, 1, 26507);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_31_5_Exception")
  void testgetDay_31_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 1, 360);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_31_6_Exception")
  void testgetDay_31_6() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(8712, 1, 24023);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_32_1_Exception")
  void testgetDay_32_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 3, 27626);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_32_5_Exception")
  void testgetDay_32_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 3, 11912);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_32_9_Exception")
  void testgetDay_32_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(6691, 3, 13688);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_33_1")
  void testgetDay_33_1() throws Exception {
    Date self = new Date(1, 4, 14);
    assertEquals("14", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_33_4")
  void testgetDay_33_4() throws Exception {
    Date self = new Date(13277, 4, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_33_5")
  void testgetDay_33_5() throws Exception {
    Date self = new Date(1, 4, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_33_8")
  void testgetDay_33_8() throws Exception {
    Date self = new Date(26141, 4, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_33_9")
  void testgetDay_33_9() throws Exception {
    Date self = new Date(25842, 4, 30);
    assertEquals("30", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_33_10")
  void testgetDay_33_10() throws Exception {
    Date self = new Date(10762, 4, 26);
    assertEquals("26", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_34_1")
  void testgetDay_34_1() throws Exception {
    Date self = new Date(1, 6, 19);
    assertEquals("19", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_34_4")
  void testgetDay_34_4() throws Exception {
    Date self = new Date(23423, 6, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_34_5")
  void testgetDay_34_5() throws Exception {
    Date self = new Date(1, 6, 8);
    assertEquals("8", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_34_8")
  void testgetDay_34_8() throws Exception {
    Date self = new Date(23286, 6, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_34_9")
  void testgetDay_34_9() throws Exception {
    Date self = new Date(16972, 6, 30);
    assertEquals("30", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_34_10")
  void testgetDay_34_10() throws Exception {
    Date self = new Date(27110, 6, 14);
    assertEquals("14", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_36_1_Exception")
  void testgetDay_36_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 9, 30889);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_36_5_Exception")
  void testgetDay_36_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 9, 17239);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_36_9_Exception")
  void testgetDay_36_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(9098, 9, 25662);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_42_4")
  void testgetDay_42_4() throws Exception {
    Date self = new Date(5600, 2, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_42_8")
  void testgetDay_42_8() throws Exception {
    Date self = new Date(26000, 2, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_42_9")
  void testgetDay_42_9() throws Exception {
    Date self = new Date(1200, 2, 29);
    assertEquals("29", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_42_10")
  void testgetDay_42_10() throws Exception {
    Date self = new Date(6000, 2, 23);
    assertEquals("23", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_45_1_Exception")
  void testgetDay_45_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 4, 15312);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_45_5_Exception")
  void testgetDay_45_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 4, 5902);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_45_9_Exception")
  void testgetDay_45_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(20768, 4, 28649);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_46_1_Exception")
  void testgetDay_46_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 6, 18013);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_46_5_Exception")
  void testgetDay_46_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 6, 31987);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_46_9_Exception")
  void testgetDay_46_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(5144, 6, 21571);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_47_4")
  void testgetDay_47_4() throws Exception {
    Date self = new Date(17908, 2, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_47_8")
  void testgetDay_47_8() throws Exception {
    Date self = new Date(5676, 2, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_47_9")
  void testgetDay_47_9() throws Exception {
    Date self = new Date(18820, 2, 29);
    assertEquals("29", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_47_10")
  void testgetDay_47_10() throws Exception {
    Date self = new Date(8024, 2, 11);
    assertEquals("11", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_52_1")
  void testgetDay_52_1() throws Exception {
    Date self = new Date(1, 2, 15);
    assertEquals("15", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_52_4")
  void testgetDay_52_4() throws Exception {
    Date self = new Date(17770, 2, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_52_5")
  void testgetDay_52_5() throws Exception {
    Date self = new Date(1, 2, 20);
    assertEquals("20", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_52_8")
  void testgetDay_52_8() throws Exception {
    Date self = new Date(15882, 2, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_52_9")
  void testgetDay_52_9() throws Exception {
    Date self = new Date(17969, 2, 28);
    assertEquals("28", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_52_10")
  void testgetDay_52_10() throws Exception {
    Date self = new Date(8919, 2, 25);
    assertEquals("25", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_53_4")
  void testgetDay_53_4() throws Exception {
    Date self = new Date(9700, 2, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_53_8")
  void testgetDay_53_8() throws Exception {
    Date self = new Date(17400, 2, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_53_9")
  void testgetDay_53_9() throws Exception {
    Date self = new Date(24300, 2, 28);
    assertEquals("28", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_53_10")
  void testgetDay_53_10() throws Exception {
    Date self = new Date(8600, 2, 7);
    assertEquals("7", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_59_9_Exception")
  void testgetDay_59_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(30800, 2, 24246);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_64_9_Exception")
  void testgetDay_64_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(25092, 2, 2134);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_70_1_Exception")
  void testgetDay_70_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 2, 20880);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_70_5_Exception")
  void testgetDay_70_5() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1, 2, 20409);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_70_9_Exception")
  void testgetDay_70_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(12419, 2, 18705);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_71_9_Exception")
  void testgetDay_71_9() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(5400, 2, 23554);
      self.getDay();
    });
  }
}
