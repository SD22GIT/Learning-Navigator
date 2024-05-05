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
import jakarta.persistence.OneToOne;

@Entity
@NamedQuery(name = "query_get_all_exams", query = "select e from Exam e")
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String examName;

	@OneToOne
	private Subject subject;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "exams")
	private Set<Student> students = new HashSet<Student>();

	public Exam() {
		super();
	}

	public Exam(Subject subject) {
		super();
		this.subject = subject;
	}

	public int getId() {
		return id;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", examName=" + examName + ", subject=" + subject + "]";
	}

}
