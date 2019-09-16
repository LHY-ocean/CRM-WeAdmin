package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.WorkGroup;

@Repository
public interface WorkGroupDao {
	
	@Select("select count(*) from  C_workgroup   ${where}")
	public int getSize(@Param("where")String where);

	@Select("select C_workgroup.* from  C_workgroup   ${where}  ${limit}")
	public List<WorkGroup> getWhere(@Param("where")String where, @Param(value = "limit") String limit);

	@Select("select C_workgroup.* from  C_workgroup ")
	public List<WorkGroup> getAll();

	@Select("select C_workgroup.* from C_workgroup  where id=#{id}")
	public WorkGroup getById(int id);

	@Delete("delete from C_workgroup where id=#{id}")
	public int delete(int id);

	@Insert("insert into C_workgroup (name) values(#{name})")
	public Integer insert(WorkGroup w);

	@Update("update C_workgroup set name=#{name} where id=#{id}")
	public Integer update(WorkGroup w);

}
