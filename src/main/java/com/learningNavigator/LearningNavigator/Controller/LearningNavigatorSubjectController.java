package com.learningNavigator.LearningNavigator.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningNavigator.LearningNavigator.Entities.Subject;
import com.learningNavigator.LearningNavigator.Exception.SubjectDoesNotExistException;
import com.learningNavigator.LearningNavigator.Service.LearningNavigatorSubjectService;

@RestController
@RequestMapping("v1")
public class LearningNavigatorSubjectController {

	@Autowired
	private LearningNavigatorSubjectService service;

	@GetMapping("/subject")
	public List<Subject> getSubjects() {
		return service.getSubjects();
	}

	@GetMapping("/subject/{id}")
	public Subject findSubjectById(@PathVariable int id) throws SubjectDoesNotExistException {
		return service.findSubjectById(id);
	}

	@PostMapping("/subject")
	public void addSubject(@RequestBody Subject subject) {
		service.saveSubject(subject);
	}

}
