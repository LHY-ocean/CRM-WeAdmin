package serviceImpl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CustomerDao;
import model.Customer;
import service.BasicService;
import service.CustomerService;
import utils.ReturnInfo;

@Service
public class BasicServiceImpl<T> implements BasicService<T>   {

	protected Object execDao(String mname, Object... objs) {
		try {
			Field f = this.getClass().getDeclaredField("dao");
			f.setAccessible(true);
			Object dao = f.get(this);
			Class cls = dao.getClass();
			Class[] cs = new Class[objs.length];
			for(int i=0; i<objs.length; i++)
				cs[i] = objs[i].getClass();
			Method m = cls.getMethod(mname, cs);
			m.setAccessible(true);
			return m.invoke(dao, objs);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage = page != null;
		ReturnInfo info = new ReturnInfo();
		String limit = ReturnInfo.getLimit(page,max);
		Object o = execDao("getWhere",where, limit);
		if(o!=null)
			info.setList((List) o);
		if (canpage) {
			Object obj = execDao("getSize",where);
			if(obj!=null)
				info.setCount((Integer)obj);
		}
		return info;
	}
	
	public T selectById(Integer id) {
		Object o = execDao("selectById", id);
		if(o!=null)
			return (T)o;
		else
			return null;
	}
	
	public Integer delete(Integer id) {
		Object o = execDao("delete", id);
		if(o!=null)
			return (Integer)o;
		else
			return null;
	}

	public Integer insert(T c) {
		Object o = execDao("insert", c);
		if(o!=null)
			return (Integer)o;
		else
			return null;
	}

	public Integer update(T c) {
		Object o = execDao("update", c);
		if(o!=null)
			return (Integer)o;
		else
			return null;
	}

	


	

}
