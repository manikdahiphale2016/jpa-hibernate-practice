package com.manikit.jpa.hibernate.jpahibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.manikit.jpa.hibernate.jpahibernate.JpaHibernateApplication;
import com.manikit.jpa.hibernate.jpahibernate.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =JpaHibernateApplication.class)
class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Test
	public void findById_basic() {
		Course course = repository.findById(10001L);
		assertEquals("Hibernate-with-Jpa",course.getName());
		
	//	logger.info("CourseRepositoryTest is Running");
		
	}
	
	@Test
	@DirtiesContext
	public void deleteById_basic() {
		repository.deleteById(10003L);
		assertNull(repository.findById(10003L));
				
	}
	
	@Test
	@DirtiesContext
	public void save_basic() {
		// get the course
		Course course = repository.findById(10001L);
		assertEquals("Hibernate-with-Jpa",course.getName());
		// update the details
		course.setName("Hibernate-with-Jpa - updated");
		
		repository.save(course);
		
		// check the value
		Course course1 = repository.findById(10001L);
		assertEquals("Hibernate-with-Jpa - updated",course1.getName());
		
	}

}
