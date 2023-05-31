package com.example.demo.Repository;

import com.example.demo.Model.PlaceDetils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPlaceDetils extends JpaRepository<PlaceDetils, Integer> {

    PlaceDetils findPlaceDetilsById(Integer id);
}
