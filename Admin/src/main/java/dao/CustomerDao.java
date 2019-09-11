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
	
	@Select("select count(1) from  Crm_customer Crm_customer inner join Crm_customer_level on Crm_customer.cuslevelid=Crm_customer_level.id inner join Crm_user on Crm_customer.userid = Crm_user.id   ${where}")
	public Integer getSize(@Param("where")String where);

	@Select("select Crm_customer.*,Crm_customer_level.levelname levelname,Crm_user.username username from  Crm_customer inner join Crm_customer_level on Crm_customer.cuslevelid=Crm_customer_level.id inner join Crm_user on Crm_customer.userid = Crm_user.id   ${where}  ${limit}")
	public  List<Customer> getWhere(@Param("where")String where, @Param(value = "limit") String limit);

	@Select("select Crm_customer.* from  Crm_customer ")
	public  List<Customer> getAll();

	@Select("select Crm_customer.* from Crm_customer   where id=#{id}")
	public  Customer selectById(@Param("id")Integer id);

	@Delete("delete from Crm_customer where id=#{id}")
	public Integer delete(@Param("id")Integer id);

	@Insert("insert into Crm_customer (cusname,cuslevelid,cuscredit,cuspleased,cusarea,cusaddress,cusphone,userid) values(#{cusname},#{cuslevelid},#{cuscredit},#{cuspleased},#{cusarea},#{cusaddress},#{cusphone},#{userid})")
	public Integer insert(Customer t);

	@Update("update Crm_customer set cusname=#{cusname},cuslevelid=#{cuslevelid},cuscredit=#{cuscredit},cuspleased=#{cuspleased},cusarea=#{cusarea},cusaddress=#{cusaddress},cusphone=#{cusphone},userid=#{userid} where id=#{id}")
	public Integer update(Customer t);

}
