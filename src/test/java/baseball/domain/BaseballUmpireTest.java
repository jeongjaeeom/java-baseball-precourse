package baseball.domain;

import org.junit.jupiter.api.Test;

class BaseballUmpireTest {

  @Test
  void decide() {
    BaseballUmpire decisionManager = new BaseballUmpire(new SecretNumbers(SecretNumbersGenerator.generate()));
    BallCount ballCount = decisionManager.decide(new GuessNumbers(GuessNumbersParser.parse("123")));
    System.out.println(ballCount);

  }
}
