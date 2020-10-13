package bad.robot.refactoring.chapter1;

import java.math.BigDecimal;

public abstract class Price {
	abstract int getPriceCode();

	abstract BigDecimal getCharge(int numDays);

	protected BigDecimal calculateCharge(int numDays, double baseCharge, int rentalPeriod, double dailyLateFee) {
		int extraDays = numDays - rentalPeriod;
		if (extraDays > 0) {
			return BigDecimal.valueOf(baseCharge + extraDays * dailyLateFee);
		} else {
			return BigDecimal.valueOf(baseCharge);
		}
	}
}
