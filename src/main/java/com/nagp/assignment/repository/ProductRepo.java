package com.nagp.assignment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagp.assignment.entities.Product;

/**
 * The Interface ProductRepo.
 */
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the optional
	 */
	Optional<Product> findByName(String name);

}
