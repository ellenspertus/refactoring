package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class StatementGenerator {
    private final String headerTemplate;
    private final String rentalTemplate;
    private final String footerTemplate;

    protected StatementGenerator(String header, String rental, String footer) {
        headerTemplate = header;
        rentalTemplate = rental;
        footerTemplate = footer;
    }


    public String generateStatement(Customer customer) {
        StringBuilder sb = new StringBuilder();
        sb.append(generateHeader(customer));
        for (Rental rental : customer.getRentals()) {
            sb.append(generateRental(rental));
        }
        sb.append(generateFooter(customer));
        return sb.toString();
    }

    private String generateHeader(Customer customer) {
        return String.format(headerTemplate, customer.getName());
    }

    private String generateRental(Rental rental) {
        return String.format(rentalTemplate, rental.getMovie(),
                formatMoney(rental.getRentalPrice()));
    }

    private String generateFooter(Customer customer) {
        return String.format(footerTemplate, formatMoney(customer.getTotalCharge()),
                customer.getFrequentRenterPoints());
    }

    private String formatMoney(BigDecimal bd) {
        return NumberFormat.getCurrencyInstance().format(bd);
    }
}
