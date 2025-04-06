package client.exception;

public class NotValidUserNameException extends Exception {
    public NotValidUserNameException() {
        super("유효하지 않은 사용자 이름입니다. 다시 입력해주세요.");
    }

    public NotValidUserNameException(String message) {
        super(message);
    }
}
