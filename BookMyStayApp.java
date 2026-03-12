abstract class Room {

    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sq ft");
        System.out.println("Price per Night: ₹" + pricePerNight);
    }
}

import java.util.HashMap;
import java.util.Map;

class RoomInventory {

    /**
     * Stores available room count for each room type.
     *
     * Key   -> Room type name
     * Value -> Available room count
     */
    private Map<String, Integer> roomAvailability;

    /**
     * Constructor initializes the inventory
     * with default availability values.
     */
    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    /**
     * Initializes room availability data.
     */
    private void initializeInventory() {
        roomAvailability.put("Standard", 10);
        roomAvailability.put("Deluxe", 5);
        roomAvailability.put("Suite", 2);
    }

    /**
     * Displays available rooms.
     */
    public void displayInventory() {
        System.out.println("Room Availability:");
        for (String roomType : roomAvailability.keySet()) {
            System.out.println(roomType + " Rooms: " + roomAvailability.get(roomType));
        }
    }
}



class RoomSearchService {

    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        System.out.println("\n===== Available Rooms =====");

        System.out.println("\nSingle Room:");
        singleRoom.displayRoomDetails();

        System.out.println("\nDouble Room:");
        doubleRoom.displayRoomDetails();

        System.out.println("\nSuite Room:");
        suiteRoom.displayRoomDetails();
    }
}


class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void displayReservation() {
        System.out.println("Guest: " + guestName + " | Room Type: " + roomType);
    }
}

import java.util.LinkedList;
import java.util.Queue;

/**
 * ============================================================
 * CLASS - BookingRequestQueue
 * ============================================================
 *
 * Handles incoming booking requests using FIFO order.
 * Requests are stored and processed based on
 * arrival sequence.
 */

class BookingRequestQueue {

    private Queue<Reservation> bookingQueue;

    public BookingRequestQueue() {
        bookingQueue = new LinkedList<>();
    }

    /**
     * Adds a booking request to the queue.
     */
    public void addRequest(Reservation reservation) {
        bookingQueue.add(reservation);
        System.out.println("Booking request added for: " + reservation.getGuestName());
    }

    /**
     * Displays all queued requests.
     */
    public void showQueue() {
        System.out.println("\nCurrent Booking Queue:");

        for (Reservation r : bookingQueue) {
            r.displayReservation();
        }
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("      Welcome to BookMyStay       ");
        System.out.println("==================================");
        System.out.println("Hotel Booking Management System Started Successfully!");
        System.out.println("System Ready.");
    }
}