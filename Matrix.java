package espresso;

public class Matrix {
  public Matrix(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    array = new double[rows][cols];
  }

  public static Matrix zeros(int rows, int cols) {
    Matrix z = new Matrix(rows, cols);
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        z.array[i][j] = 0.0;
      }
    }
    return z;
  }

  public static Matrix dot(Matrix a, Matrix b) {
    Matrix r = Matrix.zeros(a.rows, b.cols);
    for (int i = 0; i < a.rows; i++) {
      for (int j = 0; j < b.cols; j++) {
        for (int k = 0; k < a.cols; k++) {
          r.array[i][j] += a.array[i][k] * b.array[k][j];
	}
      }
    }
    return r;
  }

  public static Matrix multiply(Matrix a, Matrix b) {
    Matrix r = new Matrix(a.rows, a.cols);
    for (int i = 0; i < a.rows; i++) {
      for (int j = 0; j < a.cols; j++) {
        r.array[i][j] = a.array[i][j] * b.array[i][j];
      }
    }
    return r;
  }
  
  public static Matrix add(Matrix a, Matrix b) {
    Matrix r = new Matrix(a.rows, a.cols);
    for (int i = 0; i < a.rows; i++) {
      for (int j = 0; j < a.cols; j++) {
        r.array[i][j] = a.array[i][j] + b.array[i][j];
      }
    }
    return r;
  }

  public static Matrix subtract(Matrix a, Matrix b) {
    Matrix r = new Matrix(a.rows, a.cols);
    for (int i = 0; i < a.rows; i++) {
      for (int j = 0; j < a.cols; j++) {
        r.array[i][j] = a.array[i][j] - b.array[i][j];
      }
    }
    return r;
  }

  public Matrix transpose() {
    Matrix r = new Matrix(cols, rows);
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        r.array[j][i] = array[i][j];
      }
    }
    return r;
  }

  public int rows;
  public int cols;
  public double[][] array;
}
