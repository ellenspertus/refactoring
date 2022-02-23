package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.*;

class RentalTest {
    private static final Movie FINDING_NEMO = new Movie("Finding Nemo", Movie.CHILDREN);
    private static final Movie DEATH_ON_THE_NILE =
            new Movie("Death on the Nile", Movie.NEW_RELEASE);
    private static final Movie THE_BLIND_SIDE = new Movie("The Blind Side", Movie.REGULAR);

    @Test
    void testGetPrice() {
        fail("Not yet implemented");
    }

}
