package lotto.machine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_LOWER_BOUND = 1;
    private static final int LOTTO_UPPER_BOUND = 45;
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;

    public List<Integer> issueLotto() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_LOWER_BOUND, LOTTO_UPPER_BOUND, NUMBER_OF_LOTTO_NUMBERS);
    }
}
