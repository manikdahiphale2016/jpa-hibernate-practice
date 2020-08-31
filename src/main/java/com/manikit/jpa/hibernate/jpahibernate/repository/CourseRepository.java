package com.manikit.jpa.hibernate.jpahibernate.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manikit.jpa.hibernate.jpahibernate.entity.Course;

@Repository
@Transactional
public class CourseRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	public Course save(Course course) {
		if(course.getId()==null) {
			// insert
			em.persist(course);
		}else {
			//update
			em.merge(course);
		}
		
		return course;
	}
	
	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}
	
	public void playWithEntityManager() {
		//logger.info("playWithEntityManager - start");
		Course course1 = new Course("SpringBoot Microservices in Action");
		em.persist(course1);
		em.flush();
		
		Course course2 = findById(10001L);
		course2.setName("Hibernate-with-Jpa - updated");
		
		/*
		 * course1.setName("SpringBoot Microservices in Action - updated"); em.flush();
		 * 
		 * Course course2 = new Course("ReactJS in Action"); em.persist(course2);
		 * em.flush(); //em.detach(course2); //em.clear()
		
		
		course2.setName("ReactJS in Action updated");
		em.flush();
		 */		
		
		
	}
}
