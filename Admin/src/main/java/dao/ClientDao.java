package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Client;

@Repository
public interface ClientDao {

	@Select("select count(1) from  C_client   ${where}")
	public int getSize(@Param("where") String where);

	@Select("select c_client.*, c_clienttype.`name` clienttypename, c_src.`name` srcname,c_operator.`name` operatorname FROM c_client  INNER JOIN c_clienttype 	ON c_client.clienttypeid = c_clienttype.id  INNER JOIN c_src 	ON c_client.srcid = c_src.id  INNER JOIN c_operator 	ON c_client.createoperatorid = c_operator.id    ${where}  ${limit}")
	public List<Client> getWhere(@Param("where") String where, @Param(value = "limit") String limit);

	@Select("select C_client.* from  C_client ")
	public List<Client> getAll();

	@Select("select C_client.*,GROUP_CONCAT(o.name)as operatornames  from C_client LEFT JOIN c_operator o	ON FIND_IN_SET(o.id , c_client.operatorids)  where C_client.id=#{id} GROUP BY c_client.id")
	public Client getById(int id);

	@Delete("delete from C_client where id=#{id}")
	public int delete(int id);

	@Insert("insert into C_client (name,sex,tel,qq,email,infos,linkstatus,clientstatus,purposestatus,assessstatus,execstatus,status,clienttypeid,operatorids,createoperatorid,createdate,srcid,count,comments) values(#{name},#{sex},#{tel},#{qq},#{email},#{infos},#{linkstatus},#{clientstatus},#{purposestatus},#{assessstatus},#{execstatus},#{status},#{clienttypeid},#{operatorids},#{createoperatorid},#{createdate},#{srcid},#{count},#{comments})")
	public Integer insert(Client c);

	@Update("update C_client set name=#{name},sex=#{sex},tel=#{tel},qq=#{qq},email=#{email},infos=#{infos},linkstatus=#{linkstatus},clientstatus=#{clientstatus},purposestatus=#{purposestatus},assessstatus=#{assessstatus},execstatus=#{execstatus},status=#{status},clienttypeid=#{clienttypeid},operatorids=#{operatorids},createoperatorid=#{createoperatorid},createdate=#{createdate},srcid=#{srcid},count=#{count},comments=#{comments} where id=#{id}")
	public Integer update(Client c);

	@Update("update C_client set operatorids=#{operatorids} where id = #{id}")
	public Integer updateOpids(Client c);
	
	@Update("update C_client set count=count+1 where id = #{id}")
	public Integer updateCount(Client c);

}
