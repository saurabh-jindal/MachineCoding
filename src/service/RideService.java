package service;

import model.Ride;
import repository.RideRepository;
import repository.UserRepository;

import java.awt.geom.RoundRectangle2D;
import java.util.List;
import java.util.Objects;

public class RideService {
    RideRepository rideRepository = RideRepository.getInstance();

    public void offerRide(String name, String origin, Integer availableSeats, String vehicle, String regNo, String destination){
        System.out.println(rideRepository.offerRide(name, origin, availableSeats, vehicle, regNo, destination));
    }

    public void selectRide(String riderName, String origin, String destination, Integer seatsRequired, String rideType, String vehicle){
        Ride ride = null;
        if(Objects.equals(rideType, "Most Vacant")){
            ride = rideRepository.findRidebyVacancy(riderName, origin, destination, seatsRequired);
        }else if(Objects.equals(rideType, "Preferred Vehicle")){
            ride = rideRepository.findRidebyPrefferedVehicle(riderName, origin, destination, seatsRequired, vehicle);
        }
        if(Objects.nonNull(ride)){
            System.out.println(ride);
            return;
        }
        System.out.println("No Rides Available");
    }

    public void endRide(Ride ride){
        if(rideRepository.endRide(ride)){
            System.out.println("Ride Ended");
            return;
        }
        System.out.println("Ride was not found");
    }

}
