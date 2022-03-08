package bad.robot.refactoring.chapter1;

import java.math.*;

public class ChildrensPrice extends Price {
    public static final ChildrensPrice INSTANCE = new ChildrensPrice();

    private ChildrensPrice() {}

    public static ChildrensPrice getInstance() {
        return INSTANCE;
    }

    @Override
    public BigDecimal getCharge(int daysRented) {
        BigDecimal amount = new BigDecimal("1.5");
        if (daysRented > 3) {
            amount = amount.add(new BigDecimal("1.5").multiply(BigDecimal.valueOf(daysRented - 3)));
        }
        return amount;
    }

}
