package program;

import java.util.Arrays;

public class Array {
  private int[] data = new int[5];

  @SuppressWarnings("serial")
  public static class IllegalDimensionSizeException extends Exception {
    public IllegalDimensionSizeException(String message) {
      super(message);
    }
  }

  public Array(int[] data) {
    for (int i = 0; i < data.length; i++) {
      this.data[i] = data[i];
    }
  }

  public Array add(Array other) {
    int[] result = new int[data.length];
    for (int i = 0; i < data.length; i++) {
      result[i] = data[i] + other.data[i];
    }
    return new Array(result);
  }

  public Array sub(Array other) {
    int[] result = new int[data.length];
    for (int i = 0; i < data.length; i++) {
      result[i] = data[i] - other.data[i];
    }
    return new Array(result);
  }

  public String getData() {
    return Arrays.toString(data);
  }

  @Override
  public String toString() {
    return Arrays.toString(data);
  }
}
