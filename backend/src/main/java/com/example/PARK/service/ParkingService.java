package com.example.PARK.service;
import java.util.List;
import com.example.PARK.model.parking.ParkingGarage;
import com.example.PARK.model.vehicle.Vehicle;
import org.springframework.stereotype.Service;

// Marks this class as a service (contains business logic)
@Service
public class ParkingService {

    // Instance of ParkingGarage where the actual parking logic lives
    private final ParkingGarage parkingGarage;

    // Constructor initializes the ParkingGarage
    public ParkingService() {
        this.parkingGarage = new ParkingGarage(); // temporary (we improve this later)
    }

    // Handles the request to park a vehicle
    public String parkVehicle(Vehicle vehicle) {
        // Calls the ParkingGarage to actually park the vehicle
        parkingGarage.parkVehicle(vehicle);

        // Returns a response back to the controller
        return "Vehicle processed by parking system";
    }

    //Handles a request to get all the vehicles parked in the garage
    public List<Vehicle> getAllVehicles() {
        return parkingGarage.getAllParkedVehicles();
    }

    //Handles a request to get the available space left in the garage
    public int getAvailableSpaces(com.example.PARK.model.vehicle.VehicleType type) {
        return parkingGarage.getAvailableSpaces(type);
    }
}