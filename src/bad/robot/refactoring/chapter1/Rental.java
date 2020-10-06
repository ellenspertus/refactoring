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
        BigDecimal amount = new BigDecimal(0);
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                amount = amount.add(BigDecimal.valueOf(DAILY_CHARGE + 0.5));
                if (getDaysRented() > REGUALAR_RENTAL_LIMIT) {
                    amount = amount.add(BigDecimal
                            .valueOf(DAILY_CHARGE * (getDaysRented() - REGUALAR_RENTAL_LIMIT)));
                }
                break;
            case Movie.NEW_RELEASE:
                amount = amount.add(BigDecimal
                        .valueOf(2 * DAILY_CHARGE * (getDaysRented() - NEW_RELEASE_RENTAL_LIMIT)));
                break;
            case Movie.CHILDREN:
                amount = amount.add(BigDecimal.valueOf(DAILY_CHARGE));
                if (getDaysRented() > CHILDRENS_RENTAL_LIMIT) {
                    amount = amount.add(BigDecimal
                            .valueOf(DAILY_CHARGE * (getDaysRented() - CHILDRENS_RENTAL_LIMIT)));
                }
                break;
        }
        return amount;
    }

    protected int getFrequentRenterPoints() {
        return getMovie().getFrequentRenterPoints(daysRented);
    }
}
