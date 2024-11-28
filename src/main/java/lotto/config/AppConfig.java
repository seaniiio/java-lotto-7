package lotto.config;

import lotto.controller.LottoController;
import lotto.machine.LottoMachine;
import lotto.parser.Parser;
import lotto.repeater.InputRepeater;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    public LottoController createLottoController() {
        return new LottoController(createInputView(), createOutputView(), createInputRepeater(), createLottoService());
    }

    private InputView createInputView() {
        return new InputView();
    }

    private OutputView createOutputView() {
        return new OutputView();
    }

    private InputRepeater createInputRepeater() {
        return new InputRepeater();
    }

    private LottoService createLottoService() {
        return new LottoService(createParser(), createLottoMachine());
    }

    private Parser createParser() {
        return new Parser();
    }

    private LottoMachine createLottoMachine() {
        return new LottoMachine();
    }
}
