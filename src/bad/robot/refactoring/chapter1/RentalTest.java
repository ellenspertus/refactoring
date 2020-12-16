package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RentalTest {
    private static final Movie MOVIE_NEW = new Movie("Onward", Movie.NEW_RELEASE);
    private static final Movie MOVIE_CHILDRENS = new Movie("Sinbad", Movie.CHILDREN);
    private static final Movie MOVIE_REGULAR = new Movie("2012", Movie.REGULAR);

    @ParameterizedTest
    @CsvSource({"1,1.5", "2,1.5", "3,1.5", "5,4.5", "6,6", "9999,14995.5"})
    void getAmount_CorrectValue_ChildrensMovie(int input, String expected) {
        Rental rental = new Rental(MOVIE_CHILDRENS, input);
        BigDecimal expectedValue = new BigDecimal(expected).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expectedValue, rental.getRentalPrice());
    }

    @Test
    void getAmount_CorrectValue_RegularMovie() {
        Rental rental = new Rental(MOVIE_REGULAR, 1);
        assertEquals(new BigDecimal("2.00"), rental.getRentalPrice());
    }

    @ParameterizedTest
    @CsvSource({"3,3.5", "4,5", "1,2", "5,6.5"})
    void getAmount_CorrectValue_RegularMovies(String daysRented, String expectedPrice) {
        Rental rental = new Rental(MOVIE_REGULAR, Integer.parseInt(daysRented));
        BigDecimal expectedValue = new BigDecimal(expectedPrice).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expectedValue, rental.getRentalPrice());
    }

    @ParameterizedTest
    @CsvSource({"1,3", "2,6", "3,9", "10,30"})
    void getAmount_CorrectValue_NewMovie(int days, String cost) {
        Rental rental = new Rental(MOVIE_NEW, days);
        BigDecimal expectedValue = new BigDecimal(cost).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expectedValue, rental.getRentalPrice(), "Wrong cost for " + days + "-day rental");
    }
}
