package bad.robot.refactoring.chapter1;

import java.math.*;

public class ChildrensPrice extends Price {
    private static final String EXTRA_DAY_RENTAL_PRICE = "1.5";
    private static final String BASE_RENTAL_PRICE = "1.5";
    private static final int BASE_RENTAL_DAYS = 3;
    public static final ChildrensPrice INSTANCE = new ChildrensPrice();

    private ChildrensPrice() {}

    public static ChildrensPrice getInstance() {
        return INSTANCE;
    }

    @Override
    public BigDecimal getCharge(int daysRented) {
        return super.getCharge(daysRented, BASE_RENTAL_PRICE, BASE_RENTAL_DAYS,
                EXTRA_DAY_RENTAL_PRICE);
    }

}
