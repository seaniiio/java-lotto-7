package lotto.parser;

import java.util.Arrays;
import java.util.List;
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

    public List<Integer> parseLottoNumber(String winningNumbersInput) {
        try {
            return Arrays.stream(winningNumbersInput.split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_FORMAT_ERROR.getMessage());
        }
    }

    public int parseBonusNumber(String bonusNumberInput) {
        try {
            int parsedBonusNumber = Integer.parseInt(bonusNumberInput);
            return parsedBonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_FORMAT_ERROR.getMessage());
        }
    }
}
