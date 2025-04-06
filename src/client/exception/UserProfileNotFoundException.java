package client.exception;

public class UserProfileNotFoundException extends Exception {
    public UserProfileNotFoundException() {
        super("사용자 정보를 불러오는데 실패했습니다. 신규 사용자 데이터를 생성합니다.");
    }

    public UserProfileNotFoundException(String message) {
        super(message);
    }
}
