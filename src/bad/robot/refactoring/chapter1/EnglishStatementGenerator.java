package bad.robot.refactoring.chapter1;

public class EnglishStatementGenerator extends StatementGenerator {
    private static final String HEADER_TEMPLATE = "Rental record for %1s\n";
    private static final String RENTAL_TEMPLATE = "\t%1s\t%2s\n";
    private static final String FOOTER_TEMPLATE =
            "Amount owed is %1s\nYou earned %2s frequent renter points";

    public EnglishStatementGenerator() {
        super(HEADER_TEMPLATE, RENTAL_TEMPLATE, FOOTER_TEMPLATE);
    }
}
