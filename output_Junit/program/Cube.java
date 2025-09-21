package program;

import java.util.Arrays;
import java.util.Objects;

public class Cube {
  private final int[][][] data;

  public Cube(int[][][] data) {
    Objects.requireNonNull(data, "data ¬° null");
    this.data = data;
  }

  public Cube add(Cube other) {
    int[][][] result = new int[data.length][data[0].length][data[0][0].length];
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        for (int k = 0; k < data[i][j].length; k++) {
          result[i][j][k] = data[i][j][k] + other.data[i][j][k];
        }
      }
    }
    return new Cube(result);
  }

  public Cube sub(Cube other) {
    int[][][] result = new int[data.length][data[0].length][data[0][0].length];
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        for (int k = 0; k < data[i][j].length; k++) {
          result[i][j][k] = data[i][j][k] - other.data[i][j][k];
        }
      }
    }
    return new Cube(result);
  }

  public String getData() {
    return Arrays.deepToString(data);
  }

  @Override
  public String toString() {
    return Arrays.deepToString(data);
  }
}
