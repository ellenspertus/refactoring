package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;

public class ChildrensPrice extends Price {
    private static final int RENTAL_PERIOD = 3; // days
    private static final double DAILY_LATE_FEE = 1.5;
    private static final double BASE_CHARGE = 1.5;

    @Override
    int getPriceCode() {
        return Movie.CHILDREN;
    }

    @Override
    BigDecimal getCharge(int numDays) {
        return calculateCharge(numDays, BASE_CHARGE, RENTAL_PERIOD, DAILY_LATE_FEE);
    }
}
