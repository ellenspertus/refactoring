package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RentalTest {
    private static final Movie MOVIE_NEW = new Movie("Onward", Movie.NEW_RELEASE);
    private static final Movie MOVIE_CHILDRENS = new Movie("Sinbad", Movie.CHILDREN);
    private static final Movie MOVIE_REGULAR = new Movie("2012", Movie.REGULAR);

    @Test
    void getAmount_CorrectValue_RegularMovie() {
        Rental rental = new Rental(MOVIE_REGULAR, 1);
        assertEquals(2, rental.getRentalPrice());
    }

    @ParameterizedTest
    @CsvSource({"3,3.5","4,5","1,2","5,6.5"})
    void getAmount_CorrectValue_RegularMovies(String daysRented, String expectedPrice)
    {
        Rental rental = new Rental(MOVIE_REGULAR, Integer.parseInt(daysRented));
        assertEquals(Integer.parseInt(expectedPrice), rental.getRentalPrice());
    }
}
