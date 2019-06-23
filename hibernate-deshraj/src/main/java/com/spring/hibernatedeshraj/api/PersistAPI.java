package com.spring.hibernatedeshraj.api;

import com.spring.hibernatedeshraj.entity.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
public class PersistAPI {

    @PersistenceContext(unitName = "MySQL")
    private EntityManager entityManager;

    @PostMapping("/persist")
    public void persist() {
        Student student = new Student();
        student.setFirstName("Rahul");
        student.setLastName("Choudhary");
        student.setEmail("thecrazzyrahul@gmail.com");

        // student object before persist
        System.out.println(student);

        entityManager.persist(student);

        // student object after persist
        System.out.println(student);
    }
}
