package com.example.PARK.controller;

import com.example.PARK.model.vehicle.Vehicle;
import com.example.PARK.service.ParkingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Marks this class as a REST controller (handles HTTP requests/responses)
@RestController
// Base URL for all endpoints in this controller
@RequestMapping("/parking")
public class ParkingController {

    // Service that contains the business logic
    private final ParkingService parkingService;

    // Constructor injection of the service
    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    // Simple test endpoint to check if the API is running
    @GetMapping("/test")
    public String test() {
        return "Parking system is working!";
    }

    // Endpoints to park a vehicle (receives JSON and converts it to a Vehicle object)
    @PostMapping("/park/car")
    public String parkCar(@RequestBody com.example.PARK.model.vehicle.Car car) {
        return parkingService.parkVehicle(car);
    }

    @PostMapping("/park/suv")
    public String parkSUV(@RequestBody com.example.PARK.model.vehicle.SUV suv) {
        return parkingService.parkVehicle(suv);
    }

    // Adds a vehicle to the parking garage
    @PostMapping("/park/bike")
    public String parkBike(@RequestBody com.example.PARK.model.vehicle.MotorBike bike) {
        return parkingService.parkVehicle(bike);
    }

    // Displays all the vehicles that have been parked in the garage
    @GetMapping("/vehicles")
    public List<Vehicle> getVehicles() {
        return parkingService.getAllVehicles();
    }

    //Displays the remaining space in the garage for each vehicle type
    @GetMapping("/spaces")
    public String getAvailableSpaces() {
        int cars = parkingService.getAvailableSpaces(com.example.PARK.model.vehicle.VehicleType.CAR);
        int suvs = parkingService.getAvailableSpaces(com.example.PARK.model.vehicle.VehicleType.SUV);
        int bikes = parkingService.getAvailableSpaces(com.example.PARK.model.vehicle.VehicleType.MOTORBIKE);

        return "Cars: " + cars + ", SUVs: " + suvs + ", Bikes: " + bikes;
    }
}