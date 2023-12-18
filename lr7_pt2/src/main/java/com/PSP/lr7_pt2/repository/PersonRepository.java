package com.PSP.lr7_pt2.repository;

import com.PSP.lr7_pt2.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByName(String name);

    List<Person> findByActedFilmsIsNotEmptyAndDirectedFilmsIsNotEmpty();
}
