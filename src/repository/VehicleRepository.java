package repository;

import model.User;
import model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VehicleRepository {
    private static VehicleRepository vehicleRepository;
    private VehicleRepository(){};
    public static VehicleRepository getInstance(){
        if(vehicleRepository == null){
            vehicleRepository = new VehicleRepository();
        }
        return vehicleRepository;
    }
    List<Vehicle> allVehicles = new ArrayList<>();
    UserRepository userRepository = UserRepository.getInstance();
    public Vehicle addVehicle(String name, String type, String regNo){
        User user = userRepository.getUserByName(name);
        if(Objects.isNull(user)){
            return null;
        }
        Vehicle vehicle = new Vehicle(type, regNo);
        user.addVehicleList(vehicle);
        allVehicles.add(vehicle);

        return vehicle;
    }

    public Vehicle getVehicleByRegNo(String regNo){
        for(Vehicle vehicle: allVehicles){
            if(vehicle.getRegNo().equals(regNo)){
                return vehicle;
            }
        }
        return null;
    }
}
