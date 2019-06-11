package com.spring.api.endpoint;

import com.spring.api.entity.Instructor;
import com.spring.api.entity.InstructorDetail;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
public class OneToOneMappingEndpoint {

    // Instructor to instructorDetail : 1 instructor can have 1 instructor detail

    @PersistenceContext(unitName = "MySQL")
    private EntityManager entityManager;

    @GetMapping("/one-to-one")
    @Transactional
    public Instructor oneToOneMapping() {

        InstructorDetail instructorDetail = new InstructorDetail("thecrazzyrahul", "coding");
        Instructor instructor = new Instructor("Rahul", "Choudhary", instructorDetail);

        entityManager.persist(instructor);

        return entityManager.find(Instructor.class, instructor.getId());
    }

    @GetMapping("/ont-to-to-bidirectional")
    public Instructor oneToOneBidirectionalMapping() {
        return entityManager.find(InstructorDetail.class, 2l).getInstructor();
    }
}
