package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;

public class NewReleasePrice extends Price {
    private static final BigDecimal DAILY_CHARGE = BigDecimal.valueOf(3);

    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    BigDecimal getCharge(int numDays) {
        return DAILY_CHARGE.multiply(BigDecimal.valueOf(numDays));
    }
}
