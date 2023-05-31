package com.example.demo.Controller;

import com.example.demo.ApiResponse.ApiResponse;
import com.example.demo.Model.User;
import com.example.demo.Service.ServicePlace;
import com.example.demo.Service.ServiceUser;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class ControllerUser {
    private final ServiceUser serviceUser;


    @GetMapping("/get")
    public ResponseEntity getAllUser() {
     List <User> userList=serviceUser.getAllUser();
     return ResponseEntity.status(200).body(userList);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user) {
        serviceUser.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("user added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@Valid @RequestBody User user, @PathVariable Integer id) {
        serviceUser.updateUser(user,id);
        return ResponseEntity.status(200).body("users Updated");
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable  Integer id) {
        serviceUser.deleteUser(id);
        return ResponseEntity.status(200).body("user deleted");

    }
    @GetMapping("/get/hoppy")
    public  ResponseEntity getUserByHoppy(@Valid @RequestBody User user, @PathVariable String hoppy){
        serviceUser.getUserByHoppy(hoppy);
        return ResponseEntity.status(200).body("added");
    }

}
