package com.manikit.jpa.hibernate.jpahibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.manikit.jpa.hibernate.jpahibernate.JpaHibernateApplication;
import com.manikit.jpa.hibernate.jpahibernate.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =JpaHibernateApplication.class)
class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	@Test
	public void jpql_basic() {
		Query query = em.createNamedQuery("query_get_all_courses");
		List resultList = query.getResultList();

		logger.info("Select c From Course c -> {} ", resultList);		
	}
	
	@Test
	public void jpql_Typed() {
		TypedQuery<Course> createQuery = 
				em.createNamedQuery("query_get_all_courses",Course.class);
		// 'query_get_all_courses': this is named query declare in Course Entity
		List<Course> resultList = createQuery.getResultList();

		logger.info("Select c From Course c -> {} ", resultList);		
	}
	
	@Test
	public void jpql_where() {
		TypedQuery<Course> createQuery = 
				em.createNamedQuery("query_get_all_like_action", Course.class);
		
		List<Course> resultList = createQuery.getResultList();

		logger.info("Select c From Course c where name like'%Action' -> {} ", resultList);		
	}
}
