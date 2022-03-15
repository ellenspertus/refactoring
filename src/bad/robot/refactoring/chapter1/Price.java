package bad.robot.refactoring.chapter1;

import java.math.*;

public abstract class Price {

    public static final Price CHILDRENS_PRICE = ChildrensPrice.getInstance();
    public static final Price NEW_RENTAL_PRICE = NewReleasePrice.getInstance();
    public static final Price REGULAR_PRICE = RegularPrice.getInstance();

    public abstract BigDecimal getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        // By default, customers get 1 frequent renter point per rental.
        return 1;
    }

    public BigDecimal getCharge(int daysRented, String baseRentalPrice, int baseRentalDays,
            String extraDayRentalPrice) {
        BigDecimal amount = new BigDecimal(baseRentalPrice);
        if (daysRented > baseRentalDays) {
            amount = amount.add(new BigDecimal(extraDayRentalPrice)
                    .multiply(BigDecimal.valueOf(daysRented - baseRentalDays)));
        }
        return amount;
    }

}
