package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Course;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.mySessionFectory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			// get course and associated with review
			int courseId = 15;
			Course theCourse = session.get(Course.class, courseId);
			// print the course
			System.out.println("theCourse: " + theCourse);

			// print the reviews
			System.out.println("the course reviews: " + theCourse.getReviews());
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}
}
