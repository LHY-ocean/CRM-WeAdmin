package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.WorkGroupDao;
import model.WorkGroup;
import service.WorkGroupService;
import utils.ReturnInfo;

@Service
public class WorkGroupServiceImpl implements WorkGroupService {

	@Autowired
	WorkGroupDao dao;
	
	public int getSize(String where) {
		return dao.getSize(where);
	}

	public ReturnInfo getWhere(String where, Integer page, Integer limit) {
		boolean canpage = page != null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.getWhere(where, ReturnInfo.getLimit(page,limit)));
		if (canpage) {
			info.setCount(dao.getSize(where));
		}
		return info;
	}

	public List<WorkGroup> getAll() {
		return dao.getAll();
	}

	public WorkGroup getById(int id) {
		return dao.getById(id);
	}

	public int delete(int id) {
		return dao.delete(id);
	}

	public Integer insert(WorkGroup w) {
		return dao.insert(w);
	}

	public Integer update(WorkGroup w) {
		return dao.update(w);
	}

}
