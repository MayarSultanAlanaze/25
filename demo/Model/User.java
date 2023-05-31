package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(20)")
    private String name;
    @NotEmpty
    @Column(columnDefinition = "varchar(20)")
    private String username;
    @Email
    @NotEmpty
    @Column(columnDefinition = "")
    private String email;
    @Column(columnDefinition = " int ")
    private Integer age;
    @Column(columnDefinition = "varchar (10) not null check(role='admin' or 'user')")
    private String role;
    @NotEmpty
    @Column(columnDefinition = "")
    private String hoppy;
    @Size(min = 5 ,max = 15)
    private String password;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
   private Set<Place>places;

}
