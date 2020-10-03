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

    protected BigDecimal getRentPrice() {

        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:

                BigDecimal regularAmount = BigDecimal.valueOf(2);
                if (getDaysRented() > 2)
                    regularAmount =
                            regularAmount.add(BigDecimal.valueOf((getDaysRented() - 2) * 1.5));
                return regularAmount;

            case Movie.NEW_RELEASE:
                return BigDecimal.valueOf(getDaysRented() * 3);

            case Movie.CHILDREN:
                BigDecimal childrenAmount = BigDecimal.valueOf(1.5);
                if (getDaysRented() > 3)
                    childrenAmount =
                            childrenAmount.add(BigDecimal.valueOf((getDaysRented() - 3) * 1.5));
                return childrenAmount;

            default:
                throw new UnsupportedOperationException();
        }

    }

    protected int getFrequentRenterPoints() {
        return getMovie().getFrequentRenterPoints(getDaysRented());
    }
}
