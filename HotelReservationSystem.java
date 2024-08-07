import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents the hotel reservation system that manages a list of hotels and provides
 * functionalities for creating hotels, viewing and managing hotels, simulating bookings,
 * displaying room availability, showing hotel earnings, and applying date-based price modifiers.
 */
public class HotelReservationSystem {
    private List<Hotel> hotels;

    /**
     * Constructs a new HotelReservationSystem with an empty list of hotels.
     */
    public HotelReservationSystem() {
        this.hotels = new ArrayList<>();
    }

    /**
     * Creates a new hotel and adds it to the system.
     * 
     * @param name The name of the hotel.
     * @param numStandard The number of Standard rooms.
     * @param numDeluxe The number of Deluxe rooms.
     * @param numExecutive The number of Executive rooms.
     */
    public void createHotel(String name, int numStandard, int numDeluxe, int numExecutive) {
        if (getHotel(name) != null) {
            System.out.println("Hotel name must be unique.");
            return;
        }

        if ((numStandard + numDeluxe + numExecutive) < 1 || 
            (numStandard + numDeluxe + numExecutive) > 50) {
            System.out.println("Total number of rooms must be between 1 and 50.");
            return;
        }

        hotels.add(new Hotel(name, numStandard, numDeluxe, numExecutive));
    }

    /**
     * Retrieves a hotel by its name.
     * 
     * @param name The name of the hotel.
     * @return The hotel with the specified name, or null if not found.
     */
    public Hotel getHotel(String name) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(name)) {
                return hotel;
            }
        }
        return null;
    }

    /**
     * Views details of a specific hotel.
     * Provides options for high-level and low-level information.
     * 
     * @param name The name of the hotel to view.
     */
    public void viewHotel(String name) {
        Hotel hotel = getHotel(name);
        Scanner scanner = new Scanner(System.in);
    
        if (hotel != null) {
            System.out.println("[1] High-level information");
            System.out.println("[2] Low-level information");
            System.out.println("[3] Exit");
    
            int choice = scanner.nextInt();
            scanner.nextLine();
    
            switch (choice) {
                case 1: 
                    System.out.println("Hotel Name: " + hotel.getName());
                    System.out.println("Total Rooms: " + hotel.getRooms().size());
                    System.out.println("Estimated Earnings: " + hotel.estimatedEarnings());
                    break;
                case 2:
                    System.out.println("[1] Total number of available and booked rooms for a selected date.");
                    System.out.println("[2] Information about a selected room, such as the room name, price per night, and availability across the entire month\r");
                    System.out.println("[3] Information about a selected reservation, such as the guest information, room information, check-in and -out dates, the total price for the booking, and the breakdown of the price per night");
                    System.out.println("[4] Exit");
            
                    int ans = scanner.nextInt();
                    scanner.nextLine();
            
                    switch (ans) {
                        case 1:
                            System.out.print("Enter day (1-31): ");
                            int day = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Available Rooms: " + hotel.getAvailableRoomsCount(day));
                            System.out.println("Booked Rooms: " + hotel.getBookedRoomsCount(day));
                            break;
                        case 2:
                            System.out.print("Enter room name: ");
                            String roomName = scanner.nextLine();
                            Room room = hotel.getRoomByName(roomName);
                            if (room != null) {
                                System.out.println("Room Name: " + room.getName());
                                System.out.println("Price per Night: " + room.getPrice());
                                System.out.println(hotel.getAvailabilityForMonth(roomName));
                            } else {
                                System.out.println("Room not found.");
                            }
                            break;
                        case 3:
                            System.out.println("Enter guest name: ");
                            String guestName = scanner.nextLine();
            
                            boolean reservationFound = false;
            
                            for (Reservation reservation : hotel.getReservations()) {
                                if (reservation.getGuestName().equalsIgnoreCase(guestName)) {
                                    System.out.println("Reservation Details:");
                                    System.out.println("Guest Name: " + reservation.getGuestName());
                                    System.out.println("Room Name: " + reservation.getRoom().getName());
                                    System.out.println("Check-in Date: " + reservation.getCheckInDay());
                                    System.out.println("Check-out Date: " + reservation.getCheckOutDay());
                                    System.out.println("Total Price: " + reservation.getSumPrice());
                                    System.out.println("Price per Night: " + reservation.getPricePerNight());
                                    reservationFound = true;
                                    break;
                                }
                            }
            
                            if (!reservationFound) {
                                System.out.println("Reservation not found for guest: " + guestName);
                            }
                            break;
                        default:
                            System.out.println("Choice not found.");
                            break;
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Choice not found.");
                    break;
            }
        } else {
            System.out.println("Hotel not found.");
        }
    }

    /**
     * Manages a specific hotel, providing options to change its name, add or remove rooms,
     * update room prices, remove reservations, or remove the hotel itself.
     * 
     * @param name The name of the hotel to manage.
     */
    public void manageHotel(String name) {
        Hotel hotel = getHotel(name);
        if (hotel != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Manage Hotel " + name);
            System.out.println("[1] Change name");
            System.out.println("[2] Add room");
            System.out.println("[3] Remove room");
            System.out.println("[4] Update price per night");
            System.out.println("[5] Remove reservation");
            System.out.println("[6] Remove hotel");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter new name:");
                    String newName = scanner.nextLine();
                    if (getHotel(newName) != null) {
                        System.out.println("Hotel name must be unique.");
                    } else {
                        String confirmation;
                        do {
                            System.out.println("Confirm change of hotel name to " + newName + "? (yes/no)");
                            confirmation = scanner.nextLine();
                        } while (!confirmation.equalsIgnoreCase("yes") && !confirmation.equalsIgnoreCase("no"));
                        
                        if (confirmation.equalsIgnoreCase("yes")) {
                            hotel.setName(newName);
                            System.out.println("Hotel name changed successfully.\n");
                        } else {
                            System.out.println("Modification discarded.\n");
                        }
                    }
                    break;
                case 2:
                    String confirmationAddRoom;
                    do {
                        System.out.println("Confirm addition of a new room? (yes/no)");
                        confirmationAddRoom = scanner.nextLine();
                    } while (!confirmationAddRoom.equalsIgnoreCase("yes") && !confirmationAddRoom.equalsIgnoreCase("no"));
                
                    if (confirmationAddRoom.equalsIgnoreCase("yes")) {
                        System.out.print("Enter room type (standard/deluxe/executive): ");
                        String roomType = scanner.nextLine();
                        hotel.addRoom(roomType);
                    } else {
                        System.out.println("Modification discarded.\n");
                    }
                    break;
                case 3:
                    System.out.println("Current rooms:");
                    for (String roomName : hotel.displayRoomNames()) {
                        System.out.println(roomName);
                    }
                    System.out.println("Enter room name to remove:");
                    String roomName = scanner.nextLine();

                    String confirmationRemoveRoom;
                    do {
                        System.out.println("Confirm removal of room " + roomName + "? (yes/no)");
                        confirmationRemoveRoom = scanner.nextLine();
                    } while (!confirmationRemoveRoom.equalsIgnoreCase("yes") && !confirmationRemoveRoom.equalsIgnoreCase("no"));
                
                    if (confirmationRemoveRoom.equalsIgnoreCase("yes")) {
                        hotel.removeRoom(roomName);
                    } else {
                        System.out.println("Modification discarded.\n");
                    }
                    break;
                case 4:
                    System.out.println("Enter new price per night:");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine();
                
                    String confirmationUpdatePrice;
                    do {
                        System.out.println("Confirm update of price per night to " + newPrice + "? (yes/no)");
                        confirmationUpdatePrice = scanner.nextLine();
                    } while (!confirmationUpdatePrice.equalsIgnoreCase("yes") && !confirmationUpdatePrice.equalsIgnoreCase("no"));
                
                    if (confirmationUpdatePrice.equalsIgnoreCase("yes")) {
                        hotel.updatePrice(newPrice);
                    } else {
                        System.out.println("Modification discarded.");
                    }
                    break;
                case 5:
                    System.out.println("Enter guest name:");
                    String guestName = scanner.nextLine();

                    System.out.println("Enter room name:");
                    String roomToRemove = scanner.nextLine();

                    System.out.println("Enter check-in day (1-31):");
                    int checkInDay = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter check-out day (1-31):");
                    int checkOutDay = scanner.nextInt();
                    scanner.nextLine();

                    String confirmationRemoveReservation;
                    do {
                        System.out.println("Confirm removal of reservation for " + guestName + " in room " + roomToRemove + " from day " + checkInDay + " to day " + checkOutDay + "? (yes/no)");
                        confirmationRemoveReservation = scanner.nextLine();
                    } while (!confirmationRemoveReservation.equalsIgnoreCase("yes") && !confirmationRemoveReservation.equalsIgnoreCase("no"));
                
                    if (confirmationRemoveReservation.equalsIgnoreCase("yes")) {
                        hotel.removeReservation(guestName, roomToRemove, checkInDay, checkOutDay);
                    } else {
                        System.out.println("Modification discarded.");
                    }
                    break;
                case 6:
                    String confirmationRemoveHotel;
                    do {
                        System.out.println("Confirm removal of hotel " + name + "? (yes/no)");
                        confirmationRemoveHotel = scanner.nextLine();
                    } while (!confirmationRemoveHotel.equalsIgnoreCase("yes") && !confirmationRemoveHotel.equalsIgnoreCase("no"));
                
                    if (confirmationRemoveHotel.equalsIgnoreCase("yes")) {
                        hotels.remove(hotel);
                        System.out.println("Hotel " + name + " removed successfully.");
                    } else {
                        System.out.println("Modification discarded.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } else {
            System.out.println("Hotel not found.");
        }
    }

    /**
     * Simulates a booking for a specified hotel.
     * 
     * @param hotelName The name of the hotel.
     * @param guestName The name of the guest.
     * @param checkInDay The check-in day (1-31).
     * @param checkOutDay The check-out day (1-31).
     * @param discountCode The discount code to apply.
     */
    public void simulateBooking(String hotelName, String guestName, int checkInDay, int checkOutDay, String discountCode) {

            if (checkInDay > checkOutDay) {
                System.out.println("Check-in date must be before the check-out date.");
                return;
            }

            Hotel hotel = getHotel(hotelName);
            if (hotel != null) {
                System.out.println("Available rooms for booking:");
            List<Room> availableRooms = new ArrayList<>();
            for (Room room : hotel.getRooms()) {
                boolean isAvailable = true;
                for (int day = checkInDay; day <= checkOutDay; day++) {
                    if (room.isBookedOnDay(day, hotel.getReservations())) {
                        isAvailable = false;
                        break;
                    }
                }
                if (isAvailable) {
                    availableRooms.add(room);
                    System.out.println("Room Name: " + room.getName() + ", Price per Night: " + room.getPrice());
                }
            }

            if (availableRooms.isEmpty()) {
                System.out.println("No available rooms for the selected dates.");
                return;
            }

            System.out.print("Enter room name to book: ");
            Scanner scanner = new Scanner(System.in);
            String roomName = scanner.nextLine();

            Room roomToBook = hotel.getRoomByName(roomName);
            if (roomToBook != null && availableRooms.contains(roomToBook)) {
                Reservation reservation = new Reservation(guestName, checkInDay, checkOutDay, roomToBook, discountCode);
                hotel.addReservation(reservation);
                roomToBook.bookRoom();
                System.out.println("Room " + roomToBook.getName() + " booked successfully. Total price: " + reservation.getSumPrice());
            } else {
                System.out.println("Room is not available for the selected dates.");
            }
        } else {
            System.out.println("Hotel not found.");
        }
    }

    /**
     * Displays room availability for a specific hotel and room name.
     * 
     * @param hotelName The name of the hotel.
     * @param roomName The name of the room.
     */
    public void displayRoomAvailability(String hotelName, String roomName) {
        Hotel hotel = getHotel(hotelName);
        if (hotel == null) {
            System.out.println("Hotel not found.");
            return;
        }

        System.out.println(hotel.getAvailabilityForMonth(roomName));
    }

    /**
     * Displays the total earnings for a specific hotel.
     * 
     * @param hotelName The name of the hotel.
     */
    public void showHotelEarnings(String hotelName) {
        Hotel hotel = getHotel(hotelName);
        if (hotel == null) {
            System.out.println("Hotel not found.");
            return;
        }

        double earnings = hotel.estimatedEarnings();
        System.out.println("Estimated Earnings: " + earnings);
    }

    /**
     * Applies a date-based price modifier to a specific hotel.
     * 
     * @param hotelName The name of the hotel.
     * @param day The day (1-31) for the price modifier.
     * @param rate The percentage to adjust the price (50-150).
     */
    public void addDatePriceModifier(String hotelName, int day, double rate) {
        Hotel hotel = getHotel(hotelName);
        if (hotel != null) {
            if (rate >= 0.5 && rate <= 1.5) {
                boolean success = hotel.addDatePriceModifier(day, rate);
                if (success) {
                    // Update each room's price based on the new base price and date price modifier
                    for (Room room : hotel.getRooms()) {
                        double newPrice = room.getPrice() * rate; // Calculate new price based on the modifier
                    }
    
                    // Recalculate the total price for all reservations
                    for (Reservation reservation : hotel.getReservations()) {
                        reservation.getSumPrice(); // Update the total price with the new rates
                    }
    
                    System.out.println("Date price modifier applied and reservations updated successfully.");
                } else {
                    System.out.println("Invalid rate. Rate must be between 0.5 (50%) and 1.5 (150%).");
                }
            } else {
                System.out.println("Rate must be between 0.5 and 1.5.");
            }
        } else {
            System.out.println("Hotel not found.");
        }
    }

    /**
    * Removes the specified hotel from the system.
    * 
    * @param hotel The hotel to be removed.
    */
    public void removeHotel(Hotel hotel) {
        hotels.remove(hotel);
    }

    /**
     * Main method to demonstrate the functionality of the HotelReservationSystem.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        HotelReservationSystem system = new HotelReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("[1] Create Hotel");
            System.out.println("[2] View Hotel");
            System.out.println("[3] Manage Hotel");
            System.out.println("[4] Simulate Booking");
            System.out.println("[5] Display Room Availability");
            System.out.println("[6] Show Hotel Earnings");
            System.out.println("[7] Date Price Modifier");
            System.out.println("[8] Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter hotel name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter number of standard rooms: ");
                    int numStandard = scanner.nextInt();
                    System.out.print("Enter number of deluxe rooms: ");
                    int numDeluxe = scanner.nextInt();
                    System.out.print("Enter number of executive rooms: ");
                    int numExecutive = scanner.nextInt();
                    scanner.nextLine();
                    system.createHotel(name, numStandard, numDeluxe, numExecutive);
                    break;
                case 2:
                    System.out.print("Enter hotel name: ");
                    name = scanner.nextLine();
                    system.viewHotel(name);
                    break;
                case 3:
                    System.out.print("Enter hotel name: ");
                    name = scanner.nextLine();
                    system.manageHotel(name);
                    break;
                case 4:
                    System.out.print("Enter hotel name: ");
                    String hotelName = scanner.nextLine();
                    System.out.print("Enter guest name: ");
                    String guestName = scanner.nextLine();
                    System.out.print("Enter check-in day (1-31): ");
                    int checkInDay = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter check-out day (1-31): ");
                    int checkOutDay = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter discount code (leave blank if none): ");
                    String discountCode = scanner.nextLine();
                    system.simulateBooking(hotelName, guestName, checkInDay, checkOutDay, discountCode);
                    break;
                case 5:
                    System.out.print("Enter hotel name: ");
                    hotelName = scanner.nextLine();
                    System.out.print("Enter room name: ");
                    String roomName = scanner.nextLine();
                    system.displayRoomAvailability(hotelName, roomName);
                    break;
                case 6:
                    System.out.print("Enter hotel name: ");
                    hotelName = scanner.nextLine();
                    system.showHotelEarnings(hotelName);
                    break;
                case 7:
                    System.out.print("Enter hotel name: ");
                    hotelName = scanner.nextLine();
                    System.out.print("Enter day (1-31) to modify: ");
                    int day = scanner.nextInt();
                    System.out.print("Enter rate (50% to 150% of base price): ");
                    double rate = scanner.nextDouble();
                    scanner.nextLine();
                    system.addDatePriceModifier(hotelName, day, rate);
                    break;
                case 8:
                    System.out.println("Exiting system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}