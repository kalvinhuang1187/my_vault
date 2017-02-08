/*
Design a Parking Lot
---
contains levels at bottom: http://massivetechinterview.blogspot.com/2015/07/cc150v5-84-design-parking-lot.html
https://xmruibi.gitbooks.io/interview-preparation-notes/content/OOD/DesignExamples/ParkingLot.html
---
Basic Functionality:
1. A parking lot has multiple Levels.
2. A Level has multiple Parking Spot.
3. A Spot can park motorcycle, car or bus, which all belongs to Vehicle.

Functions:
1. Vehicle.parkInSpot(Spot s)
2. Vehicle.leaveSpot(Spot s)
3. Vehicle.canFitIn(Spot s)
4. ParkingLot.parkVehicle(Vehicle v)
5. Level.parkVehicle(Vehicle v)
6. Level.parkVehicleAtSpot(Vehicle v, Spot s)
7. Level.findAvailableSpot(VehicleType vt)

---
Basic Object:

Vehicle
    size of vehicle (small, medium, large)
    status of vehicle (run or parked)
Sedan, SUV, Bus, Truck... extends Vehicle
Slot
    size of slot
    status (available or not)
Lot
    hold slots in lot

---
Diagram:

Vehicle
    functions:
        bool getSize();
        List<Slot> findSlot();
        void park();
        void leave();
    private variables:
        int size;
        String license;
        bool status;
        Lot lot;

Car/Truck/Bux extends Vehicle

Lot
    functions:
        List<Slot> getSlots;
        Map<VehicleID, Slot> occupiedSlots;

Slot
    functions:
        void occupy();
        void release();
    private variables:
        int size;
        bool status;
        Vehicle vehicle
*/

// Vehicle Class
public class Vehicle {
    private final int size;
    private final int lisense;
    private boolean status;
    private Lot lot;

    public Vehicle(int size) {
        this.size = size;
        lisense = this.hashCode();
        lot = Lot.getInstance();
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private Slot findSlot() {

        Slot slot;
        switch (this.size) {
        case 1:
            slot = lot.getSmallSlots().remove(0);
        case 2:
            slot = lot.getCompactSlots().remove(0);
        case 3:
            slot = lot.getLargeSlots().remove(0);
        default:
            slot = null;
        }
        return slot;
    }

    public void park() {
        Slot slot = findSlot();
        if (slot != null) {
            lot.occupiedSlots.put(this.lisense, slot);
            slot.occupy(this);
        }
    }

    public void leave() {
        Slot slot = lot.occupiedSlots.remove(this.lisense);
        slot.release();
        switch (this.size) {
        case 1:
            lot.getSmallSlots().add(slot);
        case 2:
            lot.getCompactSlots().add(slot);
        case 3:
            lot.getLargeSlots().add(slot);
        }
    }
}

public class Car extends Vehicle{
    public Car(){
        super(1);        
    }
}
public class Truck extends Vehicle{
    public Truck(){
        super(2);        
    }
}
// ... other type of vehicle


// Lot Class
public class Lot {
    private static Lot lot = null;

    private static final int NUMBER_OF_SMALL_SLOTS = 10;
    private static final int NUMBER_OF_COMPACT_SLOTS = 10;
    private static final int NUMBER_OF_LARGE_SLOTS = 10;

    public Map<Integer, Slot> occupiedSlots;
    private List<Slot> smallSlots;
    private List<Slot> compactSlots;
    private List<Slot> largeSlots;

    private Lot() {
        smallSlots = new LinkedList<>();
        compactSlots = new LinkedList<>();
        largeSlots = new LinkedList<>();
        occupiedSlots = new HashMap<>();
        for (int i = 1; i <= NUMBER_OF_SMALL_SLOTS; i++)
            smallSlots.add(new Slot(i, 1));

        for (int i = 1; i <= NUMBER_OF_COMPACT_SLOTS; i++)
            compactSlots.add(new Slot(i, 2));

        for (int i = 1; i <= NUMBER_OF_LARGE_SLOTS; i++)
            largeSlots.add(new Slot(i, 3));

    }

    public List<Slot> getSmallSlots() {
        return smallSlots;
    }

    public List<Slot> getCompactSlots() {
        return compactSlots;
    }

    public List<Slot> getLargeSlots() {
        return largeSlots;
    }

    public static Lot getInstance() {
        if (lot == null)
            lot = new Lot();
        return lot;
    }
}

// Slot Class
public class Slot {
    private final int id;
    private final int size;
    private boolean available;
    private Vehicle vehicle;

    public Slot(int id, int size) {
        this.id = id;
        this.size = size;
        this.available = true;
    }

    public void occupy(Vehicle v) {
        this.vehicle = v;
        this.available = false;
    }

    public void release() {
        this.vehicle = null;
        this.available = true;
    }
}
