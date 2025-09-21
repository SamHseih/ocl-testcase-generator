package program;

import java.util.Arrays;
import java.util.Objects;

public class TwoDimVarArray {

  private final int[][] data;

  @SuppressWarnings("serial")
  public static class IllegalDimensionSizeException extends Exception {
    public IllegalDimensionSizeException(String message) {
      super(message);
    }
  }

  public TwoDimVarArray(int[][] inputArray) {
    Objects.requireNonNull(inputArray, "inputArray 不可為 null");

    this.data = Arrays.copyOf(inputArray, inputArray.length);
  }

  public TwoDimVarArray add(TwoDimVarArray arg) throws IllegalDimensionSizeException {


    if (this.data.length != arg.data.length) {
      throw new IllegalDimensionSizeException(
          "維度不一致: this=" + this.data.length + ", arg=" + arg.data.length);
    }
    if (this.data[0].length != arg.data[0].length) {
      throw new IllegalDimensionSizeException(
          "子陣列維度不一致: this[0]=" + this.data[0].length + ", arg[0]=" + arg.data[0].length);
    }
    // 逐列檢查內層長度
    // for (int i = 0; i < data.length; i++) {
    // if (this.data[i].length != arg.data[i].length) {
    // throw new IllegalDimensionSizeException("子陣列維度不一致: row=" + i + ", this[" + i + "]="
    // + this.data[i].length + ", arg[" + i + "]=" + arg.data[i].length);
    // }
    // }
    int[][] result = new int[data.length][data[0].length];
    for (int i = 0; i < data.length; i++) {
      result[i] = new int[data[i].length]; // ← 必須配置
      for (int j = 0; j < data[i].length; j++) {
        result[i][j] = this.data[i][j] + arg.data[i][j];
      }
    }
    return new TwoDimVarArray(result);
  }

  public TwoDimVarArray sub(TwoDimVarArray arg) throws IllegalDimensionSizeException {
    if (this.data.length != arg.data.length) {
      throw new IllegalDimensionSizeException(
          "維度不一致: this=" + this.data.length + ", arg=" + arg.data.length);
    }
    if (this.data[0].length != arg.data[0].length) {
      throw new IllegalDimensionSizeException(
          "子陣列維度不一致: this[0]=" + this.data[0].length + ", arg[0]=" + arg.data[0].length);
    }

    // 逐列檢查內層長度
    // for (int i = 0; i < data.length; i++) {
    // if (this.data[i].length != arg.data[i].length) {
    // throw new IllegalDimensionSizeException("子陣列維度不一致: row=" + i + ", this[" + i + "]="
    // + this.data[i].length + ", arg[" + i + "]=" + arg.data[i].length);
    // }
    // }
    int[][] result = new int[data.length][data[0].length];
    for (int i = 0; i < data.length; i++) {
      result[i] = new int[data[i].length]; // ← 必須配置
      for (int j = 0; j < data[i].length; j++) {
        result[i][j] = this.data[i][j] - arg.data[i][j];
      }
    }
    return new TwoDimVarArray(result);
  }

  public String getData() {
    return Arrays.deepToString(data);
  }

  @Override
  public String toString() {
    return Arrays.deepToString(data);
  }

}
