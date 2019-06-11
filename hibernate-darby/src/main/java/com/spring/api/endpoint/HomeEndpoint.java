package com.spring.api.endpoint;

import com.spring.api.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RestController
public class HomeEndpoint {


    @PersistenceContext(unitName = "MySQL")
    private EntityManager entityManager;

    @GetMapping("/")
    @Transactional
    public Student home() {
        Student student = new Student("Shalu", "Choudhary", "thecrazzyshalu@gmail.com");
        entityManager.persist(student);


        System.out.println(student);

        return entityManager.find(Student.class, student.getId());
    }
}
