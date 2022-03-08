package bad.robot.refactoring.chapter1;

import java.math.*;

public class RegularPrice extends Price {

    public static final RegularPrice INSTANCE = new RegularPrice();

    private RegularPrice() {}

    public static RegularPrice getInstance() {
        return INSTANCE;
    }

    @Override
    public BigDecimal getCharge(int daysRented) {
        BigDecimal amount = BigDecimal.valueOf(2);
        if (daysRented > 2) {
            amount = amount.add(new BigDecimal("1.5").multiply(BigDecimal.valueOf(daysRented - 2)));
        }
        return amount;
    }

}
