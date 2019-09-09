package service;

import java.util.List;

import model.Product;

public interface ProductService extends BasicService<Product> {

	public List<Product> selectAll();
	
}
