import model.Ride;
import service.RideService;
import service.UserService;
import service.VehicleService;

public class Main {
    
    public static void main(String[] args) {
        Ride ride;
        UserService userService = new UserService();
        VehicleService vehicleService = new VehicleService();
        RideService rideService = new RideService();
        userService.addUser("Rohan", "M", 36);
        vehicleService.addVehicle("Rohan", "Swift", "KA-01-12345");
        userService.addUser("Shashank", "M", 29);
        vehicleService.addVehicle("Shashank", "Baleno", "TS-05-62395");
        userService.addUser("Nandini", "F", 29);
        userService.addUser("Shipra", "F", 27);
        vehicleService.addVehicle("Shipra", "Activa", "KA-12-12332");
        vehicleService.addVehicle("Shipra", "Polo", "KA-05-41491");
        userService.addUser("Gaurav", "M", 29);
        userService.addUser("Rahul", "M", 35);
        vehicleService.addVehicle("Rahul", "XUV", "KA-05-1234");
        rideService.offerRide("Rohan", "Hyderabad",1, "Swift", "KA-01-12345", "Bangalore");
        rideService.offerRide("Shipra", "Bangalore",1, "Activa", "KA-12-12332", "Mysore");
        rideService.offerRide("Shipra", "Bangalore",2, "Polo", "KA-05-41491", "Mysore");
        rideService.offerRide("Shashank", "Hyderabad",2, "Baleno", "TS-05-62395", "Bangalore");
        rideService.offerRide("Rahul", "Hyderabad",5, "XUV", "KA-05-1234", "Bangalore");
        rideService.offerRide("Rohan", "Bangalore",1, "Swift", "KA-01-12345", "Pune");
        rideService.selectRide("Nandini", "Bangalore","Mysore",1,"Most Vacant", "");
        rideService.selectRide("Gaurav", "Bangalore","Mysore",1,"Preferred Vehicle", "Activa");
        rideService.selectRide("Shashank", "Mumbai","Bangalore",1,"Most Vacant", "");
        rideService.selectRide("Rohan", "Hyderabad","Bangalore",1,"Preferred Vehicle", "Baleno");
        rideService.selectRide("Shashank", "Hyderabad","Bangalore",1,"Preferred Vehicle", "Polo");
        userService.printRideStats();
    }
}