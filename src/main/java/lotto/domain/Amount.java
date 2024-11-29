package lotto.domain;

import lotto.constant.ErrorMessage;

public class Amount {

    private static final int UNIT = 1000;
    private final int amount;

    public Amount(int amount) {
        this.amount = amount;
        validate(amount);
    }

    public int getCount() {
        return amount / UNIT;
    }

    public int getAmount() {
        return amount;
    }

    private void validate(int amount) {
        validatePositive(amount);
        validateUnit(amount);
    }

    private void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_NOT_POSITIVE_ERROR.getMessage());
        }
    }

    private void validateUnit(int amount) {
        if (amount % UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_UNIT_ERROR.getMessage());
        }
    }
}
