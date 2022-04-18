package baseball.domain;

import java.util.Objects;

public class BaseballUmpire {

  private SecretNumbers secretNumbers;
  private BallCount ballCount;

  public BaseballUmpire(SecretNumbers secretNumbers) {
    this.secretNumbers = secretNumbers;
    this.ballCount = new BallCount();
  }

  public void decide(GuessNumbers guessNumbers) {
    ballCount.initialize();
    for (int i = 0; i < secretNumbers.size(); i++) {
      decide(secretNumbers.get(i), guessNumbers.get(i));
    }
  }

  public BallCount getBallCount() {
    return new BallCount(ballCount.getStrike(), ballCount.getBall());
  }

  public boolean isStrikeout() {
    return ballCount.isStrikeout();
  }

  public void resetGame(SecretNumbers secretNumbers) {
    this.secretNumbers = secretNumbers;
    this.ballCount = new BallCount();
  }

  private void decide(Integer secretNumber, Integer guessNumber) {
    if (Objects.equals(secretNumber, guessNumber)) {
      ballCount.addStrike();
    } else if (secretNumbers.contains(guessNumber)) {
      ballCount.addBall();
    }
  }

}
