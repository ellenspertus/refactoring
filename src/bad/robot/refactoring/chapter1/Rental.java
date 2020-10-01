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
        return movie.getRentalPrice(daysRented);
    }

    protected int getFrequentRenterPoints() {
        return getMovie().getFrequentRenterPoints(daysRented);
    }
}
