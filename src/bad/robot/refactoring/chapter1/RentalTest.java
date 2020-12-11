package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RentalTest {
    private static final Movie MOVIE_NEW = new Movie("Onward", Movie.NEW_RELEASE);
    private static final Movie MOVIE_CHILDRENS = new Movie("Sinbad", Movie.CHILDREN);
    private static final Movie MOVIE_REGULAR = new Movie("2012", Movie.REGULAR);

    @ParameterizedTest
    @CsvSource({"1,1.50", "2,1.50", "3,1.50", "4,3.00","5,4.50", "6,6.00", "9999,14995.50"})
    void getAmount_CorrectValue_ChildrensMovie(int input, BigDecimal expected) {
        Rental rental = new Rental(MOVIE_CHILDRENS, input);
        assertEquals(expected, rental.getRentalPrice());
    }

    @Test
    void getAmount_CorrectValue_RegularMovie() {
        Rental rental = new Rental(MOVIE_REGULAR, 1);
        assertEquals(2.0, rental.getRentalPrice().doubleValue());
    }

    @ParameterizedTest
    @CsvSource({"3,3.50","4,5.00","1,2.00","5,6.50"})
    void getAmount_CorrectValue_RegularMovies(int daysRented, BigDecimal expectedPrice)
    {
        Rental rental = new Rental(MOVIE_REGULAR, daysRented);
        assertEquals(expectedPrice, rental.getRentalPrice());
    }

    @ParameterizedTest
    @CsvSource({"1,3.00", "2,6.00", "3,9.00", "10,30.00"})
    void getAmount_CorrectValue_NewMovie(int days, BigDecimal cost) {
        Rental rental = new Rental(MOVIE_NEW, days);
        assertEquals(cost, rental.getRentalPrice(), "Wrong cost for " + days + "-day rental");
    }
}
