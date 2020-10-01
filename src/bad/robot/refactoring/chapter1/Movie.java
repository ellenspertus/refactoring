package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;

public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;
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
            case CHILDREN:
                price = new ChildrensPrice();
                break;
            case REGULAR:
                price = new RegularPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Invalid priceCode: " + priceCode);
        }
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
        return price.getRentalPrice(daysRented);
    }
}
