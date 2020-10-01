package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;

public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    protected int getFrequentRenterPoints(int daysRented) {
        int frequentRenterPoints = 1;

        // add bonus for a two day new release rental
        if (priceCode == NEW_RELEASE && daysRented > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

    protected BigDecimal getRentalPrice(int daysRented) {
        BigDecimal amount = new BigDecimal(0);
        switch (getPriceCode()) {
            case Movie.REGULAR:
                amount = amount.add(new BigDecimal(2));
                if (daysRented > 2)
                    amount = amount.add(new BigDecimal((daysRented - 2) * 1.5));
                break;
            case Movie.NEW_RELEASE:
                amount = amount.add(new BigDecimal(daysRented * 3));
                break;
            case Movie.CHILDREN:
                amount = amount.add(new BigDecimal(1.5));
                if (daysRented > 3)
                    amount = amount.add(new BigDecimal((daysRented - 3) * 1.5));
                break;
        }
        return amount;
    }
}
