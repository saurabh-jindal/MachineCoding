package model;

import enums.Gender;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    String id;
    String name;
    Gender gender;
    Integer age;

    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                '}';
    }

    Integer offeredRides;
    Integer takenRides;
    List<Vehicle> vehicleList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getOfferedRides() {
        return offeredRides;
    }

    public void setOfferedRides(Integer offeredRides) {
        this.offeredRides = offeredRides;
    }

    public Integer getTakenRides() {
        return takenRides;
    }

    public void setTakenRides(Integer takenRides) {
        this.takenRides = takenRides;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void addVehicleList(Vehicle vehicle) {
        this.vehicleList.add(vehicle);
    }

    public User(String name, Gender gender, Integer age) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.offeredRides = 0;
        this.takenRides = 0;
        this.vehicleList = new ArrayList<>();
    }
}
