package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RentalTest {
    private static final Movie MOVIE_NEW = new Movie("New Movie", Movie.NEW_RELEASE);
    private static final Movie MOVIE_CHILDRENS = new Movie("children's movies", Movie.CHILDREN);
    private static final Movie MOVIE_REGULAR = new Movie("regular Movie", Movie.REGULAR);

    @ParameterizedTest
    @CsvSource({"1,3", "2,6", "3,9", "10,30"})
    void getAmount_CorrectValue_NewMovie(int days, int cost) {
        Rental rental1 = new Rental(MOVIE_NEW, days);
        assertEquals(cost, rental1.getRentPrice(), "Wrong cost for " + days + "-day rental");
    }

    @ParameterizedTest
    @CsvSource({"1,1.5", "2,1.5", "3,1.5", "10,12"})
    void getAmount_CorrectValue_ChildrensMovie(int days, double cost) {
        Rental rental1 = new Rental(MOVIE_CHILDRENS, days);
        assertEquals(cost, rental1.getRentPrice(), "Wrong cost for " + days + "-day rental");
    }

    @ParameterizedTest
    @CsvSource({"1,2", "2,2", "3,3.5", "10,14"})
    void getAmount_CorrectValue_RegularMovie(int days, double cost) {
        Rental rental1 = new Rental(MOVIE_REGULAR, days);
        assertEquals(cost, rental1.getRentPrice(), "Wrong cost for " + days + "-day rental");
    }
}
