package com.example.demo.Service;

import com.example.demo.ApiException.ApiException;
import com.example.demo.Dto.PlaceDetailsDOT;
import com.example.demo.Model.Place;
import com.example.demo.Model.PlaceDetils;
import com.example.demo.Repository.RepositoryPlace;
import com.example.demo.Repository.RepositoryPlaceDetils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServisplaceDitils {
private final RepositoryPlaceDetils repositoryPlaceDetils;
private final RepositoryPlace repositoryPlace;



        public List<PlaceDetils> findAll(){
            return repositoryPlaceDetils.findAll();
        }


        public void addPlaceDetails(PlaceDetailsDOT dto){
            Place place=repositoryPlace.findAllById(dto.getPlease_id());

           if (place==null){
                throw new ApiException("Can't add details, place not found");
            }
           PlaceDetils  placeDetails=new PlaceDetils(null, dto.getLocation(), dto.getTimeWork(), dto.getTimeWork(), dto.getDurationOfEvent(), place);
        }

        public void updatePlaceDetails( PlaceDetils placeDetils, Integer id){
            PlaceDetils old=repositoryPlaceDetils.findPlaceDetilsById(id);
            if(old==null){
                throw new ApiException("Not found");
            }

            old.setId(old.getId());
            old.setLocation(old.getLocation());
            old.setTimeWork(old.getTimeWork());
            old.setDate(old.getDate());
            repositoryPlaceDetils.save(old);
        }


        public void deletePlaceDetails(Integer id){
            PlaceDetils placeDetails=repositoryPlaceDetils.findPlaceDetilsById(id);
            if(placeDetails==null){
                throw new ApiException("Not found");
            }
            repositoryPlaceDetils.delete(placeDetails);
        }

        public Place getPlaceDetails(Integer id){
            return repositoryPlace.findAllById(id);

        }

    }
