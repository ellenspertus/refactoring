package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

class RentalTest {
    private static final Movie MOVIE_NEW = new Movie("New Movie", Movie.NEW_RELEASE);
    private static final Movie MOVIE_CHILDRENS = new Movie("Children's Movie", Movie.CHILDREN);
    private static final Movie MOVIE_REGULAR = new Movie("Regular Movie", Movie.REGULAR);

    @Test
    void getAmount_CorrectValue_RegularMovie() {
        fail("Not yet implemented");
    }

}
