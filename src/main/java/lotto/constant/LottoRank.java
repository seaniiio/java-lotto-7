package lotto.constant;

public enum LottoRank {
    FIFTH(5_000, 3, "3개 일치 (5,000원)"),
    FORTH(50_000, 4, "4개 일치 (50,000원)"),
    THIRD( 1_500_000, 5, "5개 일치 (1,500,000원)"),
    SECOND(30_000_000, 5, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(2_000_000_000, 6, "6개 일치 (2,000,000,000원)"),
    NONE(0, -1, "");

    private final long prize;
    private final int matchCount;
    private final String message;

    LottoRank(long prize, int matchCount, String message) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.message = message;
    }

    public static LottoRank checkLottoRank(int matchCount, boolean isBonusMatch) {
        if (isBonusMatch && matchCount == SECOND.matchCount) {
            return SECOND;
        }

        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.equals(SECOND)) {
                continue;
            }
            if (lottoRank.matchCount == matchCount) {
                return lottoRank;
            }
        }

        return NONE;
    }

    public String getMessage() {
        return message;
    }

    public double getPrize(int count) {
        return prize * count;
    }
}
