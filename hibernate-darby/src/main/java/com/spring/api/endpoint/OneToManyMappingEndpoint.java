package com.spring.api.endpoint;

import com.spring.api.entity.Course;
import com.spring.api.entity.Instructor;
import com.spring.api.entity.InstructorDetail;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@RestController
public class OneToManyMappingEndpoint {

    // Instructor to Courses : 1 Instructor can have many Courses

    @PersistenceContext(unitName = "MySQL")
    private EntityManager entityManager;

    @GetMapping("/one-to-many")
    @Transactional
    public String oneToManyMapping() {

        InstructorDetail instructorDetail = new InstructorDetail("thecrazzyrahul", "coding");

        Course java = new Course("Java");
        Course angular = new Course("Angular");
        Course hibernate = new Course("Hibernate");

        Instructor instructor = new Instructor("Rahul", "Choudhary", instructorDetail);

        // Add Courses Using : Bidirectional Convenience Method
        instructor.addCourse(java);
        instructor.addCourse(angular);
        instructor.addCourse(hibernate);

        entityManager.persist(instructor);

        return "instructor persisted";
    }

    @GetMapping("/ont-to-many-bidirectional")
    public Instructor oneToOneBidirectionalMapping() {
       /* Query query = entityManager.createQuery("FROM Instructor");
        List<Instructor> instructors = query.getResultList();
        System.out.println(instructors);

        System.out.println("*********************************");*/

        Instructor instructor = entityManager.find(Instructor.class,1l);
        System.out.println(instructor);

        System.out.println("*********************************");

        // System.out.println(instructor.getCourses());

        return instructor;
    }

}
