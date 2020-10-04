package bad.robot.refactoring.chapter1;

public class TextStatementGenerator extends StatementGenerator {
    private static final String HEADER_TEMPLATE = "Rental Record for %1s\n";
    private static final String RENTAL_TEMPLATE = "\t%1s\t%2s\n";
    private static final String FOOTER_TEMPLATE =
            "Amount owed is %1s\nYou earned %d frequent renter points\n";

    public static final TextStatementGenerator INSTANCE = new TextStatementGenerator();

    public static TextStatementGenerator getInstance() {
        return INSTANCE;
    }

    private TextStatementGenerator() {
        super(HEADER_TEMPLATE, RENTAL_TEMPLATE, FOOTER_TEMPLATE);
    }
}
