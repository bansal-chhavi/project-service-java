package com.nagp.assignment.service;

import java.util.List;

import com.nagp.assignment.dto.ProductDTO;

/**
 * The Interface IProductService.
 */
public interface IProductService {

	/**
	 * Save.
	 *
	 * @param productDTO the product DTO
	 */
	public void save(ProductDTO productDTO);

	/**
	 * Update.
	 *
	 * @param productDTO the product DTO
	 */
	public void update(ProductDTO productDTO);

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	public void delete(Long id);

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<ProductDTO> findAll();

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the product DTO
	 */
	public ProductDTO findById(Long id);

	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the product DTO
	 */
	public ProductDTO findByName(String name);

}
