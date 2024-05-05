package com.learningNavigator.LearningNavigator.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningNavigator.LearningNavigator.Entities.Exam;

@Repository
public interface LearningNavigatorExamRepository extends JpaRepository<Exam, Integer> {

}
