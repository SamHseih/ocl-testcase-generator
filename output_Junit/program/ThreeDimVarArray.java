package program;

import java.util.Arrays;
import java.util.Objects;

public class ThreeDimVarArray {

  private final int[][][] data;

  @SuppressWarnings("serial")
  public static class IllegalDimensionSizeException extends Exception {
    public IllegalDimensionSizeException(String message) {
      super(message);
    }
  }

  public ThreeDimVarArray(int[][][] inputArray) {
    Objects.requireNonNull(inputArray, "inputArray ���i�� null");

    this.data = Arrays.copyOf(inputArray, inputArray.length);
  }

  public ThreeDimVarArray add(ThreeDimVarArray arg) throws IllegalDimensionSizeException {
    if (this.data.length != arg.data.length) {
      throw new IllegalDimensionSizeException(
          "���פ��@�P: this=" + this.data.length + ", arg=" + arg.data.length);
    }

    if (this.data[0].length != arg.data[0].length) {
      throw new IllegalDimensionSizeException(
          "�l�}�C���פ��@�P: this[0]=" + this.data[0].length + ", arg[0]=" + arg.data[0].length);
    }

    if (this.data[0][0].length != arg.data[0][0].length) {
      throw new IllegalDimensionSizeException("�l�}�C���ĤT���פ��@�P: this[0][0]=" + this.data[0][0].length
          + ", arg[0][0]=" + arg.data[0][0].length);
    }

    int[][][] result = new int[data.length][data[0].length][data[0][0].length];
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        for (int k = 0; k < data[i][j].length; k++) {
          result[i][j][k] = this.data[i][j][k] + arg.data[i][j][k];
        }
      }
    }
    return new ThreeDimVarArray(result);
  }

  public ThreeDimVarArray sub(ThreeDimVarArray arg) throws IllegalDimensionSizeException {
    if (this.data.length != arg.data.length) {
      throw new IllegalDimensionSizeException(
          "���פ��@�P: this=" + this.data.length + ", arg=" + arg.data.length);
    }

    if (this.data[0].length != arg.data[0].length) {
      throw new IllegalDimensionSizeException(
          "�l�}�C���פ��@�P: this[0]=" + this.data[0].length + ", arg[0]=" + arg.data[0].length);
    }

    if (this.data[0][0].length != arg.data[0][0].length) {
      throw new IllegalDimensionSizeException("�l�}�C���ĤT���פ��@�P: this[0][0]=" + this.data[0][0].length
          + ", arg[0][0]=" + arg.data[0][0].length);
    }

    int[][][] result = new int[data.length][data[0].length][data[0][0].length];
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        for (int k = 0; k < data[i][j].length; k++) {
          result[i][j][k] = this.data[i][j][k] - arg.data[i][j][k];
        }
      }
    }
    return new ThreeDimVarArray(result);
  }

  public String getData() {
    return Arrays.deepToString(data);
  }

  @Override
  public String toString() {
    return Arrays.deepToString(data);
  }
}
