package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Customer;

@Repository
public interface CustomerDao {
	
	@Select("select count(1) from customer inner join product on customer.pro_id = product.id ${txt}")
	public Integer getSize(@Param(value = "txt") String where);
	
	@Select("select customer.*,product.pro_no pro_no from customer inner join product on customer.pro_id = product.id ${txt} order by id ${limit}")
	public List<Customer> getWhere(@Param(value = "txt") String where, @Param(value = "limit") String limit);
	
	@Select("select customer.*,product.pro_no pro_no from customer inner join product on customer.pro_id = product.id where customer.id = ${id}")
	public Customer selectById(@Param("id")Integer id);
	
	@Delete("delete from customer where id=${id}")
	public Integer delete(@Param(value = "id")Integer id);
	
	@Insert("insert into customer(cus_no,cus_name,cus_sex,pro_id) values(#{cus_no},#{cus_name},#{cus_sex},#{pro_id})")
	public Integer insert(Customer c);
	
	@Update("update customer set cus_no=#{cus_no}, cus_name=#{cus_name},cus_sex=#{cus_sex},pro_id=#{pro_id} where id=#{id}")
	public Integer update(Customer c);
}
