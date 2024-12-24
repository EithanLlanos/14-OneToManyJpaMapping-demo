package com.springCourse.OneToManyJpaMapping.dao;

import com.springCourse.OneToManyJpaMapping.entity.Course;
import com.springCourse.OneToManyJpaMapping.entity.Instructor;
import com.springCourse.OneToManyJpaMapping.entity.InstructorDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);
}
