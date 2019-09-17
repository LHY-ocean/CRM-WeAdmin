package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientDao;
import model.Client;
import service.ClientService;
import utils.ReturnInfo;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientDao dao;
	
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

	public List<Client> getAll() {
		return dao.getAll();
	}

	public Client getById(int id) {
		return dao.getById(id);
	}

	public int delete(int id) {
		return dao.delete(id);
	}

	public Integer insert(Client c) {
		return dao.insert(c);
	}

	public Integer update(Client c) {
		return dao.update(c);
	}

}
