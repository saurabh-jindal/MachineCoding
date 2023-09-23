package service;

import repository.UserRepository;

public class UserService {
    UserRepository userRepository = UserRepository.getInstance();
    public void addUser(String name, String gender, Integer age){
        userRepository.addUser(name, gender, age);
        System.out.println("User Created");
    }
    public void printRideStats(){
        userRepository.printRideStats();
    }
}
