package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductDao;
import model.Product;
import service.ProductService;
import utils.ReturnInfo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao dao;
	
	public int getSize(String where) {
		return dao.getSize(where);
	}

	public ReturnInfo getWhere(String where, Integer page, Integer limit) {
		boolean canpage = page != null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.getWhere(where, ReturnInfo.getLimit(page,limit)));
		if (canpage) {
			info.setCount(dao.getSize(where));
		}
		return info;
	}

	public List<Product> getAll() {
		return dao.getAll();
	}

	public Product getById(int id) {
		return dao.getById(id);
	}

	public int delete(int id) {
		return dao.delete(id);
	}

	public Integer insert(Product p) {
		return dao.insert(p);
	}

	public Integer update(Product p) {
		return dao.update(p);
	}

}
