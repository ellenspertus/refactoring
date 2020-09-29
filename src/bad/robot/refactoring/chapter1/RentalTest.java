package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
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
        assertEquals(regTwoDay.getRentalPrice(), 2);
    }

    @ParameterizedTest
    @CsvSource({"1,1.5", "3, 1.5", "4, 3", "5, 4.5"})
    void getRentalPrice_CorrectValue_ChildrensMovie(int days, int cost) {
        Rental childRental = new Rental(MOVIE_CHILDRENS, 3);
        assertEquals(cost, childRental.getRentalPrice(), "Wrong cost for " + days);
    }

    @Test
    void getRentalPrice_CorrectValue_NewRelease() {
        fail("Not yet implemented");
    }

    void getRentalPrice_CorrectValue_RegularExtraDays() {
        fail("Not yet implemented");

    }


}
