package com.nagp.assignment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class Product.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product extends Auditable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7712599575280758238L;

	/** The name. */
	@Column(nullable = false)
	private String name;

	/** The price. */
	@Column(nullable = false)
	private Long price;

	/** The description. */
	private String description;

	/** The quantity. */
	@Column(nullable = false)
	private Long quantity;

	/** The label. */
	@Column(nullable = false)
	private String label;

	/** The category. */
	@Column(nullable = false)
	private String category;

}
