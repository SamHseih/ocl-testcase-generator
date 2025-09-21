package program;

import java.util.Arrays;
import java.util.Objects;

public class VarArray {

  private final int[] data;

  @SuppressWarnings("serial")
  public static class IllegalDimensionSizeException extends Exception {
    public IllegalDimensionSizeException(String message) {
      super(message);
    }
  }

  public VarArray(int[] inputArray) {
    Objects.requireNonNull(inputArray, "inputArray 不可為 null");

    this.data = Arrays.copyOf(inputArray, inputArray.length);
  }

  public VarArray add(VarArray arg) throws IllegalDimensionSizeException {
    if (this.data.length != arg.data.length) {
      throw new IllegalDimensionSizeException(
          "維度不一致: this=" + this.data.length + ", arg=" + arg.data.length);
    }

    int[] result = new int[data.length];
    for (int i = 0; i < data.length; i++) {
      result[i] = this.data[i] + arg.data[i];
    }
    return new VarArray(result);
  }

  public VarArray sub(VarArray arg) throws IllegalDimensionSizeException {
    if (this.data.length != arg.data.length) {
      throw new IllegalDimensionSizeException(
          "維度不一致: this=" + this.data.length + ", arg=" + arg.data.length);
    }

    int[] result = new int[data.length];
    for (int i = 0; i < data.length; i++) {
      result[i] = this.data[i] - arg.data[i];
    }
    return new VarArray(result);
  }

  public String getData() {
    return Arrays.toString(data);
  }

  @Override
  public String toString() {
    return Arrays.toString(data);
  }
}
