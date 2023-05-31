package com.example.demo.Controller;

import com.example.demo.Dto.PlaceDetailsDOT;
import com.example.demo.Model.PlaceDetils;
import com.example.demo.Service.ServisplaceDitils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
@RequiredArgsConstructor
@RequestMapping("/api/v1/placedetils")
public class ControllerPlaceDetils {
    private final ServisplaceDitils servisplaceDitils;

    public List<PlaceDetils> findAll() {
        return servisplaceDitils.findAll();
    }

    @PutMapping("/addDetails")
    public ResponseEntity addDetailsToPlace(@RequestBody @Valid PlaceDetailsDOT placeDetailsDOT ){
        servisplaceDitils.addPlaceDetails(placeDetailsDOT);
        return ResponseEntity.status(200).body("Done Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePlaceDetails(@Valid @RequestBody PlaceDetils placeDetils, @PathVariable Integer id ){
        servisplaceDitils.updatePlaceDetails(placeDetils,id);
        return ResponseEntity.status(200).body("Updated Done");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePlaceDetails(@PathVariable Integer id){
        servisplaceDitils.deletePlaceDetails(id);
        return ResponseEntity.status(200).body("Deleted Done");
    }

    @GetMapping("/getDetails/{id}")
    public ResponseEntity getPlaceDetails(@PathVariable  Integer id){
        return ResponseEntity.status(200).body(servisplaceDitils.getPlaceDetails(id));
    }
}
