package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RentalTest {

    private static final Movie MOVIE_NEW = new Movie("Elona Holmes", Movie.NEW_RELEASE);
    private static final Movie MOVIE_CHILDRENS = new Movie("The Dark Crystal", Movie.CHILDREN);
    private static final Movie MOVIE_REGULAR = new Movie("Animal House", Movie.REGULAR);

    @ParameterizedTest
    @CsvSource({"1,2", "2,2", "3,3.5", "4,5"})
    void getAmount_CorrectValue_RegularMovie(int days, double cost) {
        Rental rental = new Rental(MOVIE_REGULAR, days);
        assertEquals(cost, rental.getRentalPrice());
    }
}
