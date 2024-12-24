package com.springCourse.OneToManyJpaMapping.dao;

import com.springCourse.OneToManyJpaMapping.entity.Instructor;
import com.springCourse.OneToManyJpaMapping.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO {
    private final EntityManager entityManager;

    public AppDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    public void deleteInstructorById(int theId) {
        // Retrieve the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        // Delete the instructor
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

//    // Method to delete Instructor detail and Instructor at the same time
//    public void deleteInstructorDetailById(int theId) {
//        // retrieve instructor detail
//        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);
//        // delete instructor detail
//        entityManager.remove(tempInstructorDetail);
//    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
//        Retrieve instructor detail
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

//        Remove the associated object reference
//        Break bidirectional link
        tempInstructorDetail.getInstructor().setInstructorDetail(null);

//        Delete the Instructor Detail
        entityManager.remove(tempInstructorDetail);
    }
}
