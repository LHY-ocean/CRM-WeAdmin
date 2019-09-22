package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Order;

@Repository
public interface OrderDao {
	@Select("select count(*) from  C_order   ${where}")
	public int getSize(@Param("where")String where);

	@Select("select c_order.* ,c_client.`name` clientname,c_operator.name operatorname from c_order INNER JOIN c_client on c_order.clientid = c_client.id inner join c_operator on c_order.operatorid = c_operator.id   ${where}  ${limit}")
	public List<Order> getWhere(@Param("where") String where, @Param(value = "limit") String limit);

	@Select("select C_order.* from  C_order ")
	public List<Order> getAll();

	@Select("select C_order.* from C_order  where id=#{id}")
	public Order getById(int id);

	@Delete("delete from C_order where id=#{id}")
	public int delete(int id);

	@Insert("insert into C_order (clientid,createdate,compdate,orderdate,startdate,enddate,operatorid,info,files,compoperatorids,compweight,status,amount,comments) values(#{clientid},#{createdate},#{compdate},#{orderdate},#{startdate},#{enddate},#{operatorid},#{info},#{files},#{compoperatorids},#{compweight},#{status},#{amount},#{comments})")
	public Integer insert(Order o);

	@Update("update C_order set clientid=#{clientid},createdate=#{createdate},compdate=#{compdate},orderdate=#{orderdate},startdate=#{startdate},enddate=#{enddate},operatorid=#{operatorid},info=#{info},files=#{files},compoperatorids=#{compoperatorids},compweight=#{compweight},status=#{status},amount=#{amount},comments=#{comments} where id=#{id}")
	public Integer update(Order o);

}
