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
        BigDecimal amount = new BigDecimal(0);
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                amount = amount.add(new BigDecimal(2));
                if (getDaysRented() > 2)
                    amount = amount.add(new BigDecimal((getDaysRented() - 2) * 1.5));
                break;
            case Movie.NEW_RELEASE:
                amount = amount.add(new BigDecimal(getDaysRented() * 3));
                break;
            case Movie.CHILDREN:
                amount = amount.add(new BigDecimal(1.5));
                if (getDaysRented() > 3)
                    amount = amount.add(new BigDecimal((getDaysRented() - 3) * 1.5));
                break;
        }
        return amount;
    }

    protected int getFrequentRenterPoints() {
        return getMovie().getFrequentRenterPoints(daysRented);
    }
}
