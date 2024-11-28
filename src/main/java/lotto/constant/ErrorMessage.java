package lotto.constant;

public enum ErrorMessage {
    AMOUNT_FORMAT_ERROR("구입 금액의 형식이 올바르지 않습니다."),
    AMOUNT_UNIT_ERROR("구입 금액의 단위가 올바르지 않습니다."),
    AMOUNT_NOT_POSITIVE_ERROR("구입 금액은 0원 이하가 될 수 없습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
