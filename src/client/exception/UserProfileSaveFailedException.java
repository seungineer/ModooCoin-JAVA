package client.exception;

public class UserProfileSaveFailedException extends Exception {
    public UserProfileSaveFailedException() {
        super("사용자 정보를 저장하는데 실패했습니다.");
    }

    public UserProfileSaveFailedException(String message) {
        super(message);
    }
}
