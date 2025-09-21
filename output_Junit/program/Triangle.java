package program;

public class Triangle {
  private int sideA;
  private int sideB;
  private int sideC;

  /** 對應 OCL 中的 pre DateErrorException。 */
  @SuppressWarnings("serial")
  public static class EdgeErrorException extends Exception {
    public EdgeErrorException() {
      super();
    }
  }

  public Triangle(int a, int b, int c) throws EdgeErrorException {
    if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || b + c <= a || a + c <= b) {
      throw new EdgeErrorException();
    }
    sideA = a;
    sideB = b;
    sideC = c;
  }

  public String category() {
    if (sideA == sideB) {
      if (sideB == sideC) {
        return "Equilateral";
      } else {
        return "Isosceles";
      }
    } else {
      if (sideA == sideC) {
        return "Isosceles";
      } else {
        if (sideB == sideC) {
          return "Isosceles";
        } else {
          return "Scalene";
        }
      }
    }
  }

  public int getSideA() {
    return this.sideA;
  }

  public int getSideB() {
    return this.sideB;
  }

  public int getSideC() {
    return this.sideC;
  }

  @Override
  public String toString() {
    return "[ " + this.sideA + ", " + this.sideB + ", " + this.sideC + " ]";
  }
}
