package com.quizProject.quizzapp.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {
	@Id
	@Column(name = "question_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String type;
	private String level;
	@Column(name = "option_1")
	private String option1;
	@Column(name = "option_2")
	private String option2;
	@Column(name = "option_3")
	private String option3;
	@Column(name = "option_4")
	private String option4;
	private String question;
	private String correctOption;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getCorrectOption() {
		return correctOption;
	}
	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}
	@Override
	public int hashCode() {
		return Objects.hash(correctOption, level, option1, option2, option3, option4, question, id, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return Objects.equals(correctOption, other.correctOption) && Objects.equals(level, other.level)
				&& Objects.equals(option1, other.option1) && Objects.equals(option2, other.option2)
				&& Objects.equals(option3, other.option3) && Objects.equals(option4, other.option4)
				&& Objects.equals(question, other.question) && Objects.equals(id, other.id)
				&& Objects.equals(type, other.type);
	}
	@Override
	public String toString() {
		return "Question [questionNumber=" + id + ", type=" + type + ", level=" + level + ", option1="
				+ option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4 + ", question="
				+ question + ", correctOption=" + correctOption + "]";
	}	
	
	
}
