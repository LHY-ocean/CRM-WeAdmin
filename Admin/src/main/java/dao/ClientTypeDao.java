package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.ClientType;

@Repository
public interface ClientTypeDao {
	
	@Select("select count(1) from  C_clienttype   ${where}")
	public int getSize(@Param("where")String where);

	@Select("select C_clienttype.* from  C_clienttype   ${where}  ${limit}")
	public List<ClientType> getWhere(@Param("where")String where, @Param(value = "limit") String limit);

	@Select("select C_clienttype.* from  C_clienttype ")
	public List<ClientType> getAll();

	@Select("select C_clienttype.* from C_clienttype  where id=#{id}")
	public ClientType getById(int id);

	@Delete("delete from C_clienttype where id=#{id}")
	public int delete(int id);

	@Insert("insert into C_clienttype (name) values(#{name})")
	public Integer insert(ClientType c);

	@Update("update C_clienttype set name=#{name} where id=#{id}")
	public Integer update(ClientType c);

}
