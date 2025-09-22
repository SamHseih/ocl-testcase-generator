package program;

public class Date {
  private final int year;
  private final int month;
  private final int day;

  /** ���� OCL ���� pre DateErrorException�C */
  @SuppressWarnings("serial")
  public static class DateErrorException extends Exception {
    public DateErrorException(String message) {
      super(message);
    }
  }

  /** ���� OCL�Gcontext Date::Date(y:int, m:int, d:int) �� pre / post�C */
  public Date(int y, int m, int d) throws DateErrorException {
    // �e�m����]�̤���W���F���ϥλ��U�禡�A�������O�^

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
    // �e�m����]�򥻽d��^
    if (!(y >= 1 && m >= 1 && m <= 12 && d >= 1))
      throw new DateErrorException("year must be >= 1");

    this.year = y; // post: year = y
    this.month = m; // post: month = m
    this.day = d; // post: day = d
  }

  /**
   * ���� OCL�Gcontext Date::next():Date �� post�]�̳W�����v�@��@�F���ϥλ��U�禡�^�C
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
        // day < 31; �P���+1
        ry = y;
        rm = m;
        rd = d + 1;
      }
    } else if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10) {
      if (d == 31) {
        // �U�Ӥ� 1 ��
        ry = y;
        rm = m + 1;
        rd = 1;
      } else {
        // ��+1
        ry = y;
        rm = m;
        rd = d + 1;
      }
    } else if (m == 4 || m == 6 || m == 9 || m == 11) {
      if (d == 30) {
        // �U�Ӥ� 1 ��
        ry = y;
        rm = m + 1;
        rd = 1;
      } else {
        // ��+1
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
          // ��+1�]d < 29�^
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
          // ��+1�]d < 28�^
          ry = y;
          rm = 2;
          rd = d + 1;
        }
      }
    }
    return new Date(ry, rm, rd);

  }

  /** ���� OCL�Gcontext Date::getYear():int �� post�]result = year�^�C */
  public String getYear() {
    return Integer.toString(year);
  }

  /** ���� OCL�Gcontext Date::getMonth():int �� post�]result = month�^�C */
  public String getMonth() {
    return Integer.toString(month);
  }

  /** ���� OCL�Gcontext Date::getDay():int �� post�]result = day�^�C */
  public String getDay() {
    return Integer.toString(day);
  }

  @Override
  public String toString() {
    return "[ " + year + ", " + month + ", " + day + " ]";
  }
}
