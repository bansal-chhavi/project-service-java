package com.nagp.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	/** The id. */
	private Long id;

	/** The name. */
	private String name;

	/** The price. */
	private Long price;

	/** The description. */
	private String description;

	/** The quantity. */
	private Long quantity;

	/** The label. */
	private String label;

	/** The category. */
	private String category;

}
