package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;

public abstract class Price {
    abstract int getPriceCode();

    abstract BigDecimal getCharge(int numDays);
}
