package lotto.controller;

import java.util.List;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    public void run() {
        int moneyInput = getMoneyInput();
        lottoService.purchaseLotto(moneyInput);
        lottoService.printPurchasedLottoNumbers();

        List<Integer> winnerNumbersInput = getWinnerNumbers();
        lottoService.setWinnerLotto(winnerNumbersInput);
    }

    private int getMoneyInput() {
        outputView.printMoneyInputMessage();
        return inputView.getMoneyInput();
    }

    private List<Integer> getWinnerNumbers() {
        outputView.printWinnerNumbersMessage();
        return inputView.getWinnerNumbersInput();
    }
}
