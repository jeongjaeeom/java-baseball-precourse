package baseball;

import baseball.domain.GuessNumber;
import baseball.domain.SecretNumber;
import camp.nextstep.edu.missionutils.Console;

public class Application {

  public static void main(String[] args) {
    String s = Console.readLine();
    GuessNumber guessNumber = new GuessNumber(s);

    // SecretNumber secretNumber = new SecretNumber();
  }
}
