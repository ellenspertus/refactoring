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
    @CsvSource({"1, 2", "3, 3.5", "10, 14"})
    void testGetPrice(int days, double expected) {
        Rental rentTest = new Rental(THE_BLIND_SIDE, days);
        assertEquals(expected, rentTest.getPrice());
    }

}
