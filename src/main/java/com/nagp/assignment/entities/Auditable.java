package com.nagp.assignment.entities;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Auditable.
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable extends Identifiable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Created UNIX time. */
	@CreatedDate
	@Column(name = "created_at", updatable = false)
	private Long createdAt;

	/** Updated UNIX time. */
	@LastModifiedDate
	private Long updatedAt;

	/** The created by. */
	@CreatedBy
	@Column(name = "created_by", updatable = false)
	private String createdBy;

	/** The last modified by. */
	@LastModifiedBy
	private String lastModifiedBy;
}
