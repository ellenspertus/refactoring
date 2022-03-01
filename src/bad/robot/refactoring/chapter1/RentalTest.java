package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class RentalTest {
    private static final Movie FINDING_NEMO = new Movie("Finding Nemo", Movie.CHILDREN);
    private static final Movie DEATH_ON_THE_NILE =
            new Movie("Death on the Nile", Movie.NEW_RELEASE);
    private static final Movie THE_BLIND_SIDE = new Movie("The Blind Side", Movie.REGULAR);

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
}
