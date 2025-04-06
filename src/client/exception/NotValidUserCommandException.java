package client.exception;

public class NotValidUserCommandException extends Exception {
    NotValidUserCommandException() {
        super("올바른 서비스를 입력해주세요 !");
    }

    NotValidUserCommandException(String message) {
        super(message);
    }
}
