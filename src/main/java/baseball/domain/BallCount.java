package baseball.domain;

import java.util.Objects;

public class BallCount {

    private int strike;

    private int ball;

    public BallCount() {
    }

    public BallCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    protected void addStrike() {
        strike += 1;
    }

    protected void addBall() {
        ball += 1;
    }

    public boolean isStrike() {
        return strike > 0;
    }

    public boolean isBall() {
        return ball > 0;
    }

    public boolean isBallWithStrike() {
        return (strike > 0 && ball > 0);
    }

    public boolean isNothing() {
        return (strike < 1 && ball < 1);
    }

    public boolean isStrikeout() {
        return strike == 3;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void initialize() {
        this.strike = 0;
        this.ball = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BallCount ballCount = (BallCount) o;
        return strike == ballCount.strike && ball == ballCount.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
