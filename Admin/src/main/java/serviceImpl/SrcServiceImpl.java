package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.SrcDao;
import model.Src;
import service.SrcService;
import utils.ReturnInfo;

@Service
public class SrcServiceImpl implements SrcService {

	@Autowired
	SrcDao dao;
	
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

	public List<Src> getAll() {
		return dao.getAll();
	}

	public Src getById(int id) {
		return dao.getById(id);
	}

	public int delete(int id) {
		return dao.delete(id);
	}

	public Integer insert(Src s) {
		return dao.insert(s);
	}

	public Integer update(Src s) {
		return dao.update(s);
	}

}
