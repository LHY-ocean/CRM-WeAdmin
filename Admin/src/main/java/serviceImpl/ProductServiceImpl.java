package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductDao;
import model.Product;
import service.ProductService;

@Service
public class ProductServiceImpl extends BasicServiceImpl<Product> implements ProductService {

	@Autowired
	ProductDao dao;
	
	
	public List<Product> selectAll() {
		return dao.select();
	}

}
