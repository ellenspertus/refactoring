package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;

public abstract class Price {
    abstract int getPriceCode();

    abstract BigDecimal getCharge(int numDays);

    protected BigDecimal calculateCharge(int numDays, BigDecimal baseCharge, int rentalPeriod,
            BigDecimal dailyLateFee) {
        int extraDays = numDays - rentalPeriod;
        if (extraDays > 0) {
            return baseCharge.add(BigDecimal.valueOf(extraDays).multiply(dailyLateFee));
        } else {
            return baseCharge;
        }
    }
}
