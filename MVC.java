
/**
 * The entry point for the Hotel Reservation System application using the Model-View-Controller (MVC) architecture.
 * Initializes the model, view, and controller, and sets the view to be visible.
 */
public class MVC {
    /**
     * The main method to launch the Hotel Reservation System application.
     * 
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Create instances of the model, view, and controller
        HotelReservationSystem model = new HotelReservationSystem();
        HotelReservationView view = new HotelReservationView();
        HotelReservationController controller = new HotelReservationController(model, view);

        // Display the view
        view.setVisible(true);
    }
}