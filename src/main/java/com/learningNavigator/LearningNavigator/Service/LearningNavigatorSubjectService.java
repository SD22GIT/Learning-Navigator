package com.learningNavigator.LearningNavigator.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningNavigator.LearningNavigator.Entities.Subject;
import com.learningNavigator.LearningNavigator.Exception.SubjectDoesNotExistException;
import com.learningNavigator.LearningNavigator.Repository.LearningNavigatorSubjectRepository;

@Service
public class LearningNavigatorSubjectService {

	@Autowired
	private LearningNavigatorSubjectRepository repository;

	public List<Subject> getSubjects() {
		return repository.findAll();
	}

	public Subject findSubjectById(int id) throws SubjectDoesNotExistException {
		try {
			return repository.findById(id).get();
		} catch (Exception e) {
			throw new SubjectDoesNotExistException("Subject With Id " + id + " Not Found");
		}
	}

	public void saveSubject(Subject subject) {
		repository.save(subject);
	}
}
