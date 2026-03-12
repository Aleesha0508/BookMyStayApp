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

/**
 * ============================================================
 * CLASS - RoomSearchService
 * ============================================================
 *
 * Use Case 4: Room Search & Availability Check
 *
 * Description:
 * This class provides search functionality
 * for guests to view available rooms.
 *
 * It reads room availability from inventory
 * and room details from Room objects.
 *
 * No inventory mutation or booking logic
 * is performed in this class.
 *
 * @version 4.0
 */

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

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("      Welcome to BookMyStay       ");
        System.out.println("==================================");
        System.out.println("Hotel Booking Management System Started Successfully!");
        System.out.println("System Ready.");
    }
}