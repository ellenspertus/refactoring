package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RentalTest {
  private static final Movie MOVIE_NEW = new Movie("New Movie", Movie.NEW_RELEASE);
  private static final Movie MOVIE_CHILDRENS = new Movie("New Movie", Movie.CHILDREN);
  private static final Movie MOVIE_REGULAR = new Movie("New Movie", Movie.REGULAR);

  @ParameterizedTest(name = "{index} => days={0}, cost={1}")
  @CsvSource({"1,3", "2,6", "7,21"})
  void getAmount_CorrectValue_NewReleaseMovie(int days, int cost) {
    Rental rental = new Rental(MOVIE_NEW, days); // simplest case, 1 day rented
    assertEquals(cost, rental.getRentalPrice());
  }

  @ParameterizedTest(name = "{index} => days={0}, cost={1}")
  @CsvSource({"1,2", "2,2", "7,9.5"})
  void getAmount_CorrectValue_RegularMovie(int days, double cost) {
    Rental rental = new Rental(MOVIE_REGULAR, days); // simplest case, 1 day rented
    assertEquals(cost, rental.getRentalPrice());
  }

  @ParameterizedTest(name = "{index} => days={0}, cost={1}")
  @CsvSource({"1,1.5", "2,1.5", "7,7.5"})
  void getAmount_CorrectValue_ChildrensMovie(int days, double cost) {
    Rental rental = new Rental(MOVIE_CHILDRENS, days); // simplest case, 1 day rented
    assertEquals(cost, rental.getRentalPrice());
  }

}
