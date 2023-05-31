package com.example.demo.Service;

import com.example.demo.ApiException.ApiException;
import com.example.demo.Model.Place;
import com.example.demo.Model.User;
import com.example.demo.Repository.RepositoryPlace;
import com.example.demo.Repository.RepositoryUser;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicePlace {
    private final RepositoryPlace repositoryPlace;
    private final RepositoryUser repositoryUser;

    public List<Place> getPlace() {
        return repositoryPlace.findAll();
    }

    public void addPlace(Place place) {
        repositoryPlace.save(place);
    }

    public Place updateplace(Place place, Integer id) {
        Place place1 = repositoryPlace.getById(id);
        if (place1 == null) {
            place1.setName(place.getName());
            place1.setCity(place.getCity());
            place1.setRole(place.getRole());
        }
        repositoryPlace.save(place1);
        return place1;

    }

    public Place deletePlace(Integer id) {
        Place place = repositoryPlace.getById(id);
        if (place == null) {
            throw new ApiException("MOVIE DELETE");
        }
        repositoryPlace.delete(place);
        return place;
    }

    public List<Place> UserByHoppy(String hoppy) {
        List<Place> place = repositoryPlace.findAllByCatgory(hoppy);
        if ( place == null) {
            throw new ApiException("not found");
        }
        return place;


    }



}
