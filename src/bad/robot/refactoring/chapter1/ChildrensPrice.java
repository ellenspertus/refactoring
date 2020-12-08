package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;

public class ChildrensPrice extends Price {
    private static final int RENTAL_PERIOD = 3; // days
    private static final BigDecimal DAILY_LATE_FEE = BigDecimal.valueOf(1.5);
    private static final BigDecimal BASE_CHARGE = BigDecimal.valueOf(1.5);

    @Override
    int getPriceCode() {
        return Movie.CHILDREN;
    }

    @Override
    BigDecimal getCharge(int numDays) {
        return calculateCharge(numDays, BASE_CHARGE, RENTAL_PERIOD, DAILY_LATE_FEE);
    }
}
