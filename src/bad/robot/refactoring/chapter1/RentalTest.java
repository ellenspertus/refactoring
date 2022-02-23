package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.*;

class RentalTest {
    private static final Movie FINDING_NEMO = new Movie("Finding Nemo", Movie.CHILDREN);
    private static final Movie DEATH_ON_THE_NILE =
            new Movie("Death on the Nile", Movie.NEW_RELEASE);
    private static final Movie THE_BLIND_SIDE = new Movie("The Blind Side", Movie.REGULAR);

    @Test
    void testGetPrice() {
        Rental m1 = new Rental (FINDING_NEMO, 3);
        assertEquals(1.5,m1.getPrice());
    }

    @Test
    void testGetPrice2() {
        Rental m1 = new Rental (FINDING_NEMO, 5);
        assertEquals(4.5,m1.getPrice());
    }

    @Test
    void testGetPrice3() {
        Rental m1 = new Rental (FINDING_NEMO, 10);
        assertEquals(12,m1.getPrice());
    }

}
