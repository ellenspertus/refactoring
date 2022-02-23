package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class RentalTest {
    private static final Movie FINDING_NEMO = new Movie("Finding Nemo", Movie.CHILDREN);
    private static final Movie DEATH_ON_THE_NILE =
            new Movie("Death on the Nile", Movie.NEW_RELEASE);
    private static final Movie THE_BLIND_SIDE = new Movie("The Blind Side", Movie.REGULAR);

    @ParameterizedTest

    @CsvSource(value = {"3, 1.5", "5, 4.5", "10, 12"})
    void testGetChildrenPrice(int days, double expected) {
        Rental childrenMovie = new Rental(FINDING_NEMO, days);
        assertEquals(expected, childrenMovie.getPrice());
    }

    @CsvSource({"1, 2", "3, 3.5", "10, 14"})
    void testGetPrice(int days, double expected) {
        Rental rentTest = new Rental(THE_BLIND_SIDE, days);
        assertEquals(expected, rentTest.getPrice());
    }

    @CsvSource(value = {"2, 6", "4, 12", "1,3"})
    void testGetPriceForNewRelease(int days, int expectedPrice) {
        Rental newMovie = new Rental(DEATH_ON_THE_NILE, days);
        assertEquals(expectedPrice, newMovie.getPrice());
    }
}
