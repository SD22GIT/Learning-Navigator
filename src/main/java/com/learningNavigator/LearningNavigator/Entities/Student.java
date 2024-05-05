package com.learningNavigator.LearningNavigator.Entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = "query_get_all_students", query = "select s from Student s")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@ManyToMany(fetch = FetchType.LAZY)
	Set<Subject> subjects = new HashSet<Subject>();

	@ManyToMany(fetch = FetchType.LAZY)
	Set<Exam> exams = new HashSet<Exam>();

	public Student() {
		super();
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void addSubject(Subject subject) {
		this.subjects.add(subject);
	}

	public Set<Exam> getExams() {
		return exams;
	}

	public void addExam(Exam exam) {
		this.exams.add(exam);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}
