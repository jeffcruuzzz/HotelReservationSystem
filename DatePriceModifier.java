import java.util.ArrayList;
import java.util.List;

/**
 * Manages price modifiers for specific days of the month.
 * Provides functionality to set and retrieve price modifiers that adjust the nightly rate based on the day of the month.
 */
public class DatePriceModifier {
    /**
     * List of price modifiers for each day of the month.
     * Each element corresponds to a day, with a default value of 1.0 (no modification).
     */
    private List<Double> modifiers;

    /**
     * Initializes the DatePriceModifier with default modifiers.
     * Sets all days of the month to a default modifier of 1.0 (no modification).
     */
    public DatePriceModifier() {
        // Initialize all days with a default modifier of 1.0 (no modification)
        modifiers = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            modifiers.add(1.0);
        }
    }

    /**
     * Adds or updates the price modifier for a specific day of the month.
     * 
     * @param day The day of the month to which the modifier should be applied (1-31).
     * @param rate The price modifier rate (0.5 to 1.5). Rates outside this range are not allowed.
     * @return True if the modifier was successfully added; false otherwise.
     */
    public boolean addPriceModifier(int day, double rate) {
        if (day >= 1 && day <= 31 && rate >= 0.5 && rate <= 1.5) {
            modifiers.set(day - 1, rate);
            return true;
        }
        return false;
    }

    /**
     * Retrieves the price modifier for a specific day of the month.
     * 
     * @param day The day of the month (1-31) for which to retrieve the modifier.
     * @return The price modifier for the specified day, or 1.0 if the day is out of range.
     */
    public double getModifier(int day) {
        if (day >= 1 && day <= 31) {
            return modifiers.get(day - 1);
        }
        return 1.0; // Default modifier if day is out of range
    }
}

