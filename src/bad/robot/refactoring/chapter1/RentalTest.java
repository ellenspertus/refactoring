package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RentalTest {
    private static final Movie MOVIE_NEW = new Movie("New Movie", Movie.NEW_RELEASE);
    private static final Movie MOVIE_CHILDRENS = new Movie("Children's Movie", Movie.CHILDREN);
    private static final Movie MOVIE_REGULAR = new Movie("Regular Movie", Movie.REGULAR);

    @ParameterizedTest
    @CsvSource({"1,3", "2,6", "3,9", "10,30"})
    void getAmount_CorrectValue_NewMovie(int days, int cost) {
        Rental rental = new Rental(MOVIE_NEW, days);
        assertEquals(cost, rental.getRentalPrice(), "Wrong cost for " + days + "-day rental");
    }
}
