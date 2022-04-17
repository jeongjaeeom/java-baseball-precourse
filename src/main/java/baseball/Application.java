package baseball;

import baseball.application.BaseballGame;
import camp.nextstep.edu.missionutils.Console;

public class Application {

  public static void main(String[] args) {
    new BaseballGame().run();
    System.out.println("입력해");
    String s = Console.readLine();
    System.out.println(s);
  }
}
