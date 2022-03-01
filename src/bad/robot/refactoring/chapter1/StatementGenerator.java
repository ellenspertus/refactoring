package bad.robot.refactoring.chapter1;

import java.math.*;
import java.text.*;

public class StatementGenerator {
    private static final String HEADER_TEMPLATE = "Rental record for %1s\n";
    private static final String RENTAL_TEMPLATE = "\t%1s\t%2s\n";
    private static final String FOOTER_TEMPLATE =
            "Amount owed is %1s\nYou earned %2s frequent renter points";

    public static String generateStatement(Customer customer) {
        String result = generateHeader(customer);
        result += generateBody(customer);
        result += generateFooter(customer);
        return result;
    }

    private static String generateHeader(Customer customer) {
        return String.format(HEADER_TEMPLATE, customer.getName());
    }

    private static String generateBody(Customer customer) {
        StringBuilder result = new StringBuilder();
        for (Rental rental : customer.getRentals()) {
            result.append(String.format(RENTAL_TEMPLATE, rental.getMovie().getTitle(),
                    bigDecimalToCurrency(rental.getPrice())));
        }
        return result.toString();
    }

    private static String generateFooter(Customer customer) {
        int frequentRenterPoints = customer.calculateFrequentRenterPoints();
        BigDecimal totalAmount = customer.calculateTotalPrice();
        return String.format(FOOTER_TEMPLATE, bigDecimalToCurrency(totalAmount),
                frequentRenterPoints);
    }

    private static String bigDecimalToCurrency(BigDecimal bd) {
        return NumberFormat.getCurrencyInstance().format(bd);
    }
}
