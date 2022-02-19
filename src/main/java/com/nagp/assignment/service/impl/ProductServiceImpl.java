package com.nagp.assignment.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagp.assignment.dto.ProductDTO;
import com.nagp.assignment.entities.Product;
import com.nagp.assignment.repository.ProductRepo;
import com.nagp.assignment.service.IProductService;

/**
 * The Class ProductServiceImpl.
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

	/** The product repo. */
	@Autowired
	private ProductRepo productRepo;

	/**
	 * Save.
	 *
	 * @param productDTO the product DTO
	 */
	@Override
	public void save(ProductDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setLabel(productDTO.getLabel());
		product.setPrice(productDTO.getPrice());
		product.setQuantity(productDTO.getQuantity());
		product.setCategory(productDTO.getCategory());
		product.setDescription(productDTO.getDescription());
		productRepo.save(product);
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the product DTO
	 */
	@Override
	public ProductDTO findById(Long id) {
		ProductDTO productDTO = null;
		Optional<Product> prodOptional = productRepo.findById(id);
		if (prodOptional.isPresent()) {
			productDTO = new ProductDTO();
			BeanUtils.copyProperties(prodOptional.get(), productDTO);
		}
		return productDTO;
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@Override
	public List<ProductDTO> findAll() {
		List<Product> products = productRepo.findAll();
		List<ProductDTO> productDTOs = new ArrayList<>(products.size());
		products.stream().forEach(e -> productDTOs.add(new ProductDTO(e.getId(), e.getName(), e.getPrice(),
				e.getDescription(), e.getQuantity(), e.getLabel(), e.getCategory()))

		);
		return productDTOs;
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	@Override
	public void delete(Long id) {
		productRepo.deleteById(id);
	}

	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the product DTO
	 */
	@Override
	public ProductDTO findByName(String name) {
		ProductDTO productDTO = null;
		Optional<Product> prodOptional = productRepo.findByName(name);
		if (prodOptional.isPresent()) {
			productDTO = new ProductDTO();
			BeanUtils.copyProperties(prodOptional.get(), productDTO);
		}
		return productDTO;
	}

	/**
	 * Update.
	 *
	 * @param productDTO the product DTO
	 */
	@Override
	public void update(ProductDTO productDTO) {
		Optional<Product> prodOptional = productRepo.findById(productDTO.getId());
		Product product = prodOptional.get();
		product.setName(productDTO.getName());
		product.setLabel(productDTO.getLabel());
		product.setPrice(productDTO.getPrice());
		product.setQuantity(productDTO.getQuantity());
		product.setCategory(productDTO.getCategory());
		product.setDescription(productDTO.getDescription());
		productRepo.save(product);
	}

}
