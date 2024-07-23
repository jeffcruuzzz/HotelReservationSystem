/**
 * Represents a Deluxe Room in the hotel.
 * Inherits from the Room class and applies a specific price modification for Deluxe Rooms.
 */
public class DeluxeRoom extends Room {
    /**
     * Constructs a DeluxeRoom with the specified name and base price.
     * The price for Deluxe Rooms is set to be 20% higher than the base price.
     * 
     * @param name The name or identifier for the Deluxe Room.
     * @param basePrice The base price of the room before applying the Deluxe modification.
     */
    public DeluxeRoom(String name, double basePrice) {
        super(name, basePrice * 1.2);
    }
}