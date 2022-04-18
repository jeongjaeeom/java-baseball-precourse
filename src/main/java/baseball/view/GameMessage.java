package baseball.view;

public enum GameMessage {

    NUMBER_INPUT("숫자를 입력해주세요 : "),
    BALL("%d볼"),
    STRIKE("%d스트라이크"),
    BALL_WITH_STRIKE("%d볼 %d스트라이크"),
    NOTHING("낫싱"),
    PLAYER_WON("%d개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    GAME_OVER("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    GameMessage(final String message) {
        this.message = message;
    }

    public String getMessage(Object... arg) {
        return String.format(message, arg);
    }
}
