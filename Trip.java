Package CoreJavaProject;

class Trip extends Vehicle {
    public int tripId;
    public String vehicleRegistrationNumber;
    public double startKilometer;
    public double endKilometer;
    public String startTime;
    public String endTime;
    public String status;
    public String allocatedVehicleRegistrationNumber;

    public Trip(int tripId, String vehicleRegistrationNumber, double startKilometer, double endKilometer,
                String startTime) {
        this.tripId = tripId;
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
        this.startKilometer = startKilometer;
        this.endKilometer = endKilometer;
        this.startTime = startTime;
        this.status = "In Progress";
    }
    public void setAllocatedVehicle(String registrationNumber) {
        this.allocatedVehicleRegistrationNumber = registrationNumber;
    }

    public String getAllocatedVehicleRegistrationNumber() {
        return allocatedVehicleRegistrationNumber;
    }
    public Vehicle findVehicleByRegistrationNumber(String registrationNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getRegistrationNumber().equals(registrationNumber)) {
                return vehicle;
            }
        }
        return null; // Vehicle not found
    }


    public void completeTrip(String endTime) {
        this.endTime = endTime;
        this.status = "Completed";
        String allocatedVehicleRegistrationNumber = getAllocatedVehicleRegistrationNumber();

        if (allocatedVehicleRegistrationNumber != null) {
            Vehicle allocatedVehicle = findVehicleByRegistrationNumber(allocatedVehicleRegistrationNumber);
            if (allocatedVehicle != null) {
                allocatedVehicle.deallocate(); // Mark the vehicle as available after the trip
            }
        }
    }






    public Object getStatus() {
        return null;
    }

    public String getTripId() {
        return null;
    }
}
