package repository;

import enums.Gender;
import model.User;
import model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static UserRepository userRepository;
    private UserRepository(){};
    public static UserRepository getInstance(){
        if(userRepository == null){
            userRepository = new UserRepository();
        }
        return userRepository;
    }
    List<User> allUser = new ArrayList<>();
    public User addUser(String name, String gender, Integer age) throws RuntimeException{
        Gender genderEnum = Gender.valueOf(gender.equals("M")?"MALE":"FEMALE");
        User user =  new User(name, genderEnum, age);
        allUser.add(user);
        return user;
    }

    public User getUserByName(String name){
        for(User u: allUser){
            if(u.getName().equals(name)){
                return u;
            }
        }
        return null;
    }

    public void printRideStats(){
        for(User user: allUser){
            System.out.println(user.getName() + ": " + user.getTakenRides() + " Taken, " + user.getOfferedRides() + " Offered");
        }
    }

}
