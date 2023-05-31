package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PlaceDetailsDOT {
    private Integer please_id;

    private String location;
    private String timeWork;
    private String date;
    private String durationOfEvent;

}
