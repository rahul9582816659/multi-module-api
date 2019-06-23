package com.spring.hibernatedeshraj.api;

import com.spring.hibernatedeshraj.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RestController
public class JpaActionAPI {

    @PersistenceContext(unitName = "MySQL")
    private EntityManager entityManager;

    @PostMapping("/persist")
    @Transactional
    public void persist() {
        Student student = new Student();
        student.setFirstName("Rahul");
        student.setLastName("Choudhary");
        student.setEmail("thecrazzyrahul@gmail.com");

        // student object before persist
        // Student{id=null, firstName='Rahul', lastName='Choudhary', email='thecrazzyrahul@gmail.com'}
        System.out.println(student);

        entityManager.persist(student);

        // student object after persist, this is not yet persisted but row is created in DB
        // Student{id=1, firstName='Rahul', lastName='Choudhary', email='thecrazzyrahul@gmail.com'}
        System.out.println(student);

        // once this method is finished @Transactional AOP will call commit and this data will be persisted in DB

        // if commit is not called it will roll back and row will be delete which is created above
    }


    @GetMapping("/find")
    public Student find() {

        // finding student with id = 1
        return entityManager.find(Student.class, 1l);
    }


    @PostMapping("/update")
    @Transactional
    public Student update() {

        // finding student with id = 1
        Student student = entityManager.find(Student.class, 1l);

        // get student first name
        System.out.println(student.getFirstName());

        // update student first name
        // Dirty check : when object is fetched its in persistence context & we updated this object during transaction
        // once the commit is called of @Transactional hibernate will check weather this object is marked as dirty/modified or not, if yes update will fire
        student.setFirstName("Shalu");

        // return student
        return student;

    }


    @PostMapping("/delete")
    @Transactional
    public void delete() {

        // finding student with id = 1
        Student student = entityManager.find(Student.class, 1l);

        // remove that object
        entityManager.remove(student);

    }

}
