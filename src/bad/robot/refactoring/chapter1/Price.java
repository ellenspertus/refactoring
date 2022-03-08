package bad.robot.refactoring.chapter1;

import java.math.*;

public abstract class Price {
    public static final Price CHILDRENS_PRICE = ChildrensPrice.getInstance();
    public static final Price NEW_RENTAL_PRICE = NewReleasePrice.getInstance();
    public static final Price REGULAR_PRICE = RegularPrice.getInstance();

    public abstract BigDecimal getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }

}
