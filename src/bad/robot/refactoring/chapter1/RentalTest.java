package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RentalTest {
  private static final Movie MOVIE_NEW = new Movie("Matrix", Movie.NEW_RELEASE);
  private static final Movie MOVIE_CHILDRENS = new Movie("Children's Movie", Movie.CHILDREN);
  private static final Movie MOVIE_REGULAR = new Movie("Regular Movie", Movie.REGULAR);

  // if (getDaysRented() > 2) amount += (getDaysRented() - 2) * 1.5;

  @ParameterizedTest
  @CsvSource({"2, 2", "3, 3.5", "4, 5"})
  void getAmount_CorrectValue_RegularMovies(int days, double cost) {
    Rental rental = new Rental(MOVIE_REGULAR, days);
    assertEquals(cost, rental.getRentalPrice(), "Wrong cost!!!");
  }
}
