package bad.robot.refactoring.chapter1;

public class SpanishStatementGenerator extends StatementGenerator {
    private static final String HEADER_TEMPLATE = "Registro de alqiuiler de %1s\n";
    private static final String RENTAL_TEMPLATE = "\t%1s\t%2s\n";
    private static final String FOOTER_TEMPLATE =
            "El monto adeudado es %1s\nGanaste %2s puntos de arrendatario frecuente";

    public SpanishStatementGenerator() {
        super(HEADER_TEMPLATE, RENTAL_TEMPLATE, FOOTER_TEMPLATE);
    }

}
