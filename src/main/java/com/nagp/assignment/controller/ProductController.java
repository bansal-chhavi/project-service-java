package com.nagp.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.assignment.dto.ProductDTO;
import com.nagp.assignment.exception.ErrorObject;
import com.nagp.assignment.service.IProductService;
import com.nagp.assignment.util.ValidationUtil;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService iProductService;

	@GetMapping
	public ResponseEntity<List<ProductDTO>> all() {
		return ResponseEntity.ok(iProductService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> byId(@PathVariable(value = "id") Long id) {
		try {
			ProductDTO productDTO = iProductService.findById(id);
			if (productDTO != null) {
				return ResponseEntity.ok(productDTO);
			} else {
				return notFound();
			}

		} catch (Exception exp) {
			return badRequest(exp);
		}
	}
    
	@PostMapping()
	public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) {
		try {
			ValidationUtil.assertValid(productDTO.getName(), "Product name is mandatory");
			ValidationUtil.assertValid(productDTO.getLabel(), "Product label is mandatory");
			ValidationUtil.assertValid(productDTO.getCategory(), "Product category is mandatory");
			ValidationUtil.assertNumGtZero(productDTO.getQuantity(), "Product quantity should be greater than zero");
			ValidationUtil.assertNumGtZero(productDTO.getPrice(), "Product price should be greater than zero");

			ProductDTO dto = iProductService.findByName(productDTO.getName());
			if (dto != null) {
				return conflict();
			} else {
				iProductService.save(productDTO);
				return ResponseEntity.ok("Product saved successfuly with name :  " + productDTO.getName());
			}
		} catch (Exception exp) {
			return badRequest(exp);
		}
	}

	@PutMapping()
	public ResponseEntity<?> update(@RequestBody ProductDTO productDTO) {
		try {
			ProductDTO dto = iProductService.findById(productDTO.getId());
			if (dto != null) {
				iProductService.update(productDTO);
				return ResponseEntity.ok("Updated successfully product with name " + productDTO.getName());
			} else {
				return notFound();
			}
		} catch (Exception exp) {
			return badRequest(exp);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		try {
			ProductDTO productDTO = iProductService.findById(id);
			if (productDTO != null) {
				iProductService.delete(id);
				return ResponseEntity.ok("Deleted successfully product with id " + id);
			} else {
				return notFound();
			}

		} catch (Exception exp) {
			return badRequest(exp);
		}
	}

	private ResponseEntity<?> notFound() {
		return new ResponseEntity<>(new ErrorObject(HttpStatus.NOT_FOUND.toString(), "Product not found"),
				HttpStatus.NOT_FOUND);
	}

	private ResponseEntity<?> badRequest(Throwable throwable) {
		return new ResponseEntity<>(new ErrorObject(HttpStatus.BAD_REQUEST.toString(), "Bad request"),
				HttpStatus.BAD_REQUEST);
	}

	private ResponseEntity<?> conflict() {
		return new ResponseEntity<>(new ErrorObject(HttpStatus.CONFLICT.toString(), "Product already exists"),
				HttpStatus.CONFLICT);
	}

}
