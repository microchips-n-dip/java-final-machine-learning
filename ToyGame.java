package espresso;

public class ToyGame {

  public static class Agent {
    public Toy1QLearner learner;
    public int x;
    public int y;
  }

  public void step() {
    int move = evaluatePolicy(agent.learner);
    /* Possible moves:
     * 0 - left
     * 1 - right
     * 2 - up
     * 3 - down. */
    switch (move) {
      case 0:
        if (agent.x != 3)
          agent.x++;
        break;
      case 1:
        if (agent.x != 0)
          agent.x--;
        break;
      case 2:
        if (agent.y != 3)
          agent.y++;
        break;
      case 3:
        if (agent.y != 0)
          agent.y--;
        break;
    }
    if (agent.x == goal.x && agent.y == goal.y)
      
  }

}
