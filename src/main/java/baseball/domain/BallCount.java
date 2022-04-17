package baseball.domain;

public class BallCount {

  private int strike;

  private int ball;

  public void strike() {
    strike += 1;
  }

  public void ball() {
    ball += 1;
  }

  public boolean isStrikeout() {
    return strike == 3;
  }

  @Override
  public String toString() {
    return "BallCount{" +
        "strike=" + strike +
        ", ball=" + ball +
        '}';
  }
}
