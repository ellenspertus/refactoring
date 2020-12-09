package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RentalTest {
    private static final Movie MOVIE_NEW = new Movie("The Avengers", Movie.NEW_RELEASE);
    private static final Movie MOVIE_CHILDRENS = new Movie("Frozen", Movie.CHILDREN);
    private static final Movie MOVIE_REGULAR = new Movie("Airplane!", Movie.REGULAR);

    @Test
    void getRentalPrice_CorrectValue_RegularMovieTwoDay() {
        Rental regTwoDay = new Rental(MOVIE_REGULAR, 2);
        assertEquals(BigDecimal.valueOf(2).doubleValue(), regTwoDay.getRentalPrice().doubleValue());
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 1.5", "3, 1.5", "4, 1.5"})
    void getRentalPrice_CorrectValue_ChildrensMovieSO(int days, BigDecimal price) {
        Rental childRental = new Rental(MOVIE_CHILDRENS, 3);
        assertEquals(price.doubleValue(), childRental.getRentalPrice().doubleValue(),
                "Wrong cost for " + days + "days.");
    }

    @ParameterizedTest
    @CsvSource({"1,1.5", "2,1.5", "3,1.5", "5,4.5", "6,6", "9999,14995.5"})
    void getAmount_CorrectValue_ChildrensMovie(int days, BigDecimal price) {
        Rental rental = new Rental(MOVIE_CHILDRENS, days);
        assertEquals(price.doubleValue(), rental.getRentalPrice().doubleValue());
    }

    @Test
    void getAmount_CorrectValue_RegularMovie() {
        Rental rental = new Rental(MOVIE_REGULAR, 1);
        assertEquals(BigDecimal.valueOf(2).doubleValue(), rental.getRentalPrice().doubleValue());
    }

    @ParameterizedTest
    @CsvSource({"3,3.5", "4,5", "1,2", "5,6.5"})
    void getAmount_CorrectValue_RegularMovies(int daysRented, BigDecimal expectedPrice) {
        Rental rental = new Rental(MOVIE_REGULAR, daysRented);
        assertEquals(expectedPrice.doubleValue(), rental.getRentalPrice().doubleValue());
    }

    @ParameterizedTest
    @CsvSource({"1,3", "2,6", "3,9", "10,30"})
    void getAmount_CorrectValue_NewMovie(int days, BigDecimal cost) {
        Rental rental = new Rental(MOVIE_NEW, days);
        assertEquals(cost.doubleValue(), rental.getRentalPrice().doubleValue(),
                "Wrong cost for " + days + "-day rental");
    }
}
