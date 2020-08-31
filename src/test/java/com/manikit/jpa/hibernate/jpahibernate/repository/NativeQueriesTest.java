package com.manikit.jpa.hibernate.jpahibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.manikit.jpa.hibernate.jpahibernate.JpaHibernateApplication;
import com.manikit.jpa.hibernate.jpahibernate.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =JpaHibernateApplication.class)
class NativeQueriesTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	@Test
	public void native_queries_basic() {
		Query query = em.createNativeQuery("SELECT * FROM COURSE",Course.class);
		List resultList = query.getResultList();

		logger.info("SELECT * FROM COURSE -> {} ", resultList);		
	}
	
	@Test
	public void native_queries_with_parameter() {
		Query query = em.createNativeQuery("SELECT * FROM COURSE WHERE id = ?",Course.class);
		query.setParameter(1, 10001L);
		List resultList = query.getResultList();

		logger.info("SELECT * FROM COURSE where id=? -> {} ", resultList);		
	}
	
	@Test
	public void native_queries_with_named_parameter() {
		Query query = em.createNativeQuery("SELECT * FROM COURSE WHERE id = :id ", Course.class);
		query.setParameter("id", 10001L);
		List resultList = query.getResultList();

		logger.info("SELECT * FROM COURSE where id= :id -> {} ", resultList);		
	}
	

	@Test
	@Transactional
	public void native_queries_to_update_date() {
		Query query = em.createNativeQuery("UPDATE COURSE SET last_updated_date = sysdate()", Course.class);
		int numberOfRows = query.executeUpdate();

		logger.info("UPDATE COURSE SET last_updated_date = sysdate() -> {} ", numberOfRows);		
	}
	
}
