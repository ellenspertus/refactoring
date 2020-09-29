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
    void getAmount_CorrectValue_RegularMovie1(int days, double cost) {
        Rental rental = new Rental(MOVIE_REGULAR, days);
        assertEquals(cost, rental.getRentalPrice());

    @ParameterizedTest
    @CsvSource({"1,3", "2,6", "3,9", "10,30"})
    void getAmount_CorrectValue_NewMovie1(int days, int cost) {
        Rental rental = new Rental(MOVIE_NEW, days);
        assertEquals(cost, rental.getRentalPrice(), "Wrong cost for " + days + "-day rental");
    }
}
