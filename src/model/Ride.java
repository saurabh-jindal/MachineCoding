package model;

import java.util.Comparator;

public class Ride{
    User user;

    @Override
    public String toString() {
        return "Ride{" +
                "user=" + user +
                ", vehicle=" + vehicle +
                ", availableSeats=" + availableSeats +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }

    Vehicle vehicle;
    Integer availableSeats;
    String origin;
    String destination;
    public Ride(User user, Vehicle vehicle, Integer availableSeats, String origin, String destination) {
        this.user = user;
        this.vehicle = vehicle;
        this.availableSeats = availableSeats;
        this.origin = origin;
        this.destination = destination;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

}
