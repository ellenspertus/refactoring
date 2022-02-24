package bad.robot.refactoring.chapter1;

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
        double totalAmount = customer.calculateTotalPrice();
        String result = "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }
}
