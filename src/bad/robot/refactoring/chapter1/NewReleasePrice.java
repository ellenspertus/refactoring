package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;

public class NewReleasePrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    BigDecimal getRentalPrice(int daysRented) {
        return BigDecimal.valueOf(daysRented * 3);
    }
}
