package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;
import java.text.NumberFormat;

public abstract class StatementGenerator {
    private final String headerTemplate;
    private final String rentalTemplate;
    private final String footerTemplate;

    protected StatementGenerator(String headerTemplate, String rentalTemplate,
            String footerTemplate) {
        this.headerTemplate = headerTemplate;
        this.rentalTemplate = rentalTemplate;
        this.footerTemplate = footerTemplate;
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

    // VisibleForTesting
    protected String generateHeader(Customer customer) {
        return String.format(headerTemplate, customer.getName());
    }

    // VisibleForTesting
    protected String generateRental(Rental rental) {
        return String.format(rentalTemplate, rental.getMovie().getTitle(),
                formatMoney(rental.getRentalPrice()));
    }

    // VisibleForTesting
    protected String generateFooter(Customer customer) {
        return String.format(footerTemplate, formatMoney(customer.getTotalCharge()),
                customer.getFrequentRenterPoints());
    }

    // VisibleForTesting
    protected static String formatMoney(BigDecimal bd) {
        return NumberFormat.getCurrencyInstance().format(bd);
    }
}
