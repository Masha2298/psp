package com.PSP.lr7_pt2.controllers.Tasks;

import com.PSP.lr7_pt2.models.Movie;
import com.PSP.lr7_pt2.models.Person;
import com.PSP.lr7_pt2.repository.MovieRepository;
import com.PSP.lr7_pt2.repository.PersonRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.SharedSessionContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

@Controller
public class Task3_2 {

    @Autowired
    private PersonRepository personRepository; // Исправлено: добавлено внедрение зависимости PersonRepository

    @PersistenceContext // Исправлено: добавлено внедрение EntityManager
    private EntityManager entityManager;

    @GetMapping("/task3/{n}")
    public String task1(Model model, @PathVariable Long n) {

        int minFilmCount = Math.toIntExact(n);

        List<Person> actors = getActorsInMovies(minFilmCount);

        model.addAttribute("actors", actors);

        return "task3_2";
    }

    public List<Person> getActorsInMovies(int n) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = criteriaBuilder.createQuery(Person.class);
        Root<Person> personRoot = query.from(Person.class);
        query.select(personRoot)
                .where(criteriaBuilder.greaterThanOrEqualTo(
                        criteriaBuilder.size(personRoot.get("actedFilms")), n));
        return entityManager.createQuery(query).getResultList();
    }
}