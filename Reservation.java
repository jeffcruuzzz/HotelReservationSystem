/**
 * Represents a reservation made by a guest for a specific room in a hotel.
 * Manages reservation details, including guest name, check-in and check-out dates, room, price calculation, and discount application.
 */
public class Reservation {
    /**
     * The name of the guest making the reservation.
     */
    private String guestName;

    /**
     * The day of check-in for the reservation.
     */
    private int checkInDay;

    /**
     * The day of check-out for the reservation.
     */
    private int checkOutDay;

    /**
     * The room being reserved.
     */
    private Room room;

    /**
     * The total price of the reservation after applying discounts.
     */
    private double totalPrice;

    /**
     * Indicates whether the reservation is valid based on check-in and check-out days.
     */
    private boolean isValid;

    /**
     * The discount code applied to the reservation, if any.
     */
    private String discountCode;


    /**
     * Constructs a new Reservation with the specified details.
     * Initializes the reservation and calculates the total price if the reservation is valid.
     * 
     * @param guestName The name of the guest making the reservation.
     * @param checkInDay The day of check-in for the reservation.
     * @param checkOutDay The day of check-out for the reservation.
     * @param room The room being reserved.
     * @param discountCode The discount code applied to the reservation, if any.
     */
    public Reservation(String guestName, int checkInDay, int checkOutDay, Room room, String discountCode) {
        this.guestName = guestName;
        this.checkInDay = checkInDay;
        this.checkOutDay = checkOutDay;
        this.room = room;
        this.discountCode = discountCode;
        
        // Check if the reservation period is valid
        if (checkInDay <= checkOutDay) {
            this.totalPrice = getSumPrice();
            this.isValid = true;
        } else {
            this.isValid = false;
        }
    }

    /**
     * Applies the discount code to the total price of the reservation.
     * 
     * @param totalPrice The original total price before discount.
     * @return The total price after applying the discount.
     */
    private double applyDiscountCode(double totalPrice) {
        // No discount if no code is provided
        if (discountCode == null || discountCode.isEmpty()) {
            return totalPrice;
        }
    
        switch (discountCode) {
            case "I_WORK_HERE":
                return totalPrice * 0.90; // 10% discount
            case "STAY4_GET1":
                if ((checkOutDay - checkInDay + 1) >= 5) {
                    // Calculate the discount for the first free day
                    return totalPrice - room.getPrice(); // First day free
                }
                return totalPrice;
            case "PAYDAY":
                if (coversDay(15) || coversDay(30)) {
                    return totalPrice * 0.93; // 7% discount
                }
                return totalPrice;
            default:
                System.out.println("Invalid discount code.");
                return totalPrice;
        }
    }
    
    /**
     * Checks if the reservation covers a specific day.
     * 
     * @param day The day to check.
     * @return True if the day is within the reservation period; false otherwise.
     */
    private boolean coversDay(int day) {
        return (day >= checkInDay && day < checkOutDay);
    }

    /**
     * Gets the name of the guest making the reservation.
     * 
     * @return The guest name.
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * Gets the check-in day of the reservation.
     * 
     * @return The check-in day.
     */
    public int getCheckInDay() {
        return checkInDay;
    }

    /**
     * Gets the check-out day of the reservation.
     * 
     * @return The check-out day.
     */
    public int getCheckOutDay() {
        return checkOutDay;
    }

    /**
     * Gets the room associated with the reservation.
     * 
     * @return The reserved room.
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Gets the total price of the reservation, including any applicable discounts.
     * 
     * @return The total price after discount.
     */
    public double getSumPrice() {
        return totalPrice;
    }

    /**
     * Calculates the total price of the reservation based on the room's daily price and any date-based modifiers.
     * Applies any applicable discount codes and updates the total price.
     * 
     * @param hotel The hotel where the reservation is made, used to get date-based price modifiers.
     * @return The total price after applying date-based modifiers and discount codes.
     */
    public double getTotalPrice(Hotel hotel) {
        double totalPrice = 0.0;
        Room room = this.getRoom();
        double basePrice = room.getPrice();

        for (int day = checkInDay; day <= checkOutDay; day++) {
            // Get the modifier for the current day
            double modifier = hotel.getDatePriceModifier(day);

            if (modifier != 1.0){
                basePrice /= 1.5;    
            }

            double dailyPrice = basePrice * modifier;
            
            totalPrice += dailyPrice;
        }
        
        double discountedPrice = applyDiscountCode(totalPrice);
        this.totalPrice = discountedPrice;
        
        return discountedPrice;
    }

    /**
     * Gets the price per night of the reservation.
     * 
     * @return The price per night.
     */
    public double getPricePerNight() {
        int days = checkOutDay - checkInDay;
        return totalPrice / days;
    }

    /**
     * Checks if a specific day is within the reservation period.
     * 
     * @param day The day to check.
     * @return True if the day is within the reservation; false otherwise.
     */
    public boolean isDayWithinReservation(int day) {
        return (day >= checkInDay && day <= checkOutDay);
    }

    /**
     * Checks if the reservation is valid.
     * 
     * @return True if the reservation is valid; false otherwise.
     */
    public boolean isValid() {
        return isValid;
    }
}
