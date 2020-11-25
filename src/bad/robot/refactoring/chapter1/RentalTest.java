package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RentalTest {
    private static final Movie MOVIE_NEW = new Movie("Onward", Movie.NEW_RELEASE);
    private static final Movie MOVIE_CHILDRENS = new Movie("Sinbad", Movie.CHILDREN);
    private static final Movie MOVIE_REGULAR = new Movie("2012", Movie.REGULAR);

    @ParameterizedTest
    @CsvSource({"1,1.5", "2,1.5", "3,1.5", "5,4.5", "6,6", "9999,14995.5"})
    void getAmount_CorrectValue_ChildrensMovie(int input, double expected) {
        Rental rental = new Rental(MOVIE_CHILDRENS, input);
        assertEquals(expected, rental.getRentalPrice().doubleValue());
    }

    @Test
    void getAmount_CorrectValue_RegularMovie() {
        Rental rental = new Rental(MOVIE_REGULAR, 1);
        assertEquals(2, rental.getRentalPrice().doubleValue());
    }

    @ParameterizedTest
    @CsvSource({"3,3.5", "4,5", "1,2", "5,6.5"})
    void getAmount_CorrectValue_RegularMovies(int daysRented, double expectedPrice) {
        Rental rental = new Rental(MOVIE_REGULAR, daysRented);
        assertEquals(expectedPrice, rental.getRentalPrice().doubleValue());
    }

    @ParameterizedTest
    @CsvSource({"1,3", "2,6", "3,9", "10,30"})
    void getAmount_CorrectValue_NewMovie(int days, int cost) {
        Rental rental = new Rental(MOVIE_NEW, days);
        assertEquals(cost, rental.getRentalPrice().doubleValue(),
                "Wrong cost for " + days + "-day rental");
    }
}
