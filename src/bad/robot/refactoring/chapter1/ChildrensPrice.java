package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;

public class ChildrensPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDREN;
    }

    @Override
    BigDecimal getCharge(int numDays) {
        if (numDays > 3) {
            return BigDecimal.valueOf(1.5 + (numDays - 3) * 1.5);
        } else {
            return BigDecimal.valueOf(1.5);
        }
    }
}
