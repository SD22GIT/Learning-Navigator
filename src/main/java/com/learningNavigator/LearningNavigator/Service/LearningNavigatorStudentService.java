package com.learningNavigator.LearningNavigator.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningNavigator.LearningNavigator.Entities.Exam;
import com.learningNavigator.LearningNavigator.Entities.Student;
import com.learningNavigator.LearningNavigator.Entities.Subject;
import com.learningNavigator.LearningNavigator.Exception.StudentDoesNotExistException;
import com.learningNavigator.LearningNavigator.Exception.SubjectDoesNotExistException;
import com.learningNavigator.LearningNavigator.Repository.LearningNavigatorStudentRepository;

@Service
public class LearningNavigatorStudentService {

	@Autowired
	private LearningNavigatorStudentRepository repository;

	@Autowired
	private LearningNavigatorSubjectService learningNavigatorSubjectService;

	@Autowired
	private LearningNavigatorExamService learningNavigatorExamService;

	public List<Student> getStudents() {
		return repository.findAll();
	}

	public Student findStudentById(int id) throws StudentDoesNotExistException {
		try {
			return repository.findById(id).get();
		} catch (Exception e) {
			throw new StudentDoesNotExistException("Student With Given Id Does Not Exist");
		}
	}

	public Student saveStudent(Student student) {
		return repository.save(student);
	}

	public void addSubjectToStudent(List<Integer> subjectsId, int id)
			throws SubjectDoesNotExistException, StudentDoesNotExistException {
		Student student = findStudentById(id);
		if (student != null) {
			for (int subjectId : subjectsId) {
				Subject subject = learningNavigatorSubjectService.findSubjectById(subjectId);
				if (subject != null) {
					subject.addStudent(student);
					student.addSubject(subject);
					learningNavigatorSubjectService.saveSubject(subject);
				}
			}
			saveStudent(student);
		} else {
			throw new StudentDoesNotExistException("Student With Given Id Does Not Exist");
		}

	}

	public void addExamToStudent(List<Integer> examsId, int id) throws StudentDoesNotExistException {
		Student student = findStudentById(id);
		if (student != null) {
			for (int examId : examsId) {
				Exam exam = learningNavigatorExamService.findExamById(examId);
				if (exam != null) {
					if (student.getSubjects().contains(exam.getSubject())) {
						exam.addStudent(student);
						student.addExam(exam);
						learningNavigatorExamService.saveExam(exam);
					}
				}
			}
			saveStudent(student);
		}

	}

}
