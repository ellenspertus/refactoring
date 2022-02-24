package bad.robot.refactoring.chapter1;

import java.util.*;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public int calculateFrequentRenterPoints() {
        int frequentRenterPoints = 0;

        for (Rental rental : rentals) {
            frequentRenterPoints += rental.calculateFrequentRenterPoints();
        }

        return frequentRenterPoints;
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Rental rental : rentals) {
            total += rental.getPrice();
        }
        return total;
    }
}
