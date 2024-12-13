package oncall;

public enum ErrorMessage {
    INPUT_NOT_VALID("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");

    public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String content;

    ErrorMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return ERROR_MESSAGE_PREFIX + content;
    }

}

