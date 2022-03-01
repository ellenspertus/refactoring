package bad.robot.refactoring.chapter1;

import java.math.*;
import java.text.*;

public abstract class StatementGenerator {

    private final String headerTemplate, rentalTemplate, footerTemplate;

    protected StatementGenerator(String header, String rental, String footer) {
        headerTemplate = header;
        rentalTemplate = rental;
        footerTemplate = footer;
    }

    public String generateStatement(Customer customer) {
        String result = generateHeader(customer);
        result += generateBody(customer);
        result += generateFooter(customer);
        return result;
    }

    private String generateHeader(Customer customer) {
        return String.format(headerTemplate, customer.getName());
    }

    private String generateBody(Customer customer) {
        StringBuilder result = new StringBuilder();
        for (Rental rental : customer.getRentals()) {
            result.append(String.format(rentalTemplate, rental.getMovie().getTitle(),
                    bigDecimalToCurrency(rental.getPrice())));
        }
        return result.toString();
    }

    private String generateFooter(Customer customer) {
        int frequentRenterPoints = customer.calculateFrequentRenterPoints();
        BigDecimal totalAmount = customer.calculateTotalPrice();
        return String.format(footerTemplate, bigDecimalToCurrency(totalAmount),
                frequentRenterPoints);
    }

    private static String bigDecimalToCurrency(BigDecimal bd) {
        return NumberFormat.getCurrencyInstance().format(bd);
    }
}
