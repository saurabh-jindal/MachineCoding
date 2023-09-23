package model;

import java.util.UUID;

public class Vehicle {
    String id;

    @Override
    public String toString() {
        return "Vehicle{" +
                ", type='" + type + '\'' +
                ", regNo='" + regNo + '\'' +
                '}';
    }

    String type;
    String regNo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public Vehicle(String type, String number) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.regNo = number;
    }
}
