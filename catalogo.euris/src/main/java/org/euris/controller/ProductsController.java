package org.euris.controller;

import java.util.List;

import org.euris.daoMySQL.IDaoProduct;
import org.euris.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	public IDaoProduct dao;
	
	@GetMapping
	public List<Product> get() {
		return dao.products();
	}
	
	@GetMapping("/{id}")
	public Product getOne(@PathVariable int id) {
		return dao.product(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		dao.delete(id);
	}
	
	@PostMapping
	public void add(@RequestBody Product product) {
		dao.add(product);
	}
	
	@PutMapping("/{id}")
	public void put(@RequestBody Product product) {
		dao.edit(product);
	}
	
}
