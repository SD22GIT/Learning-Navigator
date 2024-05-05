package com.learningNavigator.LearningNavigator.Entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = "query_get_all_subjects", query = "select s from Subject s")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String subject;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "subjects")
	private Set<Student> students = new HashSet<Student>();

	public Subject() {
		super();
	}

	public Subject(String subject) {
		super();
		this.subject = subject;
	}

	public int getId() {
		return id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", subject=" + subject + "]";
	}

}
