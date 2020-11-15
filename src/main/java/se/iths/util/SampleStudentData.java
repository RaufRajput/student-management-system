package se.iths.util;


import se.iths.entity.Student;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SampleStudentData {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {

        entityManager.persist(new Student("Donald", "Trump", "donald@altavista.com", "787-0000"));
        entityManager.persist(new Student("Joe", "Biden", "biden@apple.com", "455-8585"));
        entityManager.persist(new Student("Barack", "Obama", "obama@yahoo.com", "877-3535"));
        entityManager.persist(new Student("George", "Bush", "bush@gmail.com", "445-8754"));

    }





}
