package se.iths.util;


import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.plaf.SeparatorUI;

@Singleton
@Startup
public class SampleStudentData {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {


        Student student1 = new Student("Donald", "Trump", "donald@altavista.com", "787-0000");
        Student student2 = new Student("Joe", "Biden", "biden@apple.com", "455-8585");
        Student student3 = new Student("Barack", "Obama", "obama@yahoo.com", "877-3535");
        Student student4 = new Student("George", "Bush", "bush@gmail.com", "445-8754");

        Subject subject1 = new Subject("Java");
        Subject subject2 = new Subject("Ruby on rails");
        Subject subject3 = new Subject("MuleSoft");

        Teacher teacher1 = new Teacher("Harvey","Specter", "harvey@psl.com","555-55555");
        Teacher teacher2 = new Teacher("Luis","Litt","litt@psl.com","858-85858");



        //Elev 1
        student1.addSubject(subject1);
        student1.addSubject(subject2);

        //Elev 2
        student2.addSubject(subject1);
        student2.addSubject(subject2);
        student2.addSubject(subject3);

        //Elev 3
        student3.addSubject(subject1);
        student3.addSubject(subject2);
        student3.addSubject(subject3);

        //Elev 4
        student4.addSubject(subject1);
        student4.addSubject(subject3);

        //Lärare 1
        teacher1.addSubject(subject1);
        teacher1.addSubject(subject2);

        //Lärare 2
        teacher2.addSubject(subject3);
        teacher2.addSubject(subject1);

        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityManager.persist(student4);

        entityManager.persist(teacher1);
        entityManager.persist(teacher2);


    }





}
