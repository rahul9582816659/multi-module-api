package com.spring.hibernatedeshraj.api;

import com.spring.hibernatedeshraj.entity.value_type.Address;
import com.spring.hibernatedeshraj.entity.value_type.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/value_type")
public class EntityValueTypeAPI {

    @PersistenceContext(unitName = "MySQL")
    private EntityManager entityManager;

    @PostMapping("/persist")
    @Transactional
    public void persist() {

        // value type
        Address homeAddress = new Address("Mapsko Paradise", "Gurgoan", "India");

        Address officeAddress = new Address("Cyber City", "Gurgoan", "India");

        // entity type
        Person person = new Person();
        person.setName("Rahul");
        person.setHomeAddress(homeAddress);
        person.setOfficeAddress(officeAddress);

        entityManager.persist(person);
    }

    @GetMapping("/find")
    public Person find() {

        // finding student with id = 1
        return entityManager.find(Person.class, 1l);
    }
}
