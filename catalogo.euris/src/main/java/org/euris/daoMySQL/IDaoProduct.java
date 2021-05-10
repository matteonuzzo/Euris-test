package org.euris.daoMySQL;

import java.util.List;

import org.euris.model.Product;

public interface IDaoProduct {
	
	List<Product> products();
	
	Product product(int id);
	
	void add(Product product);
	
	void delete(int id);
	
	void edit(Product product);
	
	public String operation (String operation);
	
}
