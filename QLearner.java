package espresso;

public class QLearner {
 
  public static int evaluatePolicy(Game game, Policy policy) {
    int besti;
    int bestq;
    Matrix s = policy.stateMatrix(game);
    for (int i = 0; i < actions.numActions; i++) {
      Matrix a = actions.actionMatrices[i];
      Matrix e = new Matrix(1, s.cols + a.cols);
      for (int j = 0; j < s.cols; j++)
        e.array[0][j] = s.array[0][j];
      for (int j = 0; j < a.cols; j++)
        e.array[0][j + s.cols] = a.array[0][j];
      double q = policy.ff.forward(e).scalarize();
      if (bestq < q || i == 0) {
        bestq = q;
	besti = i;
      }
    }
    return i;
  }

  public static abstract class Policy {
    public abstract Matrix stateMatrix(Game game);

    public Matrix[] actionMatrices;
    public int numActions;
    public FeedForward policyApprox;
    public FeedForward rewardApprox;
  }

  public static class GamePolicy extends Policy {
    public GamePolicy() {

    }

    public Matrix stateMatrix(Game game) {

    }
  }

  public static class MenuPolicy extends Policy {
    public MenuPolicy() {

    }

    public Matrix stateMatrix(Game game) {

    }
  }

}

