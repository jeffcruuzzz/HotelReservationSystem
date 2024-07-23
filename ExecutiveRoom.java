/**
 * Represents an Executive Room in the hotel.
 * Inherits from the Room class and applies a specific price modification for Executive Rooms.
 */
public class ExecutiveRoom extends Room {
    /**
     * Constructs an ExecutiveRoom with the specified name and base price.
     * The price for Executive Rooms is set to be 35% higher than the base price.
     * 
     * @param name The name or identifier for the Executive Room.
     * @param basePrice The base price of the room before applying the Executive modification.
     */
    public ExecutiveRoom(String name, double basePrice) {
        super(name, basePrice * 1.35);
    }
}