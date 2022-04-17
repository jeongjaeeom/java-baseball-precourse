package baseball.domain;

import java.util.Objects;

public class BaseballUmpire {

  private final SecretNumbers secretNumbers;

  public BaseballUmpire(SecretNumbers secretNumbers) {
    this.secretNumbers = secretNumbers;
  }

  public BallCount decide(GuessNumbers guessNumbers) {
    BallCount ballCount = new BallCount();
    for (int i = 0; i < secretNumbers.size(); i++) {
      decide(ballCount, secretNumbers.get(i), guessNumbers.get(i));
    }
    return ballCount;
  }

  private void decide(BallCount ballCount, Integer secretNumber, Integer guessNumber) {
    if (Objects.equals(secretNumber, guessNumber)) {
      ballCount.strike();
    } else if (secretNumbers.contains(guessNumber)) {
      ballCount.ball();
    }
  }

}
