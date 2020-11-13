package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RentalTest {

	private static final Movie MOVIE_NEW = new Movie("New Movie", Movie.NEW_RELEASE);
	private static final Movie MOVIE_CHILDRENS = new Movie("Children's Movie", Movie.CHILDREN);
	private static final Movie MOVIE_REGULAR = new Movie("Regular Movie", Movie.REGULAR);

	@Test
	void getAmount_CorrectValue_RegularMovie() {
		Rental rental = new Rental(MOVIE_REGULAR, 0);
		assertEquals(2, rental.getRentalPrice());
	}

	@ParameterizedTest
	@CsvSource({ "0,0", "2,6.0", "3,9.0", "5,15.0", "6,18.0", "5,15.0", "5876,17628.0" })
	void getAmount_CorrectValue_NewMovie(int input, double expected) {
		Rental rental = new Rental(MOVIE_NEW, input);
		assertEquals(expected, rental.getRentalPrice());
	}

	@ParameterizedTest
	@CsvSource({ "1,1.5", "2,1.5", "4,3.0", "5,4.5", "7,7.5" })
	void getAmount_CorrectValue_ChildrensMovie(int input, double expected) {
		Rental rental = new Rental(MOVIE_CHILDRENS, input);
		assertEquals(expected, rental.getRentalPrice());
	}
}
