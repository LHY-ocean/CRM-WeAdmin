package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Position;

@Repository
public interface PositionDao {
	
	@Select("select count(1) from  Crm_user_position   ${where}")
	public Integer getSize(@Param("where")String where);

	@Select("select Crm_user_position.* from  Crm_user_position   ${where} order by id ${limit}")
	public  List<Position> getWhere(@Param("where")String where, @Param(value = "limit") String limit);

	@Select("select * from Crm_user_position")
	public List<Position> select();
	
	@Select("select Crm_user_position.* from Crm_user_position  where id=${id}")
	public  Position selectById(@Param("id")Integer id);

	@Delete("delete from Crm_user_position where id=${id}")
	public Integer delete(@Param("id")Integer id);

	@Insert("insert into Crm_user_position (posname) values(#{posname})")
	public Integer insert(Position u);

	@Update("update Crm_user_position set posname=#{posname} where id=#{id}")
	public Integer update(Position u);

	

}
