package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import model.Product;

@Repository
public interface ProductDao {
	
	@Select("select * from product")
	public List<Product> select();
}
