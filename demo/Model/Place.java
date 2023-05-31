package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.groups.ConvertGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Table
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(columnDefinition = "varchar (10) not null ")
    private String name;

    @NotEmpty
    @Column(columnDefinition = "varchar (10) not null ")
    private String City;

    @NotEmpty
    @Column(columnDefinition = "varchar (10) not null")
    private String role;


    @NotEmpty
    @Column(columnDefinition = "varchar (10) not null check(Category= 'drawing' or 'writer' or 'programming' or 'sing' )")
    private String catgory;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "Place_name",referencedColumnName = "name")
    private User user;
}
