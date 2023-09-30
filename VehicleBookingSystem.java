package CoreJavaProject;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VehicleBookingSystem extends Trip  {
    public static List<Vehicle> vehicles = new ArrayList<>();
    public static List<Trip> trips = new List<>();
    public static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 1 for Vehicle Registration");
            System.out.println("Enter 2 for Vehicle Allocation Request");
            System.out.println("Enter 3 for Multiple Allocation Requests in Parallel");
            System.out.println("Enter 4 for Vehicle Usage Report");
            System.out.println("Enter 0 to exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerVehicle(scanner);
                    break;
                case 2:
                    allocateVehicle(scanner);
                    break;
                case 3:
                    parallelAllocation(scanner);
                    break;
                case 4:
                    generateCsvReport();
                    break;
                case 0:
                    executor.shutdown();
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void registerVehicle(Scanner scanner) {
        System.out.print("Enter Registration Number: ");
        String registrationNumber = scanner.nextLine();
        System.out.print("Enter Vehicle Type: ");
        String type = scanner.nextLine();
        System.out.print("Enter Vehicle Manufacturer: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Enter Vehicle Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        Vehicle vehicle = new Vehicle(registrationNumber, type, manufacturer, capacity);
        vehicles.add(vehicle);

        System.out.println("Vehicle registered successfully.");
    }

    public static void allocateVehicle(Scanner scanner) {
        System.out.print("Enter Trip ID: ");
        int tripId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Start Kilometer: ");
        double startKilometer = scanner.nextDouble();
        System.out.print("Enter End Kilometer: ");
        double endKilometer = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Start Time: ");
        String startTime = scanner.nextLine();
        System.out.print("Enter Required Vehicle Capacity: ");
        int requiredCapacity = scanner.nextInt();
        scanner.nextLine();

        boolean allocated = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable() && vehicle.getCapacity() >= requiredCapacity) {
                double distance = endKilometer - startKilometer;
                vehicle.allocate(distance);
                Trip trip = new Trip(tripId, vehicle.getRegistrationNumber(), startKilometer, endKilometer, startTime);
                trips.add(trip);
                allocated = true;
                System.out.println("Trip " + tripId + " allocated to vehicle " + vehicle.getRegistrationNumber());
                break;
            }
        }

        if (!allocated) {
            System.out.println("No available vehicles for trip " + tripId + ". Retrying after 30 seconds...");
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            allocateVehicle(scanner);
        }
    }

    public static void parallelAllocation(Scanner scanner) {
        List<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(() -> {
                allocateVehicle(scanner);
                return null; // Callable requires a return value
            });
        }

        try {
            executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void generateCsvReport() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date now = new Date(0);
        String currentTime = dateFormat.format(now);

        System.out.println("Generating CSV report...");
        System.out.println("Registration Number, Vehicle Type, Total Trips Completed, Total Distance Traveled");

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getRegistrationNumber() + "," + vehicle.getType() + ","
                    + vehicle.getTotalTrips() + "," + vehicle.getTotalDistance());
        }

        for (Trip trip : trips) {
            if ("In Progress".equals(trip.getStatus())) {
                // Complete ongoing trips
                trip.completeTrip(currentTime);
                System.out.println("Trip " + trip.getTripId() + " completed.");
            }
        }
    }
}
