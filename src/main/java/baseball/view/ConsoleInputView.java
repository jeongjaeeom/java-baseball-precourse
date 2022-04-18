package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {

    public String readLine() {
        return Console.readLine();
    }

}
