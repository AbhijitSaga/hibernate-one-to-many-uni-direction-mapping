package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Course;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.mySessionFectory();
		Session session = sessionFactory.openSession();
		try {
			// transaction start
			session.beginTransaction();

			// get the course and reviews by courseId
			int theCourseId = 17;
			Course theCourse = session.get(Course.class, theCourseId);
			System.out.println("Course : " + theCourse);
			//System.out.println("Reviews: " + theCourse.getReviews());

			// delete the course and related reviews
			session.delete(theCourse);

			// session commit
			session.getTransaction().commit();
		} finally {
			session.close();
		}

	}
}
