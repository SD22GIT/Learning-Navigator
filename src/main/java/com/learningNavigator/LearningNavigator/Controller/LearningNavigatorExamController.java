package com.learningNavigator.LearningNavigator.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learningNavigator.LearningNavigator.Entities.Exam;
import com.learningNavigator.LearningNavigator.Exception.SubjectDoesNotExistException;
import com.learningNavigator.LearningNavigator.Service.LearningNavigatorExamService;

@RestController
@RequestMapping("v1")
public class LearningNavigatorExamController {

	@Autowired
	private LearningNavigatorExamService service;

	@GetMapping("/exam")
	public List<Exam> getExams() {
		return service.getExams();
	}

	@GetMapping("/exam/{id}")
	public Exam findExamById(@PathVariable int id) {
		return service.findExamById(id);

	}

	@PostMapping("/exam")
	public void addExamForSubject(@RequestParam(name = "subjectId") int subjectId, @RequestBody Exam exam)
			throws SubjectDoesNotExistException {
		service.saveExam(subjectId, exam);
	}

}
