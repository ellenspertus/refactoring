package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;

public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDREN:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect price code: " + priceCode);
        }
    }

    protected BigDecimal getRentalPrice(int days) {
        return price.getCharge(days);
    }


    protected int getFrequentRenterPoints(int daysRented) {
        int frequentRenterPoints = 1;

        // add bonus for a two day new release rental
        if (getPriceCode() == NEW_RELEASE && daysRented > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
}
