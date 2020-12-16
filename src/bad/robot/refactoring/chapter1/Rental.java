package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rental {

    private Movie movie;
    private int daysRented;

    private static final BigDecimal REGULAR_RENTAL_COST = new BigDecimal("2.00");
    private static final BigDecimal EXTENDED_REGULAR_RENTAL_COST = new BigDecimal("1.50");
    private static final BigDecimal NEW_RELEASE_RENTAL_COST = new BigDecimal("3.00");
    private static final BigDecimal CHILDREN_RENTAL_COST = new BigDecimal("1.50");

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    protected BigDecimal getRentalPrice() {
        BigDecimal amount = new BigDecimal("0.00");
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                amount = amount.add(REGULAR_RENTAL_COST);
                if (getDaysRented() > 2) {
                    BigDecimal extraDaysRented = new BigDecimal(getDaysRented() - 2);
                    amount = amount.add(extraDaysRented.multiply(EXTENDED_REGULAR_RENTAL_COST));
                }
                break;
            case Movie.NEW_RELEASE:
                BigDecimal newReleaseTotal = new BigDecimal(getDaysRented()).multiply(NEW_RELEASE_RENTAL_COST);
                amount = amount.add(newReleaseTotal);
                break;
            case Movie.CHILDREN:
                amount = amount.add(CHILDREN_RENTAL_COST);
                if (getDaysRented() > 3) {
                    BigDecimal extraDaysRented = new BigDecimal(getDaysRented() - 3);
                    amount = amount.add(extraDaysRented.multiply(CHILDREN_RENTAL_COST));
                }
                break;
        }
        return amount.setScale(2, RoundingMode.HALF_UP);
    }

    protected int getFrequentRenterPoints() {
        return getMovie().getFrequentRenterPoints(daysRented);
    }
}
