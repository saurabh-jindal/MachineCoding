package service;

import repository.VehicleRepository;

public class VehicleService {
    VehicleRepository vehicleRepository = VehicleRepository.getInstance();
    public void addVehicle(String name, String type, String regNo){
        vehicleRepository.addVehicle(name, type, regNo);
        System.out.println("Vehicle added");
    }
}
