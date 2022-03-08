package bad.robot.refactoring.chapter1;

public class EnglishStatementGenerator extends StatementGenerator {
    private static final String HEADER_TEMPLATE = "Rental record for %s\n";
    private static final String RENTAL_TEMPLATE = "\t%s\t%s\n";
    private static final String FOOTER_TEMPLATE =
            "Amount owed is %s\nYou earned %s frequent renter points";

    public EnglishStatementGenerator() {
        super(HEADER_TEMPLATE, RENTAL_TEMPLATE, FOOTER_TEMPLATE);
    }
}
