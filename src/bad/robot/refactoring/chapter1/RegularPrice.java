package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;

public class RegularPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    BigDecimal getCharge(int numDays) {
        if (numDays > 2) {
            return BigDecimal.valueOf(2 + (numDays - 2) * 1.5);
        } else {
            return BigDecimal.valueOf(2);
        }
    }
}
