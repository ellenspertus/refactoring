package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;

public class Rental {

    final private int NEW_RELEASE_RENTAL_LIMIT = 0;
    final private int REGUALAR_RENTAL_LIMIT = 2;
    final private int CHILDRENS_RENTAL_LIMIT = 3;
    final private float DAILY_CHARGE = 1.5f;

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
