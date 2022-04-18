package baseball.view;

import baseball.domain.BallCount;

public interface OutputView {

    void printNumberInputMessage();

    void print(BallCount ballCount);
}
