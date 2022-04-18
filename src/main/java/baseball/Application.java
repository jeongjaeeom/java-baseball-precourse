package baseball;

import baseball.domain.BaseballUmpire;
import baseball.domain.SecretNumbers;
import baseball.domain.SecretNumbersGenerator;
import baseball.interfaces.BaseballGameController;
import baseball.view.ConsoleInputView;
import baseball.view.SystemOutputView;

public class Application {

    public static void main(String[] args) {
        BaseballGameController controller = new BaseballGameController(
                new BaseballUmpire(new SecretNumbers(SecretNumbersGenerator.generate())),
                new ConsoleInputView(),
                new SystemOutputView());
        controller.startGame();
    }

}
