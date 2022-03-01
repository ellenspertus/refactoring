package bad.robot.refactoring.chapter1;

import java.math.*;
import java.text.*;

public class StatementGenerator {
    public static String generateStatement(Customer customer) {
        String result = generateHeader(customer);
        result += generateBody(customer);
        result += generateFooter(customer);
        return result;
    }

    private static String generateHeader(Customer customer) {
        return "Rental record for " + customer.getName() + "\n";
    }

    private static String generateBody(Customer customer) {
        StringBuilder result = new StringBuilder();
        for (Rental rental : customer.getRentals()) {
            result.append("\t");
            result.append(rental.getMovie().getTitle());
            result.append("\t");
            result.append(rental.getPrice());
            result.append("\n");
        }
        return result.toString();
    }

    private static String generateFooter(Customer customer) {
        int frequentRenterPoints = customer.calculateFrequentRenterPoints();
        BigDecimal totalAmount = customer.calculateTotalPrice();
        String result = "Amount owed is " + bigDecimalToCurrency(totalAmount) + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }

    private static String bigDecimalToCurrency(BigDecimal bd) {
        return NumberFormat.getCurrencyInstance().format(bd);
    }
}
