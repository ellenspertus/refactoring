package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.*;
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
}
