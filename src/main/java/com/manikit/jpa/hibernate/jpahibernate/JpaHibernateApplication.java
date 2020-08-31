package com.manikit.jpa.hibernate.jpahibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.manikit.jpa.hibernate.jpahibernate.entity.Course;
import com.manikit.jpa.hibernate.jpahibernate.repository.CourseRepository;

@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * Course course = courseRepository.findById(10001L);
		 * 
		 * logger.info("Course -> {} ",course);
		 * 
		 * courseRepository.save(new Course("SpringMicroservices in 100 steps"));
		 */
		//courseRepository.deleteById(10002L);
	}

}
