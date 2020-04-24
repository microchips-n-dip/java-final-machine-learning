package espresso;

public class FeedForward {

  public FeedForward(int[] sizes) {
    weights = new Matrix[sizes.length];
    for (int i = 0; i < sizes.length - 1; i++)
      weights[i] = new Matrix.random(sizes[i], sizes[i + 1]);
  }

  private Matrix[] weights;

  Matrix forward(Matrix x) {
    Matrix a = x;
    for (int i = 0; i < weights.length; i++) {
      Matrix z = Matrix.dot(a, weights[i]);
      a = Matrix.sigmoid(z);
    }
    return a;
  }

  public static class FeedForwardState {
    public FeedForwardState(int num) {
      a = new Matrix[num];
      z = new Matrix[num];
    }

    public Matrix yhat;
    public Matrix[] a;
    public Matrix[] z;
  }

  public FeedForwardState forwardAndRecord(Matrix x) {
    FeedForwardState fs = new FeedForwardState(weights.length);
    Matrix a = x;
    for (int i = 0; i < weights.length; i++) {
      fs.a[i] = a;
      Matrix z = Matrix.dot(a, weights[i]);
      a = Matrix.sigmoid(z);
      fs.z[i] = z;
    }
    fs.yhat = a;
    return fs;
  }

  Matrix[] dydW(FeedForwardState fs, Matrix delta1) {
    int nl = weights.length - 1;
    Matrix[] dJdW = new Matrix[weights.length];
    Matrix zPrime = Matrix.sigmoidPrime(fs.z[nl]);
    Matrix delta = Matrix.multiply(delta1, zPrime);
    dJdW[0] = Matrix.dot(fs.a[nl], delta);
    /* Iterate the rest of the backprop. */
    for (int i = 1; i < weights.length; i++) {
      nl--; /* (reverse) step to the next layer. */
      zPrime = Matrix.sigmoidPrime(fs.z[nl]);
      delta = Matrix.multiply(Matrix.dot(delta, weights[nl + 1].transpose()), zPrime);
      dJdW[i] = Matrix.dot(fs.a[nl].transpose(), delta);
    }
    return dJdW;
  }

}
