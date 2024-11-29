package lotto.domain;

import lotto.constant.ErrorMessage;

public class WinningLotto {

    private static final int LOTTO_NUMBER_LOWER_BOUND = 1;
    private static final int LOTTO_NUMBER_UPPER_BOUND = 45;

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int checkLottoMatchCount(Lotto lotto) {
        return lotto.getNumbers().stream()
                .filter(number -> winningLotto.getNumbers().contains(number))
                .toList()
                .size();
    }

    public boolean checkBonusNumberMatch(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        validateDuplicated(winningLotto, bonusNumber);
        validateBonusNumberBound(bonusNumber);
    }

    private void validateDuplicated(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATED_ERROR.getMessage());
        }
    }

    private void validateBonusNumberBound(int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_LOWER_BOUND || bonusNumber > LOTTO_NUMBER_UPPER_BOUND) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_BOUND_ERROR.getMessage());
        }
    }
}
