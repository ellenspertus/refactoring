package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    public BigDecimal getTotalCharge() {
        BigDecimal totalCharge = new BigDecimal(0);
        for (Rental rental : rentals) {
            totalCharge = totalCharge.add(rental.getRentalPrice());
        }
        return totalCharge;
    }

    public String generateStatement() {
        return StatementGenerator.generateStatement(this);
    }
}
