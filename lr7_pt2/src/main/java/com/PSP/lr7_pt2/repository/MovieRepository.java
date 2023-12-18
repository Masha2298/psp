package com.PSP.lr7_pt2.repository;

import com.PSP.lr7_pt2.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    //void updateById(Long id, String name, LocalDate releaseDate, String country, Set<Person> directors, Set<Person> actors);
    List<Movie> findByReleaseDateBetween(LocalDate lastYearDate, LocalDate currentDate);

    List<Movie> findByReleaseDateBefore(LocalDate thresholdDate);

}
