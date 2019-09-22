package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.OrderDetails;

@Repository
public interface OrderDetailsDao {
	
	@Select("select count(*) from  C_orderdetails   ${where}")
	public int getSize(@Param("where")String where);

	@Select("select C_orderdetails.* from  C_orderdetails   ${where} ")
	public List<OrderDetails> getWhere(@Param("where")String where);

	@Select("select C_orderdetails.* from  C_orderdetails ")
	public List<OrderDetails> getAll();

	@Select("select C_orderdetails.* from C_orderdetails  where id=#{id}")
	public OrderDetails getByid(int id);

	@Delete("delete from C_orderdetails where id=#{id}")
	public int delete(int id);

	@Insert("insert into C_orderdetails (orderid,productid,count,amount,desc,comments) values(#{orderid},#{productid},#{count},#{amount},#{desc},#{comments})")
	public Integer insert(OrderDetails t);

	@Update("update C_orderdetails set orderid=#{orderid},productid=#{productid},count=#{count},amount=#{amount},desc=#{desc},comments=#{comments} where id=#{id}")
	public Integer update(OrderDetails t);

}
