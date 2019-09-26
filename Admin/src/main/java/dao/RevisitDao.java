package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Revisit;

@Repository
public interface RevisitDao {

	@Select("select count(*) from  C_revisit   ${where}")
	public int getSize(@Param("where") String where);

	@Select("select C_revisit.*,C_client.name clientname,C_operator.id operatorid from  C_revisit inner join C_client on C_revisit.clientid = C_client.id inner join C_operator on C_revisit.operatorid = C_operator.id  ${where}  ${limit}")
	public List<Revisit> getWhere(@Param("where") String where, @Param("limit") String limit);

	@Select("select C_revisit.* from  C_revisit ")
	public List<Revisit> getAll();

	@Select("select C_revisit.* from C_revisit  where id=#{id}")
	public Revisit getById(int id);

	@Delete("delete from C_revisit where id=#{id}")
	public int delete(int id);

	@Insert("insert into C_revisit (clientid,operatorid,linkstatus,clientstatus,purposestatus,assessstatus,execstatus,askinfo,followinfo,probleminfo,status,comments) values(#{clientid},#{operatorid},#{linkstatus},#{clientstatus},#{purposestatus},#{assessstatus},#{execstatus},#{askinfo},#{followinfo},#{probleminfo},#{status},#{comments})")
	public Integer insert(Revisit r);

	@Update("update C_revisit set clientid=#{clientid},operatorid=#{operatorid},linkstatus=#{linkstatus},clientstatus=#{clientstatus},purposestatus=#{purposestatus},assessstatus=#{assessstatus},execstatus=#{execstatus},askinfo=#{askinfo},followinfo=#{followinfo},probleminfo=#{probleminfo},status=#{status},comments=#{comments} where id=#{id}")
	public Integer update(Revisit r);

}
