package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLotto {

    private final List<Lotto> purchasedLotto;

    public PurchasedLotto(List<Lotto> purchasedLotto) {
        this.purchasedLotto = purchasedLotto;
    }

    public List<Lotto> getPurchasedLotto() {
        return new ArrayList<>(purchasedLotto);
    }
}
