package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class RentalTest {
  private static final Movie MOVIE_NEW = new Movie("New Movie", Movie.NEW_RELEASE);
  private static final Movie MOVIE_CHILDRENS = new Movie("New Movie", Movie.CHILDREN);
  private static final Movie MOVIE_REGULAR = new Movie("New Movie", Movie.REGULAR);

  @Test
  void getAmount_CorrectValue_NewMovie() {
    Rental rental = new Rental(MOVIE_NEW, 1); // simplest case, 1 day rented
    assertEquals(3, rental.getRentalPrice());
  }

  @Test
  void getAmount_CorrectValue_RegularMovie() {
    Rental rental = new Rental(MOVIE_REGULAR, 1); // simplest case, 1 day rented
    assertEquals(2, rental.getRentalPrice());
  }

  @Test
  void getAmount_CorrectValue_ChildrensMovie() {
    Rental rental = new Rental(MOVIE_CHILDRENS, 1); // simplest case, 1 day rented
    assertEquals(1.5, rental.getRentalPrice());
  }

}
