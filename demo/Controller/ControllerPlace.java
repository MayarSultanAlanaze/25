package com.example.demo.Controller;

import com.example.demo.ApiResponse.ApiResponse;
import com.example.demo.Model.Place;
import com.example.demo.Service.ServicePlace;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/place")
public class ControllerPlace {

    private final ServicePlace servicePlace;

    @PostMapping("/add")
    public ResponseEntity addPlace(@Valid @RequestBody Place place) {
        servicePlace.addPlace(place);
        return ResponseEntity.status(200).body(new ApiResponse("place added"));
    }

    @PutMapping("/update")
    public ResponseEntity updatePlace(@Valid @RequestBody Place place) {
        return ResponseEntity.status(200).body("place Updated");


    }
}