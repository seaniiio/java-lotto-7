package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String MONEY_INPUT_MESSAGE = "구입 금액을 입력해주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해주세요.";

    public String getMoneyInput() {
        System.out.println(MONEY_INPUT_MESSAGE);
        return Console.readLine();
    }

    public String getWinningNumbersInput() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }

    public String getBonusNumberInput() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }
}
