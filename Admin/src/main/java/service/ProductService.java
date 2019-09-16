package service;

import java.util.List;

import model.Product;
import utils.ReturnInfo;

public interface ProductService {
	
	public int getSize(String where);

	public ReturnInfo getWhere(String where, Integer page, Integer limit);

	public List<Product> getAll();

	public Product getById(int id);

	public int delete(int id);

	public Integer insert(Product p);

	public Integer update(Product p);
}
