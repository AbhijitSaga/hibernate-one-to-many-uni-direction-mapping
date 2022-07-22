package com.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Review;

public final class HibernateUtil {

private	static SessionFactory sessionFactory=null;
public static SessionFactory mySessionFectory() {
	if(sessionFactory ==null) {
		Configuration configuration=new  Configuration();
		              configuration.configure("hibernate.cfg.xml");
		              configuration.addAnnotatedClass(Course.class);
		              configuration.addAnnotatedClass(Review.class);
		     sessionFactory=configuration.buildSessionFactory();         
	}
	return sessionFactory;
}
}
