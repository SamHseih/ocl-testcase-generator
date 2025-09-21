package program;

public class Date {
  private final int year;
  private final int month;
  private final int day;

  /** 對應 OCL 中的 pre DateErrorException。 */
  @SuppressWarnings("serial")
  public static class DateErrorException extends Exception {
    public DateErrorException(String message) {
      super(message);
    }
  }

  /** 對應 OCL：context Date::Date(y:int, m:int, d:int) 的 pre / post。 */
  public Date(int y, int m, int d) throws DateErrorException {
    // 前置條件（依月份上限；不使用輔助函式，直接內嵌）

    if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
      if (d >= 32)
        throw new DateErrorException("day must be <= 31");
    } else if (m == 4 || m == 6 || m == 9 || m == 11) {
      if (d >= 31)
        throw new DateErrorException("day must be <= 30");
    } else { // m == 2
      if ((y % 400 == 0) || ((y % 4 == 0) && (y % 100 != 0))) {
        if (d >= 30)
          throw new DateErrorException("day must be <= 29");
      } else {
        if (d >= 29)
          throw new DateErrorException("day must be <= 28");
      }
    }
    // 前置條件（基本範圍）
    if (!(y >= 1 && m >= 1 && m <= 12 && d >= 1))
      throw new DateErrorException("year must be >= 1");

    this.year = y; // post: year = y
    this.month = m; // post: month = m
    this.day = d; // post: day = d
  }

  /**
   * 對應 OCL：context Date::next():Date 的 post（依規格分支逐一實作；不使用輔助函式）。
   * 
   * @throws DateErrorException
   */
  public Date next() throws DateErrorException {
    int y = this.year;
    int m = this.month;
    int d = this.day;

    int ry, rm, rd; // result y/m/d

    if (m == 12) {
      if (d == 31) {
        // result.year = self.year + 1; result.month = 1; result.day = 1
        ry = y + 1;
        rm = 1;
        rd = 1;
      } else {
        // day < 31; 同月日+1
        ry = y;
        rm = m;
        rd = d + 1;
      }
    } else if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10) {
      if (d == 31) {
        // 下個月 1 號
        ry = y;
        rm = m + 1;
        rd = 1;
      } else {
        // 日+1
        ry = y;
        rm = m;
        rd = d + 1;
      }
    } else if (m == 4 || m == 6 || m == 9 || m == 11) {
      if (d == 30) {
        // 下個月 1 號
        ry = y;
        rm = m + 1;
        rd = 1;
      } else {
        // 日+1
        ry = y;
        rm = m;
        rd = d + 1;
      }
    } else { // m == 2
      boolean leap = (y % 400 == 0) || ((y % 4 == 0) && (y % 100 != 0));
      if (leap) {
        if (d == 29) {
          // 3/1
          ry = y;
          rm = 3;
          rd = 1;
        } else {
          // 日+1（d < 29）
          ry = y;
          rm = 2;
          rd = d + 1;
        }
      } else {
        if (d == 28) {
          // 3/1
          ry = y;
          rm = 3;
          rd = 1;
        } else {
          // 日+1（d < 28）
          ry = y;
          rm = 2;
          rd = d + 1;
        }
      }
    }
    return new Date(ry, rm, rd);

  }

  /** 對應 OCL：context Date::getYear():int 的 post（result = year）。 */
  public String getYear() {
    return Integer.toString(year);
  }

  /** 對應 OCL：context Date::getMonth():int 的 post（result = month）。 */
  public String getMonth() {
    return Integer.toString(month);
  }

  /** 對應 OCL：context Date::getDay():int 的 post（result = day）。 */
  public String getDay() {
    return Integer.toString(day);
  }

  @Override
  public String toString() {
    return "[ " + year + ", " + month + ", " + day + " ]";
  }
}
