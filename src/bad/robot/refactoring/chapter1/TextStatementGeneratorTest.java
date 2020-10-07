package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TextStatementGeneratorTest {
    private static final String CUSTOMER_NAME = "Elvis";
    private static final Customer CUSTOMER = new Customer(CUSTOMER_NAME);
    private static final TextStatementGenerator GENERATOR = TextStatementGenerator.getInstance();
    private static final String MOVIE_TITLE = "Hamilton";
    private static final Movie MOVIE = new Movie(MOVIE_TITLE, Movie.NEW_RELEASE);
    private static final int NUM_DAYS = 5;
    private static final Rental RENTAL = new Rental(MOVIE, NUM_DAYS);

    @Test
    void generateHeader_ExpectedOutput_ValidCustomer() {
        assertEquals("Rental Record for " + CUSTOMER_NAME + "\n",
                GENERATOR.generateHeader(CUSTOMER));
    }

    @Test
    void generateRental_ExpectedOutput_ValidRental() {
        assertEquals(
                "\tHamilton\t" + StatementGenerator.formatMoney(RENTAL.getRentalPrice()) + "\n",
                GENERATOR.generateRental(RENTAL));
    }

}
