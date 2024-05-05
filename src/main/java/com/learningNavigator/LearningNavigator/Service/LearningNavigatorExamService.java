package com.learningNavigator.LearningNavigator.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningNavigator.LearningNavigator.Entities.Exam;
import com.learningNavigator.LearningNavigator.Entities.Subject;
import com.learningNavigator.LearningNavigator.Exception.SubjectDoesNotExistException;
import com.learningNavigator.LearningNavigator.Repository.LearningNavigatorExamRepository;

@Service
public class LearningNavigatorExamService {

	@Autowired
	private LearningNavigatorExamRepository repository;

	@Autowired
	private LearningNavigatorSubjectService subjectService;

	public List<Exam> getExams() {
		return repository.findAll();
	}

	public Exam findExamById(int id) {
		return repository.findById(id).get();
	}

	public Exam saveExam(Exam exam) {
		return repository.save(exam);
	}

	public Exam saveExam(int subjectId, Exam exam) throws SubjectDoesNotExistException {
		Subject subject = subjectService.findSubjectById(subjectId);
		exam.setSubject(subject);
		return repository.save(exam);
	}
}
