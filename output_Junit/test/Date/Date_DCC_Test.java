package test.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Date;


public class Date_DCC_Test {
  @Test
  @DisplayName("tcgen_Date_Date_DCC_1")
  void testDate_1() throws Exception {
    int Arg_1 = 1138;
    int Arg_2 = 12;
    int Arg_3 = 7;

    assertEquals("[ 1138, 12, 7 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_2_Exception")
  void testDate_2() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 26935;
      int Arg_2 = 12;
      int Arg_3 = 2433;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_3")
  void testDate_3() throws Exception {
    int Arg_1 = 4322;
    int Arg_2 = 10;
    int Arg_3 = 26;

    assertEquals("[ 4322, 10, 26 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_4_Exception")
  void testDate_4() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 12275;
      int Arg_2 = 12;
      int Arg_3 = -12933;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_5_Exception")
  void testDate_5() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 5724;
      int Arg_2 = 10;
      int Arg_3 = 1986;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_6")
  void testDate_6() throws Exception {
    int Arg_1 = 16699;
    int Arg_2 = 8;
    int Arg_3 = 6;

    assertEquals("[ 16699, 8, 6 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_8_Exception")
  void testDate_8() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 7097;
      int Arg_2 = 10;
      int Arg_3 = -10904;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_9_Exception")
  void testDate_9() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 15598;
      int Arg_2 = 8;
      int Arg_3 = 18855;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_10")
  void testDate_10() throws Exception {
    int Arg_1 = 31021;
    int Arg_2 = 7;
    int Arg_3 = 4;

    assertEquals("[ 31021, 7, 4 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_11_Exception")
  void testDate_11() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -30998;
      int Arg_2 = 12;
      int Arg_3 = 22;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_14_Exception")
  void testDate_14() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 20745;
      int Arg_2 = 8;
      int Arg_3 = -5800;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_15_Exception")
  void testDate_15() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 9268;
      int Arg_2 = 7;
      int Arg_3 = 25241;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_16")
  void testDate_16() throws Exception {
    int Arg_1 = 25872;
    int Arg_2 = 5;
    int Arg_3 = 11;

    assertEquals("[ 25872, 5, 11 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_17_Exception")
  void testDate_17() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -9125;
      int Arg_2 = 10;
      int Arg_3 = 6;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_20_Exception")
  void testDate_20() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 12114;
      int Arg_2 = 7;
      int Arg_3 = -32360;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_21_Exception")
  void testDate_21() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 16572;
      int Arg_2 = 5;
      int Arg_3 = 21842;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_22")
  void testDate_22() throws Exception {
    int Arg_1 = 6343;
    int Arg_2 = 11;
    int Arg_3 = 9;

    assertEquals("[ 6343, 11, 9 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_23_Exception")
  void testDate_23() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 7115;
      int Arg_2 = 11;
      int Arg_3 = 8364;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_24")
  void testDate_24() throws Exception {
    int Arg_1 = 7097;
    int Arg_2 = 1;
    int Arg_3 = 30;

    assertEquals("[ 7097, 1, 30 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_25")
  void testDate_25() throws Exception {
    int Arg_1 = 27898;
    int Arg_2 = 3;
    int Arg_3 = 24;

    assertEquals("[ 27898, 3, 24 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_26_Exception")
  void testDate_26() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -32339;
      int Arg_2 = 8;
      int Arg_3 = 31;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_29_Exception")
  void testDate_29() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 25702;
      int Arg_2 = 5;
      int Arg_3 = -21129;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_30_Exception")
  void testDate_30() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 8422;
      int Arg_2 = 1;
      int Arg_3 = 8294;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_31_Exception")
  void testDate_31() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 28497;
      int Arg_2 = 3;
      int Arg_3 = 16132;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_32")
  void testDate_32() throws Exception {
    int Arg_1 = 31201;
    int Arg_2 = 9;
    int Arg_3 = 4;

    assertEquals("[ 31201, 9, 4 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_33_Exception")
  void testDate_33() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 10891;
      int Arg_2 = 11;
      int Arg_3 = -27166;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_34_Exception")
  void testDate_34() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 7685;
      int Arg_2 = 9;
      int Arg_3 = 27943;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_35_Exception")
  void testDate_35() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -3433;
      int Arg_2 = 7;
      int Arg_3 = 22;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_38_Exception")
  void testDate_38() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 5399;
      int Arg_2 = 1;
      int Arg_3 = -32197;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_39_Exception")
  void testDate_39() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 12282;
      int Arg_2 = 3;
      int Arg_3 = -22194;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_40")
  void testDate_40() throws Exception {
    int Arg_1 = 16066;
    int Arg_2 = 4;
    int Arg_3 = 6;

    assertEquals("[ 16066, 4, 6 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_41")
  void testDate_41() throws Exception {
    int Arg_1 = 20431;
    int Arg_2 = 6;
    int Arg_3 = 26;

    assertEquals("[ 20431, 6, 26 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_43_Exception")
  void testDate_43() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 8514;
      int Arg_2 = 9;
      int Arg_3 = -16780;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_44_Exception")
  void testDate_44() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 4884;
      int Arg_2 = 4;
      int Arg_3 = 16232;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_45_Exception")
  void testDate_45() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 6318;
      int Arg_2 = 6;
      int Arg_3 = 20917;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_46_Exception")
  void testDate_46() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -12368;
      int Arg_2 = 5;
      int Arg_3 = 31;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_50")
  void testDate_50() throws Exception {
    int Arg_1 = 13600;
    int Arg_2 = 2;
    int Arg_3 = 5;

    assertEquals("[ 13600, 2, 5 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_51_Exception")
  void testDate_51() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -31136;
      int Arg_2 = 11;
      int Arg_3 = 14;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_54_Exception")
  void testDate_54() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 10800;
      int Arg_2 = 4;
      int Arg_3 = -30277;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_55_Exception")
  void testDate_55() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 23101;
      int Arg_2 = 6;
      int Arg_3 = -4200;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_56_Exception")
  void testDate_56() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 11600;
      int Arg_2 = 2;
      int Arg_3 = 16788;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_57")
  void testDate_57() throws Exception {
    int Arg_1 = 20072;
    int Arg_2 = 2;
    int Arg_3 = 19;

    assertEquals("[ 20072, 2, 19 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_58_Exception")
  void testDate_58() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -27838;
      int Arg_2 = 1;
      int Arg_3 = 2;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_59_Exception")
  void testDate_59() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -19034;
      int Arg_2 = 3;
      int Arg_3 = 28;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_62_Exception")
  void testDate_62() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 23620;
      int Arg_2 = 2;
      int Arg_3 = 28398;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_63")
  void testDate_63() throws Exception {
    int Arg_1 = 6109;
    int Arg_2 = 2;
    int Arg_3 = 10;

    assertEquals("[ 6109, 2, 10 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_64")
  void testDate_64() throws Exception {
    int Arg_1 = 27700;
    int Arg_2 = 2;
    int Arg_3 = 5;

    assertEquals("[ 27700, 2, 5 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_65_Exception")
  void testDate_65() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -15572;
      int Arg_2 = 9;
      int Arg_3 = 6;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_69_Exception")
  void testDate_69() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 25200;
      int Arg_2 = 2;
      int Arg_3 = -24736;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_70_Exception")
  void testDate_70() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 21994;
      int Arg_2 = 2;
      int Arg_3 = 19132;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_71_Exception")
  void testDate_71() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 28300;
      int Arg_2 = 2;
      int Arg_3 = 270;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_72_Exception")
  void testDate_72() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 30748;
      int Arg_2 = 2;
      int Arg_3 = -22815;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_73_Exception")
  void testDate_73() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -26258;
      int Arg_2 = 4;
      int Arg_3 = 22;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_74_Exception")
  void testDate_74() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -8940;
      int Arg_2 = 6;
      int Arg_3 = 3;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_77_Exception")
  void testDate_77() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 32000;
      int Arg_2 = 14675;
      int Arg_3 = 21;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_78_Exception")
  void testDate_78() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 14133;
      int Arg_2 = 2;
      int Arg_3 = -13075;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_79_Exception")
  void testDate_79() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 29700;
      int Arg_2 = 2;
      int Arg_3 = -21188;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_80_Exception")
  void testDate_80() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1356;
      int Arg_2 = 2788;
      int Arg_3 = 21;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_81_Exception")
  void testDate_81() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -19200;
      int Arg_2 = 2;
      int Arg_3 = 14;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_82_Exception")
  void testDate_82() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 16000;
      int Arg_2 = -13485;
      int Arg_3 = 12;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_83_Exception")
  void testDate_83() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 5223;
      int Arg_2 = 10245;
      int Arg_3 = 7;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_84_Exception")
  void testDate_84() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 1900;
      int Arg_2 = 6914;
      int Arg_3 = 21;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_85_Exception")
  void testDate_85() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -25024;
      int Arg_2 = 2;
      int Arg_3 = 6;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_86_Exception")
  void testDate_86() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 16876;
      int Arg_2 = -20865;
      int Arg_3 = 5;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_87_Exception")
  void testDate_87() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -22237;
      int Arg_2 = 2;
      int Arg_3 = 2;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_88_Exception")
  void testDate_88() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -6200;
      int Arg_2 = 2;
      int Arg_3 = 27;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_89_Exception")
  void testDate_89() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 266;
      int Arg_2 = -12510;
      int Arg_3 = 10;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DCC_90_Exception")
  void testDate_90() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = 21300;
      int Arg_2 = -8603;
      int Arg_3 = 19;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_1")
  void testnext_1() throws Exception {
    Date self = new Date(29213, 12, 31);
    assertEquals("[ 29214, 1, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_2")
  void testnext_2() throws Exception {
    Date self = new Date(3992, 12, 23);
    assertEquals("[ 3992, 12, 24 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_3")
  void testnext_3() throws Exception {
    Date self = new Date(1746, 10, 31);
    assertEquals("[ 1746, 11, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_4")
  void testnext_4() throws Exception {
    Date self = new Date(5488, 10, 23);
    assertEquals("[ 5488, 10, 24 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_5")
  void testnext_5() throws Exception {
    Date self = new Date(13217, 8, 31);
    assertEquals("[ 13217, 9, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_6")
  void testnext_6() throws Exception {
    Date self = new Date(28681, 8, 28);
    assertEquals("[ 28681, 8, 29 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_7")
  void testnext_7() throws Exception {
    Date self = new Date(13244, 7, 31);
    assertEquals("[ 13244, 8, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_8")
  void testnext_8() throws Exception {
    Date self = new Date(32168, 7, 19);
    assertEquals("[ 32168, 7, 20 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_9")
  void testnext_9() throws Exception {
    Date self = new Date(26586, 5, 31);
    assertEquals("[ 26586, 6, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_10")
  void testnext_10() throws Exception {
    Date self = new Date(4282, 5, 9);
    assertEquals("[ 4282, 5, 10 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_11")
  void testnext_11() throws Exception {
    Date self = new Date(16883, 1, 31);
    assertEquals("[ 16883, 2, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_12")
  void testnext_12() throws Exception {
    Date self = new Date(8047, 3, 31);
    assertEquals("[ 8047, 4, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_13")
  void testnext_13() throws Exception {
    Date self = new Date(24568, 11, 30);
    assertEquals("[ 24568, 12, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_14")
  void testnext_14() throws Exception {
    Date self = new Date(1709, 1, 29);
    assertEquals("[ 1709, 1, 30 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_15")
  void testnext_15() throws Exception {
    Date self = new Date(19047, 3, 21);
    assertEquals("[ 19047, 3, 22 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_16")
  void testnext_16() throws Exception {
    Date self = new Date(21693, 11, 3);
    assertEquals("[ 21693, 11, 4 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_17")
  void testnext_17() throws Exception {
    Date self = new Date(21462, 9, 30);
    assertEquals("[ 21462, 10, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_18")
  void testnext_18() throws Exception {
    Date self = new Date(31649, 9, 2);
    assertEquals("[ 31649, 9, 3 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_19")
  void testnext_19() throws Exception {
    Date self = new Date(7594, 4, 30);
    assertEquals("[ 7594, 5, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_20")
  void testnext_20() throws Exception {
    Date self = new Date(3377, 6, 30);
    assertEquals("[ 3377, 7, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_21")
  void testnext_21() throws Exception {
    Date self = new Date(3012, 4, 4);
    assertEquals("[ 3012, 4, 5 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_22")
  void testnext_22() throws Exception {
    Date self = new Date(16536, 6, 16);
    assertEquals("[ 16536, 6, 17 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_23")
  void testnext_23() throws Exception {
    Date self = new Date(18000, 2, 29);
    assertEquals("[ 18000, 3, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_24")
  void testnext_24() throws Exception {
    Date self = new Date(6000, 2, 5);
    assertEquals("[ 6000, 2, 6 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_25")
  void testnext_25() throws Exception {
    Date self = new Date(29444, 2, 29);
    assertEquals("[ 29444, 3, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_26")
  void testnext_26() throws Exception {
    Date self = new Date(3768, 2, 8);
    assertEquals("[ 3768, 2, 9 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_27")
  void testnext_27() throws Exception {
    Date self = new Date(18667, 2, 28);
    assertEquals("[ 18667, 3, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_28")
  void testnext_28() throws Exception {
    Date self = new Date(12300, 2, 28);
    assertEquals("[ 12300, 3, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_29")
  void testnext_29() throws Exception {
    Date self = new Date(11609, 2, 1);
    assertEquals("[ 11609, 2, 2 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DCC_30")
  void testnext_30() throws Exception {
    Date self = new Date(7800, 2, 21);
    assertEquals("[ 7800, 2, 22 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_1")
  void testgetYear_1() throws Exception {
    Date self = new Date(29808, 12, 19);
    assertEquals("29808", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_2")
  void testgetYear_2() throws Exception {
    Date self = new Date(30748, 10, 24);
    assertEquals("30748", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_3_Exception")
  void testgetYear_3() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(27893, 12, 20176);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_4")
  void testgetYear_4() throws Exception {
    Date self = new Date(16532, 8, 24);
    assertEquals("16532", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_6_Exception")
  void testgetYear_6() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(11410, 10, 10544);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_7")
  void testgetYear_7() throws Exception {
    Date self = new Date(6772, 7, 22);
    assertEquals("6772", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_10_Exception")
  void testgetYear_10() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(24652, 8, 2586);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_11")
  void testgetYear_11() throws Exception {
    Date self = new Date(30392, 5, 23);
    assertEquals("30392", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_16_Exception")
  void testgetYear_16() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(24142, 7, 22996);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_17")
  void testgetYear_17() throws Exception {
    Date self = new Date(24082, 11, 10);
    assertEquals("24082", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_18")
  void testgetYear_18() throws Exception {
    Date self = new Date(9224, 1, 24);
    assertEquals("9224", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_19")
  void testgetYear_19() throws Exception {
    Date self = new Date(28745, 3, 17);
    assertEquals("28745", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_24_Exception")
  void testgetYear_24() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(15227, 5, 9464);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_25")
  void testgetYear_25() throws Exception {
    Date self = new Date(22538, 9, 22);
    assertEquals("22538", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_26_Exception")
  void testgetYear_26() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(2480, 11, 9604);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_31_Exception")
  void testgetYear_31() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(14687, 1, 18747);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_32_Exception")
  void testgetYear_32() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(6977, 3, 10941);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_33")
  void testgetYear_33() throws Exception {
    Date self = new Date(23809, 4, 14);
    assertEquals("23809", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_34")
  void testgetYear_34() throws Exception {
    Date self = new Date(25491, 6, 1);
    assertEquals("25491", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_36_Exception")
  void testgetYear_36() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(7915, 9, 24000);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_42")
  void testgetYear_42() throws Exception {
    Date self = new Date(1200, 2, 22);
    assertEquals("1200", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_45_Exception")
  void testgetYear_45() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(480, 4, 21185);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_46_Exception")
  void testgetYear_46() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(31033, 6, 28134);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_47")
  void testgetYear_47() throws Exception {
    Date self = new Date(14908, 2, 8);
    assertEquals("14908", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_52")
  void testgetYear_52() throws Exception {
    Date self = new Date(23277, 2, 1);
    assertEquals("23277", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_53")
  void testgetYear_53() throws Exception {
    Date self = new Date(15700, 2, 6);
    assertEquals("15700", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_59_Exception")
  void testgetYear_59() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(32400, 2, 11739);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_64_Exception")
  void testgetYear_64() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(18388, 2, 32371);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_70_Exception")
  void testgetYear_70() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(28518, 2, 27779);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DCC_71_Exception")
  void testgetYear_71() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(3800, 2, 25530);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_1")
  void testgetMonth_1() throws Exception {
    Date self = new Date(2559, 12, 2);
    assertEquals("12", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_2")
  void testgetMonth_2() throws Exception {
    Date self = new Date(27182, 10, 6);
    assertEquals("10", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_3_Exception")
  void testgetMonth_3() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(29985, 12, 16478);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_4")
  void testgetMonth_4() throws Exception {
    Date self = new Date(25107, 8, 19);
    assertEquals("8", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_6_Exception")
  void testgetMonth_6() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(18783, 10, 25347);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_7")
  void testgetMonth_7() throws Exception {
    Date self = new Date(27084, 7, 15);
    assertEquals("7", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_10_Exception")
  void testgetMonth_10() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(31449, 8, 3923);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_11")
  void testgetMonth_11() throws Exception {
    Date self = new Date(23459, 5, 29);
    assertEquals("5", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_16_Exception")
  void testgetMonth_16() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(8235, 7, 7187);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_17")
  void testgetMonth_17() throws Exception {
    Date self = new Date(20322, 11, 22);
    assertEquals("11", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_18")
  void testgetMonth_18() throws Exception {
    Date self = new Date(22119, 1, 3);
    assertEquals("1", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_19")
  void testgetMonth_19() throws Exception {
    Date self = new Date(7819, 3, 26);
    assertEquals("3", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_24_Exception")
  void testgetMonth_24() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(18800, 5, 29410);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_25")
  void testgetMonth_25() throws Exception {
    Date self = new Date(18850, 9, 24);
    assertEquals("9", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_26_Exception")
  void testgetMonth_26() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(24303, 11, 16092);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_31_Exception")
  void testgetMonth_31() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(15275, 1, 5620);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_32_Exception")
  void testgetMonth_32() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(22358, 3, 24667);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_33")
  void testgetMonth_33() throws Exception {
    Date self = new Date(13411, 4, 23);
    assertEquals("4", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_34")
  void testgetMonth_34() throws Exception {
    Date self = new Date(19523, 6, 13);
    assertEquals("6", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_36_Exception")
  void testgetMonth_36() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(18745, 9, 20196);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_42")
  void testgetMonth_42() throws Exception {
    Date self = new Date(22800, 2, 18);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_45_Exception")
  void testgetMonth_45() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(20222, 4, 9439);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_46_Exception")
  void testgetMonth_46() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(11219, 6, 10497);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_47")
  void testgetMonth_47() throws Exception {
    Date self = new Date(30968, 2, 28);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_52")
  void testgetMonth_52() throws Exception {
    Date self = new Date(18994, 2, 24);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_53")
  void testgetMonth_53() throws Exception {
    Date self = new Date(12500, 2, 22);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_59_Exception")
  void testgetMonth_59() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(20000, 2, 15544);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_64_Exception")
  void testgetMonth_64() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(8, 2, 11988);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_70_Exception")
  void testgetMonth_70() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(26157, 2, 14064);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DCC_71_Exception")
  void testgetMonth_71() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(27800, 2, 16651);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_1")
  void testgetDay_1() throws Exception {
    Date self = new Date(10906, 12, 30);
    assertEquals("30", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_2")
  void testgetDay_2() throws Exception {
    Date self = new Date(19610, 10, 2);
    assertEquals("2", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_3_Exception")
  void testgetDay_3() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(1980, 12, 15611);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_4")
  void testgetDay_4() throws Exception {
    Date self = new Date(19221, 8, 10);
    assertEquals("10", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_6_Exception")
  void testgetDay_6() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(7215, 10, 9142);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_7")
  void testgetDay_7() throws Exception {
    Date self = new Date(31633, 7, 29);
    assertEquals("29", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_10_Exception")
  void testgetDay_10() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(6827, 8, 15912);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_11")
  void testgetDay_11() throws Exception {
    Date self = new Date(14, 5, 19);
    assertEquals("19", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_16_Exception")
  void testgetDay_16() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(18341, 7, 8720);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_17")
  void testgetDay_17() throws Exception {
    Date self = new Date(782, 11, 30);
    assertEquals("30", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_18")
  void testgetDay_18() throws Exception {
    Date self = new Date(31483, 1, 17);
    assertEquals("17", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_19")
  void testgetDay_19() throws Exception {
    Date self = new Date(12909, 3, 23);
    assertEquals("23", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_24_Exception")
  void testgetDay_24() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(27659, 5, 16346);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_25")
  void testgetDay_25() throws Exception {
    Date self = new Date(30002, 9, 23);
    assertEquals("23", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_26_Exception")
  void testgetDay_26() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(17164, 11, 16169);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_31_Exception")
  void testgetDay_31() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(20081, 1, 31589);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_32_Exception")
  void testgetDay_32() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(4869, 3, 4082);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_33")
  void testgetDay_33() throws Exception {
    Date self = new Date(16484, 4, 13);
    assertEquals("13", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_34")
  void testgetDay_34() throws Exception {
    Date self = new Date(16802, 6, 12);
    assertEquals("12", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_36_Exception")
  void testgetDay_36() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(26849, 9, 15270);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_42")
  void testgetDay_42() throws Exception {
    Date self = new Date(18000, 2, 27);
    assertEquals("27", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_45_Exception")
  void testgetDay_45() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(10871, 4, 4945);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_46_Exception")
  void testgetDay_46() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(21138, 6, 20031);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_47")
  void testgetDay_47() throws Exception {
    Date self = new Date(20840, 2, 28);
    assertEquals("28", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_52")
  void testgetDay_52() throws Exception {
    Date self = new Date(15598, 2, 9);
    assertEquals("9", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_53")
  void testgetDay_53() throws Exception {
    Date self = new Date(3800, 2, 1);
    assertEquals("1", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_59_Exception")
  void testgetDay_59() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(6000, 2, 6225);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_64_Exception")
  void testgetDay_64() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(14772, 2, 26499);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_70_Exception")
  void testgetDay_70() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(18619, 2, 27858);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DCC_71_Exception")
  void testgetDay_71() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(10100, 2, 6096);
      self.getDay();
    });
  }
}
