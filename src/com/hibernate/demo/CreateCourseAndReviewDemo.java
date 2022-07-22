package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Course;
import com.entity.Review;

public class CreateCourseAndReviewDemo {
public static void main(String[] args) {
	//get sessionFectory from HibernateUtil class
	SessionFactory sessionFactory=HibernateUtil.mySessionFectory();
	
	//create session from sessionFectory
	Session session=sessionFactory.openSession();
	
	try {
		//start transaction
		session.beginTransaction();
		//create course
		Course tempCourse=new Course();
		tempCourse.setCourseName(" Data Science course - HOW To Score one to million points");
		
		//add some reviews
		tempCourse.addReviews(new Review("Great course...loved it"));
		tempCourse.addReviews(new Review("greate  concept  is there"));
		tempCourse.addReviews(new Review("Super course"));
		tempCourse.addReviews(new Review("nice course"));
		
		
		//save the course...and leverage the cascade all
		System.out.println("saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		session.save(tempCourse);
		
		//commit transaction
		session.getTransaction().commit();
		
	} finally {

		session.close();
	}
}
}
