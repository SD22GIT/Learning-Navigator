package com.learningNavigator.LearningNavigator.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningNavigator.LearningNavigator.Entities.Student;

@Repository
public interface LearningNavigatorStudentRepository extends JpaRepository<Student, Integer> {

}
