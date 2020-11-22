package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;

import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional

public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public Student createStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    public Student updateStudent(Student student) {
        entityManager.merge(student);
        return student;
    }

    public Student findStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }


    public List<Student> getAllStudents() {
        return entityManager.createQuery(
                "SELECT i FROM Student i", Student.class).getResultList();}


    public List<Student> getStudentByLastName(String lastName) {
        return entityManager.createQuery("SELECT S FROM Student S WHERE S.lastName = \'"+ lastName +"\'", Student.class).getResultList();
    }


    public void deleteStudent(Long id) {
        Student deleteThisStudent = entityManager.find(Student.class, id);
        entityManager.remove(deleteThisStudent);
    }

    public void addSubject(String SubjectName) {
        Subject subject = new Subject();
        subject.setSubjectName(SubjectName);
        entityManager.persist(subject);
    }

    public Set<Student> getStudentsForSubject(String subjectName) {
        Subject subject = (Subject) entityManager
                .createQuery("SELECT DISTINCT i FROM Subject i " + "INNER JOIN i.teacher t " + "INNER JOIN i.students s " + "WHERE i.SubjectName = :subjectName ")
                .setParameter("subjectName", subjectName).getSingleResult();
        Set<Student> studentsResult = subject.getStudents();
        return studentsResult;
    }

}