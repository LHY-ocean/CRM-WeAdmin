package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public interface UserDao {
	
	@Select("select count(1) from  Crm_user inner join Crm_user_position on Crm_user.posid = Crm_user_position.id   ${where}")
	public Integer getSize(@Param("where")String where);

	@Select("select Crm_user.* ,Crm_user_position.posname posname from  Crm_user inner join Crm_user_position on Crm_user.posid = Crm_user_position.id   ${where} order by id ${limit}")
	public  List<User> getWhere(@Param("where")String where, @Param(value = "limit") String limit);

	@Select("select Crm_user.* from  Crm_user ")
	public  List<User> getAll();

	@Select("select Crm_user.*  from  Crm_user where Crm_user.id=${id}")
	public  User selectById(@Param("id")Integer id);
	
	@Select("select Crm_user.* from Crm_user where username=#{username} and userpwd=#{userpwd}")
	public User selectUser(User u);

	@Delete("delete from Crm_user where id=${id}")
	public int delete(@Param("id")Integer id);

	@Insert("insert into Crm_user (username,userpwd,usersex,userphone,posid) values(#{username},#{userpwd},#{usersex},#{userphone},#{posid})")
	public Integer insert(User u);

	@Update("update Crm_user set username=#{username},userpwd=#{userpwd},usersex=#{usersex},userphone=#{userphone},posid=#{posid} where id=#{id}")
	public Integer update(User u);

	


}
