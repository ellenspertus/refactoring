package bad.robot.refactoring.chapter1;

import java.math.*;

public class NewReleasePrice extends Price {
    private static final NewReleasePrice INSTANCE = new NewReleasePrice();

    private NewReleasePrice() {}

    public static NewReleasePrice getInstance() {
        return INSTANCE;
    }

    @Override
    public BigDecimal getCharge(int daysRented) {
        return BigDecimal.valueOf(daysRented * 3);
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        if (daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }

}
