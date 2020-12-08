package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;

public class RegularPrice extends Price {
    private static final BigDecimal DAILY_LATE_FEE = BigDecimal.valueOf(1.5);
    private static final BigDecimal BASE_CHARGE = BigDecimal.valueOf(2);
    private static final int RENTAL_PERIOD = 2;

    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    BigDecimal getCharge(int numDays) {
        return calculateCharge(numDays, BASE_CHARGE, RENTAL_PERIOD, DAILY_LATE_FEE);
    }
}
