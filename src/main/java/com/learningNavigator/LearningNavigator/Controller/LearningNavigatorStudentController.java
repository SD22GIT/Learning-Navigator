package com.learningNavigator.LearningNavigator.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningNavigator.LearningNavigator.Entities.Student;
import com.learningNavigator.LearningNavigator.Exception.StudentDoesNotExistException;
import com.learningNavigator.LearningNavigator.Exception.SubjectDoesNotExistException;
import com.learningNavigator.LearningNavigator.Service.LearningNavigatorStudentService;

@RestController
@RequestMapping("v1")
public class LearningNavigatorStudentController {

	@Autowired
	private LearningNavigatorStudentService service;

	@GetMapping("/student")
	public List<Student> getStudents() {
		return service.getStudents();
	}

	@GetMapping("/student/{id}")
	public Student findStudentById(@PathVariable int id) throws StudentDoesNotExistException {
		return service.findStudentById(id);
	}

	@PostMapping("/student")
	public void saveStudent(@RequestBody Student student) {
		service.saveStudent(student);
	}

	@PutMapping("/student/{id}/subjects")
	public void addStudent(@RequestBody List<Integer> subjectsId, @PathVariable int id)
			throws StudentDoesNotExistException, SubjectDoesNotExistException {
		service.addSubjectToStudent(subjectsId, id);
	}

	@PutMapping("/student/{id}/exams")
	public void addExam(@RequestBody List<Integer> examsId, @PathVariable int id) throws StudentDoesNotExistException {
		System.out.println(examsId);
		service.addExamToStudent(examsId, id);
	}

}
