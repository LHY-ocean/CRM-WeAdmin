package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Src;

@Repository
public interface SrcDao {
	
	@Select("select count(*) from  C_src   ${where}")
	public int getSize(@Param("where")String where);

	@Select("select C_src.* from  C_src   ${where} ${limit}")
	public  List<Src> getWhere(@Param("where")String where,@Param("limit")String limit);

	@Select("select C_src.* from  C_src ")
	public  List<Src> getAll();

	@Select("select C_src.* from C_src  where id=#{id}")
	public  Src getById(int id);

	@Delete("delete from C_src where id=#{id}")
	public int delete(int id);

	 @Insert("insert into C_src (name) values(#{name})")
	 public Integer insert(Src s);

	 @Update("update C_src set name=#{name} where id=#{id}")
	 public Integer update(Src s);

}
