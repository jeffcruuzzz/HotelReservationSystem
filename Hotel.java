import java.util.ArrayList;
import java.util.List;

/**
 * Represents a hotel with various rooms and reservations.
 * Manages room creation, reservation handling, price updates, and availability checks.
 */
public class Hotel {
    /**
     * The name of the hotel.
     */
    private String name;

    /**
     * List of rooms in the hotel.
     */
    private List<Room> rooms;

    /**
     * List of reservations made at the hotel.
     */
    private List<Reservation> reservations;

    /**
     * Base price for rooms in the hotel.
     */
    private double basePrice;

    /**
     * Number of standard rooms in the hotel.
     */
    private int standardRoomCount;

    /**
     * Number of deluxe rooms in the hotel.
     */
    private int deluxeRoomCount;

    /**
     * Number of executive rooms in the hotel.
     */
    private int executiveRoomCount;

    /**
     * Date-based price modifiers for rooms.
     */
    private DatePriceModifier datePriceModifier;

    /**
     * Constructs a new Hotel with the specified name and number of each room type.
     * Initializes rooms with default prices and sets up the date price modifier.
     * 
     * @param name The name of the hotel.
     * @param numStandard Number of standard rooms.
     * @param numDeluxe Number of deluxe rooms.
     * @param numExecutive Number of executive rooms.
     */
    public Hotel(String name, int numStandard, int numDeluxe, int numExecutive) {
        this.name = name;                                       // Initialize hotel name
        this.rooms = new ArrayList<>();                         // Initialize list of rooms
        this.reservations = new ArrayList<>();                  // Initialize list of reservations
        this.basePrice = 1299.0;                                // Set base price for rooms
        this.standardRoomCount = numStandard;                   // Set number of standard rooms
        this.deluxeRoomCount = numDeluxe;                       // Set number of deluxe rooms
        this.executiveRoomCount = numExecutive;                 // Set number of executive rooms
        this.datePriceModifier = new DatePriceModifier();       // Initialize date-based price modifier

        int standardCounter = 1;    // Counter for standard room names
        int deluxeCounter = 1;      // Counter for deluxe room names
        int executiveCounter = 1;   // Counter for executive room names

        // Create and add standard rooms to the list
        for (int i = 0; i < numStandard; i++) {
            rooms.add(new StandardRoom("S" + standardCounter, basePrice));
            standardCounter++;
        }
        // Create and add deluxe rooms to the list
        for (int i = 0; i < numDeluxe; i++) {
            rooms.add(new DeluxeRoom("D" + deluxeCounter, basePrice));
            deluxeCounter++;
        }
        // Create and add executive rooms to the list
        for (int i = 0; i < numExecutive; i++) {
            rooms.add(new ExecutiveRoom("E" + executiveCounter, basePrice));
            executiveCounter++;
        }
    }

    /**
     * Gets the name of the hotel.
     * 
     * @return The name of the hotel.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the hotel.
     * 
     * @param name The new name of the hotel.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the list of rooms in the hotel.
     * 
     * @return The list of rooms.
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * Gets the list of reservations made at the hotel.
     * 
     * @return The list of reservations.
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Adds a new room of the specified type to the hotel.
     * 
     * @param roomType The type of the room to add (standard, deluxe, or executive).
     */
    public void addRoom(String roomType) {
        if (rooms.size() < 50) {
            switch (roomType.toLowerCase()) {
                case "standard":
                    standardRoomCount++;
                    rooms.add(new StandardRoom("S" + standardRoomCount, basePrice));
                    break;
                case "deluxe":
                    deluxeRoomCount++;
                    rooms.add(new DeluxeRoom("D" + deluxeRoomCount, basePrice * 1.20));
                    break;
                case "executive":
                    executiveRoomCount++;
                    rooms.add(new ExecutiveRoom("E" + executiveRoomCount, basePrice * 1.35));
                    break;
                default:
                    System.out.println("Invalid room type.");
                    return;
            }

            // Sort rooms by type and then numerically within each type
            int n = rooms.size();
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        Room room1 = rooms.get(j);
                        Room room2 = rooms.get(j + 1);
        
                        // Extract room types
                        char roomType1 = room1.getName().charAt(0);
                        char roomType2 = room2.getName().charAt(0);
        
                        // Define the order of room types ('S' < 'D' < 'E')
                        String order = "SDE";
        
                        // Compare based on predefined order
                        if (order.indexOf(roomType1) > order.indexOf(roomType2)) {
                            // Swap rooms
                            Room temp = rooms.get(j);
                            rooms.set(j, rooms.get(j + 1));
                            rooms.set(j + 1, temp);
                        } else if (roomType1 == roomType2) {
                            // If same type, extract numeric parts and compare numerically
                            String numPart1 = room1.getName().substring(1);
                            String numPart2 = room2.getName().substring(1);
            
                            // Convert numeric parts to integers
                            int num1 = Integer.parseInt(numPart1);
                            int num2 = Integer.parseInt(numPart2);
            
                            // Compare numerically
                            if (num1 > num2) {
                                // Swap rooms
                                Room temp = rooms.get(j);
                                rooms.set(j, rooms.get(j + 1));
                                rooms.set(j + 1, temp);
                            }
                        }
                    }
                }

            System.out.println(roomType + " room added successfully.");
        } else {
            System.out.println("Cannot add more rooms! Maximum limit reached.");
        }
    }

    /**
     * Checks if a room with the specified name exists in the hotel.
     * 
     * @param roomName The name of the room to check.
     * @return True if the room exists; false otherwise.
     */
    public boolean roomExists(String roomName) {
        for (Room room : rooms) {
            if (room.getName().equalsIgnoreCase(roomName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes a room with the specified name from the hotel.
     * The room must not be booked to be removed.
     * 
     * @param roomName The name of the room to remove.
     */
    public void removeRoom(String roomName) {
        if (!roomExists(roomName)) {
            System.out.println("Room " + roomName + " does not exist.");
            return;
        }

        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            if (room.getName().equalsIgnoreCase(roomName) && !room.isBooked()) {
                rooms.remove(i);
                System.out.println("Room " + roomName + " removed successfully.");
                return;
            }
        }
        System.out.println("Room " + roomName + " cannot be removed. It is currently booked.");
    }

    /**
     * Checks if a room with the specified name is booked.
     * 
     * @param roomName The name of the room to check.
     * @return True if the room is booked; false otherwise.
     */
    public boolean isRoomBooked(String roomName) {
        for (Room room : rooms) {
            if (room.getName().equalsIgnoreCase(roomName) && room.isBooked()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if there are any active reservations in the hotel.
     * 
     * @return True if there are active reservations; false otherwise.
     */
    public boolean hasActiveReservations() {
        return !reservations.isEmpty();
    }

    /**
     * Updates the base price for rooms in the hotel.
     * The price can only be updated if there are no active reservations.
     * 
     * @param newPrice The new price to set.
     */
    public void updatePrice(double newPrice) {
        if (newPrice >= 100.0) {
            if (hasActiveReservations()) {
                System.out.println("Cannot update price as there are active reservations.");
            } else {
                for (Room room : rooms) {
                    room.setPrice(newPrice);
                }
                this.basePrice = newPrice;
                System.out.println("Price updated successfully.");
            }
        } else {
            System.out.println("Price per night must be greater or equal to 100.0!");
        }
    }

    /**
     * Updates the base price for rooms in the hotel and returns a status indicator.
     * The price can only be updated if there are no active reservations.
     * 
     * @param newPrice The new price to set.
     * @return True if the price was updated successfully; false if there are active reservations.
     */
    public boolean updatePriceGUI(double newPrice) {
        if (newPrice >= 100.0) {
            if (hasActiveReservations()) {
                return false; // Cannot update price if there are active reservations
            } else {
                for (Room room : rooms) {
                    room.setPrice(newPrice);
                }
                this.basePrice = newPrice;
                return true; // Price updated successfully
            }
        } else {
            System.out.println("Price per night must be greater or equal to 100.0!");
            return false;
        }
    }

    /**
     * Adds a reservation to the hotel.
     * The reservation is added if it is valid.
     * 
     * @param reservation The reservation to add.
     */
    public void addReservation(Reservation reservation) {
        if (reservation.isValid()) {
            reservations.add(reservation);
            reservation.getRoom().bookRoom();
            System.out.println("Room " + reservation.getRoom().getName() + " booked successfully. Total price: " + reservation.getTotalPrice(this));
        } else {
            System.out.println("Invalid reservation details.");
        }
    }

    /**
     * Calculates the estimated earnings from all reservations.
     * 
     * @return The estimated earnings.
     */
    public double estimatedEarnings() {
        double totalEarnings = 0.0;

        for (Reservation reservation : reservations) {
            totalEarnings += reservation.getSumPrice();
        }

        return totalEarnings;
    }

    /**
     * Gets the count of available rooms on a specific day.
     * 
     * @param day The day to check.
     * @return The count of available rooms.
     */
    public int getAvailableRoomsCount(int day) {
        int count = 0;
        for (Room room : rooms) {
            if (!room.isBookedOnDay(day, reservations)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Gets the count of booked rooms on a specific day.
     * 
     * @param day The day to check.
     * @return The count of booked rooms.
     */
    public int getBookedRoomsCount(int day) {
        return rooms.size() - getAvailableRoomsCount(day);
    }

    /**
     * Finds a room by its name.
     * 
     * @param roomName The name of the room to find.
     * @return The room if found; null otherwise.
     */
    public Room getRoomByName(String roomName) {
        for (Room room : rooms) {
            if (room.getName().equalsIgnoreCase(roomName)) {
                return room;
            }
        }
        return null;
    }

    /**
     * Gets the availability of a specific room for the month.
     * 
     * @param roomName The name of the room to check.
     * @return A string representing the room's availability for the month.
     */
    public String getAvailabilityForMonth(String roomName) {
        String availabilityInfo = "Availability for the month:\n";
        int numDaysInMonth = 31;

        Room specifiedRoom = null;
        for (Room room : rooms) {
            if (room.getName().equalsIgnoreCase(roomName)) {
                specifiedRoom = room;
                break;
            }
        }

        if (specifiedRoom == null) {
            return "Room not found.";
        }

        availabilityInfo += "Room Name: " + specifiedRoom.getName() + "\n";

        for (int day = 1; day <= numDaysInMonth; day++) {
            boolean isBooked = specifiedRoom.isBookedOnDay(day, reservations);
            availabilityInfo += "2024-01-" + String.format("%02d", day) + ": " + (isBooked ? "Booked" : "Available") + "\n";
        }
        return availabilityInfo;
    }

    /**
     * Displays the names of all rooms in the hotel.
     * 
     * @return A list of room names.
     */
    public List<String> displayRoomNames() {
        List<String> roomNames = new ArrayList<>();
        for (Room room : rooms) {
            roomNames.add(room.getName());
        }
        return roomNames;
    }

    /**
     * Removes a reservation with the specified details.
     * 
     * @param guestName The name of the guest.
     * @param roomName The name of the room.
     * @param checkInDay The check-in day.
     * @param checkOutDay The check-out day.
     */
    public void removeReservation(String guestName, String roomName, int checkInDay, int checkOutDay) {
        Reservation reservationToRemove = null;

        for (Reservation reservation : reservations) {
            if (reservation.getGuestName().equalsIgnoreCase(guestName) &&
                reservation.getRoom().getName().equalsIgnoreCase(roomName) &&
                reservation.getCheckInDay() == checkInDay &&
                reservation.getCheckOutDay() == checkOutDay) {
                reservationToRemove = reservation;
                break;
            }
        }

        if (reservationToRemove != null) {
            reservations.remove(reservationToRemove);
            reservationToRemove.getRoom().releaseRoom();
            System.out.println("Reservation removed successfully.");
        } else {
            System.out.println("Reservation not found.");
        }
    }

    /**
     * Checks if a reservation with the specified details exists.
     * 
     * @param guestName The name of the guest.
     * @param roomName The name of the room.
     * @param checkInDay The check-in day.
     * @param checkOutDay The check-out day.
     * @return True if the reservation exists; false otherwise.
     */
    public boolean checkReservationExists(String guestName, String roomName, int checkInDay, int checkOutDay) {
        for (Reservation reservation : reservations) {
            if (reservation.getGuestName().equalsIgnoreCase(guestName) &&
                reservation.getRoom().getName().equalsIgnoreCase(roomName) &&
                reservation.getCheckInDay() == checkInDay &&
                reservation.getCheckOutDay() == checkOutDay) {
                return true; // Reservation found
            }
        }
        return false; // No reservation found with given details
    }

    /**
     * Adds a date-based price modifier for the specified day.
     * 
     * @param day The day to modify.
     * @param rate The new price rate for the day.
     * @return True if the modifier was added successfully; false otherwise.
     */
    public boolean addDatePriceModifier(int day, double rate) {
        return datePriceModifier.addPriceModifier(day, rate);
    }

    /**
     * Gets the price modifier for a specific day.
     * 
     * @param day The day to get the modifier for.
     * @return The price modifier for the day.
     */
    public double getDatePriceModifier(int day) {
        return datePriceModifier.getModifier(day);
    }
}
