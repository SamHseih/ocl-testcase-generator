package program;

import java.util.Arrays;
import java.util.Objects;

public class Matrix {
  private final int[][] data;

  public Matrix(int[][] data) {
    Objects.requireNonNull(data, "data ¬° null");
    this.data = data;
  }

  public Matrix add(Matrix other) {
    int[][] result = new int[data.length][data[0].length];
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        result[i][j] = data[i][j] + other.data[i][j];

      }
    }
    return new Matrix(result);
  }

  public Matrix sub(Matrix other) {
    int[][] result = new int[data.length][data[0].length];
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        result[i][j] = data[i][j] - other.data[i][j];
      }
    }
    return new Matrix(result);
  }

  public String getData() {
    return Arrays.deepToString(data);
  }

  @Override
  public String toString() {
    return Arrays.deepToString(data);
  }
}
