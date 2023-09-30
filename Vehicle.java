class Vehicle {
    public String registrationNumber;
    public String type;
    public String manufacturer;
    public int capacity;
    public boolean isAvailable;
    public double distanceTravelled;
    public int totalTrips;

    public Vehicle(String registrationNumber, String type, String manufacturer, int capacity) {
        this.registrationNumber = registrationNumber;
        this.type = type;
        this.manufacturer = manufacturer;
        this.capacity = capacity;
        this.isAvailable = true;
        this.distanceTravelled = 0.0;
        this.totalTrips = 0;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void allocate(double distance) {
        isAvailable = false;
        distanceTravelled += distance;
        totalTrips++;
    }

    public void deallocate() {
        isAvailable = true;
    }

    public double getTotalDistance() {
        return distanceTravelled;
    }

    public int getTotalTrips() {
        return totalTrips;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
