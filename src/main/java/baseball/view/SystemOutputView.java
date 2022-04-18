package baseball.view;

import static java.lang.System.out;

import baseball.domain.BallCount;

public class SystemOutputView implements OutputView {

    public void printNumberInputMessage() {
        out.print(GameMessage.NUMBER_INPUT.getMessage());
    }

    public void print(BallCount ballCount) {
        if (ballCount.isNothing()) {
            out.println(GameMessage.NOTHING.getMessage());
        } else if (ballCount.isBallWithStrike()) {
            out.println(GameMessage.BALL_WITH_STRIKE.getMessage(ballCount.getBall(), ballCount.getStrike()));
        } else if (ballCount.isStrike()) {
            out.println(GameMessage.STRIKE.getMessage(ballCount.getStrike()));
        } else if (ballCount.isBall()) {
            out.println(GameMessage.BALL.getMessage(ballCount.getBall()));
        }

        if (ballCount.isStrikeout()) {
            out.println(GameMessage.PLAYER_WON.getMessage(ballCount.getStrike()));
            out.println(GameMessage.GAME_OVER.getMessage());
        }
    }

}
