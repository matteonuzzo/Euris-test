package org.euris.model;

import org.euris.util.IMappablePro;

public class Product implements IMappablePro{
	
	private int id;
	private String nameProduct;
	private String price;
	
	public Product(int id, String nameProduct, String price) {
		super();
		this.id = id;
		this.nameProduct = nameProduct;
		this.price = price;
	}

	public Product() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "{id:" + id + ", nameProduct:" + nameProduct + ", price:" + price + "}";
	}
	
}
