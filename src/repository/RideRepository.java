package repository;

import model.Ride;
import model.User;
import model.Vehicle;

import java.util.*;

public class RideRepository {
    private static RideRepository rideRepository;
    private RideRepository(){};
    public static RideRepository getInstance(){
        if(rideRepository == null){
            rideRepository = new RideRepository();
        }
        return rideRepository;
    }
    UserRepository userRepository = UserRepository.getInstance();
    List<Ride> allRides = new ArrayList<>();
    List<Ride> updatedRides = new ArrayList<>();
    VehicleRepository vehicleRepository = VehicleRepository.getInstance();
    public String offerRide(String name, String origin, Integer availableSeats, String vehicleType, String regNo, String destination){
        User user = userRepository.getUserByName(name);
        if(Objects.isNull(user)){
            return "User not found in the system";
        }
        Vehicle vehicle = vehicleRepository.getVehicleByRegNo(regNo);
        if(Objects.isNull(vehicle)){
            return "Vehicle is not registered";
        }
        boolean foundVehicle = false;
        for(Vehicle vehicleIterator: user.getVehicleList()){
            if(vehicleIterator.getRegNo().equals(regNo)){
                foundVehicle = true;
                break;
            }
        }
        if(!foundVehicle){
            return "Vehicle is not registered for this user";
        }
        for(Ride ride: updatedRides){
            if(ride.getVehicle().getRegNo().equals(regNo) && ride.getUser().getId().equals(user.getId())){
                return "Ride cannot be offered since a ride has already been offered";
            }
        }

        Ride ride = new Ride(user, vehicle, availableSeats, origin, destination);
        allRides.add(ride);
        updatedRides.add(ride);
        user.setOfferedRides(user.getOfferedRides() + 1);
        return "Ride Successfully Offered";
    }

    public Ride findRidebyPrefferedVehicle(String riderName, String origin, String destination, Integer seats, String preferredVehicle){
        User user = userRepository.getUserByName(riderName);
        for(Ride ride: updatedRides){
            if(ride.getOrigin().equals(origin) && ride.getDestination().equals(destination) && ride.getAvailableSeats() >= seats && ride.getVehicle().getType().equals(preferredVehicle)){
                user.setTakenRides(user.getTakenRides() + 1);
                return ride;
            }
        }
        return null;
    }

    public Ride findRidebyVacancy(String riderName, String origin, String destination, Integer seats){
        List<Ride> rides = new ArrayList<>();
        User user = userRepository.getUserByName(riderName);
        for(Ride ride: updatedRides){
            if(ride.getOrigin().equals(origin) && ride.getDestination().equals(destination) && ride.getAvailableSeats() >= seats){
                rides.add(ride);
            }
        }
        if(!rides.isEmpty()) user.setTakenRides(user.getTakenRides() + 1);
        rides.sort(Comparator.comparing(Ride::getAvailableSeats, Comparator.reverseOrder()));
        if(!rides.isEmpty()){
            for(Ride ride: updatedRides){
                if(Objects.equals(ride, rides.get(0))){
                    ride.setAvailableSeats(ride.getAvailableSeats() - seats);

                }
            }
            return rides.get(0);
        }
        return null;
    }

    public boolean endRide(Ride ride){
        int seats = 0;

        for(Ride rideIterator: allRides){
            if(rideIterator.equals(ride)){
                seats = rideIterator.getAvailableSeats();
            }
        }
        for(Ride rideIterator: updatedRides){
            if(rideIterator.equals(ride)){
                rideIterator.setAvailableSeats(seats);
                return true;
            }
        }
        return false;
    }

}
