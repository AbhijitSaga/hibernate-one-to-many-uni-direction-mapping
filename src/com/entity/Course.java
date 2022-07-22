package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Table(name = "course")
@Entity(name = "theCourse")
public class Course {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int courseId;

@Column(name = "title")
private String CourseName;
@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY )
@JoinColumn(name = "course_id",referencedColumnName = "courseId")
private List<Review> reviews;


public int getCourseId() {
	return courseId;
}
public void setCourseId(int courseId) {
	this.courseId = courseId;
}
public String getCourseName() {
	return CourseName;
}
public void setCourseName(String courseName) {
	CourseName = courseName;
}
public List<Review> getReviews() {
	return reviews;
}
public void setReviews(List<Review> reviews) {
	this.reviews = reviews;
}

//add a convenience method

public void addReviews(Review myReview) {
	if (reviews ==null) {
		reviews= new ArrayList<>();
	}
	reviews.add(myReview);
}


@Override
public String toString() {
	return "Course [id=" + courseId + ", CourseName=" + CourseName + "]";
}
	


}
