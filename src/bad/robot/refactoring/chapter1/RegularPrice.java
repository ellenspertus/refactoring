package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;

public class RegularPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    BigDecimal getRentalPrice(int daysRented) {
        if (daysRented > 2) {
            return BigDecimal.valueOf(2 + (daysRented - 2) * 1.5);
        } else {
            return BigDecimal.valueOf(2);
        }
    }
}
