package com.learningNavigator.LearningNavigator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.learningNavigator.LearningNavigator.Entities.Exam;
import com.learningNavigator.LearningNavigator.Entities.Student;
import com.learningNavigator.LearningNavigator.Entities.Subject;
import com.learningNavigator.LearningNavigator.Exception.StudentDoesNotExistException;
import com.learningNavigator.LearningNavigator.Exception.SubjectDoesNotExistException;
import com.learningNavigator.LearningNavigator.Service.LearningNavigatorExamService;
import com.learningNavigator.LearningNavigator.Service.LearningNavigatorStudentService;
import com.learningNavigator.LearningNavigator.Service.LearningNavigatorSubjectService;

import jakarta.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class LearningNavigatorApplicationTests {

	@Autowired
	private LearningNavigatorExamService examService;

	@Autowired
	private LearningNavigatorStudentService studentService;

	@Autowired
	private LearningNavigatorSubjectService subjectService;

	@DirtiesContext
	@Test
	public void testSaveStudents() {
		studentService.saveStudent(new Student("Student1"));
		studentService.saveStudent(new Student("Student2"));
		List<Student> students = studentService.getStudents();
		System.out.println(students.size());
		assertTrue(students.size() >= 2);
	}

	@DirtiesContext
	@Test
	public void testSaveSubjects() {
		subjectService.saveSubject(new Subject("Subject1"));
		subjectService.saveSubject(new Subject("Subject2"));
		List<Subject> subjects = subjectService.getSubjects();
		assertTrue(subjects.size() >= 2);
	}

	@DirtiesContext
	@Test
	public void testSaveExamForSubject() throws SubjectDoesNotExistException {
		Subject subject = new Subject("Subject1");
		subjectService.saveSubject(subject);
		examService.saveExam(subject.getId(), new Exam());
		List<Exam> exams = examService.getExams();
		assertTrue(exams.size() >= 1);
	}

	@DirtiesContext
	@Test
	public void testaddExamForStudent() throws SubjectDoesNotExistException, StudentDoesNotExistException {
		Subject subject1 = new Subject("Subject1");
		Subject subject2 = new Subject("Subject2");
		subjectService.saveSubject(subject1);
		subjectService.saveSubject(subject2);
		Exam exam1 = new Exam();
		Exam exam2 = new Exam();
		examService.saveExam(subject1.getId(), exam1);
		examService.saveExam(subject2.getId(), exam2);
		Student student = new Student("Student1");
		studentService.saveStudent(student);
		List<Integer> examsId = new ArrayList<>();
		examsId.add(exam1.getId());
		examsId.add(exam2.getId());
		studentService.addExamToStudent(examsId, student.getId());
	}

}
