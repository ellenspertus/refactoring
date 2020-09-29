package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RentalTest {
    private static final Movie MOVIE_NEW = new Movie("New Movie", Movie.NEW_RELEASE);
    private static final Movie MOVIE_CHILDRENS = new Movie("Children's Movie", Movie.CHILDREN);
    private static final Movie MOVIE_REGULAR = new Movie("Regular Movie", Movie.REGULAR);

    @ParameterizedTest
    @CsvSource({"1,1.5", "2,1.5", "3,1.5", "5,4.5", "6,6", "9999,14995.5"})
    void getAmount_CorrectValue_ChildrensMovie(int input, double expected) {
        Rental rental = new Rental(MOVIE_CHILDRENS, input);
        assertEquals(expected, rental.getRentalPrice());
    }

}
