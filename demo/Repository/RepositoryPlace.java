package com.example.demo.Repository;

import com.example.demo.Model.Place;
import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryPlace extends JpaRepository<Place,Integer> {
     Place findAllById(Integer id);
     Place getPlaceByName(String name);
     Place getPlaceByCity(String city);
     Place getPlaceByRole(String role);
   List<Place> findAllByCatgory(String catgory);
}
