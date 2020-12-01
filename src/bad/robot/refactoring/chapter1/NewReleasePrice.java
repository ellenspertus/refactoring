package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;

public class NewReleasePrice extends Price {
    private static final int DAILY_CHARGE = 3;

    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    BigDecimal getCharge(int numDays) {
        return BigDecimal.valueOf(numDays).multiply(BigDecimal.valueOf(DAILY_CHARGE));
    }
}
