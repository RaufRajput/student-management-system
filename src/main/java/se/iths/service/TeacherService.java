package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;

    public Teacher createTeacher(Teacher teacher){
        entityManager.persist(teacher);
        return teacher;
    }

    public Teacher updateTeacher(Teacher teacher) {
        entityManager.merge(teacher);
        return teacher;
    }

    public Teacher findTeacherById(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    public List<Teacher> getAllTeachers() {
        return entityManager.createQuery("SELECT s FROM Teacher s", Teacher.class).getResultList();
    }

    public List<Teacher> getTeacherByName(String lastName) {
        return entityManager.createQuery("SELECT t FROM Teacher t WHERE t.lastName = \'"+ lastName +"\'", Teacher.class).getResultList();
    }

    public void deleteTeacher(Long id) {
        Teacher deleteThisTeacher = entityManager.find(Teacher.class, id);
        entityManager.remove(deleteThisTeacher);
    }







}
