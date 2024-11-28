package lotto.controller;

import lotto.repeater.InputRepeater;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputRepeater inputRepeater;
    private final LottoService lottoService;

    public LottoController(final InputView inputView, final OutputView outputView, final InputRepeater inputRepeater, final LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputRepeater = inputRepeater;
        this.lottoService = lottoService;
    }

    public void run() {
        processInput();
    }

    private void processInput() {
        inputRepeater.continueUntilNormalInput(this::processAmountInput, outputView::printMessage);
    }

    private void processAmountInput() {
        String amountInput = inputView.inputAmount();
        lottoService.setAmount(amountInput);
    }
}
