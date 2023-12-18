package com.PSP.lr7_pt2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Entity
@Table(name="Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String name;
    private LocalDate dateOfBirth;

    @JsonIgnore
    @ManyToMany(mappedBy = "directors")
    @Fetch(FetchMode.SUBSELECT)
    private Set<Movie> directedFilms = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "actors")
    @Fetch(FetchMode.SUBSELECT)
    private Set<Movie> actedFilms = new HashSet<>();

    Person() {

    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<Movie> getDirectedFilms() {
        return directedFilms;
    }

    public void setDirectedFilms(Set<Movie> directedFilms) {
        this.directedFilms = directedFilms;
    }

    public Set<Movie> getActedFilms() {
        return actedFilms;
    }

    public void setActedFilms(Set<Movie> actedFilms) {
        this.actedFilms = actedFilms;
    }
}
