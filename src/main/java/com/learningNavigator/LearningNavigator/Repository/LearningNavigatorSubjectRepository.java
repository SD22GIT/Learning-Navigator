package com.learningNavigator.LearningNavigator.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningNavigator.LearningNavigator.Entities.Subject;

@Repository
public interface LearningNavigatorSubjectRepository extends JpaRepository<Subject, Integer> {

}
