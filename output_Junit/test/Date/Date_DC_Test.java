package test.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.Date;


public class Date_DC_Test {
  @Test
  @DisplayName("tcgen_Date_Date_DC_1_Exception")
  void testDate_1() {
    assertThrows(Exception.class, () -> {
      int Arg_1 = -29259;
      int Arg_2 = 1;
      int Arg_3 = 22;
      new Date(Arg_1, Arg_2, Arg_3);
    });
  }

  @Test
  @DisplayName("tcgen_Date_Date_DC_2")
  void testDate_2() throws Exception {
    int Arg_1 = 32378;
    int Arg_2 = 1;
    int Arg_3 = 14;

    assertEquals("[ 32378, 1, 14 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DC_3")
  void testDate_3() throws Exception {
    int Arg_1 = 6463;
    int Arg_2 = 4;
    int Arg_3 = 29;

    assertEquals("[ 6463, 4, 29 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_Date_DC_4")
  void testDate_4() throws Exception {
    int Arg_1 = 30800;
    int Arg_2 = 2;
    int Arg_3 = 18;

    assertEquals("[ 30800, 2, 18 ]", new Date(Arg_1, Arg_2, Arg_3).toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_1")
  void testnext_1() throws Exception {
    Date self = new Date(19891, 12, 31);
    assertEquals("[ 19892, 1, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_2")
  void testnext_2() throws Exception {
    Date self = new Date(16744, 12, 23);
    assertEquals("[ 16744, 12, 24 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_3")
  void testnext_3() throws Exception {
    Date self = new Date(24206, 1, 31);
    assertEquals("[ 24206, 2, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_4")
  void testnext_4() throws Exception {
    Date self = new Date(16464, 1, 9);
    assertEquals("[ 16464, 1, 10 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_5")
  void testnext_5() throws Exception {
    Date self = new Date(2605, 4, 30);
    assertEquals("[ 2605, 5, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_6")
  void testnext_6() throws Exception {
    Date self = new Date(12501, 4, 17);
    assertEquals("[ 12501, 4, 18 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_7")
  void testnext_7() throws Exception {
    Date self = new Date(24800, 2, 29);
    assertEquals("[ 24800, 3, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_8")
  void testnext_8() throws Exception {
    Date self = new Date(17200, 2, 11);
    assertEquals("[ 17200, 2, 12 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_9")
  void testnext_9() throws Exception {
    Date self = new Date(6890, 2, 28);
    assertEquals("[ 6890, 3, 1 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_next_DC_10")
  void testnext_10() throws Exception {
    Date self = new Date(17099, 2, 22);
    assertEquals("[ 17099, 2, 23 ]", self.next().toString());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_1_Exception")
  void testgetYear_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(4473, 1, 24230);
      self.getYear();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_2")
  void testgetYear_2() throws Exception {
    Date self = new Date(9242, 1, 7);
    assertEquals("9242", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_3")
  void testgetYear_3() throws Exception {
    Date self = new Date(11267, 4, 20);
    assertEquals("11267", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getYear_DC_4")
  void testgetYear_4() throws Exception {
    Date self = new Date(9200, 2, 15);
    assertEquals("9200", self.getYear());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_1_Exception")
  void testgetMonth_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(12804, 1, 27994);
      self.getMonth();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_2")
  void testgetMonth_2() throws Exception {
    Date self = new Date(22853, 1, 17);
    assertEquals("1", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_3")
  void testgetMonth_3() throws Exception {
    Date self = new Date(21852, 4, 4);
    assertEquals("4", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getMonth_DC_4")
  void testgetMonth_4() throws Exception {
    Date self = new Date(1600, 2, 17);
    assertEquals("2", self.getMonth());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_1_Exception")
  void testgetDay_1() {
    assertThrows(Exception.class, () -> {
      Date self = new Date(5385, 1, 21126);
      self.getDay();
    });
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_2")
  void testgetDay_2() throws Exception {
    Date self = new Date(17331, 1, 24);
    assertEquals("24", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_3")
  void testgetDay_3() throws Exception {
    Date self = new Date(26204, 4, 28);
    assertEquals("28", self.getDay());
  }

  @Test
  @DisplayName("tcgen_Date_getDay_DC_4")
  void testgetDay_4() throws Exception {
    Date self = new Date(14400, 2, 6);
    assertEquals("6", self.getDay());
  }
}
