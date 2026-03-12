import java.util.*;   // ALL imports go here

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

class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        roomAvailability.put("Standard", 10);
        roomAvailability.put("Deluxe", 5);
        roomAvailability.put("Suite", 2);
    }

    public void displayInventory() {
        System.out.println("Room Availability:");
        for (String roomType : roomAvailability.keySet()) {
            System.out.println(roomType + " Rooms: " + roomAvailability.get(roomType));
        }
    }

    public boolean isAvailable(String roomType) {
        return roomAvailability.getOrDefault(roomType, 0) > 0;
    }

    public void decrementRoom(String roomType) {
        roomAvailability.put(roomType, roomAvailability.get(roomType) - 1);
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

class BookingRequestQueue {

    private Queue<Reservation> bookingQueue;

    public BookingRequestQueue() {
        bookingQueue = new LinkedList<>();
    }

    public Queue<Reservation> getQueue() {
        return bookingQueue;
    }

    public void addRequest(Reservation reservation) {
        bookingQueue.add(reservation);
        System.out.println("Booking request added for: " + reservation.getGuestName());
    }

    public void showQueue() {
        System.out.println("\nCurrent Booking Queue:");

        for (Reservation r : bookingQueue) {
            r.displayReservation();
        }
    }
}

class BookingService {

    private Map<String, Set<String>> allocatedRooms;

    public BookingService() {
        allocatedRooms = new HashMap<>();
    }

    public void processBookings(BookingRequestQueue queue, RoomInventory inventory) {

        Queue<Reservation> requests = queue.getQueue();

        while (!requests.isEmpty()) {

            Reservation reservation = requests.poll();
            String roomType = reservation.getRoomType();

            if (inventory.isAvailable(roomType)) {

                String roomId = generateRoomId(roomType);

                allocatedRooms.putIfAbsent(roomType, new HashSet<>());

                Set<String> assignedRooms = allocatedRooms.get(roomType);

                if (!assignedRooms.contains(roomId)) {

                    assignedRooms.add(roomId);
                    inventory.decrementRoom(roomType);

                    System.out.println("Booking Confirmed!");
                    System.out.println("Guest: " + reservation.getGuestName());
                    System.out.println("Room Type: " + roomType);
                    System.out.println("Assigned Room ID: " + roomId);
                    System.out.println("--------------------------");
                }

            } else {

                System.out.println("Sorry " + reservation.getGuestName() +
                        ", no " + roomType + " rooms available.");
            }
        }
    }

    private String generateRoomId(String roomType) {

        int random = new Random().nextInt(1000);

        return roomType.substring(0, 2).toUpperCase() + "-" + random;
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("      Welcome to BookMyStay      ");
        System.out.println("=================================");

        BookingRequestQueue queue = new BookingRequestQueue();

        queue.addRequest(new Reservation("Amit", "Standard"));
        queue.addRequest(new Reservation("Sara", "Deluxe"));
        queue.addRequest(new Reservation("Rahul", "Suite"));

        RoomInventory inventory = new RoomInventory();

        BookingService bookingService = new BookingService();

        bookingService.processBookings(queue, inventory);
    }
}