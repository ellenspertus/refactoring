package bad.robot.refactoring.chapter1;

public class SpanishStatementGenerator extends StatementGenerator {
    private static final String HEADER_TEMPLATE = "Registro de alqiuiler de %s\n";
    private static final String RENTAL_TEMPLATE = "\t%s\t%s\n";
    private static final String FOOTER_TEMPLATE =
            "El monto adeudado es %s\nGanaste %s puntos de arrendatario frecuente";
    private static final SpanishStatementGenerator INSTANCE = new SpanishStatementGenerator();

    private SpanishStatementGenerator() {
        super(HEADER_TEMPLATE, RENTAL_TEMPLATE, FOOTER_TEMPLATE);
    }

    public static SpanishStatementGenerator getInstance() {
        return INSTANCE;
    }
}
