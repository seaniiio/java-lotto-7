package lotto.parser;

import lotto.constant.ErrorMessage;

public class Parser {

    public int parseAmount(String inputAmount) {
        try {
            int parsedAmount = Integer.parseInt(inputAmount);
            return parsedAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_FORMAT_ERROR.getMessage());
        }
    }
}
