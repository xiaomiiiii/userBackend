package com.maven.backend.Controller;

import com.maven.backend.Entity.User;
import com.maven.backend.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User newUser) {
        userRepo.save(newUser);
        System.out.println(newUser);
        return new ResponseEntity("Created new user.", HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity updateUser(@RequestParam int id,
                                     @RequestParam String email,
                                     @RequestParam String name,
                                     @RequestParam String password,
                                     @RequestParam int year,
                                     @RequestParam int month,
                                     @RequestParam int day,
                                     @RequestParam int gender) {


        User user = userRepo.findOne(id);
        User newUser = new User(id, email, name, password, year, month, day, gender);
        userRepo.save(newUser);


        return new ResponseEntity("Updated user information.", HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity deleteUser(@RequestParam int id) {
        if (userRepo.exists(id)) {
            userRepo.delete(id);
            return new ResponseEntity("Deleted user information.", HttpStatus.OK);
        }

        return new ResponseEntity("This user id is not valid.", HttpStatus.BAD_REQUEST);
    }
}
