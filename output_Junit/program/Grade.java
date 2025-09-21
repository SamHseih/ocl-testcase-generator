package program;

public class Grade {
  int n;

  public Grade(int score) throws Exception {
    if (score >= 0 && score <= 100) {
      this.n = score;
    } else {
      throw new Exception();
    }

  }

  public String rating() {
    if (this.n <= 59)
      return "F";
    else if (this.n <= 69 && this.n >= 60)
      return "D";
    else if (this.n >= 70 && this.n <= 79)
      return "C";
    else if (this.n >= 80 && this.n <= 89)
      return "B";
    else
      return "A";
  }

  public String getNumber() {
    return Integer.toString(n);
  }

  @Override
  public String toString() {
    return "[ " + Integer.toString(n) + " ]";
  }
}
