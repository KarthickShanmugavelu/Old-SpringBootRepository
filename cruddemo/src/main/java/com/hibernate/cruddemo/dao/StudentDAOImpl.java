package com.hibernate.cruddemo.dao;

import com.hibernate.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    public StudentDAOImpl() {
    }

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student find(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY firstName",Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findStudentByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName LIKE :lastNameParam ", Student.class);
        query.setParameter("lastNameParam","%"+lastName+"%");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
       entityManager.merge(student);
    }

    @Override
    @Transactional
    public void updateStudentUsingQuery() {
        int status = entityManager.createQuery("UPDATE Student SET firstName='Naveen', lastName='Kumar',email='naveen@gmail.com' where id=2").executeUpdate();
        System.out.println(" ******** "+status+" ********** ");
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numberOfRowsDeleted=entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numberOfRowsDeleted;
    }


}
