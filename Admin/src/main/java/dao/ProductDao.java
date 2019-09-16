package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Product;

@Repository
public interface ProductDao {
	
	@Select("select count(*) from  C_product   ${where}")
	public int getSize(@Param("where")String where);

	@Select("select C_product.* from  C_product   ${where}  ${limit}")
	public List<Product> getWhere(@Param("where")String where, @Param(value = "limit") String limit);

	@Select("select C_product.* from  C_product ")
	public List<Product> getAll();

	@Select("select C_product.* from C_product  where id=#{id}")
	public Product getById(int id);

	@Delete("delete from C_product where id=#{id}")
	public int delete(int id);

	@Insert("insert into C_product (name,amount,info) values(#{name},#{amount},#{info})")
	public Integer insert(Product p);

	@Update("update C_product set name=#{name},amount=#{amount},info=#{info} where id=#{id}")
	public Integer update(Product p);

}
