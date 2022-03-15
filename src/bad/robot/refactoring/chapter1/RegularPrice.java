package bad.robot.refactoring.chapter1;

import java.math.*;

public class RegularPrice extends Price {
    private static final String EXTRA_DAY_RENTAL_PRICE = "1.5";
    private static final String BASE_RENTAL_PRICE = "2";
    private static final int BASE_RENTAL_DAYS = 2;
    public static final RegularPrice INSTANCE = new RegularPrice();

    private RegularPrice() {}

    public static RegularPrice getInstance() {
        return INSTANCE;
    }

    @Override
    public BigDecimal getCharge(int daysRented) {
        return super.getCharge(daysRented, BASE_RENTAL_PRICE, BASE_RENTAL_DAYS,
                EXTRA_DAY_RENTAL_PRICE);
    }
}
