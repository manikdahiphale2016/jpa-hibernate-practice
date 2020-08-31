package com.manikit.jpa.hibernate.jpahibernate.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQueries (value = {
	@NamedQuery(name = "query_get_all_courses",query = "Select c From Course c"),
	@NamedQuery(name = "query_get_all_like_action",query = " Select c From Course c where name like'%Action' ")
})
//@NamedQuery(name = "query_get_all_courses",query = "Select c From Course c")
//@NamedQuery(name = "query_get_all_like_action",query = " Select c From Course c where name like'%Action' ")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;

	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	protected Course() { }
	
	public Course(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Course [%s]", name);
	}
	
	
	
	
}
