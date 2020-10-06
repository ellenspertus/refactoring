package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class StatementGenerator {
    private static final String HEADER_TEMPLATE = "Rental Record for %1s\n";
    private static final String RENTAL_TEMPLATE = "\t%1s\t%2s\n";
    private static final String FOOTER_TEMPLATE =
            "Amount owed is %1s\nYou earned %d frequent renter points\n";

    private StatementGenerator() {}

    public static String generateStatement(Customer customer) {
        StringBuilder sb = new StringBuilder();
        sb.append(generateHeader(customer));
        for (Rental rental : customer.getRentals()) {
            sb.append(generateRental(rental));
        }
        sb.append(generateFooter(customer));
        return sb.toString();
    }

    private static String generateHeader(Customer customer) {
        return String.format(HEADER_TEMPLATE, customer.getName());
    }

    private static String generateRental(Rental rental) {
        return String.format(RENTAL_TEMPLATE, rental.getMovie(),
                formatMoney(rental.getRentalPrice()));
    }

    private static String generateFooter(Customer customer) {
        return String.format(FOOTER_TEMPLATE, formatMoney(customer.getTotalCharge()),
                customer.getFrequentRenterPoints());
    }

    private static String formatMoney(BigDecimal bd) {
        return NumberFormat.getCurrencyInstance().format(bd);
    }
}
