package baseball.interfaces;

import baseball.domain.BaseballUmpire;
import baseball.domain.GuessNumbers;
import baseball.domain.GuessNumbersParser;
import baseball.domain.SecretNumbers;
import baseball.domain.SecretNumbersGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.concurrent.atomic.AtomicBoolean;

public class BaseballGameController {

    public static final String GAME_RESTART_KEYWORD = "1";
    public static final String GAME_TERMINATE_KEYWORD = "2";

    private final BaseballUmpire baseballUmpire;
    private final InputView input;
    private final OutputView view;
    private final AtomicBoolean running;

    public BaseballGameController(BaseballUmpire baseballUmpire, InputView input, OutputView view) {
        this.baseballUmpire = baseballUmpire;
        this.input = input;
        this.view = view;
        this.running = new AtomicBoolean(true);
    }

    public void startGame() {
        while (running.get()) {
            view.printNumberInputMessage();
            baseballUmpire.decide(getGuessNumbers());
            view.print(baseballUmpire.getBallCount());
            checkGameOver();
        }
    }

    private GuessNumbers getGuessNumbers() {
        return new GuessNumbers(GuessNumbersParser.parse(input.readLine()));
    }

    private void checkGameOver() {
        if (!baseballUmpire.isStrikeout()) {
            return;
        }
        checkGameTerminate(input.readLine());
    }

    private void checkGameTerminate(final String command) {
        validateCommand(command);
        executeCommand(command);
    }

    private void validateCommand(final String command) {
        if (!GAME_RESTART_KEYWORD.equals(command) && !GAME_TERMINATE_KEYWORD.equals(command)) {
            throw new IllegalArgumentException();
        }
    }

    private void executeCommand(final String command) {
        if (GAME_RESTART_KEYWORD.equals(command)) {
            baseballUmpire.resetGame(new SecretNumbers(SecretNumbersGenerator.generate()));
        } else if (GAME_TERMINATE_KEYWORD.equals(command)) {
            running.set(false);
        }
    }

}
