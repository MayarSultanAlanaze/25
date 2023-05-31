package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Table
public class PlaceDetils {
    @Id
    private Integer id;
    @Column(columnDefinition = "varchar(100) not null")
    private String location;


    @Column(columnDefinition = "varchar(8) not null")
    private String timeWork;


    @Column(columnDefinition = "varchar(20) not null")
    private String date;

    @Column(columnDefinition = "varchar(20) not null")
    private String durationOfEvent;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Place place;


    }

