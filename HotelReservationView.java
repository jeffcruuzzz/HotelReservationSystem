import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * The view class for the Hotel Reservation System.
 * This class sets up the GUI components and layout.
 */
public class HotelReservationView {
    private JFrame frame;
    private JButton createHotelButton;
    private JButton viewHotelButton;
    private JButton manageHotelButton;
    private JButton simulateBookingButton;
    private JButton displayRoomAvailabilityButton;
    private JButton showHotelEarningsButton;
    private JButton datePriceModifierButton;
    private JButton exitButton;

    /**
     * Constructs a HotelReservationView and initializes the GUI components.
     */
    public HotelReservationView() {
        frame = new JFrame("Hotel Reservation System");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(112, 9, 30));
        frame.setContentPane(panel);

        Font buttonFont = new Font("Monospaced", Font.BOLD, 14);
        Color buttonColor = new Color(0, 128, 128);
        Color buttonTextColor = new Color(112, 9, 30);

        createHotelButton = createStyledButton("Create Hotel", buttonFont, buttonColor, buttonTextColor);
        viewHotelButton = createStyledButton("View Hotel", buttonFont, buttonColor, buttonTextColor);
        manageHotelButton = createStyledButton("Manage Hotel", buttonFont, buttonColor, buttonTextColor);
        simulateBookingButton = createStyledButton("Simulate Booking", buttonFont, buttonColor, buttonTextColor);
        displayRoomAvailabilityButton = createStyledButton("Display Room Availability", buttonFont, buttonColor, buttonTextColor);
        showHotelEarningsButton = createStyledButton("Show Hotel Earnings", buttonFont, buttonColor, buttonTextColor);
        datePriceModifierButton = createStyledButton("Date Price Modifier", buttonFont, buttonColor, buttonTextColor);
        exitButton = createStyledButton("Exit", buttonFont, buttonColor, buttonTextColor);

        // Add buttons to the frame
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(createHotelButton, gbc);

        gbc.gridy = 1;
        frame.add(viewHotelButton, gbc);

        gbc.gridy = 2;
        frame.add(manageHotelButton, gbc);

        gbc.gridy = 3;
        frame.add(simulateBookingButton, gbc);

        gbc.gridy = 4;
        frame.add(displayRoomAvailabilityButton, gbc);

        gbc.gridy = 5;
        frame.add(showHotelEarningsButton, gbc);

        gbc.gridy = 6;
        frame.add(datePriceModifierButton, gbc);

        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.NONE; // Center the exit button
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(exitButton, gbc);
    }

    /**
     * Creates a styled JButton with the specified text, font, background color, and text color.
     *
     * @param text The text to display on the button.
     * @param font The font to use for the button text.
     * @param bgColor The background color of the button.
     * @param textColor The text color of the button.
     * @return A styled JButton.
     */
    private JButton createStyledButton(String text, Font font, Color bgColor, Color textColor) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setBackground(bgColor);
        button.setForeground(textColor);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEtchedBorder());
        return button;
    }

    /**
     * Sets the visibility of the main frame.
     *
     * @param visible true to make the frame visible; false to hide it.
     */
    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    /**
     * Adds an ActionListener to the Create Hotel button.
     *
     * @param listenForCreateHotelButton The ActionListener to add.
     */
    public void addCreateHotelListener(ActionListener listenForCreateHotelButton) {
        createHotelButton.addActionListener(listenForCreateHotelButton);
    }

    /**
     * Adds an ActionListener to the View Hotel button.
     *
     * @param listenForViewHotelButton The ActionListener to add.
     */
    public void addViewHotelListener(ActionListener listenForViewHotelButton) {
        viewHotelButton.addActionListener(listenForViewHotelButton);
    }

    /**
     * Adds an ActionListener to the Manage Hotel button.
     *
     * @param listenForManageHotelButton The ActionListener to add.
     */
    public void addManageHotelListener(ActionListener listenForManageHotelButton) {
        manageHotelButton.addActionListener(listenForManageHotelButton);
    }

    /**
     * Adds an ActionListener to the Simulate Booking button.
     *
     * @param listenForSimulateBookingButton The ActionListener to add.
     */
    public void addSimulateBookingListener(ActionListener listenForSimulateBookingButton) {
        simulateBookingButton.addActionListener(listenForSimulateBookingButton);
    }

    /**
     * Adds an ActionListener to the Display Room Availability button.
     *
     * @param listenForDisplayRoomAvailabilityButton The ActionListener to add.
     */
    public void addDisplayRoomAvailabilityListener(ActionListener listenForDisplayRoomAvailabilityButton) {
        displayRoomAvailabilityButton.addActionListener(listenForDisplayRoomAvailabilityButton);
    }

    /**
     * Adds an ActionListener to the Show Hotel Earnings button.
     *
     * @param listenForShowHotelEarningsButton The ActionListener to add.
     */
    public void addShowHotelEarningsListener(ActionListener listenForShowHotelEarningsButton) {
        showHotelEarningsButton.addActionListener(listenForShowHotelEarningsButton);
    }

    /**
     * Adds an ActionListener to the Date Price Modifier button.
     *
     * @param listenForDatePriceModifierButton The ActionListener to add.
     */
    public void addDatePriceModifierListener(ActionListener listenForDatePriceModifierButton) {
        datePriceModifierButton.addActionListener(listenForDatePriceModifierButton);
    }

    /**
     * Adds an ActionListener to the Exit button.
     *
     * @param listenForExitButton The ActionListener to add.
     */
    public void addExitListener(ActionListener listenForExitButton) {
        exitButton.addActionListener(listenForExitButton);
    }

    /**
     * Returns the main frame.
     *
     * @return The main frame.
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Shows a dialog to create a new hotel.
     *
     * @param model The HotelReservationSystem model to interact with.
     */
    public void showCreateHotelDialog(HotelReservationSystem model) {
        JTextField nameField = new JTextField(20);
        JTextField numStandardField = new JTextField(5);
        JTextField numDeluxeField = new JTextField(5);
        JTextField numExecutiveField = new JTextField(5);
    
        customizeInputField(nameField);
        customizeInputField(numStandardField);
        customizeInputField(numDeluxeField);
        customizeInputField(numExecutiveField);
    
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setBackground(new Color(112, 9, 30));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
    
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(createStyledLabel("Hotel Name:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(nameField, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(createStyledLabel("Standard Rooms:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(numStandardField, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(createStyledLabel("Deluxe Rooms:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(numDeluxeField, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(createStyledLabel("Executive Rooms:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(numExecutiveField, gbc);
    
        // Show dialog and handle user input
        int result = JOptionPane.showConfirmDialog(frame, inputPanel, "Create Hotel", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            int numStandard = parseInt(numStandardField.getText());
            int numDeluxe = parseInt(numDeluxeField.getText());
            int numExecutive = parseInt(numExecutiveField.getText());
    
            // Validate input and create hotel if valid
            if (name == null || name.isEmpty()) {
                showCustomMessageDialog(frame, "Hotel name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (model.getHotel(name) != null) {
                showCustomMessageDialog(frame, "Hotel name must be unique.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (numStandard < 0 || numDeluxe < 0 || numExecutive < 0) {
                showCustomMessageDialog(frame, "Number of rooms cannot be negative.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if ((numStandard + numDeluxe + numExecutive) < 1 || (numStandard + numDeluxe + numExecutive) > 50) {
                showCustomMessageDialog(frame, "Total number of rooms must be between 1 and 50.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            model.createHotel(name, numStandard, numDeluxe, numExecutive);
            showCustomMessageDialog(frame, "Hotel created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Creates a styled JLabel with the specified text.
     *
     * @param text The text to display on the label.
     * @return A styled JLabel.
     */
    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Monospaced", Font.BOLD, 14));
        label.setForeground(new Color(0, 128, 128));
        return label;
    }
    
    /**
     * Parses a string to an integer.
     *
     * @param str The string to parse.
     * @return The parsed integer, or -1 if the string is not a valid integer.
     */
    private int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1; // Return a negative number to indicate invalid input
        }
    }

    /**
     * Prompts the user for input with a dialog.
     *
     * @param message The message to display in the dialog.
     * @return The user's input.
     */
    public String getInput(String message) {
        return JOptionPane.showInputDialog(frame, message);
    }

    /**
     * Customizes the appearance of a JTextField.
     *
     * @param textField The JTextField to customize.
     */
    private void customizeInputField(JTextField textField) {
        textField.setBackground(new Color(245, 245, 245));
        textField.setForeground(new Color(0, 128, 128));
        textField.setFont(new Font("Monospaced", Font.PLAIN, 14));
    }

    /**
     * Displays a custom message dialog.
     *
     * @param parentComponent The parent component of the dialog.
     * @param message The message to display.
     * @param title The title of the dialog.
     * @param messageType The type of message (e.g., ERROR_MESSAGE, INFORMATION_MESSAGE).
     */
    private void showCustomMessageDialog(Component parentComponent, String message, String title, int messageType) {
        JPanel messagePanel = new JPanel();
        messagePanel.setBackground(new Color(112, 9, 30));
        messagePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        JLabel messageLabel = new JLabel(message);
        messageLabel.setForeground(new Color(0, 128, 128));
        messageLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
    
        messagePanel.add(messageLabel);
    
        JOptionPane.showMessageDialog(parentComponent, messagePanel, title, messageType);
    }

    /**
     * Shows a dialog to view hotel details.
     *
     * @param model The HotelReservationSystem model to interact with.
     */
    public void showViewHotelDialog(HotelReservationSystem model) {
        JTextField hotelNameField = new JTextField(20);
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(new Color(112, 9, 30));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(createStyledLabel("Hotel Name:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(hotelNameField, gbc);
        
        // Show dialog and handle user input
        int result = JOptionPane.showConfirmDialog(frame, inputPanel, "View Hotel", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String hotelName = hotelNameField.getText();
            Hotel hotel = model.getHotel(hotelName);
            
            if (hotel == null) {
                JOptionPane.showMessageDialog(frame, "Hotel not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] options = {"High-level information", "Low-level information", "Exit"};
            int choice = JOptionPane.showOptionDialog(frame, "Select an option:", "View Hotel",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    showHighLevelInfo(hotel);
                    break;
                case 1:
                    showLowLevelInfo(hotel);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Shows high-level information about the hotel.
     *
     * @param hotel The hotel to display information about.
     */
    private void showHighLevelInfo(Hotel hotel) {
        JOptionPane.showMessageDialog(frame,
                "Hotel Name: " + hotel.getName() + "\n" +
                "Total Rooms: " + hotel.getRooms().size() + "\n" +
                "Estimated Earnings: " + hotel.estimatedEarnings(),
                "High-level Information", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Shows low-level information about the hotel.
     *
     * @param hotel The hotel to display information about.
     */
    private void showLowLevelInfo(Hotel hotel) {
        String[] options = {
            "Total number of available and booked rooms for a selected date.",
            "Information about a selected room.",
            "Information about a selected reservation.",
            "Exit"
        };
        int choice = JOptionPane.showOptionDialog(frame, "Select an option:", "Low-level Information",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                handleAvailableAndBookedRooms(hotel);
                break;
            case 1:
                handleRoomInformation(hotel);
                break;
            case 2:
                handleReservationInformation(hotel);
                break;
            default:
                break;
        }
    }

    /**
     * Handles the display of available and booked rooms for a specified day.
     *
     * @param hotel The hotel object containing room information.
     */
    private void handleAvailableAndBookedRooms(Hotel hotel) {
        String dayStr = JOptionPane.showInputDialog(frame, "Enter day (1-31):");
        int day = parseInt(dayStr);
        if (day < 1 || day > 31) {
            JOptionPane.showMessageDialog(frame, "Invalid day. Please enter a value between 1 and 31.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(frame,
                "Available Rooms: " + hotel.getAvailableRoomsCount(day) + "\n" +
                "Booked Rooms: " + hotel.getBookedRoomsCount(day),
                "Room Availability", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Handles the display of information for a specified room.
     *
     * @param hotel The hotel object containing room information.
     */
    private void handleRoomInformation(Hotel hotel) {
        String roomName = JOptionPane.showInputDialog(frame, "Enter room name:");
        Room room = hotel.getRoomByName(roomName);
        if (room == null) {
            JOptionPane.showMessageDialog(frame, "Room not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(frame,
                "Room Name: " + room.getName() + "\n" +
                "Price per Night: " + room.getPrice() + "\n" +
                hotel.getAvailabilityForMonth(roomName),
                "Room Information", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Handles the display of reservation information for a specified guest.
     *
     * @param hotel The hotel object containing reservation information.
     */
    private void handleReservationInformation(Hotel hotel) {
        String guestName = JOptionPane.showInputDialog(frame, "Enter guest name:");
        List<Reservation> reservations = hotel.getReservations();
        for (Reservation reservation : reservations) {
            if (reservation.getGuestName().equalsIgnoreCase(guestName)) {
                JOptionPane.showMessageDialog(frame,
                        "Reservation Details:\n" +
                        "Guest Name: " + reservation.getGuestName() + "\n" +
                        "Room Name: " + reservation.getRoom().getName() + "\n" +
                        "Check-in Date: " + reservation.getCheckInDay() + "\n" +
                        "Check-out Date: " + reservation.getCheckOutDay() + "\n" +
                        "Total Price: " + reservation.getSumPrice() + "\n" +
                        "Price per Night: " + reservation.getPricePerNight(),
                        "Reservation Information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(frame, "Reservation not found for guest: " + guestName, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays a dialog for managing a hotel, including options to change name, add/remove rooms, update prices, or remove reservations.
     *
     * @param model The hotel reservation system model containing hotel data.
     */
    public void showManageHotelDialog(HotelReservationSystem model) {
        JTextField hotelNameField = new JTextField(20);
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(new Color(112, 9, 30));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(createStyledLabel("Hotel Name:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(hotelNameField, gbc);

        int result = JOptionPane.showConfirmDialog(frame, inputPanel, "Manage Hotel", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String hotelName = hotelNameField.getText();
            Hotel hotel = model.getHotel(hotelName);

            if (hotel == null) {
                JOptionPane.showMessageDialog(frame, "Hotel not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] options = {
                "Change name", "Add room", "Remove room", "Update price per night", "Remove reservation", "Remove hotel"
            };
            int choice = JOptionPane.showOptionDialog(frame, "Select an option:", "Manage Hotel",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    changeHotelName(model, hotel);
                    break;
                case 1:
                    addRoom(hotel);
                    break;
                case 2:
                    removeRoom(hotel);
                    break;
                case 3:
                    updatePricePerNight(hotel);
                    break;
                case 4:
                    removeReservation(hotel);
                    break;
                case 5:
                    removeHotel(model, hotel);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Changes the name of the specified hotel.
     *
     * @param model The hotel reservation system model containing hotel data.
     * @param hotel The hotel object to be renamed.
     */
    private void changeHotelName(HotelReservationSystem model, Hotel hotel) {
        String newName = JOptionPane.showInputDialog(frame, "Enter new name:");
        if (newName != null && !newName.trim().isEmpty()) {
            if (model.getHotel(newName) != null) {
                JOptionPane.showMessageDialog(frame, "Hotel name must be unique.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int confirmation = JOptionPane.showConfirmDialog(frame, "Confirm change of hotel name to " + newName + "?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    hotel.setName(newName);
                    JOptionPane.showMessageDialog(frame, "Hotel name changed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    /**
     * Adds a new room to the specified hotel.
     *
     * @param hotel The hotel object to which a new room will be added.
     */
    private void addRoom(Hotel hotel) {
        String roomType = JOptionPane.showInputDialog(frame, "Enter room type (standard/deluxe/executive):");
        if (roomType != null && !roomType.trim().isEmpty()) {
            roomType = roomType.trim().toLowerCase();
            if (roomType.equals("standard") || roomType.equals("deluxe") || roomType.equals("executive")) {
                int confirmation = JOptionPane.showConfirmDialog(frame, "Confirm addition of a new room?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    hotel.addRoom(roomType);
                    JOptionPane.showMessageDialog(frame, "Room added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid room type. Please enter 'standard', 'deluxe', or 'executive'.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Room type cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Removes a room from the specified hotel.
     *
     * @param hotel The hotel object from which a room will be removed.
     */
    private void removeRoom(Hotel hotel) {
        List<String> roomNames = hotel.displayRoomNames();
        if (roomNames.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No rooms available to remove.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String roomName = (String) JOptionPane.showInputDialog(frame, "Select room to remove:", "Remove Room", JOptionPane.PLAIN_MESSAGE, null, roomNames.toArray(), roomNames.get(0));
        if (roomName != null && !roomName.trim().isEmpty()) {
            // Check if the room is booked
            if (hotel.isRoomBooked(roomName)) {
                JOptionPane.showMessageDialog(frame, "Room " + roomName + " cannot be removed. It is currently booked.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            int confirmation = JOptionPane.showConfirmDialog(frame, "Confirm removal of room " + roomName + "?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                hotel.removeRoom(roomName);
                JOptionPane.showMessageDialog(frame, "Room removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    /**
     * Updates the price per night for all rooms in the specified hotel.
     *
     * @param hotel The hotel object in which the price per night will be updated.
     */
    private void updatePricePerNight(Hotel hotel) {
        String newPriceStr = JOptionPane.showInputDialog(frame, "Enter new price per night:");
        if (newPriceStr != null && !newPriceStr.trim().isEmpty()) {
            try {
                double newPrice = Double.parseDouble(newPriceStr);
                int confirmation = JOptionPane.showConfirmDialog(frame, "Confirm update of price per night to " + newPrice + "?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    boolean success = hotel.updatePriceGUI(newPrice);
                    if (success) {
                        JOptionPane.showMessageDialog(frame, "Price updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Cannot update price as there are active reservations.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid price. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Removes a reservation from the specified hotel based on the provided details.
     *
     * @param hotel The hotel object from which the reservation will be removed.
     */
    private void removeReservation(Hotel hotel) {
        JTextField guestNameField = new JTextField(20);
        JTextField roomNameField = new JTextField(20);
        JTextField checkInDayField = new JTextField(2);
        JTextField checkOutDayField = new JTextField(2);
    
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(new Color(112, 9, 30));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
    
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(createStyledLabel("Guest Name:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(guestNameField, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(createStyledLabel("Room Name:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(roomNameField, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(createStyledLabel("Check-in Day (1-31):"), gbc);
        gbc.gridx = 1;
        inputPanel.add(checkInDayField, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(createStyledLabel("Check-out Day (1-31):"), gbc);
        gbc.gridx = 1;
        inputPanel.add(checkOutDayField, gbc);
    
        int result = JOptionPane.showConfirmDialog(frame, inputPanel, "Remove Reservation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
        if (result == JOptionPane.OK_OPTION) {
            String guestName = guestNameField.getText();
            String roomName = roomNameField.getText();
            int checkInDay;
            int checkOutDay;
    
            // Try parsing the integers, handle exceptions if they occur
            try {
                checkInDay = Integer.parseInt(checkInDayField.getText());
                checkOutDay = Integer.parseInt(checkOutDayField.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid days.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            // Check for valid inputs
            if (guestName.isEmpty() || roomName.isEmpty() || checkInDay < 1 || checkInDay > 31 || checkOutDay < 1 || checkOutDay > 31) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid details.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            // Check if the reservation exists
            boolean reservationExists = hotel.checkReservationExists(guestName, roomName, checkInDay, checkOutDay);
    
            if (!reservationExists) {
                JOptionPane.showMessageDialog(frame, "Reservation not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            int confirmation = JOptionPane.showConfirmDialog(frame, "Confirm removal of reservation for " + guestName + " in room " + roomName + " from day " + checkInDay + " to day " + checkOutDay + "?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                hotel.removeReservation(guestName, roomName, checkInDay, checkOutDay);
                JOptionPane.showMessageDialog(frame, "Reservation removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    /**
     * Removes a hotel from the reservation system after user confirmation.
     *
     * @param model The hotel reservation system model.
     * @param hotel The hotel to be removed.
     */
    private void removeHotel(HotelReservationSystem model, Hotel hotel) {
        int confirmation = JOptionPane.showConfirmDialog(frame, "Confirm removal of hotel " + hotel.getName() + "?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            model.removeHotel(hotel);
            JOptionPane.showMessageDialog(frame, "Hotel removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Gets the manage hotel button.
     *
     * @return The manage hotel button.
     */
    public JButton getManageHotelButton() {
        return manageHotelButton;
    }

    
    /**
     * Displays a dialog to simulate booking a room.
     *
     * @param model The hotel reservation system model.
     */
    public void showSimulateBookingDialog(HotelReservationSystem model) {
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(new Color(112, 9, 30));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
    
        // Create and add input fields
        JTextField hotelNameField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(createStyledLabel("Hotel Name:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(hotelNameField, gbc);
    
        JTextField guestNameField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(createStyledLabel("Guest Name:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(guestNameField, gbc);
    
        JTextField checkInDayField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(createStyledLabel("Check-in Day (1-31):"), gbc);
        gbc.gridx = 1;
        inputPanel.add(checkInDayField, gbc);
    
        JTextField checkOutDayField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(createStyledLabel("Check-out Day (1-31):"), gbc);
        gbc.gridx = 1;
        inputPanel.add(checkOutDayField, gbc);
    
        JTextField discountCodeField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 4;
        inputPanel.add(createStyledLabel("Discount Code:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(discountCodeField, gbc);
    
        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Simulate Booking", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
        if (result == JOptionPane.OK_OPTION) {
            String hotelName = hotelNameField.getText();
            if (hotelName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Hotel name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            String guestName = guestNameField.getText();
            if (guestName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Guest name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            String checkInDayStr = checkInDayField.getText();
            int checkInDay = parseInt(checkInDayStr);
            if (checkInDay < 1 || checkInDay > 31) {
                JOptionPane.showMessageDialog(null, "Please enter a valid check-in day (1-31).", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            String checkOutDayStr = checkOutDayField.getText();
            int checkOutDay = parseInt(checkOutDayStr);
            if (checkOutDay < 1 || checkOutDay > 31) {
                JOptionPane.showMessageDialog(null, "Please enter a valid check-out day (1-31).", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            if (checkInDay > checkOutDay) {
                JOptionPane.showMessageDialog(null, "Check-in date must be before the check-out date.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            String discountCode = discountCodeField.getText();
    
            // Retrieve available rooms
            List<Room> availableRooms = getAvailableRooms(model, hotelName, checkInDay, checkOutDay);
            if (availableRooms.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No available rooms for the selected dates.", "Information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
    
            // Prepare room list for display
            StringBuilder roomList = new StringBuilder("Available rooms for booking:\n");
            for (Room room : availableRooms) {
                roomList.append("Room Name: ").append(room.getName())
                        .append(", Price per Night: ").append(room.getPrice())
                        .append("\n");
            }
    
            // Add room selection to the input panel
            JTextArea roomListArea = new JTextArea(roomList.toString());
            roomListArea.setEditable(false);
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.gridwidth = 2;
            inputPanel.add(new JScrollPane(roomListArea), gbc);
    
            JTextField roomNameField = new JTextField(20);
            gbc.gridy = 6;
            inputPanel.add(createStyledLabel("Room Name to Book:"), gbc);
            gbc.gridy = 7;
            inputPanel.add(roomNameField, gbc);
    
            result = JOptionPane.showConfirmDialog(null, inputPanel, "Select Room", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
            if (result == JOptionPane.OK_OPTION) {
                String roomName = roomNameField.getText();
                if (roomName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Room name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
    
                boolean success = bookRoom(model, hotelName, guestName, checkInDay, checkOutDay, roomName, discountCode);
                if (success) {
                    double totalPrice = getTotalPrice(model, hotelName, guestName, checkInDay, checkOutDay, roomName, discountCode);
                    JOptionPane.showMessageDialog(null, "Room booked successfully. Total price: " + totalPrice, "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Room booking failed. Please check the details and try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    /**
     * Retrieves a list of available rooms for the specified hotel and dates.
     *
     * @param model The hotel reservation system model.
     * @param hotelName The name of the hotel.
     * @param checkInDay The check-in day.
     * @param checkOutDay The check-out day.
     * @return A list of available rooms.
     */
    private List<Room> getAvailableRooms(HotelReservationSystem model, String hotelName, int checkInDay, int checkOutDay) {
        Hotel hotel = model.getHotel(hotelName);
        if (hotel == null) {
            return new ArrayList<>(); // Return an empty list if hotel is not found
        }

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
                }
            }
        return availableRooms;
    }

    /**
     * Books a room for the specified hotel and guest.
     *
     * @param model The hotel reservation system model.
     * @param hotelName The name of the hotel.
     * @param guestName The name of the guest.
     * @param checkInDay The check-in day.
     * @param checkOutDay The check-out day.
     * @param roomName The name of the room to book.
     * @param discountCode The discount code for the booking.
     * @return True if the booking is successful, false otherwise.
     */
    private boolean bookRoom(HotelReservationSystem model, String hotelName, String guestName, int checkInDay, int checkOutDay, String roomName, String discountCode) {
        Hotel hotel = model.getHotel(hotelName);
        if (hotel == null) {
            return false; // Return false if hotel is not found
        }
    
        Room room = hotel.getRoomByName(roomName);
        if (room == null) {
            return false; // Return false if room is not found
        }
    
        // Check if the room is available
        boolean isAvailable = true;
        for (int day = checkInDay; day <= checkOutDay; day++) {
            if (room.isBookedOnDay(day, hotel.getReservations())) {
                isAvailable = false;
                break;
            }
        }
    
        if (!isAvailable) {
            return false; // Return false if room is not available
        }
    
        // Create a new reservation and book the room
        Reservation reservation = new Reservation(guestName, checkInDay, checkOutDay, room, discountCode);
        hotel.addReservation(reservation);
        room.bookRoom(); // Mark room as booked
        return true; // Return true if booking is successful
    }

    /**
     * Gets the total price for a booking.
     *
     * @param model The hotel reservation system model.
     * @param hotelName The name of the hotel.
     * @param guestName The name of the guest.
     * @param checkInDay The check-in day.
     * @param checkOutDay The check-out day.
     * @param roomName The name of the room.
     * @param discountCode The discount code for the booking.
     * @return The total price for the booking.
     */
    private double getTotalPrice(HotelReservationSystem model, String hotelName, String guestName, int checkInDay, int checkOutDay, String roomName, String discountCode) {
        // Retrieve the Hotel object
        Hotel hotel = model.getHotel(hotelName);
        if (hotel == null) {
            return 0; // Hotel not found
        }
    
        // Retrieve the Room object based on the provided room name
        Room room = hotel.getRoomByName(roomName);
        if (room == null) {
            return 0; // Room not found or not available
        }
    
        // Create a Reservation object
        Reservation reservation = new Reservation(guestName, checkInDay, checkOutDay, room, discountCode);
    
        double totalPrice = reservation.getTotalPrice(hotel);
    
        // Return the total price of the reservation
        return totalPrice;
    }

    /**
     * Displays a dialog to show room availability and prompt for room name.
     *
     * @param model The hotel reservation system model.
     */
    public void showDisplayRoomAvailabilityDialog(HotelReservationSystem model) {
        // Create and set up the panel for hotel name input
        JPanel hotelInputPanel = new JPanel(new GridBagLayout());
        hotelInputPanel.setBackground(new Color(112, 9, 30));
        hotelInputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
    
        JTextField hotelNameField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        hotelInputPanel.add(createStyledLabel("Hotel Name:"), gbc);
        gbc.gridx = 1;
        hotelInputPanel.add(hotelNameField, gbc);
    
        int result = JOptionPane.showConfirmDialog(null, hotelInputPanel, "Enter Hotel Name", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
        if (result == JOptionPane.OK_OPTION) {
            String hotelName = hotelNameField.getText().trim();
            if (hotelName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Hotel name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            // Retrieve and display room names
            Hotel hotel = model.getHotel(hotelName);
            if (hotel == null) {
                JOptionPane.showMessageDialog(null, "Hotel not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            List<String> roomNames = hotel.displayRoomNames();
            if (roomNames.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No rooms available in the hotel.", "Information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
    
            // Create and set up the panel for room names and input
            JPanel displayPanel = new JPanel(new GridBagLayout());
            displayPanel.setBackground(new Color(112, 9, 30));
            displayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
            JTextArea roomListArea = new JTextArea();
            roomListArea.setText("Available rooms:\n");
            for (String roomName : roomNames) {
                roomListArea.append(roomName + "\n");
            }
            roomListArea.setEditable(false);
            roomListArea.setBackground(new Color(112, 9, 30));
            roomListArea.setForeground(new Color(0, 128, 128));
            
            Font font = new Font("Monospaced", Font.BOLD, 14); // Change "Arial" to your desired font family, Font.PLAIN to Font.BOLD or Font.ITALIC if needed, and 14 to your desired font size
            roomListArea.setFont(font);
    
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            displayPanel.add(new JScrollPane(roomListArea), gbc);
    
            JTextField roomNameField = new JTextField(20);
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            displayPanel.add(createStyledLabel("Room Name:"), gbc);
            gbc.gridx = 1;
            displayPanel.add(roomNameField, gbc);
    
            // Show room list and prompt for room name
            result = JOptionPane.showConfirmDialog(null, displayPanel, "Display Room Availability", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
            if (result == JOptionPane.OK_OPTION) {
                String roomName = roomNameField.getText().trim();
                if (roomName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Room name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
    
                // Retrieve and display availability information using the method
                String availability = displayRoomAvailability(model, hotelName, roomName);
                JOptionPane.showMessageDialog(null, availability, "Room Availability", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    /**
     *
     * Retrieves the availability of a specific room in a hotel.
     * @param model The hotel reservation system model.
     * @param hotelName The name of the hotel.
     * @param roomName The name of the room.
     * @return A string representing the availability of the room.
     */
    private String displayRoomAvailability(HotelReservationSystem model, String hotelName, String roomName) {
        Hotel hotel = model.getHotel(hotelName);
        if (hotel == null) {
            return "Hotel not found.";
        }

        return hotel.getAvailabilityForMonth(roomName);
    }

    /**
     * Displays a dialog to show estimated earnings of a specific hotel.
     *
     * @param model The hotel reservation system model.
     */
    public void showHotelEarningsDialog(HotelReservationSystem model) {
        // Create and set up the panel for hotel name input
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(new Color(112, 9, 30));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
    
        // Create and add the input field for hotel name
        JTextField hotelNameField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(createStyledLabel("Hotel Name:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(hotelNameField, gbc);
    
        // Prompt for hotel name
        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Enter Hotel Name", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
        if (result == JOptionPane.OK_OPTION) {
            String hotelName = hotelNameField.getText().trim();
            if (hotelName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Hotel name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            // Retrieve earnings information
            double earnings = getHotelEarnings(model, hotelName);
    
            // Show earnings in a message dialog
            JOptionPane.showMessageDialog(null, "Estimated Earnings: " + earnings, "Hotel Earnings", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Retrieves the estimated earnings of a specific hotel.
     *
     * @param model The hotel reservation system model.
     * @param hotelName The name of the hotel.
     * @return The estimated earnings of the hotel.
     */
    private double getHotelEarnings(HotelReservationSystem model, String hotelName) {
        Hotel hotel = model.getHotel(hotelName);
        if (hotel == null) {
            JOptionPane.showMessageDialog(null, "Hotel not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }

        return hotel.estimatedEarnings();
    }

    /**
     * Displays a dialog to apply a date price modifier for a specific hotel.
     *
     * @param model The hotel reservation system model.
     */
    public void showDatePriceModifierDialog(HotelReservationSystem model) {
        // Create and set up the panel for input fields
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(new Color(112, 9, 30));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
    
        // Create and add input field for hotel name
        JTextField hotelNameField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(createStyledLabel("Hotel Name:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(hotelNameField, gbc);
    
        // Create and add input field for day
        JTextField dayField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(createStyledLabel("Day (1-31):"), gbc);
        gbc.gridx = 1;
        inputPanel.add(dayField, gbc);
    
        // Create and add input field for rate
        JTextField rateField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(createStyledLabel("Rate (0.5 (50%) to 1.5 (150%):"), gbc);
        gbc.gridx = 1;
        inputPanel.add(rateField, gbc);
    
        // Show the input panel dialog
        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Apply Date Price Modifier", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
        if (result == JOptionPane.OK_OPTION) {
            String hotelName = hotelNameField.getText().trim();
            if (hotelName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Hotel name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            String dayStr = dayField.getText().trim();
            if (dayStr.isEmpty() || !isValidDay(dayStr)) {
                JOptionPane.showMessageDialog(null, "Please enter a valid day (1-31).", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int day = Integer.parseInt(dayStr);
    
            String rateStr = rateField.getText().trim();
            if (rateStr.isEmpty() || !isValidRate(rateStr)) {
                JOptionPane.showMessageDialog(null, "Please enter a valid rate (0.5 (50%) to 1.5 (150%):.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double rate = Double.parseDouble(rateStr);
    
            // Add date price modifier
            boolean success = addDatePriceModifier(model, hotelName, day, rate);
            if (success) {
                JOptionPane.showMessageDialog(null, "Date price modifier applied and reservations updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to apply date price modifier. Check the details and try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     * Validates if the provided day is within the acceptable range (1-31).
     *
     * @param dayStr The string representation of the day.
     * @return True if the day is valid; false otherwise.
     */
    private boolean isValidDay(String dayStr) {
        try {
            int day = Integer.parseInt(dayStr);
            return day >= 1 && day <= 31;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Validates if the provided rate is within the acceptable range (0.5 to 1.5).
     *
     * @param rateStr The string representation of the rate.
     * @return True if the rate is valid; false otherwise.
     */
    private boolean isValidRate(String rateStr) {
        try {
            double rate = Double.parseDouble(rateStr);
            return rate >= 0.5 && rate <= 1.5;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Adds a date price modifier for a specific hotel and updates room prices and reservations.
     *
     * @param model The hotel reservation system model.
     * @param hotelName The name of the hotel.
     * @param day The day of the month to apply the modifier.
     * @param rate The modifier rate (0.5 to 1.5).
     * @return True if the modifier was successfully applied; false otherwise.
     */
    private boolean addDatePriceModifier(HotelReservationSystem model, String hotelName, int day, double rate) {
        Hotel hotel = model.getHotel(hotelName);
        if (hotel != null) {
            if (rate >= 0.5 && rate <= 1.5) {
                boolean success = hotel.addDatePriceModifier(day, rate);
                if (success) {
                    // Update each room's price based on the new base price and date price modifier
                    for (Room room : hotel.getRooms()) {
                        double newPrice = room.getPrice() * rate; // Calculate new price based on the modifier
                        room.setPrice(newPrice); // Update room's price
                    }

                    // Recalculate the total price for all reservations
                    for (Reservation reservation : hotel.getReservations()) {
                        reservation.getSumPrice(); // Update the total price with the new rates
                    }

                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
