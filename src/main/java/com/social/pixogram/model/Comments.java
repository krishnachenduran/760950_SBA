package com.social.pixogram.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table(name="comments")
@SequenceGenerator(name = "seq1", initialValue = 1, allocationSize = 100)
public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
	Integer Id;
	
	
	Integer userId;
	Integer postId;
	
	String comments;
	
}
