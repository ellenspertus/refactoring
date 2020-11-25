package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;

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

    protected BigDecimal getRentalPrice() {
        BigDecimal amount = BigDecimal.valueOf(0);
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                amount = BigDecimal.valueOf(2);
                if (getDaysRented() > 2) {
                    amount = amount.add(BigDecimal.valueOf(getDaysRented() - 2)
                            .multiply(BigDecimal.valueOf(1.5)));
                }
                return amount;
            case Movie.NEW_RELEASE:
                return BigDecimal.valueOf(getDaysRented() * 3);
            case Movie.CHILDREN:
                amount = BigDecimal.valueOf(1.5);

                if (getDaysRented() > 3) {
                    // amount += (getDaysRented() - 3) * 1.5;
                    amount = amount.add(BigDecimal.valueOf(getDaysRented() - 3)
                            .multiply(BigDecimal.valueOf(1.5)));
                }
                return amount;
        }
        return amount;
    }

    protected int getFrequentRenterPoints() {
        return getMovie().getFrequentRenterPoints(daysRented);
    }
}
