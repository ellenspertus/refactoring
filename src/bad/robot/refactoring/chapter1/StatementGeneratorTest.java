package bad.robot.refactoring.chapter1;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class StatementGeneratorTest {

    @Test
    void formatMoney_CorrectOutput_DollarAmount() {
        String output = StatementGenerator.formatMoney(BigDecimal.valueOf(15));
        assertTrue(output.equals("$15") || output.equals("$15.00"));
    }

    @Test
    void formatMoney_CorrectOutput_SubdollarAmount() {
        String output = StatementGenerator.formatMoney(BigDecimal.valueOf(.15));
        assertTrue(output.equals("$0.15") || output.equals("$.15"));
    }
}
