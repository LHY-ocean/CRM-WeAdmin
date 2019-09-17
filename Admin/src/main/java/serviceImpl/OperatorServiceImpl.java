package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.OperatorDao;
import model.Operator;
import service.OperatorService;
import utils.ReturnInfo;

@Service
public class OperatorServiceImpl implements OperatorService {

	@Autowired
	OperatorDao dao;
	
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

	public List<Operator> getAll() {
		return dao.getAll();
	}

	public Operator getById(int id) {
		return dao.getById(id);
	}

	public int delete(int id) {
		return dao.delete(id);
	}

	public Integer insert(Operator o) {
		return dao.insert(o);
	}

	public Integer update(Operator o) {
		return dao.update(o);
	}

	public Operator selectOperator(Operator o) {
		return dao.selectOperator(o);
	}

}
