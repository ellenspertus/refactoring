package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.*;
import java.math.*;
import java.nio.charset.*;
import java.nio.file.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class RentalTest {
    private static final Movie FINDING_NEMO = new Movie("Finding Nemo", Price.CHILDRENS_PRICE);
    private static final Movie DEATH_ON_THE_NILE =
            new Movie("Death on the Nile", NewReleasePrice.getInstance());
    private static final Movie THE_BLIND_SIDE = new Movie("The Blind Side", Price.REGULAR_PRICE);

    @ParameterizedTest
    @CsvSource(value = {"3, 1.5", "5, 4.5", "10, 12"})
    void testGetChildrenPrice(int days, String expected) {
        Rental childrenMovie = new Rental(FINDING_NEMO, days);
        assertEquals(new BigDecimal(expected).doubleValue(),
                childrenMovie.getPrice().doubleValue());
    }

    @ParameterizedTest
    @CsvSource(value = {"2, 6", "4, 12", "1, 3"})
    void testGetNewReleasePrice(int days, String expected) {
        Rental newMovie = new Rental(DEATH_ON_THE_NILE, days);
        assertEquals(new BigDecimal(expected).doubleValue(), newMovie.getPrice().doubleValue());
    }

    @ParameterizedTest
    @CsvSource({"1, 2", "3, 3.5", "10, 14"})
    void testGetRegularPrice(int days, String expected) {
        Rental regularMovie = new Rental(THE_BLIND_SIDE, days);
        assertEquals(new BigDecimal(expected).doubleValue(), regularMovie.getPrice().doubleValue());
    }

    private static String readFile(String fileName) throws IOException {
        Path resourceDirectory = Paths.get("src", "resources", fileName);
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        byte[] encoded = Files.readAllBytes(Paths.get(absolutePath));
        return new String(encoded, Charset.defaultCharset());
    }

    private static String removeCarriageReturns(String s) {
        return s.replaceAll("\r", "");
    }

    @Test
    void testStatementGeneration() throws IOException {
        Customer c = new Customer("Maria");
        Movie cindarella = new Movie("Cindarella", Price.CHILDRENS_PRICE);
        Movie batman = new Movie("Batman", Price.NEW_RENTAL_PRICE);
        c.addRental(new Rental(cindarella, 3));
        c.addRental(new Rental(batman, 2));

        String actual = new EnglishStatementGenerator().generateStatement(c);
        actual = removeCarriageReturns(actual);
        String expected = removeCarriageReturns(readFile("maria-statement.txt"));
        assertEquals(expected, actual);
    }
}
