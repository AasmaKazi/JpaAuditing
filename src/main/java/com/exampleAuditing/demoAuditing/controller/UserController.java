package com.exampleAuditing.demoAuditing.controller;

import com.exampleAuditing.demoAuditing.domain.User;
import com.exampleAuditing.demoAuditing.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;
    public static final String RESPONSE = "response";

    @PostMapping(value = "/saveUser")
    public User saveUser(@RequestBody User user) {

        userRepo.save(user);
        return user;

    }

    @GetMapping(value = "/getAll")
    public List<User> getAll() {
        List<User> userList = userRepo.findAll();
        return userList;
    }

    @GetMapping(value = "/findById/{id}")
    public User findUser(@PathVariable Long id) {

        User user = userRepo.getOne(id);
        System.out.println("*************" + user.getCreatedDate());
        System.out.println("**************" + user.getLastModifiedDate());

        return user;


    }

//    @PutMapping(value = "/updateUser")
//    public User updateUser(@RequestBody User user) {
//        Map map = new HashMap();
//
//        userRepo.findById(user.getId());
//        user.setName(user.getName());
//        user.setEmail(user.getEmail());
//        user.setCountry(user.getCountry());
//        System.out.println("*************"+user.getCreatedDate());
//        System.out.println("**************"+ user.getLastModifiedDate());
//        userRepo.save(user);
//
//        return user;
//    }


    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateStudent(
            @PathVariable Long id,
            @RequestBody User user) {
        User update = userRepo.findById(id).get();

        update.setName(user.getName());
        update.setEmail(user.getEmail());
        update.setCountry(user.getCountry());
        return ResponseEntity.ok(userRepo.save(update));
    }
}
