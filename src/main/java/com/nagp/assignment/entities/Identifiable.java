package com.nagp.assignment.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

/**
 * Denotes an entity to be identifiable
 *
 * @author nkhan
 * @version 1.0.0
 */
@Getter
@Setter
@MappedSuperclass
public class Identifiable implements Serializable {

	/**
	 * Serial Id
	 */
	private static final long serialVersionUID = -1931592129893859702L;
	
	/**
	 * Primary key of the table
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


}
