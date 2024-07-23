import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * The controller for the Hotel Reservation System.
 * This class handles the interaction between the model and the view.
 */
public class HotelReservationController {
    private HotelReservationSystem model;
    private HotelReservationView view;

    /**
     * Constructs a HotelReservationController with the specified model and view.
     *
     * @param model The model of the hotel reservation system.
     * @param view The view of the hotel reservation system.
     */
    public HotelReservationController(HotelReservationSystem model, HotelReservationView view) {
        this.model = model;
        this.view = view;

        // Add action listeners to view components
        this.view.addCreateHotelListener(new CreateHotelListener());
        this.view.addViewHotelListener(new ViewHotelListener());
        this.view.getManageHotelButton().addActionListener(new ManageHotelListener());
        this.view.addSimulateBookingListener(new SimulateBookingListener());
        this.view.addDisplayRoomAvailabilityListener(new DisplayRoomAvailabilityListener());
        this.view.addShowHotelEarningsListener(new ShowHotelEarningsListener());
        this.view.addDatePriceModifierListener(new DatePriceModifierListener());
        this.view.addExitListener(new ExitListener());
    }

    /**
     * ActionListener for Create Hotel Button.
     */
    class CreateHotelListener implements ActionListener {
        /**
         * Invoked when the Create Hotel button is pressed.
         *
         * @param e The event to be processed.
         */
        public void actionPerformed(ActionEvent e) {
            view.showCreateHotelDialog(model);
        }
    }

    /**
     * ActionListener for View Hotel Button.
     */
    class ViewHotelListener implements ActionListener {
        /**
         * Invoked when the View Hotel button is pressed.
         *
         * @param e The event to be processed.
         */
        public void actionPerformed(ActionEvent e) {
            view.showViewHotelDialog(model);
        }
    }

    /**
     * ActionListener for Manage Hotel Button.
     */
    class ManageHotelListener implements ActionListener {
        /**
         * Invoked when the Manage Hotel button is pressed.
         *
         * @param e The event to be processed.
         */
        public void actionPerformed(ActionEvent e) {
            view.showManageHotelDialog(model);
        }
    }

    /**
     * ActionListener for Simulate Booking Button.
     */
    class SimulateBookingListener implements ActionListener {
        /**
         * Invoked when the Simulate Booking button is pressed.
         *
         * @param e The event to be processed.
         */
        public void actionPerformed(ActionEvent e) {
            view.showSimulateBookingDialog(model);
        }
    }

    /**
     * ActionListener for Display Room Availability Button.
     */
    class DisplayRoomAvailabilityListener implements ActionListener {
        /**
         * Invoked when the Display Room Availability button is pressed.
         *
         * @param e The event to be processed.
         */
        public void actionPerformed(ActionEvent e) {
            view.showDisplayRoomAvailabilityDialog(model);
        }
    }

    /**
     * ActionListener for Show Hotel Earnings Button.
     */
    class ShowHotelEarningsListener implements ActionListener {
        /**
         * Invoked when the Show Hotel Earnings button is pressed.
         *
         * @param e The event to be processed.
         */
        public void actionPerformed(ActionEvent e) {
            view.showHotelEarningsDialog(model);
        }
    }

    /**
     * ActionListener for Date Price Modifier Button.
     */
    class DatePriceModifierListener implements ActionListener {
        /**
         * Invoked when the Date Price Modifier button is pressed.
         *
         * @param e The event to be processed.
         */
        public void actionPerformed(ActionEvent e) {
            view.showDatePriceModifierDialog(model);
        }
    }

    /**
     * ActionListener for Exit Button.
     */
    class ExitListener implements ActionListener {
        /**
         * Invoked when the Exit button is pressed.
         *
         * @param e The event to be processed.
         */
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
