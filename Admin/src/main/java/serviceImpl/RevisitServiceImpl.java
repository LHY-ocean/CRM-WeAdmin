package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RevisitDao;
import model.Revisit;
import service.RevisitService;
import utils.ReturnInfo;

@Service
public class RevisitServiceImpl implements RevisitService {

	@Autowired
	RevisitDao dao;
	
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

	public List<Revisit> getAll() {
		return dao.getAll();
	}

	public Revisit getById(int id) {
		return dao.getById(id);
	}

	public int delete(int id) {
		return dao.delete(id);
	}

	public Integer insert(Revisit r) {
		return dao.insert(r);
	}

	public Integer update(Revisit r) {
		return dao.update(r);
	}

}
