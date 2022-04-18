package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballUmpireTest {


  private SecretNumbers secretNumbers;

  @BeforeEach
  public void setUp() {
    List<Integer> secretNumbers = new ArrayList<>();
    secretNumbers.add(7);
    secretNumbers.add(1);
    secretNumbers.add(3);
    this.secretNumbers = new SecretNumbers(secretNumbers);
  }

  @ParameterizedTest
  @CsvSource(value = {"123:1", "145:1", "671:2", "216:0", "713:0"}, delimiter = ':')
  void 볼_카운트(String input, int expected) {
    BaseballUmpire baseballUmpire = new BaseballUmpire(secretNumbers);
    baseballUmpire.decide(new GuessNumbers(GuessNumbersParser.parse(input)));
    BallCount ballCount = baseballUmpire.getBallCount();
    assertThat(ballCount.getBall()).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource(value = {"123:1", "145:0", "671:0", "216:1", "713:3"}, delimiter = ':')
  void 스트라이크_카운트(String input, int expected) {
    BaseballUmpire baseballUmpire = new BaseballUmpire(secretNumbers);
    baseballUmpire.decide(new GuessNumbers(GuessNumbersParser.parse(input)));
    BallCount ballCount = baseballUmpire.getBallCount();
    assertThat(ballCount.getStrike()).isEqualTo(expected);
  }
}
