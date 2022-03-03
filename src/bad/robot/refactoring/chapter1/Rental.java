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
        Price price = getMovie().getPrice(); // either RegularPrice, ChildrensPrice, etc.
        return price.getCharge(getDaysRented());
    }

    public int calculateFrequentRenterPoints() {
        return getMovie().getPrice().getFrequentRenterPoints(getDaysRented());
    }
}
