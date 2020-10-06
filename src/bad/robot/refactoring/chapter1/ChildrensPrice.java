package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;

public class ChildrensPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDREN;
    }

    @Override
    BigDecimal getRentalPrice(int daysRented) {
        if (daysRented > 3) {
            return BigDecimal.valueOf(1.5 + (daysRented - 3) * 1.5);
        } else {
            return BigDecimal.valueOf(1.5);
        }
    }
}
