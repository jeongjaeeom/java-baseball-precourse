package baseball.application;

import baseball.domain.BallCount;
import baseball.domain.BaseballUmpire;
import baseball.domain.GuessNumbers;
import baseball.domain.GuessNumbersParser;
import baseball.domain.SecretNumbers;
import baseball.domain.SecretNumbersGenerator;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

  public void run() {
    BaseballUmpire baseballUmpire = new BaseballUmpire(
        new SecretNumbers(SecretNumbersGenerator.generate()));

    System.out.print("숫자를 입력해주세요 : ");
    String value = Console.readLine();
    BallCount ballCount = baseballUmpire.decide(
        new GuessNumbers(GuessNumbersParser.parse(value)));
    System.out.println(ballCount);
    while (!ballCount.isStrikeout()) {
      System.out.print("숫자를 입력해주세요 : ");
      ballCount = baseballUmpire.decide(
          new GuessNumbers(GuessNumbersParser.parse(Console.readLine())));
      System.out.println(ballCount);
    }
  }

}
