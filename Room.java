import java.util.List;

/**
 * Represents a room in a hotel.
 * Contains information about the room's name, price, and booking status.
 */
public class Room {
    /**
     * The name of the room.
     */
    protected String name;

    /**
     * The price of the room.
     */
    protected double price;

    /**
     * Flag indicating if the room is currently booked.
     */
    protected boolean isBooked;

    /**
     * Constructs a new Room with the specified name and price.
     * The room is initially not booked.
     * 
     * @param name The name of the room.
     * @param price The price of the room.
     */
    public Room(String name, double price) {
        this.name = name;           // Initialize the room's name.
        this.price = price;         // Initialize the room's price.
        this.isBooked = false;      // Room is not booked by default.
    }

    /**
     * Gets the name of the room.
     * 
     * @return The name of the room.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the room.
     * 
     * @return The price of the room.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets a new price for the room.
     * 
     * @param newPrice The new price to set for the room.
     */
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    /**
     * Checks if the room is currently booked.
     * 
     * @return True if the room is booked; false otherwise.
     */
    public boolean isBooked() {
        return isBooked;
    }

    /**
     * Checks if the room is booked on a specific day.
     * 
     * @param day The day to check.
     * @param reservations The list of reservations to check against.
     * @return True if the room is booked on the specified day; false otherwise.
     */
    public boolean isBookedOnDay(int day, List<Reservation> reservations) {
        // Iterate through the list of reservations.
        for (Reservation reservation : reservations) {
            // Check if the reservation includes the specified day and the room matches.
            if (reservation.isDayWithinReservation(day) && reservation.getRoom().equals(this)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Marks the room as booked.
     */
    public void bookRoom() {
        isBooked = true;
    }

    /**
     * Marks the room as available (not booked).
     */
    public void releaseRoom() {
        isBooked = false;
    }
}
