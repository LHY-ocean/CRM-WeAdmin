package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Level;

@Repository
public interface LevelDao {
	
	@Select("select count(1) from  Crm_customer_level   ${where}")
	public Integer getSize(@Param("where")String where);

	@Select("select Crm_customer_level.* from  Crm_customer_level   ${where}  ${limit}")
	public  List<Level> getWhere(@Param("where")String where, @Param(value = "limit") String limit);

	@Select("select Crm_customer_level.* from  Crm_customer_level ")
	public  List<Level> getAll();

	@Select("select Crm_customer_level.* from Crm_customer_level  where id=#{id}")
	public  Level selectById(@Param("id")Integer id);

	@Delete("delete from Crm_customer_level where id=#{id}")
	public Integer delete(@Param("id")Integer id);

	@Insert("insert into Crm_customer_level (levelname) values(#{levelname})")
	public Integer insert(Level t);

	@Update("update Crm_customer_level set levelname=#{levelname} where id=#{id}")
	public Integer update(Level t);

}	
