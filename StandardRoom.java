/**
 * Represents a Standard Room in the hotel.
 * Inherits from the Room class and applies the base price without any modification.
 */
public class StandardRoom extends Room {
    /**
     * Constructs a StandardRoom with the specified name and base price.
     * The price for Standard Rooms is set to be equal to the base price without any modification.
     * 
     * @param name The name or identifier for the Standard Room.
     * @param basePrice The base price of the room.
     */
    public StandardRoom(String name, double basePrice) {
        super(name, basePrice);
    }
}