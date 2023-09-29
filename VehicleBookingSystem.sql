CREATE DATABASE vehicle_booking_system;

CREATE TABLE vehicles (
    registration_number VARCHAR(20) PRIMARY KEY,
    type VARCHAR(50),
    manufacturer VARCHAR(50),
    capacity INT,
    is_available BOOLEAN,
    distance_travelled DOUBLE,
    total_trips INT
);

CREATE TABLE trips (
    trip_id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_registration_number VARCHAR(20),
    start_kilometer DOUBLE,
    end_kilometer DOUBLE,
    start_time DATETIME,
    end_time DATETIME,
    status VARCHAR(20),
    FOREIGN KEY (vehicle_registration_number) REFERENCES vehicles(registration_number)
);