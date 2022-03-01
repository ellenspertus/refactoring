package bad.robot.refactoring.chapter1;

import java.math.*;

public class Rental {

    private Movie movie;
    private int daysRented;

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

    public BigDecimal getPrice() {
        BigDecimal amount = BigDecimal.ZERO;

        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                amount = BigDecimal.valueOf(2);
                if (getDaysRented() > 2) {
                    amount = amount.add(new BigDecimal("1.5")
                            .multiply(BigDecimal.valueOf(getDaysRented() - 2)));
                }
                break;
            case Movie.NEW_RELEASE:
                amount = BigDecimal.valueOf(getDaysRented() * 3);
                break;
            case Movie.CHILDREN:
                amount = new BigDecimal("1.5");
                if (getDaysRented() > 3) {
                    amount = amount.add(new BigDecimal("1.5")
                            .multiply(BigDecimal.valueOf(getDaysRented() - 3)));
                }
                break;
        }
        return amount;
    }

    public int calculateFrequentRenterPoints() {
        int frequentRenterPoints = 1;

        // add bonus for a two day new release rental
        if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1) {
            frequentRenterPoints++;
        }

        return frequentRenterPoints;
    }
}
